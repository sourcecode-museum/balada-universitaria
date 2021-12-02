<%@ include file="includes/_siteBegin.jspf" %>
<%@ page import="java.util.ArrayList" %>

<%
String vReqAcao = "";
String vMessageTop = "";
String vImgLogo = "imgs/ico-consulta.png";
String vTituloPage = "Administrador";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; consultar os usu&aacute;rios administradores!";
String vFormAction = "admin_list.jsp";

Adm_UsuarioDAO dao = new Adm_UsuarioDAO();

if (request.getParameter("acao") != null) {
    vReqAcao = request.getParameter("acao").toString().toLowerCase();
}

if (vReqAcao.equals("delete")) {
    String usuario = request.getParameter("usuario").toString();
    String nome = request.getParameter("nome").toString();
    
    try {
        if (dao.getTotalRegistros() == 1) {
            vMessageTop = oFuncoes.getMessageTop("Este é o único usuário administrador e não poderá ser excluído!", admFuncoes.enumMessageTop.Aviso);
        }
        else {
            dao.delete(usuario);
            vMessageTop = oFuncoes.getMessageTop("O administrador <b>" + nome + "</b> foi excluído com sucesso.", admFuncoes.enumMessageTop.Ok);
        }          
    }
    catch (Exception ex) {
        vMessageTop = oFuncoes.getMessageTop("Erro ao executar esta operação!<br/>" + ex.getMessage(), admFuncoes.enumMessageTop.Erro) ;         
    }
}
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
	<legend class="negrito">Listagem</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr class="borderbottom">
			<th align="left">Administrador</th>
			<th align="left">Email</th>
			<th>Opções</th>
		</tr>
		<%		
		int nCount = 0;
        String sLinkDel = "";
        String sTRClass = "";
        
        ArrayList lista = dao.buscarTodos();

        for(Object obj : lista) {
            Adm_UsuarioTO to = (Adm_UsuarioTO) obj;

            sTRClass = "row" + ((nCount % 2) + 1);
            nCount++;
                                  
            if (to.getUsuario().equals(admSession.getUsuario())) {
                sLinkDel = "";
            } 
            else {
                sLinkDel = "<a href='" + vFormAction + "?acao=delete&usuario=" + to.getUsuario() + "&nome=" + to.getNome() + "' title='Excluir registro'><img src='imgs/btn-excluir.png' border='0'/></a>";
            }
            
            out.println(oFuncoes.getTagTRLight(sTRClass));
            out.println("<td>" + to.getNome() + "</td>");
            out.println("<td>" + to.getEmail() + "</td>");
			out.println("<td align='center'>" + sLinkDel + "</td>");
			out.println("</tr>");                              
        }
        %>
		<tr class="bordertop" align="right"><th colspan="3">Total&nbsp;de&nbsp;registros:&nbsp;<%=nCount%></th></tr>
		</table>
	</fieldset>
	</div>
</td></tr>
</table>
</div>
<%@ include file="includes/_siteEnd.jspf" %>