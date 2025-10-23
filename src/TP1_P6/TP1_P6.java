package TP1_P6;

public class TP1_P6 {


    // CREAR CÍRCULO
    public static Circulo crearCirculo(){
        String color = Helper.getValidStrings("Color: ");
        double radio = Helper.getValidDouble("Radio: ");
        return new Circulo(color,radio);
    }

    // CREAR RECTÁNGULO
    public static Rectangle crearRectangle(){
        String color = Helper.getValidStrings("Color: ");
        double largo = Helper.getValidDouble("Largo: ");
        double ancho = Helper.getValidDouble("Ancho: ");
        return new Rectangle(color,largo,ancho);
    }

    public static void main (String [] args){
        System.out.println("*** CIRCULO ***");
        Circulo circle = crearCirculo();
        System.out.println("*** RECTÁNGULO ***");
        Rectangle rectangle = crearRectangle();
        System.out.println("*** DATOS ***");
        System.out.println("--- CIRCULO ---");
        circle.mostrarInfo();
        System.out.println("--- RECTÁNGULO ---");
        rectangle.mostrarInfo();

    }
}
