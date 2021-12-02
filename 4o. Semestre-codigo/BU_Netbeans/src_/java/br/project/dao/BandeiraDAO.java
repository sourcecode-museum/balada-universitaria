package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.BandeiraTO;

public class BandeiraDAO extends AbstractDAO implements IBandeiraDAO{

  public BandeiraDAO(Connection conn){
        super(conn);
  }

  public void insert(BandeiraTO to) throws DAOException{
     final String sql = "insert into BANDEIRA" +
                      "(Cod_Bandeira        " +
                      ",Nome_Bandeira)" +
                "VALUES(?, ?)";                 
                      

     PreparedStatement stmt;
       try {
           stmt = super.getConnection().prepareStatement(sql);
           stmt.setInt(1, to.getCod_Bandeira());
           stmt.setString(2, to.getNome_Bandeira());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(BandeiraTO to) throws DAOException{
    final String sql = "update BANDEIRA"            +
            " set  Nome_Bandeira        = ? " +
            "where Cod_Bandeira         = ? "  
        ;
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, to.getNome_Bandeira());
         stmt.setInt(2, to.getCod_Bandeira());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(BandeiraTO to) throws DAOException{
        final String sql = "delete from BANDEIRA              " +
             "where Cod_Bandeira         = ? " 
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setInt(1, to.getCod_Bandeira());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public BandeiraTO  findByPrimaryKey(BandeiraTO pk) throws DAOException{
        final String sql = "select * from BANDEIRA"  +
                    "where Cod_Bandeira         = ? "  
        ;
    PreparedStatement stmt;
     BandeiraTO to = new BandeiraTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, pk.getCod_Bandeira());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setCod_Bandeira(rs.getInt("Cod_Bandeira"));
            to.setNome_Bandeira(rs.getString("Nome_Bandeira"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from BANDEIRA" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            BandeiraTO to = new BandeiraTO();
            to.setCod_Bandeira(rs.getInt("Cod_Bandeira"));
            to.setNome_Bandeira(rs.getString("Nome_Bandeira"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
