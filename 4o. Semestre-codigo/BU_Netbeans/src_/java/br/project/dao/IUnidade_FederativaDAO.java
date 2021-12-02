package br.project.dao;

import java.util.List;
import br.project.transferobject.Unidade_FederativaTO;

public interface IUnidade_FederativaDAO {

    public void insert(Unidade_FederativaTO to) throws DAOException;

    public void update(Unidade_FederativaTO to) throws DAOException;

    public void delete(Unidade_FederativaTO to) throws DAOException;

    public Unidade_FederativaTO findByPrimaryKey(Unidade_FederativaTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
