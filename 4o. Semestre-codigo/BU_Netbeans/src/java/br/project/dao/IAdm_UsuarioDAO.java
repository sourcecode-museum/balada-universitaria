/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.project.dao;

import br.project.transferobject.Adm_UsuarioTO;
import java.util.ArrayList;
/**
 *
 * @author Heliomar
 */
public interface IAdm_UsuarioDAO {
    public void insert(Adm_UsuarioTO to) throws DAOException;
    public void update(Adm_UsuarioTO to) throws DAOException;
    public void delete(Adm_UsuarioTO to) throws DAOException;
    public void delete(String pkUsuario) throws DAOException;
    
    public Adm_UsuarioTO buscarPorPK(String pkUsuario) throws DAOException;
    public ArrayList buscarTodos() throws DAOException;
    
    public Adm_UsuarioTO checarLogin(String pUsuario, String pSenha) throws DAOException;
}
