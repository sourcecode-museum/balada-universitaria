package br.project.transferobject;

public class Evento_PromocaoTO {

    private int Cod_Evento_promocao;
    private int Cod_Estabelecimento;
    private String Tipo;
    private String Nome;
    private String Data_Inicio;
    private String Descricao;

     public int getCod_Evento_promocao() {
         return Cod_Evento_promocao;
     }
     public void  setCod_Evento_promocao(int cod_evento_promocao) {
         this.Cod_Evento_promocao=cod_evento_promocao;
     }
     public int getCod_Estabelecimento() {
         return Cod_Estabelecimento;
     }
     public void  setCod_Estabelecimento(int cod_estabelecimento) {
         this.Cod_Estabelecimento=cod_estabelecimento;
     }
     public String getTipo() {
         return Tipo;
     }
     public void  setTipo(String tipo) {
         this.Tipo=tipo;
     }
     public String getNome() {
         return Nome;
     }
     public void  setNome(String nome) {
         this.Nome=nome;
     }
     public String getData_Inicio() {
         return Data_Inicio;
     }
     public void  setData_Inicio(String data_inicio) {
         this.Data_Inicio=data_inicio;
     }
     public String getDescricao() {
         return Descricao;
     }
     public void  setDescricao(String descricao) {
         this.Descricao=descricao;
     }
}
