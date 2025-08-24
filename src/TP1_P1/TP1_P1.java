package TP1_P1;

public class TP1_P1 {

    public static void main (String[] args){

        Rectangulo rect = new Rectangulo();
        System.out.println("### AREA Y PERIMETRO ###");
        double ancho = Helper.GetPositiveNumber("Ancho: ");
        double alto = Helper.GetPositiveNumber("Alto: ");
        System.out.println("Ingreso: " + ancho + " " + alto);
        rect.SetAncho(ancho);
        rect.SetAlto(alto);

        System.out.println("### RESULTADOS ###");
        System.out.println("Area: " + rect.Area());
        System.out.println("Perimetro: " + rect.Perimeter());

    }
}
