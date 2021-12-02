/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.project.dao;

import br.project.transferobject.Adm_UsuarioTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Heliomar
 */

public class Adm_UsuarioDAO implements IAdm_UsuarioDAO {
    public void insert(Adm_UsuarioTO to){
        final String sql;        
        sql = "insert into adm_usuario (usuario, senha, nome, email) values (?, ?, ?, ?)";
        
        PreparedStatement stmt;
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, to.getUsuario());
            stmt.setString(2, to.getSenha());
            stmt.setString(3, to.getNome());
            stmt.setString(4, to.getEmail());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
        } catch (Exception e) {
            //throw new DAOException(e.getMessage());
            e.printStackTrace();
        }          
    }
    public void insertLog(String usuario, String local_host, String local_ip){
        final String sql;        
        sql = "insert into adm_logacesso (usuario, local_host, local_ip) values (?, ?, ?)";
        
        PreparedStatement stmt;
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, local_host);
            stmt.setString(3, local_ip);
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
        } catch (Exception e) {
            //throw new DAOException(e.getMessage());
            e.printStackTrace();
        }          
    }
    
    public void update(Adm_UsuarioTO to) {
        final String sql;        
        sql = "update adm_usuario set senha=?, nome=?, email=? where usuario=?";
        
        PreparedStatement stmt;
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, to.getSenha());
            stmt.setString(2, to.getNome());            
            stmt.setString(3, to.getEmail());
            stmt.setString(4, to.getUsuario());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
        } catch (Exception e) {
            //throw new DAOException(e.getMessage());
            e.printStackTrace();
        }  
    }
    public void delete(Adm_UsuarioTO to) {
        delete(to.getUsuario());    
    }
    public void delete(String pkUsuario) {
        final String sql;        
        sql = "delete from adm_usuario where usuario = ?";
        
        PreparedStatement stmt;
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pkUsuario);
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
        } catch (Exception e) {
            //throw new DAOException(e.getMessage());
            e.printStackTrace();
        }        
        
    }
    public Adm_UsuarioTO buscarPorPK(String pkUsuario) {
        final String sql;                
        sql = "select * from adm_usuario where usuario=?";
        
        PreparedStatement stmt;        
        Adm_UsuarioTO to = null;
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pkUsuario);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                to = new Adm_UsuarioTO(rs.getString("usuario"), 
                                       rs.getString("senha"),
                                       rs.getString("nome"),
                                       rs.getString("email"));
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return to;
    }
    
    public ArrayList buscarTodos() {
        final String sql;
        sql = "select * from adm_usuario";
        
        PreparedStatement stmt;
        ArrayList list = null;        
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                if (list == null) list = new ArrayList();
               
                Adm_UsuarioTO to = new Adm_UsuarioTO(rs.getString("usuario"),
                                                     rs.getString("senha"),
                                                     rs.getString("nome"),
                                                     rs.getString("email"));

                list.add(to);
            }
            
            rs.close();
            stmt.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public Adm_UsuarioTO checarLogin(String pUsuario, String pSenha) {
        final String sql;                
        sql = "select * from adm_usuario where usuario=? and senha=?";
        
        PreparedStatement stmt;        
        Adm_UsuarioTO to = null;
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pUsuario);
            stmt.setString(2, pSenha);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                to = new Adm_UsuarioTO(rs.getString("usuario"), 
                                       rs.getString("senha"),
                                       rs.getString("nome"),
                                       rs.getString("email"));
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return to;     
    }
    
    public long getTotalRegistros(){
        final String sql;
        sql = "select count(*) as qtde from adm_usuarios";
        
        long qtde = 0;
        PreparedStatement stmt;
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                qtde = rs.getLong("qtde");
            }
            
            rs.close();
            stmt.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return qtde;
    }
}
