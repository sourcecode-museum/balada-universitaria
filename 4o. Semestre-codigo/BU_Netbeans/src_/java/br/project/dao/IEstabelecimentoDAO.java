package br.project.dao;

import java.util.List;
import br.project.transferobject.EstabelecimentoTO;

public interface IEstabelecimentoDAO {

    public void insert(EstabelecimentoTO to) throws DAOException;

    public void update(EstabelecimentoTO to) throws DAOException;

    public void delete(EstabelecimentoTO to) throws DAOException;

    public EstabelecimentoTO findByPrimaryKey(EstabelecimentoTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
