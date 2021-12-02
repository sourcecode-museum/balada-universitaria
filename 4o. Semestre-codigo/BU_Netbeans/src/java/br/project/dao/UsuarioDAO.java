package br.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.project.transferobject.UsuarioTO;
import sun.net.smtp.SmtpClient;

public class UsuarioDAO extends AbstractDAO implements IUsuarioDAO {

    public UsuarioDAO(Connection conn) {
        super(conn);
    }

    public void insert(UsuarioTO to) throws DAOException {
        final String sql = "insert into USUARIO" +
                "(Email               " +
                ",Nome                " +
                ",Senha               " +
                ",Bairro              " +
                ",Rg                  " +
                ",Sexo                " +
                ",Endereco            " +
                ",Cep                 " +
                ",Cidade              " +
                ",Telefone            " +
                ",Cod_Area            " +
                ",Uf)" +
                "VALUES(?                 " +
                ",?                 " +
                ",?                 " +
                ",?                 " +
                ",?                 " +
                ",?                 " +
                ",?                 " +
                ",?                 " +
                ",?                 " +
                ",?                 " +
                ",?                 " +
                ",?)";

        PreparedStatement stmt;
        try {
            stmt = super.getConnection().prepareStatement(sql);
            stmt.setString(1, to.getEmail());
            stmt.setString(2, to.getNome());
            stmt.setString(3, to.getSenha());
            stmt.setString(4, to.getBairro());
            stmt.setString(5, to.getRg());
            stmt.setString(6, to.getSexo());
            stmt.setString(7, to.getEndereco());
            stmt.setString(8, to.getCep());
            stmt.setString(9, to.getCidade());
            stmt.setString(10, to.getTelefone());
            stmt.setInt(11, to.getCod_Area());
            stmt.setString(12, to.getUf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public void update(UsuarioTO to) throws DAOException {
        final String sql = "update USUARIO" +
                " set  Nome                 = ? " +
                "     ,Senha                = ? " +
                "     ,Bairro               = ? " +
                "     ,Rg                   = ? " +
                "     ,Sexo                 = ? " +
                "     ,Endereco             = ? " +
                "     ,Cep                  = ? " +
                "     ,Cidade               = ? " +
                "     ,Telefone             = ? " +
                "     ,Cod_Area             = ? " +
                "     ,Dt_Ultimo_Acesso     = ? " +
                "     ,Uf                   = ? " +
                "     ,Email                = ? " +
                "where Email                = ? ";
        PreparedStatement stmt;
        try {
            stmt = super.getConnection().prepareStatement(sql);
            stmt.setString(1, to.getNome());
            stmt.setString(2, to.getSenha());
            stmt.setString(3, to.getBairro());
            stmt.setString(4, to.getRg());
            stmt.setString(5, to.getSexo());
            stmt.setString(6, to.getEndereco());
            stmt.setString(7, to.getCep());
            stmt.setString(8, to.getCidade());
            stmt.setString(9, to.getTelefone());
            stmt.setInt(10, to.getCod_Area());
            stmt.setString(11, to.getDt_Ultimo_Acesso());
            stmt.setString(12, to.getUf());
            stmt.setString(13, (to.getEmailNovo() == null ? to.getEmail() : to.getEmailNovo()));
            stmt.setString(14, to.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public void delete(UsuarioTO to) throws DAOException {
        final String sql = "delete from USUARIO              " +
                "where Email                = ? ";
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

    public UsuarioTO findByPrimaryKey(UsuarioTO pk) throws DAOException {
        final String sql = "select * from USUARIO" +
                "where Email                = ? ";
        PreparedStatement stmt;
        UsuarioTO to = new UsuarioTO();
        try {
            stmt = super.getConnection().prepareStatement(sql);
            stmt.setString(1, pk.getEmail());
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                to.setEmail(rs.getString("Email"));
                to.setNome(rs.getString("Nome"));
                to.setSenha(rs.getString("Senha"));
                to.setBairro(rs.getString("Bairro"));
                to.setRg(rs.getString("Rg"));
                to.setSexo(rs.getString("Sexo"));
                to.setEndereco(rs.getString("Endereco"));
                to.setCep(rs.getString("Cep"));
                to.setCidade(rs.getString("Cidade"));
                to.setTelefone(rs.getString("Telefone"));
                to.setCod_Area(rs.getInt("Cod_Area"));
                to.setDt_Ultimo_Acesso(rs.getString("Dt_Ultimo_Acesso"));
                to.setDt_Cadastro(rs.getString("dt_cadastro"));
                to.setUf(rs.getString("Uf"));
            }
            rs.close();
            stmt.close();
            return to;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public List getCollection() throws DAOException {
        final String sql = "select * from USUARIO";
        PreparedStatement stmt;
        List list = null;
        try {
            stmt = super.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (list == null) {
                    list = new ArrayList();
                }
                UsuarioTO to = new UsuarioTO();
                to.setEmail(rs.getString("Email"));
                to.setNome(rs.getString("Nome"));
                to.setSenha(rs.getString("Senha"));
                to.setBairro(rs.getString("Bairro"));
                to.setRg(rs.getString("Rg"));
                to.setSexo(rs.getString("Sexo"));
                to.setEndereco(rs.getString("Endereco"));
                to.setCep(rs.getString("Cep"));
                to.setCidade(rs.getString("Cidade"));
                to.setTelefone(rs.getString("Telefone"));
                to.setCod_Area(rs.getInt("Cod_Area"));
                to.setDt_Ultimo_Acesso(rs.getString("Dt_Ultimo_Acesso"));
                to.setDt_Cadastro(rs.getString("dt_cadastro"));
                to.setUf(rs.getString("Uf"));
                
                list.add(to);
            }
            rs.close();
            stmt.close();
            return list;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public UsuarioTO buscarPorPk(String email) throws DAOException {
        final String sql = "select * from ADMIN.USUARIO where email = ? ";
        
        PreparedStatement stmt;
        UsuarioTO to = null;
        try {
         
            stmt = super.getConnection().prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            
            if (rs != null) {
                if(rs.next()){
                    to = new UsuarioTO();

                    to.setEmail(rs.getString("Email"));
                    to.setNome(rs.getString("Nome"));
                    to.setSenha(rs.getString("Senha"));
                    to.setBairro(rs.getString("Bairro"));
                    to.setRg(rs.getString("Rg"));
                    to.setSexo(rs.getString("Sexo"));
                    to.setEndereco(rs.getString("Endereco"));
                    to.setCep(rs.getString("Cep"));
                    to.setCidade(rs.getString("Cidade"));
                    to.setTelefone(rs.getString("Telefone"));
                    to.setCod_Area(rs.getInt("Cod_Area"));
                    to.setDt_Ultimo_Acesso(rs.getString("Dt_Ultimo_Acesso"));
                    to.setDt_Cadastro(rs.getString("dt_cadastro"));
                    to.setUf(rs.getString("Uf"));
                }
            } 
            rs.close();
            stmt.close();            
            return to;
            
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public long getTotalRegistros() {
        final String sql;
        sql = "select count(*) as qtde from usuario";

        long qtde = 0;
        PreparedStatement stmt;
        try {
            stmt = super.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                qtde = rs.getLong("qtde");
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return qtde;
    }
    
    public List getUltimosCadastros(long maximo) throws DAOException {
        //final String sql = "select top " + maximo + " * from USUARIO order by dt_cadastro desc ";
        final String sql = "select * from USUARIO order by dt_cadastro desc";
        PreparedStatement stmt;
        List list = null;
        long cont = 0;
        
        try {
            stmt = super.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next() && cont <= maximo-1) {
                cont ++;
                if (list == null) {list = new ArrayList();}
                
                UsuarioTO to = new UsuarioTO();
                to.setEmail(rs.getString("Email"));
                to.setNome(rs.getString("Nome"));
                to.setSenha(rs.getString("Senha"));
                to.setBairro(rs.getString("Bairro"));
                to.setRg(rs.getString("Rg"));
                to.setSexo(rs.getString("Sexo"));
                to.setEndereco(rs.getString("Endereco"));
                to.setCep(rs.getString("Cep"));
                to.setCidade(rs.getString("Cidade"));
                to.setTelefone(rs.getString("Telefone"));
                to.setCod_Area(rs.getInt("Cod_Area"));
                to.setDt_Ultimo_Acesso(rs.getString("Dt_Ultimo_Acesso"));
                to.setDt_Cadastro(rs.getString("dt_cadastro"));
                to.setUf(rs.getString("Uf"));
                
                list.add(to);
            }
            rs.close();
            stmt.close();
            return list;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }    
}
