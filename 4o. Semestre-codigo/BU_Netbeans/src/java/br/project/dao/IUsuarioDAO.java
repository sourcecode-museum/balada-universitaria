package br.project.dao;

import java.util.List;
import br.project.transferobject.UsuarioTO;

public interface IUsuarioDAO {

    public void insert(UsuarioTO to) throws DAOException;

    public void update(UsuarioTO to) throws DAOException;

    public void delete(UsuarioTO to) throws DAOException;

    public UsuarioTO findByPrimaryKey(UsuarioTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
