<%@ include file="includes/_siteBegin.jspf" %>

<script language="javascript">
	function habilitaCampo(pChk) {
		var oCampo = document.getElementById('id' + pChk.value);
		oCampo.disabled = !pChk.checked;
		oCampo.focus();
	}
</script>
<%
String vImgLogo = "imgs/ico-config.png";
String vTituloPage = "Ferramentas";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; alterar as configurações do seu site facilmente.";
String vFormAction = "cfg_site.jsp";
String vMessageTop = "";

String vReqAcao = request.getParameter("acao");

ConfigSiteDAO dao = new ConfigSiteDAO();
ConfigSiteTO to;
        
if (vReqAcao != null) {
    vReqAcao = vReqAcao.toLowerCase();

    if (vReqAcao.equals("alterar")) {
        if (request.getParameterValues("id") == null) {
            vMessageTop = oFuncoes.getMessageTop("É necessario selecionar algum registro para alteração.", "Aviso");
            
        } else {
            int cont, id;
            String valor, sql;
            
            to = new ConfigSiteTO();            
            for (cont=0; cont < request.getParameterValues("id").length; cont++) {
                id = Integer.parseInt(request.getParameterValues("id")[cont]);		
                valor = request.getParameterValues("valor")[cont].replace("'", "''");
                
                to.setValor(valor);
                to.setId(id);
                dao.update(to);
            }
            to = null;
            
            vMessageTop = oFuncoes.getMessageTop("Atualização efetuada com Sucesso.", "Ok");
        }
    }    
}
%>
<div id="main">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr><td width="100%" valign=top>
	<%=oFuncoes.getTituloPagina(vImgLogo, vTituloPage, vSubTitulo )%>
</td></tr>
<tr><td><%=vMessageTop%></td></tr>
<tr><td class="main" valign="top">
<div class="panel">
	<form name="frmEditar" method="post" action="<%=vFormAction%>" >
	<fieldset>
	<legend class="negrito">Configurações do Site</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr class="borderbottom"><th colspan="2"></th></tr>
		<%
        ArrayList list = dao.buscarTodos();
        
        for (Object obj : list) {
            to = (ConfigSiteTO) obj;
            
            out.println("<tr class='borderbottom'>");
            out.println("<td class='coluna' width='10%' nowrap='nowrap'>" + to.getCaption() + "<br/><font style='font-size:9;font-weight: normal;'>&nbsp;&nbsp;&raquo;&nbsp;" + to.getDescricao() + "</font></td>");
            out.println("<td nowrap='nowrap'>");
            out.println("<input type='checkbox' name='id' value='" + to.getId() + "' onclick='habilitaCampo(this);'/>");
            out.println(dao.getOpcoes(to.getTipo(), to.getValor(), to.getOpcao1_Size(), to.getOpcao2_Max(), to.getId()));
            out.println("</td>");
            out.println("</tr>");
        }
		%>
		<tr class="bordertop"><th colspan="2"></th></tr>
		</table>
	</fieldset>
	
	<div style="width:100%" align="right">
		<%=oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-salvar", "Alterar", "", "acao")%>
	</div>
	</form>
</div>	
</td></tr>
</table></div>

<%@ include file="includes/_siteEnd.jspf" %>