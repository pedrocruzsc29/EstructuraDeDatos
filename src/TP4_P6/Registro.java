package TP4_P6;

import java.time.LocalTime;

public class Registro {


    // DECLARACIÓN DE VARIABLES
    private int dni;
    private String motivo;
    private LocalTime hora;
    private boolean fueAutorizado;


    // CONSTRUCTOR PREDETERMINADO
    public Registro(){
        this.dni = 0;
        this.motivo = "A definir";
        this.hora = LocalTime.now();
        this.fueAutorizado = false;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Registro (int dni, String motivo, LocalTime hora, boolean fueAutorizado){
        this.dni = dni;
        this.motivo = motivo;
        this.hora = hora;
        this.fueAutorizado = fueAutorizado;
    }

    // GETTERS AND SETTERS

    public int getDni(){
        return this.dni;
    }
    public void setDni(int dni){
        this.dni = dni;
    }

    public String getMotivo(){
        return this.motivo;
    }
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }

    public LocalTime getHora(){
        return this.hora;
    }
    public void setHora(LocalTime hora){
        this.hora = hora;
    }

    public boolean getFueAutorizado(){
        return this.fueAutorizado;
    }
    public void setFueAutorizado(boolean fueAutorizado){
        this.fueAutorizado = fueAutorizado;
    }

    @Override

    public String toString(){
        return "DNI: " + getDni() + " Motivo: " + getMotivo() + " Hora: " + getHora() + " Autorización: " + getFueAutorizado();
    }

}
