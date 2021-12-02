package br.project.transferobject;

public class UsuarioTO {

    private String Email;
    private String Nome;
    private String Senha;
    private String Dt_Nascimento;
    private long Rg;
    private String Sexo;
    private String Endereco;
    private int Cep;
    private String Cidade;
    private String Telefone;
    private int Cod_Area;
    private String Dt_Ultimo_Acesso;
    private String Uf;

     public String getEmail() {
         return Email;
     }
     public void  setEmail(String email) {
         this.Email=email;
     }
     public String getNome() {
         return Nome;
     }
     public void  setNome(String nome) {
         this.Nome=nome;
     }
     public String getSenha() {
         return Senha;
     }
     public void  setSenha(String senha) {
         this.Senha=senha;
     }
     public String getDt_Nascimento() {
         return Dt_Nascimento;
     }
     public void  setDt_Nascimento(String dt_nascimento) {
         this.Dt_Nascimento=dt_nascimento;
     }
     public long getRg() {
         return Rg;
     }
     public void  setRg(long rg) {
         this.Rg=rg;
     }
     public String getSexo() {
         return Sexo;
     }
     public void  setSexo(String sexo) {
         this.Sexo=sexo;
     }
     public String getEndereco() {
         return Endereco;
     }
     public void  setEndereco(String endereco) {
         this.Endereco=endereco;
     }
     public int getCep() {
         return Cep;
     }
     public void  setCep(int cep) {
         this.Cep=cep;
     }
     public String getCidade() {
         return Cidade;
     }
     public void  setCidade(String cidade) {
         this.Cidade=cidade;
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
     public String getDt_Ultimo_Acesso() {
         return Dt_Ultimo_Acesso;
     }
     public void  setDt_Ultimo_Acesso(String dt_ultimo_acesso) {
         this.Dt_Ultimo_Acesso=dt_ultimo_acesso;
     }
     public String getUf() {
         return Uf;
     }
     public void  setUf(String uf) {
         this.Uf=uf;
     }
}
