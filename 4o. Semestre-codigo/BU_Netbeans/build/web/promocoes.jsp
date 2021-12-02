<%@ include file="WEB-INF/jspf/_siteBegin.jspf" %>
<%-- 
    Document   : promocoes
    Created on : 14/06/2008, 21:47:46
    Author     : Heliomar
--%>
<label>
<form name="frmTela" method="post" action="#" onSubmit="return validaCampos(this);">
    <!--<fieldset>-->	
    <h3>Promoções</h3>
    <div class='l-gray3'><img src='imgs/red1.gif' width='9' height='1' border='0'></div>
    <p>
        Disponibilizamos aqui as promoções de nossos parceiros e que tem como objetivo dar condições de nossos usuários terem mais vantagens na balada!
        <br>Desfrute de todas as promoções e bom divertimento!
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

<%    
        
java.sql.Connection conn = br.project.dao.JdbcDAOFactory.getConnection();
java.sql.PreparedStatement pstmt;
pstmt = conn.prepareStatement(
        "select Cod_evento_promocao,                         " +
        "       Nome_fantasia,                               " + 
        "       nome titulo,                                 " + 
        "       data_inicio,                                 " + 
        "       data_final,                                  " + 
        "       descricao                                    " +
        "from EVENTO_PROMOCAO a,                             " + 
        "     estabelecimento b                              " + 
        "WHERE TIPO ='P'                                     " + 
        "  and data_final >= current_date                    " + 
        "  and a.cod_estabelecimento = b.cod_estabelecimento " + 
        "order by data_inicio");
                            
java.sql.ResultSet toAux = pstmt.executeQuery();
    
     java.lang.StringBuilder sb = new java.lang.StringBuilder();
     while(toAux.next()){
                sb.append("<p><b>Estabelecimento :</b> ");
                sb.append(toAux.getString("nome_fantasia"));
                sb.append("<br><b>Título:</b> ");
                sb.append(toAux.getString("titulo")); 
                sb.append("<br><b>Validade:</b> ");
                sb.append(toAux.getString("data_inicio")); 
                sb.append(" à ");
                sb.append(toAux.getString("data_final")); 
                sb.append("<br><b>Descrição:</b>");
                sb.append(toAux.getString("descricao"));    
                sb.append("</p><hr>");       
            }
       toAux.close();
       out.print(sb.toString());
       
 %>

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