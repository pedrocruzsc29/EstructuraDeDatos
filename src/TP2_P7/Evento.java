package TP2_P7;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Evento {

    private int idEvento;
    private String nombreEvento;
    private LocalDate fecha;
    private String lugar;
    private ArrayList<Participante> participantesInscriptos;

    public Evento(){
        this.idEvento = 0;
        this.nombreEvento = "";
        this.fecha = LocalDate.now();
        this.lugar = "";
        //this.participantesInscriptos = new ArrayList<>();
    }

    public Evento(int idEvento, String nombreEvento, LocalDate fecha, String lugar){
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
        this.participantesInscriptos = new ArrayList<>();
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

    public LocalDate GetFecha(){
        return this.fecha;
    }
    public void SetFecha (LocalDate fecha){
        this.fecha = fecha;
    }

    public String GetLugar(){
        return this.lugar;
    }
    public void SetLugar(String lugar){
        this.lugar = lugar;
    }

    public ArrayList<Participante> GetParticipantesInscriptos(){
        return this.participantesInscriptos;
    }
    public void SetParticipantesInscriptos(ArrayList<Participante> participantesInscriptos){
        this.participantesInscriptos = participantesInscriptos;
    }

    // CARGAR EVENTO





    @Override

    public String toString(){
        return "ID del Evento: " + GetIdEvento() + " Nombre del Evento: " + GetNombreEvento() +
                " Fecha: " + GetFecha() + " Lugar: " + GetLugar() +
                " Participantes: " + GetParticipantesInscriptos().size();
    }


}
// zerocool
