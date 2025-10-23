package TP1_P6;

public class Rectangle extends GeometricFigure{

    // ATRIBUTOS

    private double ancho;
    private double largo;

    // CONSTRUCTOR PREDETERMINADO

    public Rectangle(){
        super();
        this.ancho = 0.0;
        this.largo = 0.0;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Rectangle(String color, double ancho, double largo){
        super(color, "Rectángulo");
        this.ancho = ancho;
        this.largo = largo;
    }

    // GETTERS AND SETTERS

    public double getAncho(){
        return this.ancho;
    }
    public void setAncho(double ancho){
        this.ancho = ancho;
    }

    public double getLargo(){
        return this.largo;
    }
    public void setLargo(double largo){
        this.largo = largo;
    }

    // MÉTODOS

    // CALCULAR AREA
    @Override

    public double calcularArea(){
        return this.ancho * this.largo;
    }

    // CALCULAR PERIMETRO

    @Override
    public double calcularPerimetro(){
        return 2 * this.ancho + 2 * this.largo;
    }

    // MOSTRAR INFORMACIÓN

    @Override

    public void mostrarInfo(){
        System.out.println("Ancho: " + getAncho() + " Largo: " + getLargo() + " Área: " + String.format("%.2f",calcularArea()) + " Perimetro: " + String.format("%.2f",calcularPerimetro()));
    }




}
