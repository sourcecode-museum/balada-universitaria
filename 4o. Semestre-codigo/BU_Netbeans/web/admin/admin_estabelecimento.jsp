<%@ include file="includes/_siteBegin.jspf" %>
<%@ page import="br.project.dao.*"%>
<%@ page import="br.project.transferobject.*"%>


<%
String vReqAcao = "";
String vMessageTop = "";
String vImgLogo = "imgs/ico-admin.jpg";
String vTituloPage = "Cadastros";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; criar, alterar, atualizar ou deletar eventos!";
String vFormAction = "admin_estabelecimento.jsp";
int vCodEstab=0; 
String sCodEstab=""; 
String vNmEstab=""; 
String vEnd=""; 
String vTel=""; 
String vCodArea=""; 
String vBairro=""; 
String vCidade=""; 

if (request.getParameter("acao") != null) {
    vReqAcao = request.getParameter("acao").toString().toLowerCase();

}

if (vReqAcao.equals("insert")) {
    
    try {
      
        EstabelecimentoDAO dao = new EstabelecimentoDAO(JdbcDAOFactory.getConnection());
            EstabelecimentoTO to = new EstabelecimentoTO();
            to.setNome_Fantasia(request.getParameter("nmEstab"));
            to.setBairro(request.getParameter("nmBairro")); 
            to.setCidade(request.getParameter("nmCidade"));
            to.setEndereco(request.getParameter("End"));
            to.setTelefone(request.getParameter("nrTel"));
            to.setUf(request.getParameter("uf"));
            to.setCod_Area(Integer.parseInt(request.getParameter("codArea")));
        
        dao.insert(to);
        
    vMessageTop = oFuncoes.getMessageTop("Registro inserido com sucesso!", "Ok");
    
} catch( Exception e ) {
    vMessageTop = oFuncoes.getMessageTop("Erro na gravação: " + e.getMessage(), "Erro");
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
	<legend class="negrito">Estabelecimentos</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr class="borderbottom"><th colspan="2"></th></tr>
		<tr class="borderbottom">	
    
			<td class="coluna">Código:</td>
			<td width="90%"><input  VALUE="<%=sCodEstab%>" class="text" type="text" maxlength="10" size="10" name="codEstab" title="* Nome"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Estabelecimento:</td>
			<td width="90%">
                            <input  VALUE="<%=vNmEstab%>" class="text" type="text" maxlength="50" size="50" name="nmEstab" title="* Nome"/>
                            </td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Endereço:</td>
			<td width="90%"><input value="<%=vEnd%>" class="text" type="text" maxlength="150" size="80" name="End" title="* Endereço"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Bairro   :</td>
			<td width="90%"><input value="<%=vBairro%>" class="text" type="text" maxlength="100" size="50" name="nmBairro" title="* Bairro"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Cidade   :</td>
			<td width="90%"><input value="<%=vCidade%>" class="text" type="text" maxlength="100" size="50" name="nmCidade" title="* Cidade"/></td>
		</tr>
                
		<tr class="borderbottom">			
			<td class="coluna">Estado:</td>
			<td width="90%">
                    <select  name="uf" onChange="MM_jumpMenu('parent',this,0)" id="uf">
                        <%@ include file="/WEB-INF/jspf/_buscaUf.jspf" %>                         
                    </select>
                    </td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Telefone   :</td>
			<td width="90%"><input value="<%=vCodArea%>" class="text" type="text" maxlength="3" size="3" name="codArea" title="* Código de Área"/>
                        <input value="<%=vTel%>" class="text" type="text" maxlength="15" size="15" name="nrTel" title="* Número do Telefone"/>
                        </td>
		</tr>
                
                <tr class="bordertop"><th class="top" colspan="2"></th></tr>
		</table>
	</fieldset>
	<div style="width:100%" align="right">
		<%
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-confirmar", "Adicionar"));
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-pesquisar", "Pesquisar"));        
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-salvar", "Atualizar"));                
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-cancelar", "Excluir"));                        
       
		%>
	</div>
	</form>
</div>
</td></tr>
</table>
</div>

<%@ include file="includes/_siteEnd.jspf" %>