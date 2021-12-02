/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.project.admin;

import br.project.dao.ConfigSiteDAO;
import br.project.transferobject.ConfigSiteTO;

import java.util.ArrayList;
/**
 *
 * @author Heliomar
 */
public class admConfig {
    String strNomeSite  = "";
	String strHttpSite  = "";
	String strEmailSite = "";
    
    public admConfig(){
        carregarInformacoes();
    }
    
    private void carregarInformacoes() {
        try {
            ConfigSiteDAO dao = new ConfigSiteDAO();
            ArrayList list = dao.buscarTodos();

            String codcampo, valor;

            if (list != null) {
                //Pegando o nome do arquivo carregado
                for(Object obj : list) {
                    ConfigSiteTO to = (ConfigSiteTO) obj;

                    codcampo = to.getCodCampo().toLowerCase();
                    valor = to.getValor();

                    if (codcampo.equals("nome_site")) {
                        strNomeSite = valor;

                    } else if (codcampo.equals("http_site")) {
                        strHttpSite = valor.toLowerCase();

                    } else if (codcampo.equals("email_site")) {
                        strEmailSite = valor.toLowerCase();
                    }
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
	public String getNomeSite() {
		return this.strNomeSite;
    }
	
	public String getHttpSite() {
		return this.strHttpSite;
    }
	
	public String getEmailSite() {
		return this.strEmailSite;
    }
}
