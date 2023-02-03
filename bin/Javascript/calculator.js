var operator;
var num1;
var num2;
var state;

function inputNum(num) {
    var objTextBox = document.getElementById("txtbox");
    if (state == "cal") {
        objTextBox.value = "0";
        state = "num";
    }
    if (objTextBox.value == "0") {
        objTextBox.value = num;
    } else {
        objTextBox.value += num;
    }
}
function clickDot(num) {
    var objTextBox = document.getElementById("txtbox");
    if (objTextBox.value.indexOf(".") == -1) {
        objTextBox.value += num;
    }
}
function inputMathSymbol(symbol) {
    num1 = document.getElementById("txtbox").value;

    operator = symbol;
    state = "cal";
}
function txtClear() {
    var objTextBox = document.getElementById("txtbox");
    objTextBox.value = 0;
    num1 = null;
    num2 = null;
    operator = null;
}
function cal() {
    objTextBox = document.getElementById("txtbox");
    num2 = objTextBox.value;
    state = "cal"
    switch (operator) {
        case '+':
            num1 = String(Number(num1) + Number(num2));
            objTextBox.value = num1;
            break;
        case '-':
            num1 = String(Number(num1) - Number(num2));
            objTextBox.value = num1;
            break;
        case '*':
            num1 = String(Number(num1) * Number(num2));
            objTextBox.value = num1;
            break;
        case '/':
            num1 = String(Number(num1) / Number(num2));
            objTextBox.value = num1;
            break;
        case '^':
            num1 = String(Number(num1) ** Number(num2));
            objTextBox.value = num1;
            break;
    }
}
function clickConversion() {
    num = document.getElementById("txtbox");
    if (Number(num.value) > 0) {
        num.value = '-' + num.value;
    } else {
        num.value = num.value.replace('-', '');
    }
}

function clickSin() {
    objTextBox = document.getElementById("txtbox");
    num = objTextBox.value;
    objTextBox.value = Math.sin(num * Math.PI / 180);
    state = "cal";
}
function clickCos() {
    objTextBox = document.getElementById("txtbox");
    num = objTextBox.value;
    objTextBox.value = Math.cos(num * Math.PI / 180);
    state = "cal";
}
function clickTan() {
    objTextBox = document.getElementById("txtbox");
    num = objTextBox.value;
    objTextBox.value = Math.tan(num * Math.PI / 180);
    state = "cal";
}
