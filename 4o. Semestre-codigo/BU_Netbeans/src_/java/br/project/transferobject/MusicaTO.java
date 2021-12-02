package br.project.transferobject;

public class MusicaTO {

    private int Cod_Musica;
    private String Nome;
    private String Artista;
    private String Album;
    private int Cod_Categoria;
    

     public int getCod_Musica() {
         return Cod_Musica;
     }
     public void  setCod_Musica(int cod_musica) {
         this.Cod_Musica=cod_musica;
     }
     public String getNome() {
         return Nome;
     }
     public void  setNome(String nome) {
         this.Nome=nome;
     }
     public String getArtista() {
         return Artista;
     }
     public void  setArtista(String artista) {
         this.Artista=artista;
     }
     public String getAlbum() {
         return Album;
     }
     public void  setAlbum(String album) {
         this.Album=album;
     }
     public int getCod_Categoria() {
         return Cod_Categoria;
     }
     public void  setCod_Categoria(int cod_categoria) {
         this.Cod_Categoria=cod_categoria;
     }

}

