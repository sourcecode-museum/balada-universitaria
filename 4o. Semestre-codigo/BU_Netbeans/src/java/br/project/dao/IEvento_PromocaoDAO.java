package br.project.dao;

import java.util.List;
import br.project.transferobject.Evento_PromocaoTO;

public interface IEvento_PromocaoDAO {

    public void insert(Evento_PromocaoTO to) throws DAOException;

    public void update(Evento_PromocaoTO to) throws DAOException;

    public void delete(Evento_PromocaoTO to) throws DAOException;

    public Evento_PromocaoTO findByPrimaryKey(Evento_PromocaoTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
