package TP1_P2;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;

    // CONSTRUCTOR PREDETERMINADO
    public Producto(){
        this.nombre = "Desconocido";
        this.precio = 0.0;
        this.stock = 0;
    }

    // CONSTRUCTOR CON PARAMETROS
    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;

    }

    // GETTERS Y SETTERS
    public String GetName(){
        return this.nombre;
    }

    public void SetName(String nombre){
        this.nombre = nombre;
    }

    public double GetPrice(){
        return this.precio;
    }

    public void SetPrice(double precio){
        this.precio = precio;
    }

    public int GetStock(){
        return this.stock;
    }

    public void SetStock(int stock){
        this.stock = stock;
    }

    // VENDER PRODUCTO

    public double Vender(int cant){
        double total = this.precio * cant;
        this.stock = this.stock - cant;
        return total;
    }

    // ACTUALIZAR STOCK

    public void Update_Stock(int cant){
        this.stock = this.stock + cant;
    }
    @Override

    // DATOS DEL PRODUCTO
    public String toString(){
        return "# Producto # Descripcion: " + this.nombre + " Precio: " + this.precio + " Stock: " + this.stock;
    }

    //zerocool



}
