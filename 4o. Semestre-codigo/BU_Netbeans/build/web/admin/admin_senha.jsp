<%@ include file="includes/_siteBegin.jspf" %>

<script language="JavaScript">
	function validaForm(pForm){
		if (validaCampos(pForm)) {
			if (pForm.senha.value != pForm.senha2.value) {
				alert("Senha de confirmação não confere!");
				pForm.senha2.focus();
				return false;
			}
			return true;					
		} 
		return false;
	}
</script>

<%
String vReqAcao = "";
String vMessageTop = "";
String vImgLogo = "imgs/ico-trocarsenha.png";
String vTituloPage = "Administrador";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; trocar sua senha.";
String vFormAction = "admin_senha.jsp";

if (request.getParameter("acao") != null) {
    vReqAcao = request.getParameter("acao").toString().toLowerCase();
}

if (vReqAcao.equals("alterar")) {
    String senhaatual = request.getParameter("senhaatual").toLowerCase();
    String senha = request.getParameter("senha").toLowerCase();    
    
    if (senhaatual.equals(admSession.getSenha())) {
        Adm_UsuarioDAO dao = new Adm_UsuarioDAO();
        Adm_UsuarioTO to = dao.buscarPorPK(admSession.getUsuario());
        to.setSenha(senha);
        
        dao.update(to);
        vMessageTop = oFuncoes.getMessageTop("Senha alterada com sucesso.", admFuncoes.enumMessageTop.Ok);
        
        //atualizando os dados da secao
        admSession.setSenha(senha);
        request.getSession().setAttribute("adm_session", admSession);
    }
    else {
        vMessageTop = oFuncoes.getMessageTop("<b>Atenção:</b><br/>SENHA ATUAL informada não confere.<br/>Tente mais uma vez!", admFuncoes.enumMessageTop.Aviso);
    }
} 
%>

<div id="main">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr><td width="100%" valign="top">
	<%= oFuncoes.getTituloPagina(vImgLogo, vTituloPage, vSubTitulo)%>
</td></tr>
<tr><td><%=vMessageTop%></td></tr>
<tr><td class="main" valign="top">
<div class="panel">
	<form name="frmEditar" method="post" action="<%=vFormAction%>" onSubmit="return validaForm(this);">
	<fieldset>
	<legend class="negrito">Trocar Senha</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr class="borderbottom"><th colspan="2"></th></tr>
		<tr class="borderbottom">		
			<td class="coluna" width="10%" nowrap="nowrap">Senha&nbsp;Atual:</td>
			<td><input class="text" type="password" maxlength="50" size="15" name="senhaatual" title="* Senha Atual"/></td>
		</tr>	
		<tr>		
			<td class="coluna" nowrap="nowrap">Nova&nbsp;Senha:</td>
			<td><input class="text" type="password" maxlength="50" size="15" name="senha" title="* Senha"/></td>
		</tr>
		<tr>			
			<td class="coluna" nowrap="nowrap">Confirmar&nbsp;Senha:</td>
			<td><input class="text" type="password" maxlength="50" size="15" name="senha2" title="Confirme sua senha"/></td>
		</tr>
		<tr class="bordertop"><th class="top2" colspan="2"></th></tr>
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