package TP1_P6;

public class GeometricFigure {

    // ATRIBUTOS

    private String color;
    private String nombre;

    // CONSTRUCTOR PREDETERMINADO

    public GeometricFigure(){
        this.color = "a definir";
        this.nombre = "a definir";
    }

    // CONSTRUCTOR PARAMETRIZADO

    public GeometricFigure(String color, String nombre){
        this.color = color;
        this.nombre = nombre;
    }

    // GETTERS AND SETTERS

    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // CALCULAR AREA

    public double calcularArea(){
        return 0;
    }

    // CALCULAR PERIMETRO

    public double calcularPerimetro(){
        return 0;
    }

    // MOSTRAR DATOS DE FIGURA

    public void mostrarInfo(){
        System.out.println("Color: " + getColor() + " Nombre: " + getNombre());
    }

    @Override

    public String toString(){
        return "Color: " + getColor() + " Nombre: " + getNombre();
    }
}
