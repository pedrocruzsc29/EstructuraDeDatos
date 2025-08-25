package TP1_P1;

public class Rectangulo {

    private double Ancho;

    private double Alto;

    // CONSTRUCTORES

    public Rectangulo(){
        this.Ancho = 0;
        this.Alto = 0;
    }

    public Rectangulo(double Ancho, double Alto){
        this.Ancho = Ancho;
        this.Alto = Alto;
    }

    // GETTERS AND SETTERS

    public double GetAncho(){
        return this.Ancho;
    }

    public void SetAncho(double Ancho) {
        this.Ancho = Ancho;
    }

    public double GetAlto() {
        return this.Alto;
    }

    public void SetAlto(double Alto){
        this.Alto = Alto;
    }

    // CALCULAR AREA

    public double Area(){
        return this.Ancho * this.Alto;
    }

    // CALCULAR PERIMETRO

    public double Perimeter(){
        return 2 * (this.Ancho + this.Alto);
    }
}

// zerocool
