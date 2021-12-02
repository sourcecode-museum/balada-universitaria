<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="br.project.dao.JdbcDAOFactory"%>
<%@page import="br.project.dao.UsuarioDAO"%>
<%@page import="br.project.transferobject.UsuarioTO"%>
<%
try {
    UsuarioDAO dao = new UsuarioDAO(JdbcDAOFactory.getConnection());
    UsuarioTO to = new UsuarioTO(
                        request.getParameter("Email"),
                        request.getParameter("Senha"),             
                        request.getParameter("Nome"), 
                        request.getParameter("Sexo"),             
                        request.getParameter("Rg"), 
                        request.getParameter("Cep"), 
                        request.getParameter("Endereco"), 
                        request.getParameter("Bairro"), 
                        request.getParameter("Cidade"), 
                        request.getParameter("Uf"),
                        Integer.parseInt(request.getParameter("Cod_Area")),             
                        request.getParameter("Telefone"));
    
    dao.insert(to); 
    out.print("Registro inserido com sucesso!");
    
} catch( Exception e ) {
    out.print("Erro na gravação: " + e.getMessage());
}
%>