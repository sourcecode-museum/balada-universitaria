package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.Unidade_FederativaTO;

public class Unidade_FederativaDAO extends AbstractDAO implements IUnidade_FederativaDAO {

  public Unidade_FederativaDAO(Connection conn){
        super(conn);
  }

  public void insert(Unidade_FederativaTO to) throws DAOException{
     final String sql = "insert into UNIDADE_FEDERATIVA" +
                      "(Uf                  " +
                      ",Estado              " +
                      ",Regiao)" +
                "VALUES(?                 "+
                      ",?                 "+
                      ",?)" ;

     PreparedStatement stmt;
       try {
           stmt = super.getConnection().prepareStatement(sql);
           stmt.setString(1, to.getUf());
           stmt.setString(2, to.getEstado());
           stmt.setString(3, to.getRegiao());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(Unidade_FederativaTO to) throws DAOException{
    final String sql = "update UNIDADE_FEDERATIVA"            +
            " set  Estado               = ? " +
            "     ,Regiao               = ? " +
            "where Uf                   = ? "  
        ;
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, to.getEstado());
         stmt.setString(2, to.getRegiao());
         stmt.setString(3, to.getUf());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(Unidade_FederativaTO to) throws DAOException{
        final String sql = "delete from UNIDADE_FEDERATIVA              " +
             "where Uf                   = ? "  
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setString(1, to.getUf());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public Unidade_FederativaTO findByPrimaryKey(Unidade_FederativaTO pk) throws DAOException{
        final String sql = "select * from UNIDADE_FEDERATIVA"  +
                    "where Uf                   = ? "  
        ;
    PreparedStatement stmt;
     Unidade_FederativaTO to = new Unidade_FederativaTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, pk.getUf());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setUf(rs.getString("Uf"));
            to.setEstado(rs.getString("Estado"));
            to.setRegiao(rs.getString("Regiao"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from UNIDADE_FEDERATIVA" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            Unidade_FederativaTO to = new Unidade_FederativaTO();
            to.setUf(rs.getString("Uf"));
            to.setEstado(rs.getString("Estado"));
            to.setRegiao(rs.getString("Regiao"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
