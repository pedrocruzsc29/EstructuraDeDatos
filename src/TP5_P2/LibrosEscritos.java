package TP5_P2;

public class LibrosEscritos implements Comparable<LibrosEscritos>{

    // ATRIBUTOS
    private String name;
    private int cantidad;

    // CONSTRUCTOR PREDETERMINADO
    public LibrosEscritos(){
        this.name = "a definir";
        this.cantidad = 0;
    }
    // CONSTRUCTOR PARAMETRIZADO
    public LibrosEscritos(String name, int cantidad){
        this.name = name;
        this.cantidad = cantidad;
    }

    // GETTERS AND SETTERS

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getCantidad(){
        return this.cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    // TO STRING
    @Override
    public String toString(){
        return "Nombre del Autor: " + getName() + " Cantidad de Libros: " + getCantidad();
    }

    @Override

    public int compareTo(LibrosEscritos libroEscrito){
        return Integer.compare(this.cantidad, libroEscrito.getCantidad());
    }
}
