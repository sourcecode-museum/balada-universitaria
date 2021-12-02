<%@ include file="includes/_siteBegin.jspf" %>

<%
String vReqAcao = "";
String vMessageTop = "";
String vImgLogo = "imgs/ico-admin.jpg";
String vTituloPage = "Cadastros";
String vSubTitulo = "Aqui voc&ecirc; poder&aacute; criar, alterar, atualizar ou deletar eventos!";
String vFormAction = "admin_eventos.jsp";
int vCodEstab=0; 
int vCodEvent=0; 
String sCodEvent=""; 
String vNmEvent=""; 
String vAtracao=""; 
String vDtIni=""; 
String vDtFim=""; 
String vDeEvent=""; 

if (request.getParameter("acao") != null) {
    vReqAcao = request.getParameter("acao").toString().toLowerCase();
    

}

if (vReqAcao.equals("adicionar")) {
    
    try {
      
        Evento_PromocaoDAO dao = new Evento_PromocaoDAO(JdbcDAOFactory.getConnection());
            Evento_PromocaoTO to = new Evento_PromocaoTO();
            to.setCod_Estabelecimento(Integer.parseInt(request.getParameter("nmEstab")));
            to.setNome(request.getParameter("nmEvent"));
            to.setDescricao(request.getParameter("deEvent"));            
            to.setTipo("E");
            to.setData_Inicio(request.getParameter("dtInicio"));
            to.setData_Final(request.getParameter("dtFim"));
            to.setAtracao(request.getParameter("atracao"));
        dao.insert(to);
        
    vMessageTop = oFuncoes.getMessageTop("Registro inserido com sucesso!", "Ok");
    
} catch( Exception e ) {
    vMessageTop = oFuncoes.getMessageTop("Erro na gravação: " + e.getMessage(), "Erro");
}
}


if (vReqAcao.equals("atualizar")) {
    
    try {
      
        Evento_PromocaoDAO dao = new Evento_PromocaoDAO(JdbcDAOFactory.getConnection());
            Evento_PromocaoTO to = new Evento_PromocaoTO();
            to.setCod_Evento_promocao(Integer.parseInt(request.getParameter("codEvent")));
         
            to.setCod_Estabelecimento(Integer.parseInt(request.getParameter("nmEstab")));
            to.setNome(request.getParameter("nmEvent"));
            to.setDescricao(request.getParameter("deEvent"));            
            to.setTipo("E");
            to.setData_Inicio(request.getParameter("dtInicio"));
            to.setData_Final(request.getParameter("dtFim"));
            to.setAtracao(request.getParameter("atracao"));
        dao.update(to);
        
    out.print("Registro atualizado com sucesso!");
    
} catch( Exception e ) {
    out.print("Erro na gravação: " + e.getMessage());
}
}


if (vReqAcao.equals("excluir")) {
    
    try {
      
        Evento_PromocaoDAO dao = new Evento_PromocaoDAO(JdbcDAOFactory.getConnection());
            Evento_PromocaoTO to = new Evento_PromocaoTO();
            to.setCod_Evento_promocao(Integer.parseInt(request.getParameter("codEvent")));
            dao.delete(to);
    out.print("Registro excluído com sucesso!");            
} catch( Exception e ) {
    out.print("Erro na deleção: " + e.getMessage());
}
}       

if (vReqAcao.equals("pesquisar")) {
    try {
      
        Evento_PromocaoDAO dao = new Evento_PromocaoDAO(JdbcDAOFactory.getConnection());
            Evento_PromocaoTO to = new Evento_PromocaoTO();
            to.setCod_Evento_promocao(Integer.parseInt(request.getParameter("codEvent")));
            Evento_PromocaoTO eto = dao.findByPrimaryKey(to);

            vCodEstab=eto.getCod_Estabelecimento();
            vCodEvent=eto.getCod_Evento_promocao();
            sCodEvent=""+vCodEvent;
            vNmEvent=eto.getNome();
            vAtracao=eto.getAtracao();
            vDtIni=eto.getData_Inicio();
            vDtFim=eto.getData_Final();
            vDeEvent=eto.getDescricao();
    out.print("Registro selecionado com sucesso!"); 
    out.print(vCodEstab)                          ;
} catch( Exception e ) {
    out.print("Erro na seleção: " + e.getMessage());
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
	<fieldset>
	<legend class="negrito">Eventos</legend>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr class="borderbottom"><th colspan="2"></th></tr>
		<tr class="borderbottom">	

			<td class="coluna">Código Evento:</td>
			<td width="90%"><input  VALUE="<%=sCodEvent%>" class="text" type="text" maxlength="10" size="10" name="codEvent" title="* Nome"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Estabelecimento:</td>
			<td width="90%">
                    <select name="nmEstab" style="width:30%; size: 50" id="nmEstab">
                        <%@ include file="/WEB-INF/jspf/_buscaEstabelecimento.jspf" %>
                    </select>
                            
                            </td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Nome Evento:</td>
			<td width="90%"><input value="<%=vNmEvent%>" class="text" type="text" maxlength="100" size="50" name="nmEvent" title="* Senha"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Atração   :</td>
			<td width="90%"><input value="<%=vAtracao%>" class="text" type="text" maxlength="50" size="50" name="atracao" title="* Senha"/></td>
		</tr>
                
		<tr class="borderbottom">			
			<td class="coluna">Data de Inicio:</td>
			<td width="90%"><input value="<%=vDtIni%>" class="text" type="text" maxlength="10" size="10" name="dtInicio" title="* dd.mm.aaaa"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Data de Fim   :</td>
			<td width="90%"><input value="<%=vDtFim%>" class="text" type="text" maxlength="10" size="10" name="dtFim" title="* dd.mm.aaaa"/></td>
		</tr>
		<tr class="borderbottom">			
			<td class="coluna">Descritivo do Evento:</td>
                        <td width="90%"><textarea  cols="80" rows="6" name="deEvent"><%=vDeEvent%></textarea></td>
		</tr>
                
                <tr class="bordertop"><th class="top" colspan="2"></th></tr>
		</table>
	</fieldset>
	<div style="width:100%" align="right">
		<%
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-confirmar", "Adicionar","","acao"));
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-pesquisar", "Pesquisar","","acao"));        
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-salvar", "Atualizar","","acao"));                
        out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-cancelar", "Excluir","","acao"));                        
       
		%>
	</div>
	</form>
</div>
</td></tr>
</table>
</div>

<%@ include file="includes/_siteEnd.jspf" %>