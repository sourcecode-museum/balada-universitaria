<%@ include file="WEB-INF/jspf/_siteBegin.jspf" %>
<%-- 
    Document   : listavip
    Created on : 14/06/2008, 21:47:38
    Author     : Heliomar
--%>
<label>
<form name="frmTela" method="post" action="#" onSubmit="return validaCampos(this);">
    <!--<fieldset>-->	
    <h3>LISTA VIP</h3>
    <div class='l-gray3'><img src='imgs/red1.gif' width='9' height='1' border='0'></div>
    <p>
        Ao preencher os dados abaixo requisitados voc poder imprimir o seu convite para poder participar da lista VIP.
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

<table border="0" cellpadding="0" cellspacing="1" align="left" width="400px">

<tr><th colspan="2" height="30px">&nbsp;</th></tr>
<tr>
<th align="right">Nome:&nbsp;</th>
<td><input class="textlcase" type="text" maxlength="150" style="width:280px" name="nome" /></td>
</tr>
<tr>
<th align="right" nowrap="nowrap">RG:&nbsp;</th>
<td><input class="textlcase" type="text" maxlength="150" style="width:280px" name="email2"/></td>
</tr>
<tr>
<th align="right">Convite válido até:&nbsp;</th>
<td>

<input type="text" class="textlcase" size="12" maxlength="12" style="width:80px" name="validade"/>
</td>
</tr>		
<tr>
<td align="right" colspan="2">
<br><div class='l-gray3'><img src='img/blue1.gif' width='9' height='1' border='0'></div><br>					
<input class="button" type="submit" name="acao" value="Imprimir"onclick="window.print();"/>

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