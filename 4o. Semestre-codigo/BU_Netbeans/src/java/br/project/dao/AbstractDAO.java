package br.project.dao;

import java.sql.Connection;


/**
 * Classe que tem implementacoes comuns para todos os dados
 */
public abstract class AbstractDAO {
	
    private Connection connection;
    
    public AbstractDAO(Connection conn){
        this.connection = conn;
    }
    
	protected Connection getConnection(){
	    return connection;
	}
	
}
