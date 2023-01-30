var regId = /^[a-zA-Z][0-9a-zA-Z]{3,11}/
var regPw = /^[a-zA-Z0-9]{4,12}/
var regEmail = /^[a-zA-Z][0-9a-zA-Z]*@\w\.\w/
var regResNum = /\d{13}/
var regAboutMe = /.{10,}/
var regName = /[가-힣]{2,5}/

function checkId(){
    let objId = document.getElementById("id");
    if (!regId.test(objId.value)){
        window.alert("아이디 형식에 맞지 않습니다. [4~12자의 영문 대문자와 숫자로 구성]")
        objId.value = "";
        return false;
    } else {
        return true;
    }
}

function checkPw(){
    let objId = document.getElementById("id");
    let objPw1 = document.getElementById("pw1");
    let objPw2 = document.getElementById("pw2");
    if (!regPw.test(objPw1.value)){
        window.alert("비밀번호 형식에 맞지 않습니다 [4~12자의 영문 대문자와 숫자로 구성].");
    }
    else if (objPw1.value != objPw2.value){
        window.alert("비밀번호가 일치하지 않습니다.");
        objPw1.value = "";
        objPw2.value = "";
        return false;
    } else if (objId.value == objPw1){
        window.alert("아이디와 비밀번호가 일치하면 안됩니다.");
        objPw1.value = "";
        objPw2.value = "";
        return false;
    } else{
        return true;
    }
    
}

function checkEmail(){
    let objEmail = document.getElementById("email");
    if (!regEmail.test(objEmail.value)){
        window.alert("이메일 주소 형식에 맞지 않습니다.");
        objEmail.value = "";
        return false;
    } else{
        return true;
    }
}

function checkName(){
    let objName = document.getElementById("name");
    if(!regname.test(objName.value)){
        window.alert("이름을 입력하시오.");
        objName.value = "";
        return false;
    }
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

function setBirthDay(){
    var objBirthYear = document.getElementById("year");
    var objBirthMonth = document.getElementById("month");
    var objBirthDay = document.getElementById("day");
    var objResNum = document.getElementById("resNum");

    objBirthYear.value = "19" + objResNum.value.substring(0, 2);
    objBirthMonth.value = objResNum.value.substring(2, 4);
    objBirthDay.value = objResNum.value.substring(4, 6);
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

function allCheck(){
    if (!checkId()){
        return false;
    } else if(!checkPw()){
        return false;
    } else if(!checkEmail()){
        return false;
    } else if(!checkName()){
        return false;
    } else if(!checkResNum()){
        return false;
    } else if(!checkHobby()){
        return false;
    } else if(!checkAboutMe()){
        return false;
    } else{
        return true;
    }
    
    
    
    
}