package com.nullnumber1.servlets;

import com.nullnumber1.model.Point;
import com.nullnumber1.model.Results;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AreaCheckServlet", value = "/areaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Point point = getPoint(req, resp);
            if (!point.isValid()) {
                return;
            }
            Results answerList = getResultsAddPoint(point);
            getServletContext().setAttribute("results", answerList);
            if (req.getParameter("Canvas_clicked") == null)
                headToTablePage(req, resp, point);
            else
                sendAJAXResponse(resp, point);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private Results getResultsAddPoint(Point check) {
        Results answerList = (Results) getServletContext().getAttribute("results");
        if (answerList == null)
            answerList = new Results();
        answerList.add(check);
        return answerList;
    }

    private void sendAJAXResponse(HttpServletResponse resp, Point point) throws IOException {
        JSONObject jo = new JSONObject(point);
        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().write(jo.toString());
    }

    private void headToTablePage(HttpServletRequest req, HttpServletResponse resp, Point check) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/jsp/result_page.jsp");
        getServletContext().setAttribute("check", check);
        rd.include(req, resp);
    }

    private Point getPoint(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double x = Double.parseDouble(req.getParameter("X_field"));
        double y = Double.parseDouble(req.getParameter("Y_field"));
        double r = Double.parseDouble(req.getParameter("R_field"));
        Point point = new Point(x, y, r);
        point.setResult(isAreaHit(x, y, r));
        if (!isValid(x, y, r)) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            point.setValid(false);
        }
        point.setTime();
        return point;
    }

    public boolean isAreaHit(double x, double y, double r) {
        return ((x <= 0) && (x >= -r) && (y >= 0) && (y <= r / 2) && (-x + y * 2 < r)) ||
                ((x >= 0) && (y <= 0) && (x * x + y * y) <= (((r * r) / 4))) ||
                ((x >= -r) && (x <= 0) && (y >= -r) && (y <= 0));
    }

    public boolean isValid(double x, double y, double r) {
        return (x > -3) && (x < 5) && (y >= -2) && (y <= 2) && (r >= 1) && (r <= 5);
    }
}