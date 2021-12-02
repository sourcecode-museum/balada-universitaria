// Cria o Objeto de Ajax independentemente do Browser
function createAjax() {    
//	var ajax;
//
//	try{
//        ajax = new ActiveXObject("Microsoft.XMLHTTP");
//	}
//	catch(e) {
//    	try {
//            ajax = new ActiveXObject("Msxml2.XMLHTTP");
//		}
//		catch(ex) {
//        	try	{
//            	ajax = new XMLHttpRequest();
//			}
//			catch(exc) {
//			    alert("Esse browser não tem recursos para uso do Ajax");
//				ajax = null;
//			}
//		}
//		return ajax;
//	}

    var arrSignatures = ["MSXML2.XMLHTTP.5.0", "MSXML2.XMLHTTP.4.0",
	   				     "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP",
						 "Microsoft.XMLHTTP"];
	for (var i=0; i < arrSignatures.length; i++) {
        try {
		    var oRequest = new ActiveXObject(arrSignatures[i]);
			return oRequest;
		}
		catch (ex){
		}
	}

	throw new Error("XMLHttpRequest is not installed on your system.");
}

// Chama uma pagina e retorna o seu conteudo
function CallPage(url) {
    try {
        var xhReq = createAjax();
        
        xhReq.open("GET", url, false);
        xhReq.send(null);

        return xhReq.responseText; 
    } catch(ex){
        throw new ex;
    }
}
