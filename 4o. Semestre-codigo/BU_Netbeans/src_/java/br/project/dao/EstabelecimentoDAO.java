package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.EstabelecimentoTO;

public class EstabelecimentoDAO extends AbstractDAO implements IEstabelecimentoDAO{

  public EstabelecimentoDAO(Connection conn){
        super(conn);
  }

  public void insert(EstabelecimentoTO to) throws DAOException{
     final String sql = "insert into ESTABELECIMENTO" +
                      "(Cod_Estabelecimento " +
                      ",Nome_Fantasia       " +
                      ",Razao_Social        " +
                      ",Cnpf                " +
                      ",Endereco            " +
                      ",Bairro              " +
                      ",Uf                  " +
                      ",Telefone            " +
                      ",Cod_Area)" +
                "VALUES(?                 "+
                      ",?                 "+
                      ",?                 "+
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
           stmt.setString(2, to.getNome_Fantasia());
           stmt.setString(3, to.getRazao_Social());
           stmt.setLong(4, to.getCnpf());
           stmt.setString(5, to.getEndereco());
           stmt.setString(6, to.getBairro());
           stmt.setString(7, to.getUf());
           stmt.setString(8, to.getTelefone());
           stmt.setInt(9, to.getCod_Area());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(EstabelecimentoTO to) throws DAOException{
    final String sql = "update ESTABELECIMENTO"            +
            " set  Nome_Fantasia        = ? " +
            "     ,Razao_Social         = ? " +
            "     ,Cnpf                 = ? " +
            "     ,Endereco             = ? " +
            "     ,Bairro               = ? " +
            "     ,Uf                   = ? " +
            "     ,Telefone             = ? " +
            "     ,Cod_Area             = ? " +
            "where Cod_Estabelecimento  = ? "  
        ;
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, to.getNome_Fantasia());
         stmt.setString(2, to.getRazao_Social());
         stmt.setLong(3, to.getCnpf());
         stmt.setString(4, to.getEndereco());
         stmt.setString(5, to.getBairro());
         stmt.setString(6, to.getUf());
         stmt.setString(7, to.getTelefone());
         stmt.setInt(8, to.getCod_Area());
         stmt.setInt(9, to.getCod_Estabelecimento());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(EstabelecimentoTO to) throws DAOException{
        final String sql = "delete from ESTABELECIMENTO              " +
             "where Cod_Estabelecimento  = ? "  
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setInt(1, to.getCod_Estabelecimento());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public EstabelecimentoTO findByPrimaryKey(EstabelecimentoTO pk) throws DAOException{
        final String sql = "select * from ESTABELECIMENTO"  +
                    "where Cod_Estabelecimento  = ? " 
        ;
    PreparedStatement stmt;
     EstabelecimentoTO to = new EstabelecimentoTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setInt(1, to.getCod_Estabelecimento());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setCod_Estabelecimento(rs.getInt("Cod_Estabelecimento"));
            to.setNome_Fantasia(rs.getString("Nome_Fantasia"));
            to.setRazao_Social(rs.getString("Razao_Social"));
            to.setCnpf(rs.getLong("Cnpf"));
            to.setEndereco(rs.getString("Endereco"));
            to.setBairro(rs.getString("Bairro"));
            to.setUf(rs.getString("Uf"));
            to.setTelefone(rs.getString("Telefone"));
            to.setCod_Area(rs.getInt("Cod_Area"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from ESTABELECIMENTO" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            EstabelecimentoTO to = new EstabelecimentoTO();
            to.setCod_Estabelecimento(rs.getInt("Cod_Estabelecimento"));
            to.setNome_Fantasia(rs.getString("Nome_Fantasia"));
            to.setRazao_Social(rs.getString("Razao_Social"));
            to.setCnpf(rs.getLong("Cnpf"));
            to.setEndereco(rs.getString("Endereco"));
            to.setBairro(rs.getString("Bairro"));
            to.setUf(rs.getString("Uf"));
            to.setTelefone(rs.getString("Telefone"));
            to.setCod_Area(rs.getInt("Cod_Area"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
