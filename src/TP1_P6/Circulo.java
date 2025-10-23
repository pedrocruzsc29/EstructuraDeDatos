package TP1_P6;

public class Circulo extends GeometricFigure{

    // ATRIBUTOS

    private double radio;

    // CONSTRUCTOR PREDETERMINADO

    public Circulo(){
        super();
        this.radio = 0.0;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Circulo(String color, double radio){
        super(color, "Circulo");
        this.radio = radio;
    }

    // GETTERS AND SETTERS

    public double getRadio(){
        return this.radio;
    }
    public void setRadio(double radio){
        this.radio = radio;
    }

    // MÉTODOS

    @Override // Indica sobre escritura con respecto a los métodos de la clase padre
    public double calcularArea(){
        return Math.PI * Math.pow(radio,2);
    }
    @Override

    public double calcularPerimetro(){
        return 2 * Math.PI * this.radio;
    }

    @Override

    public void mostrarInfo(){
        System.out.println("Radio: " + getRadio() + " Área: " + String.format("%.2f",calcularArea()) + " Perimetro: " + String.format("%.2f",calcularPerimetro()));
    }



}
