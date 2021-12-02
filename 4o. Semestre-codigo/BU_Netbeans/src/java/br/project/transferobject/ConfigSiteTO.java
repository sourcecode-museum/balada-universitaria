/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.project.transferobject;

/**
 *
 * @author Heliomar
 */
public class ConfigSiteTO {
    private int id;
    private String codcampo;
    private String caption;
    private String descricao;
    private String tipo;
    private String opcao1_size;
    private String opcao2_max;
    private String valor;

    //Contrutor padrão
    public ConfigSiteTO() {}
    
    public void setId(int id) {this.id = id;}
    public int getId() {return this.id;}
    
    public void setCodCampo(String codcampo) {this.codcampo = codcampo;}
    public String getCodCampo() {return this.codcampo;}
    
    public void setCaption(String caption) {this.caption = caption;}
    public String getCaption() {return this.caption;}

    public void setDescricao(String descricao) {this.descricao = descricao;}
    public String getDescricao() {return this.descricao;}    

    public void setTipo(String tipo) {this.tipo = tipo;}
    public String getTipo() {return this.tipo;}
    
    public void setOpcao1_Size(String opcao1_size) {this.opcao1_size = opcao1_size;}
    public String getOpcao1_Size() {return this.opcao1_size;}    

    public void setOpcao2_Max(String opcao2_max) {this.opcao2_max = opcao2_max;}
    public String getOpcao2_Max() {return this.opcao2_max;}    
    
    public void setValor(String valor) {this.valor = valor;}
    public String getValor() {return this.valor;}       
}

