<%@ include file="WEB-INF/jspf/_siteBegin.jspf" %>
<%-- 
    Document   : fotos
    Created on : 14/06/2008, 21:47:14
    Author     : Heliomar
--%>
<label>
<form name="frmTela" method="post" action="#" onSubmit="return validaCampos(this);">
    <!--<fieldset>-->	
    <h3>FOTOS</h3>
    <div class='l-gray3'><img src='imgs/red1.gif' width='9' height='1' border='0'></div>
    <p>
        Inclua suas fotos.
    </p>

    <table align='center' cellspacing='0' cellpadding='0' border='0' width='100%'>
    <tr>
        <td><img src="imgs/site/c1.gif" width="7" height="7" alt="" border="0"></td>
        <td background="imgs/site/c2.gif"></td>
        <td><img src="imgs/site/c3.gif" width="7" height="7" alt="" border="0"></td>
    </tr>
    <tr>
        <td background="imgs/site/c4.gif"></td>
        <td bgcolor="black" width="100%" align="left">

		<table border="0" cellpadding="0" cellspacing="1" align="left" width="300px">
		<tr>
			<td align="center" width="100%">
				<table width="100%" border="0" cellpadding="2" cellspacing="1" align="center">
				<tr>
					<td><img src="imgs/fotos/foto.gif" border="0"/><br/>Foto 01</td>
					<td><img src="imgs/fotos/foto.gif" border="0"/><br/>Foto 02</td>
					<td><img src="imgs/fotos/foto.gif" border="0"/><br/>Foto 03</td>
					<td><img src="imgs/fotos/foto.gif" border="0"/><br/>Foto 04</td>
				</tr>
				<tr>
					<td><img src="imgs/fotos/foto.gif" border="0"/><br/>Foto 05</td>
					<td><img src="imgs/fotos/foto.gif" border="0"/><br/>Foto 06</td>
					<td><img src="imgs/fotos/foto.gif" border="0"/><br/>Foto 07</td>
					<td><img src="imgs/fotos/foto.gif" border="0"/><br/>Foto 08</td>
				</tr>
				</table>
			</td>
		</tr>
         <tr><td><a href="#">voltar</a>&nbsp;|&nbsp;<a href="#">prximo</a></td></tr>
		<tr>
			<td align="left">&nbsp;&nbsp;&nbsp;            
				<br/><div class='l-gray3'><img src='imgs/blue1.gif' width='9' height='1' border='0'/></div><br/>
                <table width="200" border="0" cellspacing="1" cellpadding="2">
				<tr>
					<td>Upload:&nbsp;</td>
					<td><input type="file" class="text" name="upload" value="" style="width:255px;"></td>
				</tr>
				<tr>
					<td>Descri&ccedil;&atilde;o:</td>
					<td><input type="text" class="text" name="descricao" value="" style="width:253px;"></td>
				</tr>
				</table>
			</td>
		</tr>         
        <tr>
            <td align="right">
                <br/><div class='l-gray3'><img src='imgs/blue1.gif' width='9' height='1' border='0'/></div><br/>
                <input class="button" type="submit" name="acao" value="Salvar"/>
                <input class="button" type="reset" name="cancelar" value="Cancelar"/>
            </td>
        </tr>         
		</table>

        </td>
        <td background="imgs/site/c5.gif"></td>
    </tr>
    <tr>
        <td><img src="imgs/site/c6.gif" width="7" height="7" alt="" border="0"></td>
        <td background="imgs/site/c7.gif"></td>
        <td><img src="imgs/site/c8.gif" width="7" height="7" alt="" border="0"></td>
    </tr>
    </table>
	<!--</fieldset>	-->		
</form>
</label>

<%@ include file="WEB-INF/jspf/_siteEnd.jspf" %>