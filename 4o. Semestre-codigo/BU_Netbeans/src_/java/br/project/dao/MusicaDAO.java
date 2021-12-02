package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.MusicaTO;

public class MusicaDAO extends AbstractDAO implements IMusicaDAO{

  public MusicaDAO(Connection conn){
        super(conn);
  }

  public void insert(MusicaTO to) throws DAOException{
     final String sql = "insert into MUSICA" +
                      "(Cod_Musica          " +
                      ",Nome                " +
                      ",Artista             " +
                      ",Album               " +
                      ",Cod_Categoria       " +
                      ",Cod_Musica)" +
                "VALUES(?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?)" ;

     PreparedStatement stmt;
       try {
           stmt = super.getConnection().prepareStatement(sql);
           stmt.setInt(1, to.getCod_Musica());
           stmt.setString(2, to.getNome());
           stmt.setString(3, to.getArtista());
           stmt.setString(4, to.getAlbum());
           stmt.setInt(5, to.getCod_Categoria());
           stmt.setInt(6, to.getCod_Musica());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(MusicaTO to) throws DAOException{
    final String sql = "update MUSICA"            +
            " set  Nome                 = ? " +
            "     ,Artista              = ? " +
            "     ,Album                = ? " +
            "     ,Cod_Categoria        = ? " +
            "     ,Cod_Musica           = ? " +
            "where Cod_Musica           = ? "  
        ;
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, to.getNome());
         stmt.setString(2, to.getArtista());
         stmt.setString(3, to.getAlbum());
         stmt.setInt(4, to.getCod_Categoria());
         stmt.setInt(5, to.getCod_Musica());
         stmt.setInt(6, to.getCod_Musica());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(MusicaTO to) throws DAOException{
        final String sql = "delete from MUSICA              " +
             "where Cod_Musica           = ? "
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setInt(1, to.getCod_Musica());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public MusicaTO findByPrimaryKey(MusicaTO pk) throws DAOException{
        final String sql = "select * from MUSICA"  +
                    "where Cod_Musica           = ? "
        ;
    PreparedStatement stmt;
     MusicaTO to = new MusicaTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, pk.getCod_Musica());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setCod_Musica(rs.getInt("Cod_Musica"));
            to.setNome(rs.getString("Nome"));
            to.setArtista(rs.getString("Artista"));
            to.setAlbum(rs.getString("Album"));
            to.setCod_Categoria(rs.getInt("Cod_Categoria"));
            to.setCod_Musica(rs.getInt("Cod_Musica"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from MUSICA" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            MusicaTO to = new MusicaTO();
            to.setCod_Musica(rs.getInt("Cod_Musica"));
            to.setNome(rs.getString("Nome"));
            to.setArtista(rs.getString("Artista"));
            to.setAlbum(rs.getString("Album"));
            to.setCod_Categoria(rs.getInt("Cod_Categoria"));
            to.setCod_Musica(rs.getInt("Cod_Musica"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
