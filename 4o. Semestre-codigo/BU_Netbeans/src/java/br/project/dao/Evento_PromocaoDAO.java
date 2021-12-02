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
                      "(Cod_Estabelecimento " +
                      ",Tipo                " +
                      ",Nome                " +
                      ",Data_Inicio         " +
                      ",Data_final          " +                              
                      ",Atracao             " +                              
                      ",Descricao)          " +
                "VALUES(?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+                             
                      ",?)" ;

     PreparedStatement stmt;
       try {
           stmt = super.getConnection().prepareStatement(sql);
           stmt.setInt(1, to.getCod_Estabelecimento());
           stmt.setString(2, to.getTipo());
           stmt.setString(3, to.getNome());
           stmt.setString(4, to.getData_Inicio());
           stmt.setString(5, to.getData_Final());
           stmt.setString(6, to.getAtracao());
           stmt.setString(7, to.getDescricao());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(Evento_PromocaoTO to) throws DAOException{
    final String sql = "update EVENTO_PROMOCAO"            +
            " set  Cod_Estabelecimento  = ? " +
            "     ,Tipo                 = ? " +
            "     ,Nome                 = ? " +
            "     ,Data_Inicio          = ? " +
            "     ,Data_Final           = ? " +            
            "     ,Atracao              = ? " +                        
            "     ,Descricao            = ? " +
            "where Cod_Evento_promocao  = ? "  
            ;
            
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, to.getCod_Estabelecimento()); 
         stmt.setString(2, to.getTipo());
         stmt.setString(3, to.getNome());
         stmt.setString(4, to.getData_Inicio());
         stmt.setString(5, to.getData_Final()); 
         stmt.setString(6, to.getAtracao()); 
         stmt.setString(7, to.getDescricao());
         stmt.setInt(8, to.getCod_Evento_promocao());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(Evento_PromocaoTO to) throws DAOException{
        final String sql = "delete from EVENTO_PROMOCAO              " +
             "where Cod_Evento_promocao  = ? " 
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setInt(1, to.getCod_Evento_promocao());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  


  public Evento_PromocaoTO findByPrimaryKey(Evento_PromocaoTO pk) throws DAOException{
        final String sql = "select * from EVENTO_PROMOCAO "  +
                    "where Cod_Evento_promocao  = ? "  
        ;
    PreparedStatement stmt;
     Evento_PromocaoTO to = new Evento_PromocaoTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, pk.getCod_Evento_promocao());
         ResultSet rs = stmt.executeQuery();
         
          if(rs.next()){
            to.setCod_Evento_promocao(rs.getInt("Cod_Evento_promocao"));
            to.setCod_Estabelecimento(rs.getInt("Cod_Estabelecimento"));
            to.setTipo(rs.getString("Tipo"));
            to.setNome(rs.getString("Nome"));
            to.setData_Inicio(rs.getString("Data_Inicio"));
            to.setData_Final(rs.getString("Data_Final"));            
            to.setAtracao(rs.getString("Atracao"));                        
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
            to.setData_Inicio(rs.getString("Data_Final"));            
            to.setData_Inicio(rs.getString("Atracao"));                        
            to.setDescricao(rs.getString("Descricao"));
            list.add(to);
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
      public long getTotalRegistros(){
        final String sql;
        sql = "select count(*) as qtde from evento_promocao";
        
        long qtde = 0;
        PreparedStatement stmt;
        try {
            stmt = super.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                qtde = rs.getLong("qtde");
            }
            
            rs.close();
            stmt.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return qtde;
    }
}
