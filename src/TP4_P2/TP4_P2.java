package TP4_P2;

public class TP4_P2 {

    // CARGAR CÓDIGOS

    public static QueueVelocidad <Integer> cargarCodes(QueueVelocidad <Integer> codes){
        String resp = "S";
        do{
            int num = Helper.getValidNumber("Código: ");
            codes.add(num);
            resp = Helper.getValidString("Desea cargar más códigos? (S/N): ");
        }while(resp.equalsIgnoreCase("S"));
        return codes;
    }

    // MOSTRAR CÓDIGOS

    public static void mostrarCodes(QueueVelocidad <Integer> codes){
        QueueVelocidad <Integer> aux_queue = new QueueVelocidad<Integer>();
        while(!codes.isEmpty()){
            int num = codes.remove();
            System.out.println(num);
            aux_queue.add(num);
        }
        while(!aux_queue.isEmpty()){
            codes.add(aux_queue.remove());
        }
    }

    // PROCESAR TAREAS

    public static QueueVelocidad <Integer> procesarCodes(QueueVelocidad <Integer> codes){
        QueueVelocidad <Integer> aux_queue = new QueueVelocidad<Integer>();
        QueueVelocidad <Integer> impares = new QueueVelocidad<Integer>();
        while(!codes.isEmpty()){
            int num = codes.remove();
            if (num % 2 != 0){
                impares.add(num);
            }else{
                aux_queue.add(num);
            }
        }
        while(!aux_queue.isEmpty()){
            codes.add(aux_queue.remove());
        }
        return impares;
    }

    // CONTAR TAREAS

    public static int contarTareas(QueueVelocidad <Integer> codes){
        QueueVelocidad <Integer> aux_queue = new QueueVelocidad<Integer>();
        int counter = 0;
        while(!codes.isEmpty()){
            int num = codes.remove();
            counter++;
            aux_queue.add(num);
        }
        while(!aux_queue.isEmpty()){
            codes.add(aux_queue.remove());
        }
        return counter;
    }

    // MAIN CONTROLLER
    public static void main (String [] args){
        QueueVelocidad <Integer> codes = new QueueVelocidad<Integer>();
        QueueVelocidad <Integer> impares = new QueueVelocidad<Integer>();
        int op = 0;
        do{
            System.out.println("*** PROCESAR TAREAS ***");
            System.out.println("1) Cargar códigos");
            System.out.println("2) Mostrar códigos");
            System.out.println("3) Procesar tareas pendientes");
            System.out.println("4) Contar tareas");
            System.out.println("5) Salir");
            op = Helper.getValidNumber("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR CÓDIGOS ***");
                    if (codes.isFull()){
                        System.out.println("No se pueden cargar más códigos... (QUEUE FULL)");
                    }else{
                        codes = cargarCodes(codes);
                        System.out.println("Carga exitosa...");
                    }
                    break;
                case 2:
                    System.out.println("*** CÓDIGOS ***");
                    if (codes.isEmpty()){
                        System.out.println("No se cargaron códigos aún...");
                    }else{
                        mostrarCodes(codes);
                    }
                    break;
                case 3:
                    System.out.println("*** PROCESAR TAREAS ***");
                    if (codes.isEmpty()){
                        System.out.println("No se cargaron códigos aún...");
                    }else{
                        System.out.println("Tareas pendientes ↓");
                        impares = procesarCodes(codes);
                        mostrarCodes(impares);
                    }
                    break;
                case 4:
                    System.out.println("*** CONTAR TAREAS ***");
                    if (codes.isEmpty()){
                        System.out.println("No se cargaron códigos aún...");
                    }else {
                        System.out.println("Cantidad de tareas pendientes: " + contarTareas(impares));
                    }
                    break;
                case 5:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }

        }while(op != 5);

    }
}

// AUTOR -> zerocool - Pedro Cruz
