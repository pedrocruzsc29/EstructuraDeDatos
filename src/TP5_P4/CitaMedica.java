package TP5_P4;

import java.time.LocalDate;

public class CitaMedica {

    // ATRIBUTOS

    private int numeroCita;
    private String paciente;
    private String medico;
    private LocalDate fecha;
    private String especialidad;
    private boolean confirmada;

    // CONSTRUCTOR PREDETERMINADO

    public CitaMedica(){
        this.numeroCita = 0;
        this.paciente = "a definir";
        this.medico = "a definir";
        this.fecha = LocalDate.now();
        this.especialidad = "Consulta";
        this.confirmada = false;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public CitaMedica(int numeroCita, String paciente, String medico, LocalDate fecha, String especialidad, boolean confirmada){
        this.numeroCita = numeroCita;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.confirmada = confirmada;
    }

    // GETTERS AND SETTERS

    public int getNumeroCita(){
        return this.numeroCita;
    }
    public void setNumeroCita(int numeroCita){
        this.numeroCita = numeroCita;
    }

    public String getPaciente(){
        return this.paciente;
    }
    public void setPaciente(String paciente){
        this.paciente = paciente;
    }

    public String getMedico(){
        return this.medico;
    }
    public void setMedico(String medico){
        this.medico = medico;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public String getEspecialidad(){
        return this.especialidad;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public boolean getConfirmada(){
        return this.confirmada;
    }
    public void setConfirmada(boolean confirmada){
        this.confirmada = confirmada;
    }
    // TO STRING

    @Override
    public String toString(){
        return "Numero de Cita: " + getNumeroCita() + " Paciente: " + getPaciente() + " Médico: " + getMedico() + " Fecha: "
                + getFecha() + " Especialidad: " + getEspecialidad() + " Confirmado?: " + getConfirmada();
    }
}

// Autor: zerocool