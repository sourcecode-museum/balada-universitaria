package br.project.dao;

import java.util.List;
import br.project.transferobject.CategoriaTO;

public interface ICategoriaDAO {

    public void insert(CategoriaTO to) throws DAOException;

    public void update(CategoriaTO to) throws DAOException;

    public void delete(CategoriaTO to) throws DAOException;

    public CategoriaTO findByPrimaryKey(CategoriaTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
