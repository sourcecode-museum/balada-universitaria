package br.project.dao;

import java.util.List;
import br.project.transferobject.MusicaTO;

public interface IMusicaDAO {

    public void insert(MusicaTO to) throws DAOException;

    public void update(MusicaTO to) throws DAOException;

    public void delete(MusicaTO to) throws DAOException;

    public MusicaTO findByPrimaryKey(MusicaTO to) throws DAOException;

    public List getCollection() throws DAOException;

}
