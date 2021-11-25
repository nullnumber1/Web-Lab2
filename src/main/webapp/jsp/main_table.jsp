<%@ page import="com.nullnumber1.model.Point" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="result_table table table-hover table-dark">
    <jsp:useBean id="results" class="com.nullnumber1.model.Results" scope="application"/>
    <thead>
    <tr>
        <th class="variable">X</th>
        <th class="variable">Y</th>
        <th class="variable">R</th>
        <th>Result</th>
        <th>Time</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (results != null) {
            for (Point check : results.getPoints()) {
    %>
    <tr>
        <th class='the_X'><%=check.getX()%>
        </th>
        <th class='the_Y'><%=check.getY()%>
        </th>
        <th class='the_R'><%=check.getR()%>
        </th>
        <th class='the_Result' style='color:<%=(check.getResult() ? "lime" : "red")%>'><%=check.getResult()%>
        </th>
        <th><%=check.getClock().getDateString()%>
        </th>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>