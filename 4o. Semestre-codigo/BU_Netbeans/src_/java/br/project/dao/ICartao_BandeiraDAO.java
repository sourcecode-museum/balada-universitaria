package br.project.dao;

import java.util.List;
import br.project.transferobject.Cartao_BandeiraTO;

public interface ICartao_BandeiraDAO {

    public void insert(Cartao_BandeiraTO to) throws DAOException;


    public void delete(Cartao_BandeiraTO to) throws DAOException;

    public Cartao_BandeiraTO findByPrimaryKey(Cartao_BandeiraTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
