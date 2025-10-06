package TP4_P5;

public class TP4_P5 {

    // CARGAR REGISTROS

    public static Queue <Registro> cargarRegistros(Queue <Registro> registros){
        String resp = "S";
        do{
            String nombre = Helper.getValidString("Nombre: ");
            int pasos = Helper.getValidNumber("Pasos: ");
            double calories = Helper.getValidDouble("Calorías: ");
            String actividad = Helper.getValidActivity();
            registros.add(new Registro(nombre, pasos, calories, actividad));
            resp = Helper.getValidString("Desea cargar más usuarios? (S/N): ");
        }while(resp.equalsIgnoreCase("s"));
        return registros;
    }

    // CONSULTAR CALORÍAS

    public static double consultarCalories(Queue <Registro> registros, String actividad){
        Queue <Registro> aux_queue = new Queue<Registro>();
        double total = 0;
        while (!registros.isEmpty()){
            Registro registro = registros.remove();
            if (registro.getActividad().equalsIgnoreCase(actividad)){
                total = total + registro.getCalories();
            }
            aux_queue.add(registro);
        }
        while(!aux_queue.isEmpty()){
            registros.add(aux_queue.remove());
        }
        return total;
    }

    // IDENTIFICAR USUARIO CON MÁS PASOS

    public static String identificarUsuarios (Queue <Registro> registros){
        Queue <Registro> aux_queue = new Queue<Registro>();
        String nombreMax = "";
        int pasosMax = 0;
        while (!registros.isEmpty()){
            Registro registro = registros.remove();
            if (pasosMax < registro.getPasos()){
                nombreMax = registro.getNombre();
            }
            aux_queue.add(registro);
        }
        while (!aux_queue.isEmpty()){
            registros.add(aux_queue.remove());
        }
        return nombreMax;
    }

    // CONTAR CANTIDAD DE ACTIVIDADES DE USUARIO

    public static int contarActividades (Queue <Registro> registros, String nombre){
        Queue <Registro> aux_queue = new Queue<Registro>();
        int counter = 0;
        while (!registros.isEmpty()){
            Registro registro = registros.remove();
            if (registro.getNombre().equalsIgnoreCase(nombre)){
                counter++;
            }
            aux_queue.add(registro);
        }
        while (!aux_queue.isEmpty()){
            registros.add(aux_queue.remove());
        }
        return counter;
    }

    // MOSTRAR ACTIVIDADES

    public static void mostrarActividades(Queue <Registro> registros){
        Queue <Registro> aux_queue = new Queue<Registro>();
        while (!registros.isEmpty()){
            Registro registro = registros.remove();
            System.out.println(registro);
            aux_queue.add(registro);
        }
        while (!aux_queue.isEmpty()){
            registros.add(aux_queue.remove());
        }
    }

    // MAIN CONTROLLER
    public static void main (String [] args){
        Queue <Registro> registros = new Queue <Registro>();
        int op = 0;
        do{
            System.out.println("*** REGISTRO DE ACTIVIDAD FÍSICA ***");
            System.out.println("1) Registrar usuario");
            System.out.println("2) Mostrar usuarios");
            System.out.println("3) Total de calorías");
            System.out.println("4) Usuario con más pasos acumulados");
            System.out.println("5) Cantidad de actividades de Usuario");
            System.out.println("6) Salir");
            op = Helper.getValidNumber("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR USUARIO ***");
                    if (registros.isFull()){
                        System.out.println("No se pueden registrar más usuarios...(QUEUE FULL)");
                    }else{
                        registros = cargarRegistros(registros);
                        System.out.println("Se cargo correctamente...");
                    }
                    break;
                case 2:
                    System.out.println("*** USUARIOS ***");
                    if (registros.isEmpty()){
                        System.out.println("No se cargaron registros aún...");
                    }else{
                        mostrarActividades(registros);
                    }
                    break;
                case 3:
                    System.out.println("*** TOTAL DE CALORÍAS ***");
                    if (registros.isEmpty()){
                        System.out.println("No se cargaron registros aún...");
                    }else{
                        String actividad = Helper.getValidActivity();
                        System.out.println("CALORÍAS PARA " + actividad + ": " + consultarCalories(registros,actividad));
                    }
                    break;
                case 4:
                    System.out.println("*** USUARIO CON MÁS PASOS ***");
                    if (registros.isEmpty()){
                        System.out.println("No se cargaron registros aún...");
                    }else{
                        System.out.println("USUARIO: " + identificarUsuarios(registros));
                    }
                    break;
                case 5:
                    System.out.println("*** ACTIVIDADES POR USUARIO ***");
                    if (registros.isEmpty()){
                        System.out.println("No se cargaron registros aún...");
                    }else{
                        String nombre = Helper.getValidString("Nombre a buscar: ");
                        if (contarActividades(registros,nombre) == 0){
                            System.out.println("El usuario es inexistente...");
                        }else{
                            System.out.println("ACTIVIDADES DE " + nombre + ": " + contarActividades(registros,nombre));
                        }
                    }
                    break;
                case 6:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;

                default:
                    System.out.println("Elija una opción valida!");
            }

        }while (op != 6);

    }
}
