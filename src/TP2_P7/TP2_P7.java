package TP2_P7;

import java.time.LocalDate;
import java.util.ArrayList;

public class TP2_P7 {


    // LOAD PARTICIPANT METHOD

    public static void LoadParticipant(ArrayList <Evento> Eventos, int pos) {
        String resp = "S";

        Evento SelectedEvent = Eventos.get(pos);

        do{
            int idParticipante = Helper.GetValidNumber("ID de Participante: ");
            String nombre = Helper.GetValidString("Nombre: ");
            String apellido = Helper.GetValidString("Apellido: ");
            String correo = Helper.GetValidString("Correo: ");
            Participante participant = new Participante(idParticipante, nombre, apellido, correo);
            SelectedEvent.GetParticipantesInscriptos().add(participant);
            resp = Helper.GetValidString("Desea cargar más participantes? (S/N): ");

        }while(resp.equals("S") || resp.equals("s"));
        System.out.println("Participante/s cargados...");
    }


    // LOAD EVENTS METHOD
    public static ArrayList<Evento> LoadEvents (ArrayList<Evento> Eventos){
        String resp = "S";

        do{
            int idEvento = Helper.GetValidNumber("ID del Evento: ");
            String nombreEvento = Helper.GetValidString("Nombre del Evento: ");
            LocalDate fecha = Helper.GetValidDate("Fecha ");
            String lugar = Helper.GetValidString("Lugar: ");
            Evento Event = new Evento(idEvento,nombreEvento,fecha,lugar);
            Eventos.add(Event);
            resp = Helper.GetValidString("Desea cargar más eventos? (S/N): ");
        }while(resp.equals("S") || resp.equals("s"));

        return Eventos;
    }

    // SHOW EVENT

    public static void ShowEvents(ArrayList<Evento> eventos){
        System.out.println("### EVENTOS ###");
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }

    // SHOW PARTICIPANTS

    public static void ShowParticipantsById(ArrayList<Evento> eventos, int pos){
        if (eventos.get(pos).GetParticipantesInscriptos().isEmpty()){
            System.out.println("No se cargaron participantes...");
        }else{
            ArrayList<Participante> participantes = eventos.get(pos).GetParticipantesInscriptos();
            System.out.println("### PARTICIPANTES DEL EVENTO " + eventos.get(pos).GetNombreEvento() + ": ");
            for (Participante participante: participantes){
                System.out.println("ID: " + participante.GetidParticante() + " Nombre y Apellido: " + participante.GetNombre() + " " + participante.GetApellido() +
                        " Correo: " + participante.GetCorreo());

            }

        }

    }

    // BUSCAR EVENTO

    public static int SearchEvent(ArrayList<Evento> event, int id){
        int pos = -1;
        for (int i = 0; i < event.size(); i++){
            if (event.get(i).GetIdEvento() == id){
                pos = i;
            }
        }
        return pos;
    }

    // BUSCAR PARTICIPANTE

    public static int SearchParticipant(ArrayList<Participante> participants){
        int id = Helper.GetValidNumber("Ingrese el ID: ");
        int posParticipant = -1;
        for (int i = 0; i < participants.size(); i++){
            if (participants.get(i).GetidParticante() == id){
                posParticipant = i;
            }
        }
        return posParticipant;
    }

    // AMOUNT OF PARTICIPANTS

    public static int AmountParticipants(ArrayList<Evento>events){
        int cant = 0;
        String name = Helper.GetValidString("Nombre del Evento: ");
        for (int i = 0; i < events.size();i++){
            if (events.get(i).GetNombreEvento().equals(name)){
                cant = events.get(i).GetParticipantesInscriptos().size();
                break;
            }
        }
        return cant;
    }

    // CONSULT DATE

    public static void ConsultDate(ArrayList<Evento> eventos){
        boolean band = true;
        LocalDate fecha = Helper.GetValidDate("Ingrese fecha a buscar ");
        for (int i = 0; i < eventos.size(); i++){
            if (fecha.equals(eventos.get(i).GetFecha())) {
                System.out.println(eventos.get(i));
                band = false;
            }
        }
        if (band){
            System.out.println("No se encontraron fechas coincidentes...");
        }

    }

    public static void main (String[] args){

        ArrayList<Evento> event = new ArrayList<>();
        int id;
        int op;
        do{
            System.out.println("### EVENTOS LAS VEGAS ###");
            System.out.println("1) Cargar evento");
            System.out.println("2) Mostrar eventos");
            System.out.println("3) Cargar participante/s");
            System.out.println("4) Consultar participantes por ID");
            System.out.println("5) Eliminar participante de evento");
            System.out.println("6) Cantidad de participantes en evento");
            System.out.println("7) Consultar fechas");
            System.out.println("8) Salir");
            op = Helper.GetValidNumber("Elija una opción: ");
            switch(op){
                case 1:
                    System.out.println("### CARGAR EVENTO ###");
                    event = LoadEvents(event);
                    ShowEvents(event);
                    break;
                case 2:
                    ShowEvents(event);
                    break;

                case 3:
                    System.out.println("### INSCRIBIR PARTICIPANTE ###");
                    id = Helper.GetValidNumber("Ingrese la id del Evento: ");
                    int pos = SearchEvent(event,id);
                    if (pos != -1){
                        System.out.println("### DATOS DEL EVENTO ###");
                        System.out.println(event.get(pos));
                        System.out.println("### CARGAR PARTICIPANTE ###");
                        LoadParticipant(event,pos);
                    }else{
                        System.out.println("El evento no existe...");
                    }
                    break;
                case 4:
                    System.out.println("### EVENTOS LAS VEGAS ###");
                    id = Helper.GetValidNumber("Ingrese la id del Evento: ");
                    int posBusqueda = SearchEvent(event,id);
                    if (posBusqueda != -1){
                        ShowParticipantsById(event,posBusqueda);
                    }else{
                        System.out.println("Evento inexistente...");
                    }
                    break;
                case 5:
                    System.out.println("### EVENTOS LAS VEGAS ###");
                    id = Helper.GetValidNumber("Ingrese la id del Evento: ");
                    int posEvento = SearchEvent(event,id);
                    if (posEvento != -1){
                        int posEliminar = SearchParticipant(event.get(posEvento).GetParticipantesInscriptos());
                        if (posEliminar != -1){
                            ArrayList<Participante> participants = event.get(posEvento).GetParticipantesInscriptos();
                            System.out.println("Se eliminara a -> Nombre y Apellido: " + participants.get(posEliminar).GetNombre()
                            + " " + participants.get(posEliminar).GetApellido());
                            event.get(posEvento).GetParticipantesInscriptos().remove(posEliminar);
                            System.out.println("Participante borrado...");
                        }else{
                            System.out.println("Participante no encontrado...");
                        }

                    }else{
                        System.out.println("Evento inexistente...");
                    }
                    break;
                case 6:
                    System.out.println("### PARTICIPANTES ###");
                    int amount = AmountParticipants(event);
                    if (amount != 0){

                        System.out.println("Cantidad de Participantes: " + amount);
                    }else{
                        System.out.println("El evento aún no tiene participantes...");
                    }
                    break;
                case 7:
                    System.out.println("### CONSULTA DE FECHAS ###");
                    ConsultDate(event);
                    break;

                case 8:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;

                default:
                    System.out.println("Elija una opción correcta!");
            }


        }while(op!=8);


    }

    // zerocool


}


