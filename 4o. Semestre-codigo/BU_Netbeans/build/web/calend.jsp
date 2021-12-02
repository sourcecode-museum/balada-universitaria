<%@ include file="WEB-INF/jspf/_siteBegin.jspf" %>

<%@page import="java.util.List, java.lang.*" %>
<label>
<form name="frmTela" method="post" action="calendario.jsp">
    <!--<fieldset>-->
    <h3>Calendário</h3>
    <div class='l-gray3'><img src='imgs/red1.gif' width='9' height='1' border='0'></div>
    <p>
        Encontre aqui os melhores eventos da sua cidade.
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
                
                <table border="0" cellpadding="0" cellspacing="1" align="left" width="300px">
                <tr>
                    <td>
                    <select name="mes" onChange="MM_jumpMenu('parent',this,0)" id="mes">
                        <%@ include file="WEB-INF/jspf/_incluirMes.jspf" %>
                    </select>
                    <select  name="uf" onChange="MM_jumpMenu('parent',this,0)" id="uf">
                        <%@ include file="WEB-INF/jspf/_buscaUf.jspf" %>
                        
                         
                    </select>
                <input type="submit"  value="Enviar" size="300px"></tr>
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
    <br>
    
    <table align='center' cellspacing='0' cellpadding='0' border='0' width='100%'>
        <tr>
            <hr size="1">
            
            
            <%
            String mes = request.getParameter("mes");
            String uf = request.getParameter("uf");
            int qtdImpresso = 0;
            String sLastPK = request.getParameter("lastPK");
            String sFirstPK = sLastPK;
            if (mes != null && uf != null) {
                try {
                    //                    java.sql.Connection conn = br.project.dao.JdbcDAOFactory.getConnection();
                    java.sql.PreparedStatement pstmt;
                    pstmt = conn.prepareStatement("select cod_evento_promocao, " +
                            "       data_inicio, data_final, nome, atracao,    " +
                            "       nome_fantasia, endereco, bairro, uf,       " +
                            "       cod_area, telefone, descricao              " +
                            "from  estabelecimento a,                          " +
                            "      evento_promocao b                           " +
                            "where a.cod_estabelecimento =                     " +
                            "                 b.cod_estabelecimento            " +
                            "  and tipo  = 'E'                                 " +
                            "  and ( month(data_final)  =  ?   or              " +
                            "        month(data_inicio) =  ?                   " +
                            "       )                                          " +
                            "  and data_final >= current_date " +
                            "  and cod_evento_promocao > ? ");



                    pstmt.setInt(1, Integer.parseInt(mes));
                    pstmt.setInt(2, Integer.parseInt(mes));
                    pstmt.setInt(3, (sLastPK != null ? Integer.parseInt(sLastPK) : 0));

                    java.sql.ResultSet toAux = pstmt.executeQuery();


                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    boolean temMais;
                    while ((temMais = toAux.next()) && qtdImpresso < 2) {

                        sLastPK = toAux.getString("cod_evento_promocao");
                        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"5\" cellpadding=\"1\"> ");
                        sb.append("<tr> ");
                        sb.append("<td  width=\"15%\" id=\"borda\"><font size=\"1\">Data</font></td id=\"borda\" > ");
                        sb.append("<td width=\"85%\" id=\"borda\"  ><font color=\"#808080\" size=\"1\"><h2> ");
                        sb.append(toAux.getString("data_inicio"));
                        sb.append(" à ");
                        sb.append(toAux.getString("data_final"));
                        sb.append("</h2></font></td id=\"borda\" > ");
                        sb.append("</tr></td<<br>");

                        sb.append("<tr> ");
                        sb.append("<td  width=\"15%\" id=\"borda\"><font size=\"1\">Evento</font></td id=\"borda\" > ");
                        sb.append("<td width=\"85%\" id=\"borda\"  ><font color=\"#808080\" size=\"1\"> ");
                        sb.append(toAux.getString("nome"));
                        sb.append("</font></td id=\"borda\" > ");
                        sb.append("</tr></td<<br>");

                        sb.append("<tr> ");
                        sb.append("<td  width=\"15%\" id=\"borda\"><font size=\"1\">Atra&ccedil;&otilde;es</font></td id=\"borda\" > ");
                        sb.append("<td width=\"85%\" id=\"borda\"  ><font color=\"#808080\" size=\"1\"><h2> ");
                        sb.append(toAux.getString("atracao"));
                        sb.append("</h2></font></td id=\"borda\" > ");
                        sb.append("</tr></td<<br>");

                        sb.append("<tr> ");
                        sb.append("<td  width=\"15%\" id=\"borda\"><font size=\"1\">Local</font></td id=\"borda\" > ");
                        sb.append("<td width=\"85%\" id=\"borda\"  ><font color=\"#808080\" size=\"1\"><h2> ");
                        sb.append(toAux.getString("nome_fantasia"));
                        sb.append("</h2></font></td id=\"borda\" > ");
                        sb.append("</tr></td<<br>");

                        sb.append("<tr> ");
                        sb.append("<td  width=\"15%\" id=\"borda\"><font size=\"1\">Endere&ccedil;o</font></td id=\"borda\" > ");
                        sb.append("<td width=\"85%\" id=\"borda\"  ><font color=\"#808080\" size=\"1\"> ");
                        sb.append(toAux.getString("Endereco"));
                        sb.append("</font></td id=\"borda\" > ");
                        sb.append("</tr></td<<br>");

                        sb.append("<tr> ");
                        sb.append("<td  width=\"15%\" id=\"borda\"><font size=\"1\">Estado</font></td id=\"borda\" > ");
                        sb.append("<td width=\"85%\" id=\"borda\"  ><font color=\"#808080\" size=\"1\"> ");
                        sb.append(toAux.getString("uf"));
                        sb.append("</font></td id=\"borda\" > ");
                        sb.append("</tr></td<<br>");


                        sb.append("<tr> ");
                        sb.append("<td  width=\"15%\" id=\"borda\"><font size=\"1\">Telefone</font></td id=\"borda\" > ");
                        sb.append("<td width=\"85%\" id=\"borda\"  ><font color=\"#808080\" size=\"1\"> (");
                        sb.append(toAux.getString("cod_area"));
                        sb.append(") ");
                        sb.append(toAux.getString("telefone"));
                        sb.append("</font></td id=\"borda\" > ");
                        sb.append("</tr></td<<br>");

                        sb.append("<tr> ");
                        sb.append("<td  width=\"15%\" id=\"borda\"><font size=\"1\">Informa&ccedil;&otilde;es</font></td id=\"borda\" > ");
                        sb.append("<td width=\"85%\" id=\"borda\"  ><font color=\"#808080\" size=\"1\"> ");
                        sb.append(toAux.getString("descricao"));
                        sb.append("</font></td id=\"borda\" > ");
                        sb.append("</tr></td<<br>");

                        sb.append("</table><hr>");
                        qtdImpresso++;
                    }
                    if (!temMais) {
                        sLastPK = null;
                    }
                    toAux.close();
                    out.print(sb.toString());

                } catch (Exception e) {
                    out.print("Erro na gravação: " + e.getMessage());
                }
            } // fim do if 
%>
            <%if (sFirstPK != null) {%>
            <input type="button" onclick="javascript:history.go(-1);" value="Anterior">
            <%}%>
            
            <%
            if (sLastPK != null) {
            %>
            <input type="hidden" name="lastPK" value="<%=sLastPK%>">
            <input type="submit" value="Próximo">
            <%
            }
            %>     
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
