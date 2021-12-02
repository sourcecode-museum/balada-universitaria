<%@ include file="includes/_siteBegin.jspf" %>

<script language="JavaScript">
	function validaForm(pForm){
		if (validaCampos(pForm)) {
			if (pForm.email.value != pForm.email2.value) {
				alert("E-mail de confirmação não confere!");
				pForm.email2.focus();
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
String vImgLogo = "imgs/ico-editar.png";
String vTituloPage = "Administrador";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; alterar seus dados cadastrados.";
String vFormAction = "admin_edit.jsp";

String nome ="";
String email = "";
        
if (request.getParameter("acao") != null) {
    vReqAcao = request.getParameter("acao").toString().toLowerCase();
}

if (vReqAcao.equals("alterar")) {
    String senhaatual = request.getParameter("senhaatual").toLowerCase();
    nome = request.getParameter("nome");
    email = request.getParameter("email").toLowerCase();    
    
    if (senhaatual.equals(admSession.getSenha())) {
        Adm_UsuarioDAO dao = new Adm_UsuarioDAO();
        Adm_UsuarioTO to = dao.buscarPorPK(admSession.getUsuario());

        to.setNome(nome);
        to.setEmail(email);
               
        dao.update(to);
        vMessageTop = oFuncoes.getMessageTop("Registro alterado com sucesso.", admFuncoes.enumMessageTop.Ok);
        
        nome = "";
        email = "";
        //atualizando os dados da secao
        admSession = to;
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
			<td class="coluna" nowrap="nowrap">Nome:</td>
			<td><input class="text" type="text" maxlength="50" size="50" name="nome" title="* Nome" value="<%=nome%>"/></td>
		</tr>
		<tr>			
			<td class="coluna" nowrap="nowrap">Email:</td>
			<td><input class="textlcase" type="text" maxlength="200" size="50" name="email" title="* Email" value="<%=email%>"/></td>
		</tr>
        <tr>			
			<td class="coluna" nowrap="nowrap">Confirmar&nbsp;Email:</td>
			<td><input class="textlcase" type="text" maxlength="200" size="50" name="email2" title="Confirme seu email"/></td>
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