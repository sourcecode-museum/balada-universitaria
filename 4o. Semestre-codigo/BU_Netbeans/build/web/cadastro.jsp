<%@ include file="WEB-INF/jspf/_siteBegin.jspf" %>

<script language="JavaScript">
	function validaForm(pForm){
		if (validaCampos(pForm)) {
			if (pForm.Email.value != pForm.Email2.value) {
				alert("Email de confirmação está diferente!");
				pForm.Email2.focus();
				return false;
			}
			if (pForm.Senha.value != pForm.Senha2.value) {
				alert("Senha de confirmação está diferente!");
				pForm.Senha2.focus();
				return false;
			}
			return true;					
		} 
		return false;
	}
     
    function postaInfo(pForm) {
        var param = getParameters(pForm);

        ret = CallPage("posts/postCadastro.jsp?" + param); 
        
        if (ret.substr(0,4).equals("Erro")) {
            return false;
        } 
        else {           
            pForm.reset();                
            return true;
        }
    }
    
    function enviar(pForm){
        if(validaForm(pForm)) 
            if (postaInfo(pForm))
                return true;

        return false;
    }
</script>

<label>
<form name="frmTela" method="post" action="#" onSubmit="enviar(this);">
    <!--<fieldset>-->	
    <h3>CADASTRO</h3>
    <div class='l-gray3'><img src='imgs/red1.gif' width='9' height='1' border='0'></div>
    <p>
        Cadastre seus dados para receber em primeira mo as informaes das melhores festas da cidade.
        <br/>Ao se cadastrar voc ainda participa de nossas Promoções automaticamente.
    </p>

    <table align='center' cellspacing='0' cellpadding='0' border='0' width='100%'>
    <tr>
        <td><img src="imgs/site/c1.gif" width="7" height="7" alt="" border="0"></td>
        <td background="imgs/site/c2.gif"></td>
        <td><img src="imgs/site/c3.gif" width="7" height="7" alt="" border="0"></td>
    </tr>
    <tr>
        <td background="imgs/site/c4.gif"></td>
        <td bgcolor="black" width="100%" align="left">

			<table border="0" cellpadding="0" cellspacing="1" align="center" width="300px">

			<tr><th colspan="2" height="30px"><div style="text-align:center"><span class="blue">INFORMAÇÕES DE ACESSO</span></div></th></tr>
			<tr>
				<th align="right">Email:&nbsp;</th>
				<td><input class="textlcase" type="text" maxlength="150" style="width:280px" name="Email" value="" title="* Email" /></td>
			</tr>
			<tr>
				<th align="right" nowrap="nowrap">Email de confirmação:&nbsp;</th>
				<td><input class="textlcase" type="text" maxlength="150" style="width:280px" name="Email2"/></td>
			</tr>
			<tr>
				<th align="right">Senha:&nbsp;</th>
				<td><input class="textlcase" type="password" maxlength="30" style="width:80px" name="Senha"  title="* Senha"/></td>
			</tr>
			<tr>
				<th align="right" nowrap="nowrap">Senha de confirmao:&nbsp;</th>
				<td><input class="textlcase" type="password" maxlength="30" style="width:80px" name="Senha2"/></td>
			</tr>
					
			<tr>
				<th colspan="2" height="30px" align="right">
					<br><div class='l-gray3'><img src='imgs/blue1.gif' width='9' height='1' border='0'></div><br>
					<div style="text-align:center"><span class="blue">INFORMAÇÕES CADASTRAIS</span></div>
					<br>
				</th>
			</tr>
			<tr>			
				<th align="right"><span id="labelNome">Nome:&nbsp;</span></th>
				<td><input class="textucase" type="text" maxlength="100" style="width:280px" id="nome" name="Nome" value="" title="* Nome:&nbsp;"/></td>
			</tr>
			<tr>
				<th align="right"><span id="labelDtNasc">Sexo:&nbsp;</span></th>
				<td> 
                                   <select name="Sexo" style="width:40px;" class="input_form" id="Sexo">
                                            <option selected value=""></option>
                                            <option value="M">M</option>
                                            <option value="F">F</option>
                                        </select> </td>
                                       
                                       
                                
			</tr
			<tr>
				<th align="right"><span id="labelRg">RG:&nbsp;</span></th>
				<td><input class="textucase" type="text" maxlength="18" style="width:100px" id="cpfcgc" name="Rg" value="" title="* Rg:&nbsp;" onKeyPress="SoNumeros()" onBlur="validaNumeros(this)"/></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<th align="right">CEP:&nbsp;</th>
				<td><input class="textucase" type="text" maxlength="9" style="width:80px" name="Cep" value=""/></td>
			</tr>
			<tr>
				<th align="right">Endereço:&nbsp;</th>
				<td><input class="textucase" type="text" maxlength="150" style="width:280px" name="Endereco" value=""/></td>
			</tr>
    			<tr>
				<th align="right">Bairro:&nbsp;</th>
				<td><input class="textucase" type="text" maxlength="50" style="width:280px" name="Bairro" value=""/></td>
			</tr>
			<tr>
				<th align="right">Cidade:&nbsp;</th>
				<td><input class="textucase" type="text" maxlength="30" style="width:180px" name="Cidade"/>&nbsp;UF:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                
                                <select name="Uf" id="Uf" style="width:50px;">
                                    <option value=00>Estado</option>
                                    <%@ include file="WEB-INF/jspf/_buscaUf.jspf" %>
                          </select></td>
                                
                                			</tr>		
			<tr><td colspan="2">&nbsp;</td></tr>	
			<tr>
				<th align="right">Telefone:&nbsp;</th>
				<td>
					<input class="textucase" type="text" maxlength="3" style="width:30px" name="Cod_Area" value="" title="* Codigo de area" onKeyPress="SoNumeros()" onBlur="validaNumeros(this)"/>
					<label>-</label>
					<input class="textucase" type="text" maxlength="10" style="width:80px" name="Telefone" value="" title="* Telefone" onKeyPress="SoNumeros()" onBlur="validaNumeros(this)"/>
				</td>
			</tr>
		
			<tr>
				<td align="right" colspan="2">
					<br><div class='l-gray3'><img src='imgs/blue1.gif' width='9' height='1' border='0'></div><br>					
					<input class="button" type="submit" name="acao" value="Cadastrar"/>
					<input class="button" type="reset" name="cancelar" value="Cancelar"/>
				</td>
			</tr>
			</table>
        </td>
        
        <td background="imgs/site/c5.gif"></td>
    </tr>
    <tr>
        <td><img src="imgs/site/c6.gif" width="7" height="7" alt="" border="0"></td>
        <td background="imgs/site/c7.gif"></td>
        <td><img src="imgs/site/c8.gif" width="7" height="7" alt="" border="0"></td>
    </tr>
    </table>
	<!--</fieldset>	-->		
</form>
</label>

<%@ include file="WEB-INF/jspf/_siteEnd.jspf" %>