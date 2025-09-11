package TP2_P6;

public class Contacto {

    private String name;
    private int telefono;
    private String mail;

    // CONSTRUCTOR PREDETERMINADO
    public Contacto (){
        this.name = "Contacto";
        this.telefono = 123456789;
        this.mail = "@";
    }

    // CONSTRUCTOR CON PARAMETROS

    public Contacto (String name, int telefono, String mail){
        this.name = name;
        this.telefono = telefono;
        this.mail = mail;
    }

    // GETTERS Y SETTERS

    public String GetName(){
        return this.name;
    }

    public void SetName(String name){
        this.name = name;
    }

    public int GetTelephone(){
        return this.telefono;
    }

    public void SetTelephone(int telefono){
        this.telefono = telefono;
    }

    public String  GetMail(){
        return this.mail;
    }

    public void SetMail(String mail){
        this.mail = mail;
    }


    //@Override

    public String toString(){
        return "Nombre: " + GetName() + " Telefono: " + GetTelephone()  + " Email: " + GetMail();
    }


    // zerocool

}
