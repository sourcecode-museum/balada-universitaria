function SoLetras() {
	if ( (event.keyCode < 65 || event.keyCode > 90) && (event.keyCode < 97 || event.keyCode > 122) ) {
		if (event.keyCode != 8) 
			event.returnValue = false;
	}
}

function validaLetras(pCampo) {
	var x;
	var newValue = '';

	for (x=0; x < pCampo.value.length; x++) {
		if (isNaN( parseInt( pCampo.value.charAt(x) ) ) == true) {
			newValue += pCampo.value.charAt(x);
		}
	}
	pCampo.value = newValue;
}

/*
Exemplo de uso:
	<input name="campo" onKeyPress="SoNumeros();">
*/ 
function SoNumeros() {
	if (event.keyCode < 48 || event.keyCode > 57) {
		if (event.keyCode != 8) 
			event.returnValue = false;
	}
}

function validaNumeros(pCampo) {
	var x;
	var newValue = '';

	for (x=0; x < pCampo.value.length; x++) {
		if (isNaN( parseInt( pCampo.value.charAt(x) ) ) == false) {
			newValue += parseInt(pCampo.value.charAt(x));
		}
	}
	pCampo.value = newValue;
}
/*
Exemplo de uso:
	<input name="txtDataNasc" size ="16" class="Campo" maxlength="10" onKeyPress="formataData(this);" onBlur="validaData(this);">
*/                          
function formatData(pCampo) {
	if (pCampo.length == 2 || pCampo.length == 5)
		pCampo.value = pCampo.value + "/";

	this.SoNumeros();
}

/*
Exemplo de uso:
	<input name="txtDataNasc" size ="16" class="Campo" maxlength="10" onKeyPress="formataData(this);" onBlur="validaData(this);">
*/ 
function validaData(Text) {
	var vText = Text.value;
	var  booInvalido = false;
	
	if (vText == "") return true;
	
	if (vText.substr(0,2) < 1 || vText.substr(0,2) > 31) booInvalido = true;
	if (vText.substr(3,2) < 1 || vText.substr(3,2) > 12) booInvalido = true;
	if (vText.substr(6,4) < 1900 || vText.substr(6,4) > 2100) booInvalido = true;

	if (booInvalido == true) {
		alert("Data Inválida!!");
		return false;
	}
}

/*
Exemplo de uso:
	<input name="nome" onKeyPress="textoMaiusculo(this);">
	<input name="email" onKeyPress="textoMinusculo(this);">
*/ 
function textoMaiusculo(pCampo) {
	if (event.keyCode >= 65 && event.keyCode <= 90) {
		pCampo.value = pCampo.value.toUpperCase();
	}
}
function textoMinusculo(pCampo) {
	if (event.keyCode >= 65 && event.keyCode <= 90) {
		pCampo.value = pCampo.value.toLowerCase();
	}
}

/*
Exemplo de uso:
	<input name="valor" onKeyPress="validaReal(this);">
*/
function validaReal(pCampo){
    var nvalor;
	
    nvalor = pCampo.value.replace(".","");
    nvalor = nvalor.replace(",",".");

    pCampo.value == nvalor;
}

function formatReal(pCampo, pMaxLength, pDecimais)
{
	var eventKey		= event.keyCode;
	var valueLength		= pCampo.value.length;
	var vr, tam;
	
	if ((eventKey == 8) && (valueLength == pMaxLength)) 
		valueLength = valueLength - 1 ;
		
    if (( eventKey == 8 || eventKey == 88 || eventKey >= 48 && eventKey <= 57 || eventKey >= 96 && eventKey <= 105 ) && ((valueLength+1) <= pMaxLength)) {
		vr	= pCampo.value;
		vr	= vr.replace( "/", "" );
		vr	= vr.replace( "/", "" );
		vr	= vr.replace( ",", "" );
		vr	= vr.replace( ".", "" );
		vr	= vr.replace( ".", "" );
		vr	= vr.replace( ".", "" );
		vr	= vr.replace( ".", "" );
		tam	= vr.length;
		
		if (tam < pMaxLength && eventKey != 8) 
			tam = vr.length + 1 ;
		
		if ((eventKey == 8) && (tam > 1)) {
			tam = tam - 1 ;
			vr = pCampo.value;
			vr = vr.replace( "/", "" );
			vr = vr.replace( "/", "" );
			vr = vr.replace( ",", "" );
			vr = vr.replace( ".", "" );
			vr = vr.replace( ".", "" );
			vr = vr.replace( ".", "" );
			vr = vr.replace( ".", "" );
		}
		
		if ( eventKey == 8 || eventKey >= 48 && eventKey <= 57 || eventKey >= 96 && eventKey <= 105 ) {
			if (pDecimais > 0) {
				if ( (tam <= pDecimais) )
					pCampo.value = ("0," + vr) ;
				
				if( (tam == (pDecimais + 1)) && (eventKey == 8))
					pCampo.value = vr.substr( 0, (tam - pDecimais)) + ',' + vr.substr( tam - (pDecimais), tam ) ;
				
				if ( (tam > (pDecimais + 1)) && (tam <= (pDecimais + 3)) &&  ((vr.substr(0,1)) == "0"))
					pCampo.value = vr.substr( 1, (tam - (pDecimais + 1))) + ',' + vr.substr( tam - (pDecimais), tam ) ;
				
				if ( (tam > (pDecimais + 1)) && (tam <= (pDecimais + 3)) &&  ((vr.substr(0,1)) != "0"))
				    pCampo.value = vr.substr( 0, tam - pDecimais ) + ',' + vr.substr( tam - pDecimais, tam ) ;
				
				if ( (tam >= (pDecimais + 4)) && (tam <= (pDecimais + 6)) )
					pCampo.value = vr.substr( 0, tam - (pDecimais + 3) ) + '.' + vr.substr( tam - (pDecimais + 3), 3 ) + ',' + vr.substr( tam - pDecimais, tam ) ;
				
			 	if ( (tam >= (pDecimais + 7)) && (tam <= (pDecimais + 9)) )
					pCampo.value = vr.substr( 0, tam - (pDecimais + 6) ) + '.' + vr.substr( tam - (pDecimais + 6), 3 ) + '.' + vr.substr( tam - (pDecimais + 3), 3 ) + ',' + vr.substr( tam - pDecimais, tam ) ;
				
				if ( (tam >= (pDecimais + 10)) && (tam <= (pDecimais + 12)) )
					pCampo.value = vr.substr( 0, tam - (pDecimais + 9) ) + '.' + vr.substr( tam - (pDecimais + 9), 3 ) + '.' + vr.substr( tam - (pDecimais + 6), 3 ) + '.' + vr.substr( tam - (pDecimais + 3), 3 ) + ',' + vr.substr( tam - pDecimais, tam ) ;
				
				if ( (tam >= (pDecimais + 13)) && (tam <= (pDecimais + 15)) )
					pCampo.value = vr.substr( 0, tam - (pDecimais + 12) ) + '.' + vr.substr( tam - (pDecimais + 12), 3 ) + '.' + vr.substr( tam - (pDecimais + 9), 3 ) + '.' + vr.substr( tam - (pDecimais + 6), 3 ) + '.' + vr.substr( tam - (pDecimais + 3), 3 ) + ',' + vr.substr( tam - pDecimais, tam ) ;
				
			}
			else if(pDecimais == 0) {
				if ( tam <= 3 ) 
			 		pCampo.value = vr ;
				
				if ( (tam >= 4) && (tam <= 6) ) {
					if(eventKey == 8) {
						pCampo.value = vr.substr(0, tam);
						window.event.cancelBubble = true;
						window.event.returnValue = false;
					}
					pCampo.value = vr.substr(0, tam - 3) + '.' + vr.substr( tam - 3, 3 );
				}
				
				if ( (tam >= 7) && (tam <= 9) ) {
					if(eventKey == 8) {
						pCampo.value = vr.substr(0, tam);
						window.event.cancelBubble = true;
						window.event.returnValue = false;
					}
					pCampo.value = vr.substr( 0, tam - 6 ) + '.' + vr.substr( tam - 6, 3 ) + '.' + vr.substr( tam - 3, 3 );
				}
				
				if ( (tam >= 10) && (tam <= 12) ) {
			 		if(eventKey == 8) {
						pCampo.value = vr.substr(0, tam);
						window.event.cancelBubble = true;
						window.event.returnValue = false;
					}
					pCampo.value = vr.substr( 0, tam - 9 ) + '.' + vr.substr( tam - 9, 3 ) + '.' + vr.substr( tam - 6, 3 ) + '.' + vr.substr( tam - 3, 3 );
				}

				if ( (tam >= 13) && (tam <= 15) ) {
					if(eventKey == 8) {
						pCampo.value = vr.substr(0, tam);
						window.event.cancelBubble = true;
						window.event.returnValue = false;
					}
					pCampo.value = vr.substr( 0, tam - 12 ) + '.' + vr.substr( tam - 12, 3 ) + '.' + vr.substr( tam - 9, 3 ) + '.' + vr.substr( tam - 6, 3 ) + '.' + vr.substr( tam - 3, 3 ) ;
				}
			}
		}
	}
	else if((window.event.keyCode != 8) && (window.event.keyCode != 9) && (window.event.keyCode != 13) && (window.event.keyCode != 35) && (window.event.keyCode != 36) && (window.event.keyCode != 46))
		{
			window.event.cancelBubble = true;
			window.event.returnValue = false;
		}
}