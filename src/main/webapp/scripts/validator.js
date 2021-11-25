document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("submitButton").addEventListener("click", submit_btn);
    const canvas = document.querySelector('canvas')
    canvas.addEventListener('click', function (e) {
        handleCanvasClick(canvas, e)
    })
});

function check(x, y, r) {
    let names = new Map()
    names.set(x, "X")
    names.set(y, "Y")
    names.set(r, "R")
    for (let it of names.keys()) {
        let name = names.get(it)
        if (it.trim() === "") {
            displayError(`You must select the ${name}!`);
            return false;
        }
        if (!isFinite(it.replace(',', '.'))) {
            displayError(`${name} must be a number!`);
            return false;
        }
    }
    if (y.replace(',', '.') >= 2 || y.replace(',', '.') <= -2) {
        displayError("Y must be in range [-2; 2]");
        return false;
    }
    if (x.replace(',', '.') > 5 || x.replace(',', '.') < -3) {
        displayError("X must be in range (-3; 5)");
        return false;
    }
    if (r.replace(',', '.') > 5 || r.replace(',', '.') < 1) {
        displayError("R must be in range [1; 5]");
        return false;
    }
    return true
}

function displayError(msg) {
    let err = document.getElementById("fieldMessageErr")
    err.innerText = msg
    err.hidden = false
    setTimeout(() => {
        err.hidden = true
    }, 3000)
}

function checkX() {
    let x = document.getElementById('X_field').value.trim().replace(",", ".");
    if (x === "") {
        document.getElementById('labelX').className = "input-group-text bg-danger text-white mb-1";
        return false
    } else if (!isFinite(x) || x === "-0") {
        setValidMessageX("Должно быть числом");
        document.getElementById('labelX').className = "input-group-text bg-warning text-white mb-1";
        return false
    } else if (x > 5 || x < -3) {
        setValidMessageX("Должно быть в диапазоне (-3; 5)");
        document.getElementById('labelX').className = "input-group-text bg-warning text-white mb-1";
        return false
    }

    document.getElementById('labelX').className = "input-group-text mb-1";
    return true
}

function setValidMessageX(message) {
    const fieldMessage = document.getElementById('fieldMessageX');
    if (message.trim() === "") {
        fieldMessage.className = "";
        fieldMessage.innerHTML = "";
    } else {
        fieldMessage.className = "alert alert-dark";
        fieldMessage.innerHTML = message;
    }
}


function removeClaimsForX() {
    setValidMessageX("");
    document.getElementById('labelX').className = "input-group-text mb-1";
}

function yChoose(y) {
    const Y_field = document.getElementById('Y_field');
    if (Y_field.value === y) {
        Y_field.value = "";
        document.getElementById("y" + y).classList.remove("active");
    } else {
        if (Y_field.value !== "") {
            document.getElementById("y" + Y_field.value).classList.remove("active");
        }
        Y_field.value = y;
        document.getElementById("y" + y).classList.add("active");
        document.getElementById('labelY').className = "input-group-text mb-1";
    }
}

function rChoose(r) {
    const R_field = document.getElementById('R_field');
    if (R_field.value === r) {
        R_field.value = "";
        document.getElementById("r" + r).classList.remove("active");
    } else {
        if (R_field.value !== "") {
            document.getElementById("r" + R_field.value).classList.remove("active");
        }
        R_field.value = r;
        document.getElementById("r" + r).classList.add("active");
        document.getElementById('labelR').className = "input-group-text mb-1";
    }
}

const submit_btn = function (e) {
    console.log('submit function');
    const yValue = document.getElementById('Y_field').value;
    const rValue = document.getElementById('R_field').value;

    if (!(checkX() && (yValue !== "") && (rValue !== ""))) {
        e.preventDefault();
        if (yValue === "") document.getElementById('labelY').className = "input-group-text bg-danger text-white mb-1";
        if (rValue === "") document.getElementById('labelR').className = "input-group-text bg-danger text-white mb-1";
    }
}

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('submitButton').addEventListener('click', submit_btn);
});