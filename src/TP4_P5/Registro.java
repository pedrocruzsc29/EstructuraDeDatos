package TP4_P5;

public class Registro {

    // ENCAPSULAMIENTO

    private String nombre;
    private int pasos;
    private double calories;
    private String actividad;

    // CONSTRUCTOR PREDETERMINADO

    public Registro(){
        this.nombre = "a definir";
        this.pasos = 0;
        this.calories = 0.0;
        this.actividad = "a definir";
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Registro(String nombre, int pasos, double calories, String actividad){
        this.nombre = nombre;
        this.pasos = pasos;
        this.calories = calories;
        this.actividad = actividad;
    }

    // GETTERS Y SETTERS

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getPasos(){
        return this.pasos;
    }
    public void setPasos(int pasos){
        this.pasos = pasos;
    }

    public double getCalories(){
        return this.calories;
    }
    public void setCalories(double calories){
        this.calories = calories;
    }

    public String getActividad(){
        return this.actividad;
    }
    public void setActividad(String actividad){
        this.actividad = actividad;
    }

    @Override

    public String toString(){
        return "Nombre: " + getNombre() + " Pasos: " + getPasos() + " Calorías: "
                + getCalories() + " Actividad: " + getActividad();
    }


}
