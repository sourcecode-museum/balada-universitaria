//Marca tudos os checkbox dos formulario
//Visit JavaScript Kit (http://javascriptkit.com) for script
//os checks para marcacao deve ter o nome de chkDel
function checkall(pChecked, pChkItems){
    var c
    var colCheck = eval(pChkItems)		 		//eval("document.forms.frmConsulta.chkSelect")
    
    for (c=0; c < colCheck.length; c++)
        colCheck[c].checked = eval(pChecked) 	//eval("document.forms.frmConsulta.chkAll.checked")
}

function showPopup(pURL, pWidth, pHeight) {
    var resp
    var top		=  ( (screen.height/2) - (pHeight/2) );
    var left	=  ( (screen.width/2) - (pWidth/2) );
    
    resp = window.open(pURL,'showPopup','width=' + pWidth + ',height=' + pHeight + ',top=' + top + ',left=' + left + ',directories=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=yes')
    if (resp != null) {
        resp.location.href = pURL
    }
}

function openPopup(pWidth, pHeight) {
    var top		=  ( (screen.height/2) - (pHeight/2) );
    var left	=  ( (screen.width/2) - (pWidth/2) );
    
    window.open('', 'openPopup','width=' + pWidth + ',height=' + pHeight + ',top=' + top + ',left=' + left + ',directories=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=yes')
}

function showDialog(pURL, pWidth, pHeight) {
    window.showModelessDialog(pURL, 'showDialog', 'Resizable:no; DialogHeight:' + pHeight + 'px; DialogWidth:' + pWidth + 'px; Edge:raised; Help:no; Scroll:no; Status:no; Center:yes;');
}

function showCalendario(oDoc, cDate) {
    window.open("inc/datepicker.asp?backf="+oDoc+"&cDate="+cDate,"showCalendario", "height=210, width=300, resizeable=no,","");
    //showDialog("./inc/datepicker.asp?backf="+oDoc+"&cDate="+cDate,300,210);
}

//Function to open preview post window
function debugPrint(pTexto) {
    document.cookie = "textarea=" + pTexto
    window.showModelessDialog('admin/editor/poppreview.asp','debugPrint', 'Resizable:no; DialogHeight:480px; DialogWidth:640px; Edge:raised; Help:no; Scroll:no; Status:no; Center:yes;');
}

function trmouseover(src,cor,useclass) {
    if (useclass == true)
        src.className=cor;
    else {
        src.className='';
        src.bgColor=cor;
    }
    src.style.cursor="hand";
}
function trmouseout(src,cor,useclass) {
    if (useclass == true)
        src.className=cor;
    else {
        src.className='';
        src.bgColor=cor;
    }
    src.style.cursor="default";
}

function validaCampos(pForm){
    var x, campo;
    var obrigatorio, caption;
    
    //alert("Cheguei no validaCampos")
    try {
        with (pForm) {
            //alert("elements " + elements.length);
            for (x=0; x < elements.length; x++) {
                campo = elements[x];
                if (campo.type != undefined) {
                    //alert("elemento: " + x + " - " + campo.type + " - " + campo.name + " - " + campo.value);
                    
                    obrigatorio = (campo.title.substr(0,1) == "*");
                    caption = campo.title.substr(2).toUpperCase();
                    
                    if (caption.length == 0)
                        caption = campo.name.toUpperCase();
                    
                    if (obrigatorio && campo.value.toString() == "") {
                        alert("O campo " + caption + " deve ser preenchido!");
                        campo.focus();
                        
                        return false;                
                    } //end if
                } //end if
            } //end for
        } //end with
        
        //alert("verdadeiro");
        return true;
    } 
    catch(ex) {
        alert("Erro no método validaCampos(): \n" + ex.message);
    }
}

function getParameters(pForm){
    var x, campo;
    var ret = "";
    
    with (pForm) {
        for (x=0; x < elements.length; x++) {
            campo = elements[x];
            if (campo.type != undefined) {
                if (ret != "") ret += "&";            
                ret += campo.name + "=" + campo.value;
            } //end if
        } //end for
    } //end with
    
    return ret;
}

function addFav(url, title){
    if (window.sidebar) window.sidebar.addPanel(title, url,"");
    else if(window.opera && window.print){
        var mbm = document.createElement('a');
        mbm.setAttribute('rel','sidebar');
        mbm.setAttribute('href',url);
        mbm.setAttribute('title',title);
        mbm.click();
    }
    else if(document.all){window.external.AddFavorite(url, title);}
}

function goBack(){
    if (parent.history.length > 0){
        parent.history.back()
    }
}
function goForward(){
    if (parent.history.length > 0){
        parent.history.forward()
    }
}
function goPage(page){
    window.location = page;
}