<%@ include file="WEB-INF/jspf/_siteBegin.jspf" %>
<%-- 
    Document   : faleconosco
    Created on : 14/06/2008, 21:47:05
    Author     : Heliomar
--%>
<label>
<form name="frmTela" method="post" action="#" onSubmit="return validaCampos(this);">
    <!--<fieldset>-->	
    <h3>FALE CONOSCO</h3>
    <div class='l-gray3'><img src='imgs/red1.gif' width='9' height='1' border='0'></div>
    <p>
        Preencha o formulrio abaixo para entrar em contato conosco.
        <br/>Escolha um assunto para que sua resposta chegue rapidamente:
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

			<table border="0" cellpadding="0" cellspacing="1" align="center" width="300px">
			<tr>			
				<th align="right"><span id="labelNome">Nome:&nbsp;</span></th>
				<td><input class="textucase" type="text" maxlength="100" style="width:280px" id="nome" name="nome" value="" title="* Nome:&nbsp;"/></td>
			</tr>
			<tr>
				<th align="right">Email:&nbsp;</th>
				<td><input class="textlcase" type="text" maxlength="150" style="width:280px" name="email" value="" title="* Email" /></td>
			</tr>
             <tr>
                 <th align="right">Assunto:&nbsp;</th>
                 <td>
                    <select name="assunto" style="width:284px">
                        <option value="1">Sugesto</option>				
                        <option value="2">Dvida</option>				
                        <option value="3">Reclamao</option>				
                        <option value="6">Publicidade</option>
                    </select>
                <td>
            </tr>
			<tr>
				<th align="right" valign="top">Mensagem:&nbsp;</th>
                 <td><textarea name="mensagem" rows="5" title="* Mensagem" style="width:280px"></textarea></td>
			</tr>
            <tr>
                <td colspan="2">
                     <input type="checkbox" name="resposta" value="on" checked="checked"/>Quero receber uma resposta do meu contato
                     <br/>
                     <input type="checkbox" name="newsletter" value="on" checked="checked">Desejo receber informaes do Baladas.com.br
                 </td>
			</tr>
             
			<tr>
				<td align="right" colspan="2">
					<br><div class='l-gray3'><img src='imgs/blue1.gif' width='9' height='1' border='0'></div><br>					
					<input class="button" type="submit" name="acao" value="Enviar"/>
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