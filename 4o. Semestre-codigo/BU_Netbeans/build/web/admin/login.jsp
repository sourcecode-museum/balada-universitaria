<%-- 
    Document   : login
    Created on : 16/06/2008, 18:26:55
    Author     : Heliomar
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import="br.project.admin.*" %>

<%
admFuncoes oFuncoes = new admFuncoes(); 
admConfig oConfig = new admConfig();

String sMsgErro="";

if (request.getParameter("err") != null) {
    String err = request.getParameter("err");
    
    if (err.equals("2")) {
        sMsgErro = "Login inválido! Usuário ou senha não confere.";
    } 
    else {
        sMsgErro = "Login inválido! Tente novamente.";   
    }   
}
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title><%=oConfig.getNomeSite()%> - &Aacute;rea Administrativa</title>

    <link href="css/login.css" rel="stylesheet" type="text/css">
    <link href="css/forms.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="framework/js/funcoes.js" type="text/javascript"></script>

    <script language="javascript">
        function validaForm(pForm){
            if (validaCampos(pForm))
                pForm.submit();					
        }

        function onKeyDownEnter(pForm) {
            /*simula o clique do botao submit*/
            if (window.event.keyCode == 13) 
                validaForm(pForm);
        }
    </script>
</head>
<body onLoad="document.frmLogin.usuario.focus();">

<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
<tr><td valign="top">
    <%
    if (sMsgErro.trim().length() > 0) {
        sMsgErro = "<font color='#FF0000'>" + sMsgErro + "</font>";        
        out.print(oFuncoes.getMessageTop(sMsgErro, admFuncoes.enumMessageTop.Aviso));
        //out.print("<div id='msgtop'><font color='#FF0000'>" + sMsgErro + "</font></div>");
    }
    %>
</td></tr>
<tr><td height="100%">
    <div id="centerLogin">
        <form name="frmLogin" method="post" action="/Baladas/LoginServlet">
            <input type="hidden" name="login" value="A"/>
            <fieldset id="framelogin">
                <div id="imgLogin"></div>	
                <table border="0" cellpadding="0" cellspacing="3" width="100%" height="100%">
                    <tr>
                        <td width="100" rowspan="3">&nbsp;</td>
                        <th colspan="2" align="left"><br/>
                            Acesso de &aacute;rea restrita 
                            <hr noshade="noshade" color="#006600" size="1">
                        </th>
                    </tr>
                    <tr>
                        <td align="right">Usu&aacute;rio:&nbsp;</td>
                        <td><input title="* Usuário" class="textLCase" type="text" name="usuario"/></td>
                    </tr>
                    <tr>
                        <td align="right">Senha:&nbsp;</td>
                        <td><input title="* Senha" class="textLCase" type="password" name="senha" onKeyDown="javascript:onKeyDownEnter(this.form);"/></td>
                    </tr>
                    <tr><td colspan="3" style="height:5px;color:#808080" valign="bottom">::.</td></tr>
                </table>
            </fieldset>
            <div style="width:100%" align="right">
                <%
                out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.submit, admFuncoes.enumAlignInput.right, "btn-confirmar", "Confirmar"));
                out.println(oFuncoes.getBotao(admFuncoes.enumTypeInput.reset, admFuncoes.enumAlignInput.right, "btn-cancelar", "Limpar"));
                %>
            </div>
        </form>
    </div>
</td></tr>
<tr>
    <td id="footer" colspan="2">
        <h1>.:. IP: <%= request.getLocalAddr() %> </h1>
        <div id="right" align="right">
            <a href="mailto:<%=oConfig.getEmailSite()%>">By Equipe Balada Universitária</a>
            <br>
            <a href="<%=oConfig.getHttpSite()%>" target="_blank">&reg; TGSI 4A3 - Uninove Memorial</a>
        </div>
    </td>
</tr>
</table>

<script>document.frmLogin.usuario.focus();</script>

</body>
</html>
