package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.CategoriaTO;

public class CategoriaDAO extends AbstractDAO implements ICategoriaDAO{

  public CategoriaDAO(Connection conn){
        super(conn);
  }

  public void insert(CategoriaTO to) throws DAOException{
     final String sql = "insert into CATEGORIA" +
                      "(Cod_Categoria       " +
                      ",Nome_Categoria)" +
                "VALUES(?                 "+
                      ",?)" ;

     PreparedStatement stmt;
       try {
           stmt = super.getConnection().prepareStatement(sql);
           stmt.setInt(1, to.getCod_Categoria());
           stmt.setString(2, to.getNome_Categoria());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(CategoriaTO to) throws DAOException{
    final String sql = "update CATEGORIA"            +
            " set  Nome_Categoria       = ? " +
            "where Cod_Categoria        = ? "  
        ;
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, to.getNome_Categoria());
         stmt.setInt(2, to.getCod_Categoria());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(CategoriaTO to) throws DAOException{
        final String sql = "delete from CATEGORIA              " +
             "where Cod_Categoria        = ? " 
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setInt(1, to.getCod_Categoria());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public CategoriaTO findByPrimaryKey(CategoriaTO pk) throws DAOException{
        final String sql = "select * from CATEGORIA"  +
                    "where Cod_Categoria        = ? " 
        ;
    PreparedStatement stmt;
     CategoriaTO to = new CategoriaTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, pk.getCod_Categoria());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setCod_Categoria(rs.getInt("Cod_Categoria"));
            to.setNome_Categoria(rs.getString("Nome_Categoria"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from CATEGORIA" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            CategoriaTO to = new CategoriaTO();
            to.setCod_Categoria(rs.getInt("Cod_Categoria"));
            to.setNome_Categoria(rs.getString("Nome_Categoria"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
