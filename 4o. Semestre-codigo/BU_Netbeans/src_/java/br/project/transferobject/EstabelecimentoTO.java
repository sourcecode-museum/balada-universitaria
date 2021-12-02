package br.project.transferobject;

public class EstabelecimentoTO {

    private int Cod_Estabelecimento;
    private String Nome_Fantasia;
    private String Razao_Social;
    private long Cnpf;
    private String Endereco;
    private String Bairro;
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
     public String getRazao_Social() {
         return Razao_Social;
     }
     public void  setRazao_Social(String razao_social) {
         this.Razao_Social=razao_social;
     }
     public long getCnpf() {
         return Cnpf;
     }
     public void  setCnpf(Long cnpf) {
         this.Cnpf=cnpf;
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
