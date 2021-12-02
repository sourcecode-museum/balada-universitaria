<%@ include file="includes/_siteBegin.jspf" %>

<script language="JavaScript">
	function validaForm(pForm){
		if (validaCampos(pForm)) {
			if (pForm.senha.value != pForm.senha2.value) {
				alert("Senha de confirmação não confere!");
				pForm.senha2.focus();
				return false;
			}
             
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
String vImgLogo = "imgs/ico-admin.jpg";
String vTituloPage = "Administrador";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; criar ou alterar usu&aacute;rios administradores!";
String vFormAction = "admin_cad.jsp";
String vMessageTop = "";

String vReqAcao = request.getParameter("acao");

if (vReqAcao != null) {
    vReqAcao = vReqAcao.toLowerCase();

    if (vReqAcao.equals("insert")) {
        String usuario = request.getParameter("usuario").toString();
        String senha = request.getParameter("senha").toString();
        String nome = request.getParameter("nome").toString();
        String email = request.getParameter("email").toString();

        try {
            Adm_UsuarioDAO dao = new Adm_UsuarioDAO();
            Adm_UsuarioTO to = dao.buscarPorPK(usuario);

            if (to != null) {
                vMessageTop = oFuncoes.getMessageTop("Esse nome de usuário já está em uso.<br/>Por favor, digite um outro nome.", admFuncoes.enumMessageTop.Erro); 
            }
            else {
                to = new Adm_UsuarioTO(usuario, senha, nome, email);
                dao.insert(to);
                vMessageTop = oFuncoes.getMessageTop("Novo administrador cadastrado com sucesso.", admFuncoes.enumMessageTop.Ok); 
            }    
        }
        catch (Exception ex) {
            vMessageTop = oFuncoes.getMessageTop("Erro ao executar esta operação!<br/>" + ex.getMessage(), admFuncoes.enumMessageTop.Erro) ;         
        }
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
	<form name="frmEditar" method="post" action="<%=vFormAction%>" onSubmit="return validaForm(this);">
	<input type="hidden" name="acao" value="insert"/>
	<fieldset>
	<legend class="negrito">Cadastrar</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr class="borderbottom"><th colspan="2"></th></tr>
		<tr class="borderbottom">			
			<td class="coluna">Nome:</td>
			<td width="90%"><input class="text" type="text" maxlength="50" size="50" name="nome" title="* Nome"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Usuário:</td>
			<td width="90%"><input class="textlcase" type="text" maxlength="30" size="15" name="usuario" title="* Usuário"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Senha:</td>
			<td width="90%"><input class="textlcase" type="text" maxlength="30" size="15" name="senha" title="* Senha"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Senha&nbsp;Confirmação:</td>
			<td width="90%"><input class="textlcase" type="text" maxlength="30" size="15" name="senha2" title="Confirme sua senha""/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Email:</td>
			<td width="90%"><input class="textlcase" type="text" maxlength="200" size="50" name="email" title="* Email"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Email&nbsp;Confirmação:</td>
			<td width="90%"><input class="textlcase" type="text" maxlength="200" size="50" name="email2" title="Confirme seu email""/></td>
		</tr>

         <tr class="bordertop"><th class="top" colspan="2"></th></tr>
		</table>
	</fieldset>
	<div style="width:100%" align="right">
		<%
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-confirmar", "Adicionar"));
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.reset, admFuncoes.enumAlignInput.right, "btn-cancelar", "Cancelar"));
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.button, admFuncoes.enumAlignInput.left, "btn-listagem", "Listagem", "javascript:goPage('admin_list.jsp');"));
		%>
	</div>
	</form>
</div>
</td></tr>
</table>
</div>

<%@ include file="includes/_siteEnd.jspf" %>