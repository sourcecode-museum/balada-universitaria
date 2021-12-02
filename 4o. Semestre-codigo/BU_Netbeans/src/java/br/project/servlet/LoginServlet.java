/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.project.servlet;

import br.project.transferobject.Adm_UsuarioTO;
import br.project.dao.Adm_UsuarioDAO;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Heliomar
 */
public class LoginServlet extends AbstractServlet {
   
    public void execute(HttpServletRequest request, HttpServletResponse response) 
    throws Exception {
        String login = request.getParameter("login").trim();
        String usuario = request.getParameter("usuario").trim();
        String senha = request.getParameter("senha").trim();
        
        if (login.equals("A")) {
            if (usuario.length() != 0 && senha.length() != 0) {
                Adm_UsuarioTO to = LoginAdmin(request);
            
                if (to != null) {
                    HttpSession secao = request.getSession(); //criando a secao do usuario
                    secao.setAttribute("adm_session", to);
                    response.sendRedirect("/Baladas/admin/index.jsp");
                    //request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
                }
                else{
                    response.sendRedirect("/Baladas/admin/login.jsp?err=1");
                    //request.setAttribute("message", "Usuário ou senha invalido!");
                    //request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
                } 
            }
            else {
                response.sendRedirect("/Baladas/admin/login.jsp?err=2");
            }                  
        } 
        else {
            response.getWriter().println("Classe usuario não implementado");
        }
    }

    private Adm_UsuarioTO LoginAdmin(HttpServletRequest request){
        String usuario = request.getParameter("usuario").trim();
        String senha = request.getParameter("senha").trim();
        
        Adm_UsuarioDAO dao = new Adm_UsuarioDAO();
        Adm_UsuarioTO to = dao.checarLogin(usuario, senha);
        
        if (to != null) {
            //Adiciona ao log
            dao.insertLog(to.getNome(), request.getLocalName(), request.getLocalAddr());
        }
        return to;
    }
}
