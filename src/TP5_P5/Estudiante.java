package TP5_P5;

public class Estudiante {

    // ATRIBUTOS

    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;

    // CONSTRUCTOR PREDETERMINADO

    public Estudiante(){
        this.lu = 0;
        this.nombre = "a definir";
        this.apellido = "a definir";
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }
    // CONSTRUCTOR PARAMETRIZADO

    public Estudiante(int lu, String nombre, String apellido, double nota1, double nota2, double nota3){
        this.lu = lu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // GETTERS AND SETTERS

    public int getLu(){
        return this.lu;
    }
    public void setLu(int lu){
        this.lu = lu;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public double getNota1(){
        return this.nota1;
    }
    public void setNota1(double nota1){
        this.nota1 = nota1;
    }

    public double getNota2(){
        return this.nota2;
    }
    public void setNota2(double nota2){
        this.nota2 = nota2;
    }

    public double getNota3(){
        return this.nota3;
    }
    public void setNota3(double nota3){
        this.nota3 = nota3;
    }

    // TO STRING
    @Override

    public String toString(){
        return "LU: " + getLu() + " Nombre y Apellido: " + getNombre() + " " + getApellido() +
                " Nota 1°: " + getNota1() + " Nota 2°: " + getNota2() + " Nota 3°: " + getNota3();
    }
}

// Autor: zerocool