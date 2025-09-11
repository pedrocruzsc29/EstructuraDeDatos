package TP2_P7;

public class Participante {

    private int idParticipante;
    private String nombre;
    private String apellido;
    private String correo;



    //CONSTRUCTOR PREDETERMINADO
    public Participante(){
        this.idParticipante = 0;
        this.nombre = "";
        this.apellido = "";
        this.correo = "@";
    }

    //CONSTRUCTOR PARAMETRIZADO

    public Participante (int idParticipante, String nombre, String apellido, String correo){
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    // GETTERS & SETTERS

    public int GetidParticante(){
        return this.idParticipante;
    }

    public void SetidParticipante(int idParticipante){
        this.idParticipante = idParticipante;
    }

    public String GetNombre(){
        return this.nombre;
    }
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }

    public String GetApellido(){
        return this.apellido;
    }
    public void SetApellido(String apellido){
        this.apellido = apellido;
    }

    public String GetCorreo(){
        return this.correo;
    }
    public void SetCorreo(String correo){
        this.correo = correo;
    }

}
