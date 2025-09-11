package TP2_P7;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

public class Evento {

    private int idEvento;
    private String nombreEvento;
    private LocalDate fecha;
    private String lugar;
    private Participante participantesInscriptos;

    public Evento(){
        this.idEvento = 0;
        this.nombreEvento = "";
        this.fecha = LocalDate.now();
        this.lugar = "";
        this.participantesInscriptos = null;
    }

    public Evento(int idEvento, String nombreEvento, LocalDate fecha, String lugar, Participante participantesInscriptos){
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
        this.participantesInscriptos = participantesInscriptos;
    }

    // GETTERS Y SETTERS

    public int GetIdEvento(){
        return this.idEvento;
    }
    public void SetIdEvento(int idEvento){
        this.idEvento = idEvento;
    }

    public String GetNombreEvento(){
        return this.nombreEvento;
    }
    public void SetNombreEvento(String nombreEvento){
        this.nombreEvento = nombreEvento;
    }


}
