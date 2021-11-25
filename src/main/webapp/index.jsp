<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta charset="UTF-8">
    <title>Web Lab №2</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="scripts/canvas_handler.js"></script>
    <script src="scripts/validator.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body onload="drawCanvas()">
<header>
    <nav class="navbar navbar-dark bg-dark mb-3">
        <span class="navbar-text">
            Вариант 10238
        </span>
        <span class="navbar-text">
            Романов Артём, <b>P3210</b>
        </span>
    </nav>
</header>
<div class="container">
    <canvas style="margin: 0 auto" id="canvas"></canvas>
</div>
<div class="container">
    <div id="fieldMessageErr"></div>
    <form class="form-group" method="get" action="controllerServlet">
        <div class="input_group my-2">
            <label id="labelX" for="X_field" class="input-group-text mb-1">X:</label>
            <input type="text" class="form-control" id="X_field" name="X_field" oninput=removeClaimsForX()
                   onchange="update()"
                   maxlength="8" placeholder="(-3 ... 5)">
        </div>
        <div id="fieldMessageX"></div>

        <div class="input_group my-2">
            <span id="labelY" class="input-group-text mb-1">Y:</span>
            <div class="btn-group">
                <button type="button" class="btn btn-secondary" id="y-2" onclick="yChoose('-2')">-2</button>
                <button type="button" class="btn btn-secondary" id="y-1.5" onclick="yChoose('-1.5')">-1.5</button>
                <button type="button" class="btn btn-secondary" id="y-1" onclick="yChoose('-1')">-1</button>
                <button type="button" class="btn btn-secondary" id="y-0.5" onclick="yChoose('-0.5')">-0.5</button>
                <button type="button" class="btn btn-secondary" id="y0" onclick="yChoose('0')">0</button>
                <button type="button" class="btn btn-secondary" id="y0.5" onclick="yChoose('0.5')">0.5</button>
                <button type="button" class="btn btn-secondary" id="y1" onclick="yChoose('1')">1</button>
                <button type="button" class="btn btn-secondary" id="y1.5" onclick="yChoose('1.5')">1.5</button>
                <button type="button" class="btn btn-secondary" id="y2" onclick="yChoose('2')">2</button>
            </div>
            <input type="hidden" name="Y_field" id="Y_field">
        </div>

        <div class="input_group my-2">
            <span id="labelR" class="input-group-text mb-1">R:</span>
            <div class="btn-group">
                <button type="button" class="btn btn-secondary" id="r1" onclick="rChoose('1')">1</button>
                <button type="button" class="btn btn-secondary" id="r2" onclick="rChoose('2')">2</button>
                <button type="button" class="btn btn-secondary" id="r3" onclick="rChoose('3')">3</button>
                <button type="button" class="btn btn-secondary" id="r4" onclick="rChoose('4')">4</button>
                <button type="button" class="btn btn-secondary" id="r5" onclick="rChoose('5')">5</button>
            </div>
            <input type="hidden" name="R_field" id="R_field">
        </div>
        <button type="submit" id="submitButton" class="btn btn-dark">Отправить</button>
    </form>
</div>
<div class="container-md">
    <jsp:include page="jsp/main_table.jsp"/>
</div>
</body>
</html>
