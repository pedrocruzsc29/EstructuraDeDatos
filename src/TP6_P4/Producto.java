package TP6_P4;

public class Producto implements  Comparable <Producto>{

    // ATRIBUTOS

    private int code;
    private String nombre;
    private int stock;
    private double precio;

    // CONSTRUCTOR PREDETERMINADO

    public Producto(){
        this.code = 0;
        this.nombre = "a definir";
        this.stock = 0;
        this.precio = 0.0;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Producto(int code, String nombre, int stock, double precio){
        this.code = code;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    // GETTERS AND SETTERS

    public int getCode(){
        return this.code;
    }
    public void setCode(int code){
        this.code = code;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getStock(){
        return this.stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    public double getPrecio(){
        return this.precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }

    // TO STRING
    @Override
    public String toString(){
        return "Código: " + getCode() + " Nombre: " + getNombre() + " Stock: " + getStock() + " Precio: " + getPrecio();
    }

    // COMPARE TO

    @Override

    public int compareTo(Producto producto){
        return Integer.compare(this.code, producto.getCode());
    }

}
