<%@ include file="includes/_siteBegin.jspf" %>
<%@ page import="java.util.ArrayList" %>

<%
String vReqAcao = "";
String vMessageTop = "";
String vImgLogo = "imgs/ico-consulta.png";
String vTituloPage = "Cadastros";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; consultar os usu&aacute;rios cadastrados!";
String vFormAction = "con_usuarios.jsp";
%>

<div id="main">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr><td valign="top">
	<%=oFuncoes.getTituloPagina(vImgLogo, vTituloPage, vSubTitulo )%>
</td></tr>
<tr><td valign="top"><%=vMessageTop%></td></tr>
<tr><td class="main" valign="top">
	<div class="panel-b">
	<fieldset>
	<legend class="negrito">Listagem de Usuários</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr class="borderbottom">
			<th nowrap="nowrap">Usuário</th>
			<th nowrap="nowrap">Email</th>
			<th nowrap="nowrap">Telefone</th>
            <th nowrap="nowrap">Cidade</th>
            <th nowrap="nowrap">Data Cadastro</th>
            <th nowrap="nowrap">Ultimo Acesso</th>
		</tr>
		<%		
		int nCount = 0;
        String sTRClass = "";
        
        UsuarioDAO dao = new UsuarioDAO(JdbcDAOFactory.getConnection());
        List lista = dao.getCollection();

        for(Object obj : lista) {
            UsuarioTO to = (UsuarioTO) obj;

            sTRClass = "row" + ((nCount % 2) + 1);
            nCount++;
                                  
            out.println(oFuncoes.getTagTRLight(sTRClass, "cad_usuarios.jsp?queryid=" + to.getEmail()));
            out.println("<td nowrap='nowrap'>" + to.getNome() + "</td>");
            out.println("<td nowrap='nowrap'>" + to.getEmail() + "</td>");
			out.println("<td nowrap='nowrap'>" + to.getCod_Area() + " - " + to.getTelefone() + "</td>");
            out.println("<td nowrap='nowrap'>" + to.getCidade() + " - " + to.getUf() + "</td>");
            out.println("<td nowrap='nowrap'>" + to.getDt_Cadastro() + "</td>");
            out.println("<td nowrap='nowrap'>" + to.getDt_Ultimo_Acesso() + "</td>");            
			out.println("</tr>");                              
        }
        %>
		<tr class="bordertop" align="right"><th colspan="6">Total&nbsp;de&nbsp;registros:&nbsp;<%=nCount%></th></tr>
		</table>
	</fieldset>
	</div>
</td></tr>
</table>
</div>
<%@ include file="includes/_siteEnd.jspf" %>