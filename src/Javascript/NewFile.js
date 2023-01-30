function dispMsg(){
    var objFontColor = document.getElementById("textColor");
    var objFontSize = document.getElementById("size");
    var objOptions = document.getElementsByName("font");
    var objText = document.getElementById("tbString");
    var objResult = document.getElementById("result");

    var targetString = objText.value;
    
    if (objOptions[0].checked){
        targetString = targetString.strike();
    }
    if (objOptions[1].checked){
        targetString = targetString.big();
    }
    if (objOptions[2].checked){
        targetString = targetString.small();
    }
    if (objOptions[3].checked){
        targetString = targetString.bold();
    }
    if (objOptions[4].checked){
        targetString = targetString.italics();
    }
    if (objOptions[5].checked){
        targetString = targetString.sup();
    }
    if (objOptions[6].checked){
        targetString = targetString.sub();
    }
    if (objOptions[7].checked){
        targetString = targetString.toLowserCase();
    }
    if (objOptions[8].checked){
        targetString = targetString.toUpperCase();
    }
    
    targetString = targetString.fontcolor(
        objFontColor.options[objFontColor.selectedIndex].value
        );

    targetString = targetString.fontsize(
        objFontSize.options[objFontSize.selectedIndex].value
        );
        
    objResult.innerHTML = targetString;
}