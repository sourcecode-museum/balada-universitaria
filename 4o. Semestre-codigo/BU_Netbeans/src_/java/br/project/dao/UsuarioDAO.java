package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.UsuarioTO;

public class UsuarioDAO extends AbstractDAO implements IUsuarioDAO{

  public UsuarioDAO(Connection conn){
        super(conn);
  }

  public void insert(UsuarioTO to) throws DAOException{
     final String sql = "insert into USUARIO" +
                      "(Email               " +
                      ",Nome                " +
                      ",Senha               " +
                      ",Dt_Nascimento       " +
                      ",Rg                  " +
                      ",Sexo                " +
                      ",Endereco            " +
                      ",Cep                 " +
                      ",Cidade              " +
                      ",Telefone            " +
                      ",Cod_Area            " +
                      ",Dt_Ultimo_Acesso    " +
                      ",Uf)" +
                "VALUES(?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+
                      ",?                 "+
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
           stmt.setString(1, to.getEmail());
           stmt.setString(2, to.getNome());
           stmt.setString(3, to.getSenha());
           stmt.setString(4, to.getDt_Nascimento());
           stmt.setLong(5, to.getRg());
           stmt.setString(6, to.getSexo());
           stmt.setString(7, to.getEndereco());
           stmt.setInt(8, to.getCep());
           stmt.setString(9, to.getCidade());
           stmt.setString(10, to.getTelefone());
           stmt.setInt(11, to.getCod_Area());
           stmt.setString(12, to.getDt_Ultimo_Acesso());
           stmt.setString(13, to.getUf());
           stmt.execute();
           stmt.close();
       } catch (SQLException e) {
          throw new DAOException(e.getMessage());
         }
  }

  public void update(UsuarioTO to) throws DAOException{
    final String sql = "update USUARIO"            +
            " set  Nome                 = ? " +
            "     ,Senha                = ? " +
            "     ,Dt_Nascimento        = ? " +
            "     ,Rg                   = ? " +
            "     ,Sexo                 = ? " +
            "     ,Endereco             = ? " +
            "     ,Cep                  = ? " +
            "     ,Cidade               = ? " +
            "     ,Telefone             = ? " +
            "     ,Cod_Area             = ? " +
            "     ,Dt_Ultimo_Acesso     = ? " +
            "     ,Uf                   = ? " +
            "where Email                = ? " 
        ;
    PreparedStatement stmt;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, to.getNome());
         stmt.setString(2, to.getSenha());
         stmt.setString(3, to.getDt_Nascimento());
         stmt.setLong(4, to.getRg());
         stmt.setString(5, to.getSexo());
         stmt.setString(6, to.getEndereco());
         stmt.setInt(7, to.getCep());
         stmt.setString(8, to.getCidade());
         stmt.setString(9, to.getTelefone());
         stmt.setInt(10, to.getCod_Area());
         stmt.setString(11, to.getDt_Ultimo_Acesso());
         stmt.setString(12, to.getUf());
         stmt.setString(13, to.getEmail());
         stmt.execute();
         stmt.close();
    } catch (SQLException e) {
        throw new DAOException(e.getMessage());
      }
  }

  public void delete(UsuarioTO to) throws DAOException{
        final String sql = "delete from USUARIO              " +
             "where Email                = ? "
              ;
    PreparedStatement stmt;
     try {
          stmt = super.getConnection().prepareStatement(sql);
          stmt.setString(1, to.getEmail());
          stmt.execute();
          stmt.close();
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public UsuarioTO findByPrimaryKey(UsuarioTO pk) throws DAOException{
        final String sql = "select * from USUARIO"  +
                    "where Email                = ? "
        ;
    PreparedStatement stmt;
     UsuarioTO to = new UsuarioTO();
     try {
         stmt = super.getConnection().prepareStatement(sql);
         stmt.setString(1, pk.getEmail());
         ResultSet rs = stmt.getResultSet();
          if(rs.next()){
            to.setEmail(rs.getString("Email"));
            to.setNome(rs.getString("Nome"));
            to.setSenha(rs.getString("Senha"));
            to.setDt_Nascimento(rs.getString("Dt_Nascimento"));
            to.setRg(rs.getLong("Rg"));
            to.setSexo(rs.getString("Sexo"));
            to.setEndereco(rs.getString("Endereco"));
            to.setCep(rs.getInt("Cep"));
            to.setCidade(rs.getString("Cidade"));
            to.setTelefone(rs.getString("Telefone"));
            to.setCod_Area(rs.getInt("Cod_Area"));
            to.setDt_Ultimo_Acesso(rs.getString("Dt_Ultimo_Acesso"));
            to.setUf(rs.getString("Uf"));
          }
         rs.close();
         stmt.close();
         return to;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }

  public List getCollection() throws DAOException{
        final String sql = "select * from USUARIO" ;
    PreparedStatement stmt;
      List list = null;
     try {
         stmt = super.getConnection().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
          while(rs.next()){
            if(list == null) list = new ArrayList();
            UsuarioTO to = new UsuarioTO();
            to.setEmail(rs.getString("Email"));
            to.setNome(rs.getString("Nome"));
            to.setSenha(rs.getString("Senha"));
            to.setDt_Nascimento(rs.getString("Dt_Nascimento"));
            to.setRg(rs.getLong("Rg"));
            to.setSexo(rs.getString("Sexo"));
            to.setEndereco(rs.getString("Endereco"));
            to.setCep(rs.getInt("Cep"));
            to.setCidade(rs.getString("Cidade"));
            to.setTelefone(rs.getString("Telefone"));
            to.setCod_Area(rs.getInt("Cod_Area"));
            to.setDt_Ultimo_Acesso(rs.getString("Dt_Ultimo_Acesso"));
            to.setUf(rs.getString("Uf"));
         }
         rs.close();
         stmt.close();
         return list;
     } catch (SQLException e) {
            throw new DAOException(e.getMessage());
       }
  }
}
