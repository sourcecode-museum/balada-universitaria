<%@ include file="WEB-INF/jspf/_siteBegin.jspf" %>
<%-- 
    Document   : calendario
    Created on : 14/06/2008, 21:46:42
    Author     : Heliomar
--%>
<label>
<form name="frmTela" method="post" action="#">
    <!--<fieldset>-->
    <h3>Calendário</h3>
    <div class='l-gray3'><img src='imgs/red1.gif' width='9' height='1' border='0'></div>
    <p>
        Encontre aqui os melhores eventos da sua cidade.
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
			<td>
				<select name="menu1" onChange="MM_jumpMenu('parent',this,0)" id="txt2">
					<option value="#" class="txt4" selected>Ms</option>
					<option value="abril" class="txt5">Abril</option>
					<option value="maio" class="txt5">Maio</option>
					<option value="junho" class="txt5">Junho</option>
					<option value="julho" class="txt5">Julho</option>
				</select>
				<select name="menu1" onChange="MM_jumpMenu('parent',this,0)" id="txt2">
					<option value="#" class="txt4" selected>Estado</option>
					<option value="abril" class="txt5">SP</option>
					<option value="maio" class="txt5">RJ</option>
					<option value="junho" class="txt5">MG</option>
					<option value="julho" class="txt5">RS</option>
				</select>
			</td>
		</tr>
		<tr><td></td></tr>
		<tr><td></td></tr>
		<tr>
			<th align="right" nowrap="nowrap">26.04.2008&nbsp;</th>
			<td>&nbsp Estancia alto da serra</td>
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

<BR>
	
<TABLE width="100%" >
<TR>
	<TD height="25" id="borda">
		<IMG SRC="" WIDTH="5" HEIGHT="1" BORDER="0" ALT="">
<!-- Comentrio... futuro href para chamar a agenda, para acesar tem que ter o login-->
			<a>Incluir Evento na Minha Agenda</a>
		</TD>
</TR>
</table>
<br>


          <table width="100%" border="0" cellspacing="5" cellpadding="1">
            <tr>
              <td  width="15%" id="borda"><font size="1">Data</font></td id="borda" >
              <td width="85%" id="borda"  ><font color="#808080" size="1">26.04.2008 - Horrio: 12:00                </font></td id="borda" >
            </tr>
            <tr>
              <td width="15%" id="borda" ><font size="1">Evento</font></td id="borda" >
              <td width="85%" id="borda" ><font color="#808080" size="1">Cerveja e Cia Folia</font></td id="borda" >
            </tr>
            			<tr>
              <td width="15%" id="borda" ><font size="1">Atra&ccedil;&otilde;es</font></td id="borda" >
              <td width="85%" id="borda" ><font color="#808080" size="1">Ivete Sangalo</font></td id="borda" >
            </tr>
            			<tr>
              <td width="15%" id="borda" ><font size="1">Local</font></td id="borda" >
              <td width="85%" id="borda" ><font color="#808080" size="1">Estncia Alto da Serra</font></td id="borda" >
            </tr>
            			<tr>
              <td width="15%" id="borda" ><font size="1">Endere&ccedil;o</font></td id="borda" >
              <td width="85%" id="borda" ><font color="#808080" size="1">Est: Nevio Carlone, 03 </font></td id="borda" >
            </tr>
            			<tr>
              <td width="15%" id="borda" ><font size="1">Cidade</font></td id="borda" >
              <td width="85%" id="borda" ><font color="#808080" size="1">SAO BERNARDO DO CAMPO</font></td id="borda" >
            </tr>
            <tr>
              <td width="15%" id="borda" ><font size="1">Estado</font></td id="borda" >
              <td width="85%" id="borda" ><font color="#808080" size="1">SP</font></td id="borda" >
            </tr>
                                    			<tr>
              <td width="15%" id="borda" ><font size="1">Informa&ccedil;&otilde;es</font></td id="borda" >
              <td width="85%" id="borda" ><font color="#808080" size="1">(11) 4101-5000</font></td id="borda" >
            </tr>
        </table> 

  <div align="center">
<img src="imgs/eventos/evento_ivete.gif" width="336" height="447" alt=""/>
</div>
<br>
</label>

<%@ include file="WEB-INF/jspf/_siteEnd.jspf" %>
