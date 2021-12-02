package br.project.transferobject;

public class FotoTO {

    private int Cod_Evento;
    private String Nome;
    private String Tipo_Foto;
    private String Local_File_System;

     public int getCod_Evento() {
         return Cod_Evento;
     }
     public void  setCod_Evento(int cod_evento) {
         this.Cod_Evento=cod_evento;
     }
     public String getNome() {
         return Nome;
     }
     public void  setNome(String nome) {
         this.Nome=nome;
     }
     public String getTipo_Foto() {
         return Tipo_Foto;
     }
     public void  setTipo_Foto(String tipo_foto) {
         this.Tipo_Foto=tipo_foto;
     }
     public String getLocal_File_System() {
         return Local_File_System;
     }
     public void  setLocal_File_System(String local_file_system) {
         this.Local_File_System=local_file_system;
     }
}
