package TP5_P1;

import java.time.LocalDate;

public class Empleado {

    // ATRIBUTOS

    private int legajo;
    private int dni;
    private String name;
    private LocalDate fecha;
    private String correo;


    // CONSTRUCTOR PREDETERMINADO

    public Empleado(){
        this.legajo = 0;
        this.dni = 0;
        this.name = "a definir";
        this.fecha = LocalDate.now();
        this.correo = "@";
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Empleado(int legajo, int dni, String name, LocalDate fecha, String correo){
        this.legajo = legajo;
        this.dni = dni;
        this.name = name;
        this.fecha = fecha;
        this.correo = correo;
    }

    // GETTERS AND SETTERS

    public int getLegajo(){
        return this.legajo;
    }
    public void setLegajo(int legajo){
        this.legajo = legajo;
    }

    public int getDni(){
        return this.dni;
    }
    public void setDni(int dni){
        this.dni = dni;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public String getCorreo(){
        return this.correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }

    @Override

    public String toString(){
        return "Legajo: " + getLegajo() + " DNI: " + getDni() + " Nombre: " + getName() + " Fecha de Nacimiento: " + getFecha() + " Correo: " + getCorreo();
    }


}
