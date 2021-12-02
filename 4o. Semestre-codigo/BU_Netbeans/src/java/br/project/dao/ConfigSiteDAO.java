/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.project.dao;

import br.project.transferobject.ConfigSiteTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Heliomar
 */
public class ConfigSiteDAO implements IConfigSiteDAO {

    public void update(ConfigSiteTO to) {
        final String sql;        
        sql = "update ConfigSite set valor=? where id=?";
                
        PreparedStatement stmt;
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, to.getValor());
            stmt.setInt(2, to.getId());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
        } catch (Exception e) {
            //throw new DAOException(e.getMessage());
            e.printStackTrace();
        }  
    }
    
    public ArrayList buscarTodos() {
        final String sql;
        sql = "select * from ConfigSite where regativo = 'S' order by ordem";
        
        PreparedStatement stmt;
        ArrayList list = null;        
        try {
            Connection conexao = JdbcDAOFactory.getConnection();
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                if (list == null) list = new ArrayList();
               
                ConfigSiteTO to = new ConfigSiteTO();
                
                to.setId(rs.getInt("id"));
                to.setCodCampo(rs.getString("codcampo"));
                to.setCaption(rs.getString("caption"));
                to.setDescricao(rs.getString("descricao"));
                to.setOpcao1_Size(rs.getString("opcao1_size"));
                to.setOpcao2_Max(rs.getString("opcao2_max"));
                to.setTipo(rs.getString("tipo"));
                to.setValor(rs.getString("valor"));
                
                list.add(to);
            }
            
            rs.close();
            stmt.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }    
    
    public String getOpcoes(String tipo, String valor, String opcao1, String opcao2, int id){
        StringBuilder res = new StringBuilder();
        
        if (tipo.equals("SN")) {
            res.append("<select disabled='disabled' id='id" + id + "' style='width:80px' name='valor'>");
			res.append("<option value='S'" + (valor.equals("S") ? " selected='selected' " : "") + ">" + opcao1 + "</option>");
			res.append("<option value='N'" + (valor.equals("N") ? " selected='selected' " : "") + ">" + opcao2 + "</option>");
			res.append("</select>");
            
        } else if (tipo.equals("TXT")) {
            res.append("<input disabled='disabled' id='id" + id + "' class='text' type='text' name='valor' size='" + opcao1 + "' maxlength='" + opcao2 + "' value='" + valor + "' />");
		
        } else if (tipo.equals("NUM")) {
            res.append("<input disabled='disabled' id='id" + id + "' class='text' type='text' name='valor' size='" + opcao1 + "' maxlength='" + opcao2 + "' value='" + valor + "' style='text-align:right' onKeyPress='javascript:SoNumeros();' onBlur='validaNumeros(this);' />");
		
        } else if (tipo.equals("VAL")) {
            res.append("<input disabled='disabled' id='id" + id + "' class='text' type='text' name='valor' size='" + opcao1 + "' maxlength='" + opcao2 + "' value='" + valor + "' style='text-align:right' onKeyPress='javascript:formatReal(this, 10, 2);' onBlur='validaReal(this);' />");

        } else if (tipo.equals("CBN")) {
            int i, x, y, v;
           
            x = Integer.parseInt(opcao1);
            y = Integer.parseInt(opcao2);
            v = Integer.parseInt(valor);
            
            res.append("<select disabled='disabled' id='id" + id + "' style='width:80px' name='valor'>");
			for (i = x; i < y; i++) {
                res.append("<option value='" + i + "'" + (v == i ? " selected='selected' " : "") + ">" + i + "</option>");
            }
			res.append("</select>");			    
        }
        
        return res.toString();
    }
}
