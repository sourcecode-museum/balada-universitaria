/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.project.admin;

import java.text.*;
/**
 *
 * @author Heliomar
 */
public class admMontarMenu {
    private String addGrupo(String pCaption){
        return "<tr><th class='menu'>" + pCaption + "</th></tr>";
    }

    private String addItem(String pHREF, String pCaption) {
        String sLink;
        
        sLink = "<a class='menu' href='" + pHREF + "'><img src='./imgs/ico-menu.gif' border='0'>&nbsp;&nbsp;" + pCaption + "</a>";
        return "<tr><td>" + sLink + "</tr></td>"; 
    }

    private String addLinha3d() {
        return ("<tr><td><div class='hr3d'></div></td></tr>");
    }

    private String addSeparador() {
        return ("<tr><td height='5px'></td></tr>");
    }
    
    public String getMenu(){
        StringBuilder sRet = new StringBuilder();
        
        sRet.append("<table width='120' border='0' height='100%' align='center' cellpadding='2' cellspacing='0'>");
        sRet.append(("<tr><td height='2px'></td></tr>"));
        
        sRet.append(addGrupo("Cadastros"));
            sRet.append(addItem("cad_usuarios.jsp", "Usuários"));
            sRet.append(addItem("admin_eventos.jsp", "Eventos"));
            sRet.append(addItem("admin_promocoes.jsp", "Promoções"));
            sRet.append(addItem("admin_estabelecimento.jsp", "Estabelecimentos"));
/*
        sRet.append(addSeparador());
        sRet.append(addGrupo("Newsletter"));
            sRet.append(addItem("news_cad.jsp", "Cadastro"));
            sRet.append(addItem("news_env.jsp", "Enviar"));
            sRet.append(addItem("news_arq.jsp", "Arquivados"));
            sRet.append(addLinha3d());
            sRet.append(addItem("news_cfg.jsp", "Configurar"));
*/
        sRet.append(addSeparador());
        sRet.append(addGrupo("Ferramentas"));
            sRet.append(addItem("cfg_site.jsp", "Config. do Site"));
//            sRet.append(addItem("edit_areas.jsp", "Editor de Áreas"));

        sRet.append(addSeparador());
        sRet.append(addGrupo("Administrador"));
            sRet.append(addItem("admin_cad.jsp", "Cadastrar"));
            sRet.append(addItem("admin_edit.jsp", "Editar"));
            sRet.append(addItem("admin_list.jsp", "Listagem"));
            sRet.append(addItem("admin_senha.jsp", "Trocar Senha"));
            
        sRet.append("<tr><td height='100%'></td></tr>");
        sRet.append("</table>");
        
        return sRet.toString();
    }
}
