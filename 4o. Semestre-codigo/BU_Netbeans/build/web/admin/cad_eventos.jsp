<%@ include file="includes/_siteBegin.jspf" %>
  
<%
String vImgLogo = "imgs/ico-editar.png";
String vTituloPage = "Cadastros";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; criar, alterar, atualizar ou deletar eventos!";
String vFormAction = "cad_eventos.jsp";
String vMessageTop = "";

String vReqAcao = request.getParameter("acao");
String vReqQueryID = request.getParameter("queryid");

String strCodEvento = "{auto}"; //(vReqQueryID == null ? "{auto}": vReqQueryID);
if (vReqQueryID != null) {
    strCodEvento = vReqQueryID;
    vFormAction += "?queryid=" + vReqQueryID;   //posso estar vindo de uma pesquisa
} 

Evento_PromocaoTO to = new Evento_PromocaoTO();

if (vReqAcao != null) {
    vReqAcao = vReqAcao.toLowerCase();

    try {        
        Evento_PromocaoDAO dao = new Evento_PromocaoDAO(JdbcDAOFactory.getConnection());
        to.setCod_Estabelecimento(Integer.parseInt(request.getParameter("nmEstab")));
        to.setNome(request.getParameter("nmEvent"));
        to.setDescricao(request.getParameter("deEvent"));            
        to.setTipo("E");
        to.setData_Inicio(request.getParameter("dtInicio"));
        to.setData_Final(request.getParameter("dtFim"));
        to.setAtracao(request.getParameter("atracao"));
               
        if (vReqAcao.equals("adicionar")) {
            dao.insert(to);        
            out.print("Registro inserido com sucesso!");
            
        } else if (vReqAcao.equals("pesquisar")) {
            to.setCod_Evento_promocao(Integer.parseInt(request.getParameter("codEvent")));
            to = dao.findByPrimaryKey(to);
            
        } else if (vReqAcao.equals("atualizar")) {
            to.setCod_Evento_promocao(Integer.parseInt(request.getParameter("codEvent")));
            dao.update(to);
            out.print("Registro atualizado com sucesso!");
            
        } else if (vReqAcao.equals("excluir")) {
            to.setCod_Evento_promocao(Integer.parseInt(request.getParameter("codEvent")));
            dao.delete(to);
            out.print("Registro excluído com sucesso!");  
        }
        
    } catch (Exception ex) {
        out.print("Erro ao executar a operação [" + vReqAcao.toUpperCase() + "] \n" + ex.getMessage());
    }
}
%>

<div id="main">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr><td width="100%" valign=top>
	<%= oFuncoes.getTituloPagina(vImgLogo, vTituloPage, vSubTitulo)%>
</td></tr>
<tr><td><%=vMessageTop%></td></tr>
<tr><td class="main" valign="top">
<div class="panel">
	<form name="frmEditar" method="post" action="<%=vFormAction%>" onSubmit="return validaCampos(this);">
	<fieldset>
	<legend class="negrito">Eventos</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr class="borderbottom"><th colspan="2"></th></tr>
		<tr class="borderbottom">
			<td class="coluna">Código Evento:</td>
			<td width="90%"><input class="text" type="text" maxlength="10" size="10" name="codEvent" title="Campo Chave" value="<%=strCodEvento%>" disabled="disabled" /></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Estabelecimento:</td>
			<td width="90%">
                <select name="nmEstab" style="width:30%; size:50px" id="nmEstab" title="* Estabelecimento">
                <%
                EstabelecimentoDAO edao = new EstabelecimentoDAO(JdbcDAOFactory.getConnection());
                out.println(edao.getOptions(to.getCod_Estabelecimento()));
                edao = null;
                %>
                </select>
            </td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Nome Evento:</td>
			<td width="90%"><input class="text" type="text" maxlength="100" size="50" name="nmEvent" title="* Nome Evento" value="<%=to.getNome()%>" /></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Atração   :</td>
			<td width="90%"><input class="text" type="text" maxlength="50" size="50" name="atracao" title="* Atração" value="<%=to.getAtracao()%>"/></td>
		</tr>
                
		<tr class="borderbottom">			
			<td class="coluna">Data de Inicio:</td>
			<td width="90%"><input class="text" type="text" maxlength="10" size="10" name="dtInicio" title="* Data Inicio (dd.mm.aaaa)" value="<%=to.getData_Inicio()%>"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Data de Fim:</td>
			<td width="90%"><input class="text" type="text" maxlength="10" size="10" name="dtFim" title="* Data Final (dd.mm.aaaa)" value="<%=to.getData_Final()%>" /></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna" nowrap="nowrap" valign="top">Descritivo do Evento:</td>
            <td width="90%"><textarea  cols="75" rows="8" name="deEvent"><%=to.getDescricao()%></textarea></td>
		</tr>
        <tr class="bordertop"><th class="top" colspan="2"></th></tr>
		</table>
	</fieldset>
	<div style="width:100%" align="right">
		<%
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.reset, admFuncoes.enumAlignInput.right, "btn-cancelar", "Cancelar"));
        if (vReqQueryID != null) {
            out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-excluir", "Excluir", "","acao"));                       
            out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-salvar", "Atualizar", "","acao"));
        } else {
            out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-confirmar", "Adicionar", "","acao"));
        }
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.button, admFuncoes.enumAlignInput.left, "btn-pesquisar", "Pesquisar", "javascript:goPage('con_eventos.jsp');"));        
        %>
	</div>
	</form>
</div>
</td></tr>
</table>
</div>

<%@ include file="includes/_siteEnd.jspf" %>