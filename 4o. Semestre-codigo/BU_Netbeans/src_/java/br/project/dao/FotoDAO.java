package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.FotoTO;

public class FotoDAO extends AbstractDAO implements IFotoDAO{

  public FotoDAO(Connection conn){
        super(conn);
  }

  public void insert(FotoTO to) throws DAOException{
     final String sql = "insert into FOTO" +
                      "(Cod_Evento          " +
                      ",Nome                " +
                      ",Tipo_Foto           " +
                      ",Local_File_System)" +
                "VALUES(?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?)" ;

     PreparedStatement stmt;
       try {
           stmt = super.getConnection().prepareStatement(sql);
           stmt.setInt(1, to.getCod_Evento());
           stmt.setString(2, to.getNome());
           stmt.setString(3, to.getTipo_Foto());
           stmt.setString(4, to.getLocal_File_System());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(FotoTO to) throws DAOException{
    final String sql = "update FOTO"            +
            " set  Tipo_Foto            = ? " +
            "     ,Local_File_System    = ? " +
            "where Cod_Evento           = ? "  +
            "  and Nome                 = ? " 
        ;
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, to.getTipo_Foto());
         stmt.setString(2, to.getLocal_File_System());
         stmt.setInt(3, to.getCod_Evento());
         stmt.setString(4, to.getNome());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(FotoTO to) throws DAOException{
        final String sql = "delete from FOTO              " +
             "where Cod_Evento           = ? "  +
             "  and Nome                 = ? "
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setInt(1, to.getCod_Evento());
          stmt.setString(2, to.getNome());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public FotoTO findByPrimaryKey(FotoTO pk) throws DAOException{
        final String sql = "select * from FOTO"  +
                    "where Cod_Evento           = ? "  +
                    "  and Nome                 = ? " 
        ;
    PreparedStatement stmt;
     FotoTO to = new FotoTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, pk.getCod_Evento());
         stmt.setString(2, pk.getNome());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setCod_Evento(rs.getInt("Cod_Evento"));
            to.setNome(rs.getString("Nome"));
            to.setTipo_Foto(rs.getString("Tipo_Foto"));
            to.setLocal_File_System(rs.getString("Local_File_System"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from FOTO" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            FotoTO to = new FotoTO();
            to.setCod_Evento(rs.getInt("Cod_Evento"));
            to.setNome(rs.getString("Nome"));
            to.setTipo_Foto(rs.getString("Tipo_Foto"));
            to.setLocal_File_System(rs.getString("Local_File_System"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
