<%@ include file="includes/_siteBegin.jspf" %>

<%
String vImgLogo = "imgs/ico-editar.png";
String vTituloPage = "Cadastros";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; alterar o cadastro dos usuários!";
String vFormAction = "cad_usuarios.jsp";
String vPageListagem = "con_usuarios.jsp";
String vMessageTop = "";

String vReqAcao = request.getParameter("acao");
String vReqQueryID = request.getParameter("queryid");

UsuarioTO to = null;

if (vReqAcao != null && vReqQueryID != null) {
    vReqAcao = vReqAcao.toLowerCase();

    if (vReqAcao.equals("alterar")) {
        try {
            UsuarioDAO dao = new UsuarioDAO(JdbcDAOFactory.getConnection());
            boolean altEmail = !request.getParameter("email").equals(vReqQueryID);
            
            if (altEmail) {                
                //se estiver alterando o deve veriricar se já não existe o email
                to = dao.buscarPorPk(request.getParameter("email"));
                if (to != null) {
                    vMessageTop = oFuncoes.getMessageTop("Este email já esta cadastro favor informar outro endereço.", admFuncoes.enumMessageTop.Aviso); 
                }   
            }
            
            if (to == null) {
                to = dao.buscarPorPk(vReqQueryID);

                if (to == null) {
                    vMessageTop = oFuncoes.getMessageTop("Registro não encontrado para alteração.", admFuncoes.enumMessageTop.Aviso); 
                } else {
                    to.setEmailNovo(request.getParameter("email"));
                    to.setNome(request.getParameter("nome"));
                    to.setSenha(request.getParameter("senha"));
                    to.setBairro(request.getParameter("bairro"));
                    to.setRg(request.getParameter("rg"));
                    to.setSexo(request.getParameter("sexo"));
                    to.setEndereco(request.getParameter("endereco"));
                    to.setCep(request.getParameter("cep"));
                    to.setCidade(request.getParameter("cidade"));
                    to.setTelefone(request.getParameter("telefone"));
                    to.setCod_Area(Integer.parseInt(request.getParameter("cod_area")));
                    to.setDt_Ultimo_Acesso(request.getParameter("dt_ultimo_acesso"));
                    to.setUf(request.getParameter("uf"));                               
                
                    dao.update(to);
    
                    vMessageTop = oFuncoes.getMessageTop("Registro alterado com sucesso.", admFuncoes.enumMessageTop.Ok); 
                }    
            }
        
        } catch (Exception ex) {
            vMessageTop = oFuncoes.getMessageTop("Erro ao executar esta operação!<br/>" + ex.getMessage(), admFuncoes.enumMessageTop.Erro) ;         
        }
    }    
} else if (vReqQueryID != null) {
    UsuarioDAO dao = new UsuarioDAO(JdbcDAOFactory.getConnection());
    to = dao.buscarPorPk(vReqQueryID);
}

if (to == null) {
    to = new UsuarioTO();
    vReqQueryID = null;
}

if (vReqQueryID != null) {vFormAction += "?queryid=" + vReqQueryID;}
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
	<legend class="negrito">Usuários</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr class="borderbottom"><th colspan="2"></th></tr>
		<tr class="borderbottom">			
			<td class="coluna">Email:</td>
			<td width="90%"><input class="textlcase" type="text" maxlength="200" size="50" name="email" title="* Email" value="<%=to.getEmail()%>"/></td>
		</tr>

         <tr class="borderbottom">			
			<td class="coluna">Senha:</td>
			<td width="90%"><input class="textlcase" type="text" maxlength="30" size="15" name="senha" title="* Senha" value="<%=to.getSenha()%>"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Nome:</td>
			<td width="90%"><input class="textucase" type="text" maxlength="50" size="50" name="nome" title="* Nome" value="<%=to.getNome()%>"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Sexo:</td>
			<td width="90%"><input class="textucase" type="text" maxlength="1" size="2" name="sexo" title="* Sexo" value="<%=to.getSexo()%>"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">RG:</td>
			<td width="90%"><input class="text" type="text" maxlength="18" size="20" name="rg" title="* RG" value="<%=to.getRg()%>"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">CEP:</td>
			<td width="90%"><input class="text" type="text" maxlength="9" size="10" name="cep" title="* CEP" value="<%=to.getCep()%>"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Endereço:</td>
			<td width="90%"><input class="textucase" type="text" maxlength="50" size="50" name="endereco" title="* Endereço" value="<%=to.getEndereco()%>"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Bairro:</td>
			<td width="90%"><input class="textucase" type="text" maxlength="50" size="50" name="bairro" title="* Bairro" value="<%=to.getBairro()%>"/></td>
		</tr>
         <tr class="borderbottom">			
			<td class="coluna">Cidade:</td>
            <td width="90%"><input class="textucase" type="text" maxlength="50" size="39" name="cidade" title="* Cidade" value="<%=to.getCidade()%>"/> &nbsp;&nbsp;<b>UF:&nbsp;</b> <input class="text" type="text" maxlength="2" size="2" name="uf" title="* UF" value="<%=to.getUf()%>"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Telefone:</td>
			<td width="90%">
                 <input class="text" type="text" maxlength="3" size="5" name="cod_area" title="* Código de Area" value="<%=to.getCod_Area()%>"/>
                 <label>-</label>
                 <input class="text" type="text" maxlength="10" size="15" name="telefone" title="* Telefone" value="<%=to.getTelefone()%>"/>
            </td>
		</tr>

         <tr class="bordertop"><th class="top" colspan="2"></th></tr>
		</table>
	</fieldset>
	<div style="width:100%" align="right">
		<%
        if (vReqQueryID != null) {
            out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-salvar", "Alterar", "", "acao"));
            out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.reset, admFuncoes.enumAlignInput.right, "btn-cancelar", "Cancelar"));
        }
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.button, admFuncoes.enumAlignInput.left, "btn-listagem", "Listagem", "javascript:goPage('" + vPageListagem + "');"));
		%>
	</div>
	</form>
</div>
</td></tr>
</table>
</div>

<%@ include file="includes/_siteEnd.jspf" %>