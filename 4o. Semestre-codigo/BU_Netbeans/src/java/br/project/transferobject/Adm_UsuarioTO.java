/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.project.transferobject;

/**
 *
 * @author Heliomar
 */
public class Adm_UsuarioTO {
    private String usuario;
    private String senha;
    private String nome;
    private String email;
    
    //Contrutor padrão
    public Adm_UsuarioTO () {}   
    
    public Adm_UsuarioTO (String usuario, String senha, String nome, String email) {
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setNome(nome);
        this.setEmail(email);
   }            
    
    public void setUsuario(String usuario){
        this.usuario = usuario.trim().toLowerCase();
    }
    public String getUsuario(){
        return this.usuario;
    }
    
    public void setSenha(String senha){
        this.senha = senha.trim().toLowerCase();
    }
    public String getSenha(){
        return this.senha;
    }
    
    public void setNome(String nome){
        this.nome = nome.trim();
    }
    public String getNome(){
        return this.nome;
    }    
    
    public void setEmail(String email){
        this.email = email.trim().toLowerCase();
    }
    public String getEmail(){
        return this.email;
    } 
}
