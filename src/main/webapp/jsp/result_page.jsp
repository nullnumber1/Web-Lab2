<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="height: 100%">
<head>
    <title>Lab 2</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body style="background-color:#e9ecef; min-height: 100vh;">
<header>
    <nav class="navbar navbar-dark bg-dark">
        <span class="navbar-text">Вариант 10238</span>
        <span class="navbar-text">Романов Артём, P3210</span>
    </nav>
</header>
<jsp:useBean id="check" class="com.nullnumber1.model.Point" scope="application"/>
<table class="table table-hover table-dark">
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
    <tr>
        <th class="theX">
            <jsp:getProperty name="check" property="x"/>
        </th>
        <th class="theY">
            <jsp:getProperty name="check" property="y"/>
        </th>
        <th class="theR">
            <jsp:getProperty name="check" property="r"/>
        </th>
        <th class="theRes">
            <jsp:getProperty name="check" property="result"/>
        </th>
        <th>
            <%=check.getTime()%>
        </th>
    </tr>
    </tbody>
</table>
<hr class="my-4">
<form method="get" action="${pageContext.request.contextPath}/index.jsp">
    <button type="submit" class="btn btn-dark btn-lg">Назад</button>
</form>
