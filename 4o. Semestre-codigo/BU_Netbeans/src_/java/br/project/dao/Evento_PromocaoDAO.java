package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.Evento_PromocaoTO;

public class Evento_PromocaoDAO extends AbstractDAO implements IEvento_PromocaoDAO{

  public Evento_PromocaoDAO(Connection conn){
        super(conn);
  }

  public void insert(Evento_PromocaoTO to) throws DAOException{
     final String sql = "insert into EVENTO_PROMOCAO" +
                      "(Cod_Evento_promocao " +
                      ",Cod_Estabelecimento " +
                      ",Tipo                " +
                      ",Nome                " +
                      ",Data_Inicio         " +
                      ",Descricao)" +
                "VALUES(?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?)" ;

     PreparedStatement stmt;
       try {
           stmt = super.getConnection().prepareStatement(sql);
           stmt.setInt(1, to.getCod_Evento_promocao());
           stmt.setInt(2, to.getCod_Estabelecimento());
           stmt.setString(3, to.getTipo());
           stmt.setString(4, to.getNome());
           stmt.setString(5, to.getData_Inicio());
           stmt.setString(6, to.getDescricao());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(Evento_PromocaoTO to) throws DAOException{
    final String sql = "update EVENTO_PROMOCAO"            +
            " set  Tipo                 = ? " +
            "     ,Nome                 = ? " +
            "     ,Data_Inicio          = ? " +
            "     ,Descricao            = ? " +
            "where Cod_Evento_promocao  = ? "  +
            "  and Cod_Estabelecimento  = ? " 
        ;
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, to.getTipo());
         stmt.setString(2, to.getNome());
         stmt.setString(3, to.getData_Inicio());
         stmt.setString(4, to.getDescricao());
         stmt.setInt(5, to.getCod_Evento_promocao());
         stmt.setInt(6, to.getCod_Estabelecimento());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(Evento_PromocaoTO to) throws DAOException{
        final String sql = "delete from EVENTO_PROMOCAO              " +
             "where Cod_Evento_promocao  = ? "  +
             "  and Cod_Estabelecimento  = ? " 
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setInt(1, to.getCod_Evento_promocao());
          stmt.setInt(2, to.getCod_Estabelecimento());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public Evento_PromocaoTO findByPrimaryKey(Evento_PromocaoTO pk) throws DAOException{
        final String sql = "select * from EVENTO_PROMOCAO"  +
                    "where Cod_Evento_promocao  = ? "  +
                    "  and Cod_Estabelecimento  = ? " 
        ;
    PreparedStatement stmt;
     Evento_PromocaoTO to = new Evento_PromocaoTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, pk.getCod_Evento_promocao());
         stmt.setInt(2, pk.getCod_Estabelecimento());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setCod_Evento_promocao(rs.getInt("Cod_Evento_promocao"));
            to.setCod_Estabelecimento(rs.getInt("Cod_Estabelecimento"));
            to.setTipo(rs.getString("Tipo"));
            to.setNome(rs.getString("Nome"));
            to.setData_Inicio(rs.getString("Data_Inicio"));
            to.setDescricao(rs.getString("Descricao"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from EVENTO_PROMOCAO" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            Evento_PromocaoTO to = new Evento_PromocaoTO();
            to.setCod_Evento_promocao(rs.getInt("Cod_Evento_promocao"));
            to.setCod_Estabelecimento(rs.getInt("Cod_Estabelecimento"));
            to.setTipo(rs.getString("Tipo"));
            to.setNome(rs.getString("Nome"));
            to.setData_Inicio(rs.getString("Data_Inicio"));
            to.setDescricao(rs.getString("Descricao"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
