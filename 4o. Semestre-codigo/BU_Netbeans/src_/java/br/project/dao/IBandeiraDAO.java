package br.project.dao;

import java.util.List;
import br.project.transferobject.BandeiraTO;

public interface IBandeiraDAO {

    public void insert(BandeiraTO to) throws DAOException;

    public void update(BandeiraTO to) throws DAOException;

    public void delete(BandeiraTO to) throws DAOException;

    public BandeiraTO findByPrimaryKey(BandeiraTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
