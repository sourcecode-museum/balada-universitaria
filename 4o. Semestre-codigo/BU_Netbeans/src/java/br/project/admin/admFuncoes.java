package br.project.admin;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Heliomar
 */
public class admFuncoes {
    public enum enumMessageTop {Aviso, Ok, Erro};
    public enum enumTypeInput {submit, reset, button};
    public enum enumAlignInput {right, left};
    
    public String getTituloPagina(String pImagem, String pTitulo, String pDescricao) {
        String sReturn = "";
	
        if (pImagem.length() > 0) 
            sReturn = "<div class='logo'><img src='" + pImagem + "' border='0'/></div>";
        
        sReturn += "<div id='title'>" + pTitulo + "</div>";
        sReturn += "<div id='subtitle'>" + pDescricao + "<hr/></div>";
	
        return sReturn;
    }
    
    /* Retorna uma caixa com a mensagem no topo da pagina
     * Usado para mensagem de Erro, Aviso e OK
     */
    public String getMessageTop(String pMsg, String pTipo) {
        pMsg = "<div id='msgtop" + pTipo + "'>" + pMsg + "</div>";	
        return pMsg;
    }
    
    public String getMessageTop(String pMsg, enumMessageTop pTipo) {
        pMsg = "<div id='msgtop" + pTipo.name() + "'>" + pMsg + "</div>";	
        return pMsg;
    } 
    
    public String getTagTRLight(String pClass) {
        String sReturn = "";

        sReturn = "<tr class=\"[class]\" onMouseOut=\"this.className='[class]'\" onMouseOver=\"this.className='highlight'\" >";
        sReturn = sReturn.replace("[class]", pClass);
        
        return sReturn;
    }
    
    public String getTagTRLight(String pClass, String pOnClick) {
        String sReturn = getTagTRLight(pClass);

        sReturn = sReturn.replace(">", " onclick=\"window.location='" + pOnClick + "'\">");
        return sReturn;
    }

    private String getDivBotao(enumAlignInput align, String input) {
        String sResult;

        sResult = "<div id=\"btn-" + align.name() + "\" class=\"onMouseOut\" onMouseOut=\"this.className='onMouseOut';\" onMouseOver=\"this.className ='onMouseOver';\">";
        sResult += input;
        sResult += "</div>";
        
        return sResult;
    }
    public String getBotao(enumTypeInput type, enumAlignInput align, String id, String value) {
        String input;
        input = "<input type=\"" + type.name() + "\" id=\"" + id + "\" value=\"" + value + "\" />";
        return getDivBotao(align, input);
    }
    public String getBotao(enumTypeInput type, enumAlignInput align, String id, String value, String onclick) {
        String input;

        input = "<input type=\"" + type.name() + "\" id=\"" + id + "\" value=\"" + value + "\" onclick=\"" + onclick + "\" />";
        return getDivBotao(align, input);
    }
    public String getBotao(enumTypeInput type, enumAlignInput align, String id, String value, String onclick, String name) {
        String input;

        input = "<input type=\"" + type.name() + "\" id=\"" + id + "\" value=\"" + value + "\" onclick=\"" + onclick + "\" name=\"" + name + "\" />";
        return getDivBotao(align, input);
    }

}
