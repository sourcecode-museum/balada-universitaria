 package br.project.dao;

import br.project.util.Constants;
import java.sql.Connection;
import java.sql.DriverManager;



/**
 * fabrica de DAO usando JDBC
 */
public class JdbcDAOFactory {
 
    public static Connection getConnection() throws DAOException{
        try {
            
            Class.forName(Constants.DB_DRIVE);
            return DriverManager.getConnection(Constants.DB_SERVIDOR,Constants.DB_USUARIO,Constants.DB_SENHA);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
    }
    
    /**
     * Pega uma referencia para interface ICursoDAO
     * @return ICursoDAO
     */
    
    public IBandeiraDAO getBandeiraDAO() throws DAOException{
        return new BandeiraDAO(getConnection());
    }
    public ICartao_BandeiraDAO getCartao_BandeiraDAO() throws DAOException{
        return new Cartao_BandeiraDAO(getConnection());
    }
    public ICategoriaDAO getCategoriaDAO() throws DAOException{
        return new CategoriaDAO(getConnection());
    }
    public IEstabelecimentoDAO getEstabelecimentoDAO() throws DAOException{
        return new EstabelecimentoDAO(getConnection());
    }
    public IEvento_PromocaoDAO getEvento_PromocaoDAO() throws DAOException{
        return new Evento_PromocaoDAO(getConnection());
    }
    public IFotoDAO getFotoDAO() throws DAOException{
        return new FotoDAO(getConnection());
    }
    public IMusicaDAO getMusicaDAO() throws DAOException{
        return new MusicaDAO(getConnection());
    }
    public IUnidade_FederativaDAO getUnidade_FederativaDAO() throws DAOException{
        return new Unidade_FederativaDAO(getConnection());
    }
    public IUsuarioDAO getUsuarioDAO() throws DAOException{
        return new UsuarioDAO(getConnection());
    }
    
    //... outros gets/sets para os outros DAOs
}