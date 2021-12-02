package br.project.dao;

import java.util.List;
import br.project.transferobject.FotoTO;

public interface IFotoDAO {

    public void insert(FotoTO to) throws DAOException;

    public void update(FotoTO to) throws DAOException;

    public void delete(FotoTO to) throws DAOException;

    public FotoTO findByPrimaryKey(FotoTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
