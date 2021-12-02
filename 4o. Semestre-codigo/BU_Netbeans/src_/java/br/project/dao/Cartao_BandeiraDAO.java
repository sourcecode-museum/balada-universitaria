package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.Cartao_BandeiraTO;

public class Cartao_BandeiraDAO extends AbstractDAO implements ICartao_BandeiraDAO{

  public Cartao_BandeiraDAO(Connection conn){
        super(conn);
  }

  public void insert(Cartao_BandeiraTO to) throws DAOException{
     final String sql = "insert into CARTAO_BANDEIRA" +
                      "(Cod_Estabelecimento " +
                      ",Cod_Bandeira)" +
                "VALUES(?                 "+
                      ",?)" ;

     PreparedStatement stmt;
       try {
           stmt = super.getConnection().prepareStatement(sql);
           stmt.setInt(1, to.getCod_Estabelecimento());
           stmt.setInt(2, to.getCod_Bandeira());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }


  public void delete(Cartao_BandeiraTO to) throws DAOException{
        final String sql = "delete from CARTAO_BANDEIRA              " +
             "where Cod_Estabelecimento  = ? " 
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public Cartao_BandeiraTO findByPrimaryKey(Cartao_BandeiraTO pk) throws DAOException{
        final String sql = "select * from CARTAO_BANDEIRA"  +
                    "where Cod_Estabelecimento  = ? " 
        ;
    PreparedStatement stmt;
     Cartao_BandeiraTO to = new Cartao_BandeiraTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, pk.getCod_Estabelecimento());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setCod_Estabelecimento(rs.getInt("Cod_Estabelecimento"));
            to.setCod_Bandeira(rs.getInt("Cod_Bandeira"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from CARTAO_BANDEIRA" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            Cartao_BandeiraTO to = new Cartao_BandeiraTO();
            to.setCod_Estabelecimento(rs.getInt("Cod_Estabelecimento"));
            to.setCod_Bandeira(rs.getInt("Cod_Bandeira"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
