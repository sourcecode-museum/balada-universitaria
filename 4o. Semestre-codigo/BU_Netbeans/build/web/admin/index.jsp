<%@ include file="includes/_siteBegin.jspf" %>
<%
String sImgLogo = "imgs/ico-home.png";
String sTituloPage = "Principal";
String sSubTitulo = "Bem-vindo &agrave; central administrativa do seu site";

Evento_PromocaoDAO daoEventos = new Evento_PromocaoDAO(JdbcDAOFactory.getConnection());
UsuarioDAO daoUsuario = new UsuarioDAO(JdbcDAOFactory.getConnection());

long qtdEventos = daoEventos.getTotalRegistros();
long qtdUsuarios = daoUsuario.getTotalRegistros();
List lstUsuarios = daoUsuario.getUltimosCadastros(5);

daoEventos = null;
daoUsuario = null;
%>

<div id="main">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr><td valign="top">
    <% out.print(oFuncoes.getTituloPagina(sImgLogo, sTituloPage, sSubTitulo));%>
</td></tr>
<tr><td class="main" valign="top">
    <div class="panel-a">
        <fieldset>
            <legend>Estat&iacute;sticas</legend>
            <table border="0" cellpadding="0" cellspacing="0">
            <tbody>
            <tr>
                <!--
                <td onClick="location='#'">
                    <img src="imgs/online.png"><br>Visitas<br><=cdbl(oContador.getNVisitas())%>
                </td>
                -->
                <td onClick="location='con_usuarios.jsp'">
                    <img src="imgs/customer.png"><br>Usuarios<br><%=qtdUsuarios%>
                </td>
                <td onClick="location='con_eventos.jsp'">
                    <img src="imgs/order.png"><br>Eventos<br><%=qtdEventos%>
                </td>
            </tr>
            </tbody>
            </table>
        </fieldset> 
    </div>
    
    <% 
    if (lstUsuarios != null) {        
    %>    
    <div class="panel-b">
        <fieldset>
            <legend>Últimos Usuários</legend>
            <table class=list>
            <tbody>
                <tr class="borderbottom">
                    <th align="left">Nome</th>
                    <th align="left">Email</th>
                    <th align="left">Cidade - UF</th>                    
                    <th align="left">Data Cadastro</th>
                </tr>
                <%
                String trclass;
                int cont = 0;
                
                for (Object obj : lstUsuarios) {
                    UsuarioTO toUsu = (UsuarioTO) obj;
                    
                    trclass = "row" + ((cont % 2) + 1);
                    cont++;
                    
                    //out.println("<tr class='" + trclass + "' onMouseOut=\"this.className='" + trclass + "'\" onMouseOver=\"this.className='highlight'\" onclick=\"location='cad_usuarios.jsp?queyid=" + toUsu.getEmail() + "'\">");
                    out.println(oFuncoes.getTagTRLight(trclass, "cad_usuarios.jsp?queryid=" + toUsu.getEmail()));
                    out.println("<td>" + toUsu.getNome() + "</td>");
                    out.println("<td>" + toUsu.getEmail() + "</td>");
                    out.println("<td>" + toUsu.getCidade() + " - " + toUsu.getUf() + "</td>");
                    out.println("<td>" + toUsu.getDt_Cadastro() + "</td>");
                    out.println("</tr>");
                }
                %>                
            </tbody>
            </table>
        </fieldset> 
    </div>
    <%
    } //end if lista de usuarios
    %>
</td></tr>
</table>
</div>

<%@ include file="includes/_siteEnd.jspf"%>