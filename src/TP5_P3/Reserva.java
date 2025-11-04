package TP5_P3;

import java.time.LocalDate;

public class Reserva implements Comparable<Reserva>{

    // ATRIBUTOS
    private int code;
    private String recurso;
    private LocalDate fechaReserva;
    private String solicitante;

    // CONSTRUCTOR PREDETERMINADO

    public Reserva(){
        this.code = 0;
        this.recurso = "a definir";
        this.fechaReserva = LocalDate.now();
        this.solicitante = "a definir";
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Reserva(int code, String recurso, LocalDate fechaReserva, String solicitante){
        this.code = code;
        this.recurso = recurso;
        this.fechaReserva = fechaReserva;
        this.solicitante = solicitante;
    }

    // GETTERS AND SETTERS

    public int getCode(){
        return this.code;
    }
    public void setCode(int code){
        this.code = code;
    }

    public String getRecurso(){
        return this.recurso;
    }
    public void setRecurso(String recurso){
        this.recurso = recurso;
    }

    public LocalDate getFechaReserva(){
        return this.fechaReserva;
    }
    public void setFechaReserva(LocalDate fechaReserva){
        this.fechaReserva = fechaReserva;
    }

    public String getSolicitante(){
        return this.solicitante;
    }
    public void setSolicitante(String solicitante){
        this.solicitante = solicitante;
    }
    // TO STRING

    @Override
    public String toString(){
        return "Código: " + getCode() + " Recurso: " + getRecurso() +
                " Fecha de Reserva: " + getFechaReserva() + " Solicitante: " + getSolicitante();
    }

    // COMPARAR FECHAS

    @Override

    public int compareTo(Reserva reserva){
        return this.fechaReserva.compareTo(reserva.getFechaReserva());
    }
}
