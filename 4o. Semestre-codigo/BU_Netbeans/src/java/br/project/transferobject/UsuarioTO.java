package br.project.transferobject;

public class UsuarioTO {

    private String Email = "";
    private String EmailNovo = null;
    private String Senha = "";
    private String Nome = "";
    private String Sexo = "";
    private String Rg = "";
    private String Cep = "";
    private String Endereco = "";
    private String Bairro = "";
    private String Cidade = "";
    private String Uf = "";
    private int Cod_Area = 0;
    private String Telefone = "";
    private String Dt_Ultimo_Acesso = "";    
    private String Dt_Cadastro;
    
    public UsuarioTO() {}
    
    public UsuarioTO(
      String Email,
      String Senha,
      String Nome,
      String Sexo,
      String Rg,
      String Cep,
      String Endereco,
      String Bairro,
      String Cidade,
      String Uf,
      int Cod_Area,
      String Telefone
            ) 
    {
        this.Email = Email;
        this.Nome = Nome;
        this.Senha = Senha;
        this.Rg = Rg;
        this.Sexo = Sexo;
        this.Endereco = Endereco;
        this.Cep = Cep;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.Telefone = Telefone;
        this.Cod_Area = Cod_Area;
        this.Uf = Uf;
    }

     public String getEmail() {return Email;}
     public void  setEmail(String email) {this.Email=email;}

     public String getEmailNovo() {return EmailNovo;}
     public void  setEmailNovo(String email) {this.EmailNovo=email;}
     
     public String getNome() {return Nome;}
     public void  setNome(String nome) {this.Nome=nome;}
     
     public String getSenha() {return Senha;}
     public void  setSenha(String senha) {this.Senha=senha;}
     
     public String getBairro() {return Bairro;}
     public void  setBairro(String bairro) {this.Bairro=bairro;}
     
     public String getRg() {return Rg;}
     public void  setRg(String rg) {this.Rg=rg;}
     
     public String getSexo() {return Sexo;}
     public void  setSexo(String sexo) {this.Sexo=sexo;}
     
     public String getEndereco() {return Endereco;}
     public void  setEndereco(String endereco) {this.Endereco=endereco;}
     
     public String getCep() {return Cep;}
     public void  setCep(String  cep) {this.Cep=cep;}
     
     public String getCidade() {return Cidade;}
     public void  setCidade(String cidade) {this.Cidade=cidade;}
     
     public String getTelefone() {return Telefone;}
     public void  setTelefone(String telefone) {this.Telefone=telefone;}
     
     public int getCod_Area() {return Cod_Area;}
     public void  setCod_Area(int cod_area) {this.Cod_Area=cod_area;}
     
     public String getDt_Ultimo_Acesso() {return Dt_Ultimo_Acesso;}
     public void  setDt_Ultimo_Acesso(String dt_ultimo_acesso) {this.Dt_Ultimo_Acesso=dt_ultimo_acesso;}
     
     public String getUf() {return Uf;}
     public void  setUf(String uf) {this.Uf=uf;}
     
     public void  setDt_Cadastro(String dt_cadastro) {this.Dt_Cadastro = dt_cadastro;}
     public String getDt_Cadastro() {return Dt_Cadastro;}

}
