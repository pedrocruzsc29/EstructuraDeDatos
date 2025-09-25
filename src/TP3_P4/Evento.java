package TP3_P4;

public class Evento {

    private String tipo;
    private String desc;
    private int code;

    // CONSTRUCTOR PREDETERMINADO

    public Evento(){
        this.tipo = "a definir";
        this.desc = "descripción";
        this.code = 0;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Evento(String tipo, String desc, int code){
        this.tipo = tipo;
        this.desc = desc;
        this.code = code;
    }

    // GETTERS Y SETTERS

    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getDesc(){
        return this.desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }

    public int getCode(){
        return this.code;
    }
    public void setCode(int code){
        this.code = code;
    }

    @Override

    public String toString(){
        return "Evento -> Tipo : " + getTipo() + " Descripción: " + getDesc() + " Código: " + getCode();
    }

}

// zerocool
