package br.project.transferobject;

public class EstabelecimentoTO {

    private int Cod_Estabelecimento;
    private String Nome_Fantasia;
    private String Endereco;
    private String Bairro;
    private String Cidade;    
    private String Uf;
    private String Telefone;
    private int Cod_Area;

     public int getCod_Estabelecimento() {
         return Cod_Estabelecimento;
     }
     public void  setCod_Estabelecimento(int cod_estabelecimento) {
         this.Cod_Estabelecimento=cod_estabelecimento;
     }
     public String getNome_Fantasia() {
         return Nome_Fantasia;
     }
     public void  setNome_Fantasia(String nome_fantasia) {
         this.Nome_Fantasia=nome_fantasia;
     }
     public String getEndereco() {
         return Endereco;
     }
     public void  setEndereco(String endereco) {
         this.Endereco=endereco;
     }
     public String getBairro() {
         return Bairro;
     }
     public void  setBairro(String bairro) {
         this.Bairro=bairro;
     }
     public String getCidade() {
         return Cidade;
     }
     public void  setCidade(String cidade) {
         this.Cidade=cidade;
     }
     
     public String getUf() {
         return Uf;
     }
     public void  setUf(String uf) {
         this.Uf=uf;
     }
     public String getTelefone() {
         return Telefone;
     }
     public void  setTelefone(String telefone) {
         this.Telefone=telefone;
     }
     public int getCod_Area() {
         return Cod_Area;
     }
     public void  setCod_Area(int cod_area) {
         this.Cod_Area=cod_area;
     }
}
