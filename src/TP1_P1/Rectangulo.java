package TP1_P1;

public class Rectangulo {

    private double Ancho;

    private double Alto;

    // CONSTRUCTORES

    public Rectangulo(){
    }

    public Rectangulo(double Ancho, double Alto){
        this.Ancho = Ancho;
        this.Alto = Alto;
    }

    // GETTERS AND SETTERS

    public double GetAncho(){
        return this.Ancho;
    }

    public void SetAncho(){
        this.Ancho = Ancho;
    }

    public double GetAlto(){
        return this.Alto;
    }

    public void SetAlto(){
        this.Alto = Alto;
    }
}
