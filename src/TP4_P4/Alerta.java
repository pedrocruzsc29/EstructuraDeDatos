package TP4_P4;

public class Alerta {

    // ENCAPSULAMIENTO

    private String ciudad;
    private String tipo;
    private int nivel;

    // CONSTRUCTOR PREDETERMINADO
    public Alerta(){
        this.ciudad = "A definir";
        this.tipo = "A definir";
        this.nivel = 1;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Alerta(String ciudad, String tipo, int nivel){
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    // GETTERS Y SETTERS

    public String getCiudad(){
        return this.ciudad;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getNivel(){
        return this.nivel;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    @Override

    public String toString(){
        return "Ciudad: " + getCiudad() + " Tipo: " + getTipo() + " Nivel: " + getNivel();
    }


}
