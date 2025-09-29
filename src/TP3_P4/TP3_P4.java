package TP3_P4;

public class TP3_P4 {


    // CARGAR DATOS
    public static Evento LoadData(){

        String tipo = Helper.GetType();
        String desc = Helper.GetValidString("Descripción: ");
        int code = Helper.GetValidNumber("Código: ");
        return new Evento(tipo,desc,code);
    }

    // AGREGAR EVENTO A STACK
    public static void registrarEvento(Stack <Evento> stack, Evento evento){
        stack.push(evento);
    }

    // MOSTRAR EVENTOS

    public static void ShowEvents(Stack <Evento> stack){
        Stack <Evento> aux_event = new Stack<Evento>();
        while(!stack.isEmpty()){
            Evento event = stack.pop();
            System.out.println(event);
            aux_event.push(event);
        }

        while(!aux_event.isEmpty()){
            stack.push(aux_event.pop());
        }
    }

    // ELIMINAR EVENTOS
    public static void eliminarEventosDeTipo(Stack <Evento> stack, String type){
        Stack <Evento> aux_event = new Stack<Evento>();
        Evento event = new Evento();
        while(!stack.isEmpty()){
            event = stack.pop();
            if (!event.getTipo().equals(type)){
                aux_event.push(event);
            }
        }
        while(!aux_event.isEmpty()){
            stack.push(aux_event.pop());
        }
    }

    // BUSCAR EVENTOS POR CÓDIGO

    public static Evento buscarEventoPorCode(Stack <Evento> stack, int code){
        Stack <Evento> aux_stack = new Stack<Evento>();
        Evento encontrado = null;
        while (!stack.isEmpty()){
            Evento aux_event = stack.pop();
            if (aux_event.getCode() == code) {
                encontrado = aux_event;
            }
            aux_stack.push(aux_event);
        }
        while (!aux_stack.isEmpty()){
            stack.push(aux_stack.pop());
        }
        return encontrado;
    }

    // CONTAR EVENTOS DE TIPO ERROR

    public static int contarErrores(Stack<Evento>eventos){
        int counter = 0;
        Stack <Evento> aux_event = new Stack<Evento>();
        while(!eventos.isEmpty()){
            Evento event = eventos.pop();
            if (event.getTipo().equals("error")){
                counter++;
            }
            aux_event.push(event);
        }

        while(!aux_event.isEmpty()){
            eventos.push(aux_event.pop());
        }

        return counter;
    }



    // MAIN CONTROLLER
    public static void main (String [] args){
        Stack <Evento> eventos = new Stack<Evento>();
        int op = 0;
        do{
            System.out.println("### EVENTOS ###");
            System.out.println("1) Cargar eventos");
            System.out.println("2) Ver eventos");
            System.out.println("3) Eliminar eventos");
            System.out.println("4) Buscar evento");
            System.out.println("5) Contador de errores");
            System.out.println("6) Salir");
            op = Helper.GetValidNumber("Elija una opción: ");
            switch (op) {
                case 1:
                    String resp = "S";
                    if (!eventos.isFull()){
                        do {
                            System.out.println("* CARGAR EVENTO *");
                            Evento event = LoadData();
                            registrarEvento(eventos, event);
                            resp = Helper.GetValidString("Desea cargar más eventos? (S/N): ");
                        } while (resp.equals("s") || resp.equals("S"));
                        System.out.println("Evento/s cargados...");

                    }else{
                        System.out.println("No se pueden cargar más eventos...");
                    }
                    break;
                case 2:
                    if (!eventos.isEmpty()) {
                        System.out.println("### EVENTOS GUARDADOS ###");
                        ShowEvents(eventos);
                    } else {
                        System.out.println("No se cargaron eventos aún...");
                    }
                    break;
                case 3:
                    System.out.println("### ELIMINAR POR TIPO ###");
                    if (!eventos.isEmpty()){
                        String type = Helper.GetType();
                        eliminarEventosDeTipo(eventos,type);
                        System.out.println("Eventos eliminados...");
                    }else{
                        System.out.println("No se cargaron eventos aún...");
                    }
                    break;
                case 4:
                    System.out.println("### BUSCAR POR CÓDIGO ###");
                    if (!eventos.isEmpty()){
                        int code = Helper.GetValidNumber("Código: ");
                        if (!(buscarEventoPorCode(eventos,code) == null)){
                            System.out.println(buscarEventoPorCode(eventos,code));
                        }else{
                            System.out.println("No se encontró el código...");
                        }
                    }else{
                        System.out.println("No se cargaron eventos aún...");
                    }
                    break;
                case 5:
                    System.out.println("### CONTADOR DE EVENTOS TIPO ERROR ###");
                    if (!eventos.isEmpty()){
                        if (!(contarErrores(eventos) == 0)){
                            System.out.println("Cantidad de eventos tipo ERROR: " + contarErrores(eventos));
                        }else{
                            System.out.println("No hay eventos de este tipo...");
                        }
                    }else{
                        System.out.println("No se cargaron eventos aún");
                    }
                    break;

                default:
                    System.out.println("### FIN DEL PROGRAMA ###");
            }

        }while (op != 6);


    }


}


// zerocool