function checkId(){
    var objId = document.getElementById("id");
    if (objId.value.length == 0){
    alert("아이디를 입력하시오");
    objId.focus;
    return false;
    } else if (!(4 <= objId.value.length && objId.value.length <= 12)){
        alert("아이디 글자 수가 일치하지 않습니다.");
        objId.focus;
        return false
    } else if (!checkEngNumber(objId.value)) {
        alert("아이디가 영어나 숫자로 이루어 지지 않았습니다.");
        objId.focus;
        return false;
    } else if (!checkEng) {
        alert("아이디에 영어가 포함되어 있지않습니다.");
        return false;
    }
    else {
        return true;
    }
}

function checkPw(){
    var objId = document.getElementById("id");
    var objPw1 = document.getElementById("pw1");
    var objPw2 = document.getElementById("pw2");
    if (objPw1.value.length == 0){
        alert("비밀번호를 입력하시오");
        objPw1.focus;
        return false;
    } else if(objPw1.value != objPw2.value){
        alert("비밀번호가 일치하지 않습니다.");
        objPw2.focus;
        return false;
    } else if (!(4 <= objPw1.value.length && objPw1.value.length <= 12)){
        alert("비밀번호 글자수가 일치하지 않습니다..");
        objPw2.focus;
        return false;
    } else if(objId.value == objPw1){
        alert("비밀번호는 아이디와 일치하면 안됩니다.")
        objPw1.focus;
        return false;
    }
    else{
        return true;
    }
}

function checkEmail(){
    var email = document.getElementById("email");
    if(email.value == ""){
        alert("이메일을 입력하세요.");
        email.focus();
        return false;
    } else if(email.value.indexOf("@") == -1 || email.value.indexOf(".") == -1 || email.value.indexOf(".") < email.value.indexOf("@")){
        alert("잘못된 이메일 형식입니다.");
        email.focus();
        return false;
    } else{
        return true;
    }
}

function checkName(){
    var name = document.getElementById("name");
    if (name.value == ""){
        alert("이름을 입력하시오");
        return false;
    } else if (!(checkKorEng(name.value))) {
        alert("이름을 영문 또는 한글로 적으시오");
        return false;
    } else {
        return true;
    }
}

function checkEngNumber(value){
    var count = 0;
    for(i=0;i<value.length;i++){
        if((value.charCodeAt(i)>=65 && value.charCodeAt(i)<=90) || (value.charCodeAt(i)>=97 && value.charCodeAt(i)<=122) || (value.charCodeAt(i)>=48 && value.charCodeAt(i)<=57)) {
            count += 1;
        }
    }
    
    if (count == value.length) {
        return true;
    } else {
        
        return false;
    }
}

function checkKorEng(value){
    var count = 0;
    for(i=0;i<value.length;i++){
        if ((value.charCodeAt(i)>=65 && value.charCodeAt(i)<=90) || (value.charCodeAt(i)>=97 && value.charCodeAt(i)<=122) || (value.charCodeAt(i)>=44032 && value.charCodeAt(i)<=55203)) {
            count += 1;
        }
    }
    if(count == value.length){
        return true;
    } else{
        return false;
    }
}

function checkEng(value){
    for(i=0;i<value.length;i++){
        if ((value.charCodeAt(i)>=65 && value.charCodeAt(i)<=90) || (value.charCodeAt(i)>=97 && value.charCodeAt(i)<=122)) {
            return true;
        }
    }
    return false;
}

function checkResNum(){
    var resNum = document.getElementById("resNum").value;
    
    var sum = Number(resNum[0]) * Number(2) +
    Number(resNum[1]) * Number(3) +
    Number(resNum[2]) * Number(4) +
    Number(resNum[3]) * Number(5) +
    Number(resNum[4]) * Number(6) +
    Number(resNum[5]) * Number(7) +
    Number(resNum[6]) * Number(8) +
    Number(resNum[7]) * Number(9) +
    Number(resNum[8]) * Number(2) +
    Number(resNum[9]) * Number(3) +
    Number(resNum[10]) * Number(4) +
    Number(resNum[11]) * Number(5);
    console.log("sum: " + sum);
    
    sum = sum % 11;
    sum = 11 - sum;
    if(sum > 9){
        sum = sum % 10;
    }

    if (sum == resNum[12]){
        setBirthDay();
        return true;
    } else {
        return false;
    }
}

function checkHobby(){
    var cob_check = document.querySelectorAll('input[name="hobby"]:checked').length;
    if(cob_check < 2){
        alert("체크박스를 두개 이상 선택해주세요");
        return false;
    } else {
        return true;
    }
}

function checkAboutMe(){
    var objAboutme = document.getElementById("aboutMe");
    if (objAboutme.length < 10){
        alert("10글자 이상 입력하시오");
        return false;
    } else {
        return true;
    }
}

function setBirthDay(){
    var objBirthYear = document.getElementById("year");
    var objBirthMonth = document.getElementById("month");
    var objBirthDay = document.getElementById("day");
    var objResNum = document.getElementById("resNum");

    objBirthYear.value = "19" + objResNum.value.substring(0, 2);
    objBirthMonth.value = objResNum.value.substring(2, 4);
    objBirthDay.value = objResNum.value.substring(4, 6);
}

function allCheck(){
    if (!checkId()){
        return false;
    } else if (!checkPw()){
        return false;
    } else if (!checkEmail()){
        return false;
    } else if (!checkName()){
        return false;
    } else if (!checkResNum()){
        return false;
    } else if (!checkHobby()){
        return false;
    } else if (!checkAboutMe()) {
        return false;
    } else {
        return true;
    }
}