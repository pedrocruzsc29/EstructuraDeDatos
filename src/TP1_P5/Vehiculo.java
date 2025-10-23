package TP1_P5;

public class Vehiculo {

    // ATRIBUTOS

    private String marca;
    private int model;
    private int yearManufacture;
    private double precio;

    // CONSTRUCTOR PREDETERMINADO

    public Vehiculo(){
        this.marca = "a definir";
        this.model = 0;
        this.yearManufacture = 1999;
        this.precio = 0.0;
    }
    // CONSTRUCTOR PARAMETRIZADO

    public Vehiculo(String marca, int model, int year, double precio){
        this.marca = marca;
        this.model = model;
        this.yearManufacture = year;
        this.precio = precio;
    }

    // GETTERS AND SETTERS


    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public int getModel(){
        return this.model;
    }
    public void setModel(int model){
        this.model = model;
    }

    public int getYearManufacture(){
        return this.yearManufacture;
    }
    public void setYearManufacture(int year){
        this.yearManufacture = yearManufacture;
    }

    public double getPrecio(){
        return this.precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }

    // OBTENER INFORMACIÓN BÁSICA DEL VEHÍCULO

    public String getBasicDescription(){
        return "MARCA: " + getMarca() + " MODELO: " + getModel() + " AÑO DE FABRICACIÓN: " + getYearManufacture() + " ";
    }

    // CALCULAR ANTIGÜEDAD

    public int calculateAge(int actualYear){
        return actualYear - getYearManufacture();
    }


    @Override

    public String toString(){
        return "VEHICULO -> MARCA: " + getMarca() + " MODELO: " + getModel() + "AÑO: " + getYearManufacture() + "PRECIO: " + getPrecio();
    }
}
