package com.nullnumber1.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllerServlet", value = "/controllerServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double x = Double.parseDouble(req.getParameter("X_field"));
            double y = Double.parseDouble(req.getParameter("Y_field"));
            double r = Double.parseDouble(req.getParameter("R_field"));
            if (isValid(x, y, r)) {
                getServletContext().getRequestDispatcher("/areaCheckServlet").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getClass());
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    public boolean isValid(double x, double y, double r) {
        return (x > -3) && (x < 5) && (y >= -2) && (y <= 2) && (r >= 1) && (r <= 5);
    }
}

