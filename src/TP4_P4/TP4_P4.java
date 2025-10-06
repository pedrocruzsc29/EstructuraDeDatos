package TP4_P4;

public class TP4_P4 {

    // CARGAR COLA DE ALERTAS

    public static Queue <Alerta> cargarAlertas(Queue <Alerta> alertas){
        String resp = "S";
        do{
            String ciudad = Helper.getValidString("Ciudad: ");
            String tipo = Helper.getValidType();
            int nivel = Helper.getValidLevel();
            alertas.add(new Alerta(ciudad,tipo,nivel));
            resp = Helper.getValidString("Desea cargar más alertas? (S/N): ");

        }while(resp.equals("S") || resp.equals("s"));
        return alertas;
    }

    // MOSTRAR ALERTAS

    public static void mostrarAlertas(Queue <Alerta> alertas){
        Queue <Alerta> aux_queue = new Queue<Alerta>();
        while(!alertas.isEmpty()){
            Alerta alerta = alertas.remove();
            System.out.println(alerta);
            aux_queue.add(alerta);
        }
        while(!aux_queue.isEmpty()){
            alertas.add(aux_queue.remove());
        }
    }

    // CLASIFICAR ALERTAS POR TIPO -> A

    public static Queue <Alerta> generarCola(Queue <Alerta> alertas, String tipo){
        Queue <Alerta> aux_queue = new Queue<Alerta>();
        Queue <Alerta> alertas_tipo = new Queue<Alerta>();
        while(!alertas.isEmpty()){
            Alerta alerta = alertas.remove();
            if (alerta.getTipo().equalsIgnoreCase(tipo)){
                alertas_tipo.add(alerta);
            }
            aux_queue.add(alerta);
        }
        while(!aux_queue.isEmpty()){
            alertas.add(aux_queue.remove());
        }
        return alertas_tipo;
    }

    // PROMEDIO DE SEVERIDAD -> B

    public static double promedioSeveridad(Queue <Alerta> alertas){
        Queue <Alerta> aux_queue = new Queue<Alerta>();
        int acumulador = 0;
        while (!alertas.isEmpty()){
            Alerta alerta = alertas.remove();
            acumulador = acumulador + alerta.getNivel();
            aux_queue.add(alerta);
        }
        while(!aux_queue.isEmpty()){
            alertas.add(aux_queue.remove());
        }

        return (double) acumulador/ alertas.size();
    }

    //  VERIFICAR ALERTA CRITICA NIVEL 5 -> C

    public static Alerta obtenerPrimerAlertaCritica(Queue <Alerta> alertas){
        Queue <Alerta> aux_queue = new Queue<Alerta>();
        Alerta alertaCritica = null;
        boolean encontrado = false;
        while(!alertas.isEmpty()){
            Alerta alerta = alertas.remove();
            if (!encontrado && alerta.getNivel() == 5){
                alertaCritica = alerta;
                encontrado = true;
            }
            aux_queue.add(alerta);
        }
        while(!aux_queue.isEmpty()){
            alertas.add(aux_queue.remove());
        }
        return alertaCritica;
    }

    // ARREGLO DE CIUDADES AFECTADAS -> D

    public static String [] ciudadesAfectadas(Queue <Alerta> alertas){
        Queue <Alerta> aux_queue = new Queue<Alerta>();
        int city_counter = 0;
        while(!alertas.isEmpty()){
            Alerta alerta = alertas.remove();
            if (alerta.getNivel() == 4 || alerta.getNivel() == 5){
                city_counter++;
            }
            aux_queue.add(alerta);
        }
        String [] ciudades = new String[city_counter];
        int i = 0;

        while(!aux_queue.isEmpty()){
            Alerta aux_alerta = aux_queue.remove();
            if (aux_alerta.getNivel() == 4 || aux_alerta.getNivel() == 5){
                ciudades[i] = "Ciudad:  " + aux_alerta.getCiudad() + " Nivel: " + aux_alerta.getNivel();
                i++;
            }
            alertas.add(aux_alerta);
        }

        return ciudades;
    }

    // MOSTRAR ARREGLO

    public static void mostrarCiudades(String [] ciudades){
        for (String ciudad : ciudades) {
            System.out.println(ciudad);
        }
    }

    public static void main (String[] args){
        Queue <Alerta> alertas = new Queue<Alerta>();
        int op = 0;

        // SE ESTABLECIERON LOS SIGUIENTES DATOS DE ENTRADA

        alertas.add(new Alerta("Jujuy", "Granizo", 3));
        alertas.add(new Alerta("Misiones", "Tormenta", 4));
        alertas.add(new Alerta("Paso de la Patria", "Viento", 5));
        alertas.add(new Alerta("Posta de Yatasto", "Viento", 3));
        alertas.add(new Alerta("Bariloche", "Granizo", 4));
        alertas.add(new Alerta("La Plata", "Tormenta", 2));
        alertas.add(new Alerta("Neuquén", "Viento", 5));

        // MENU
        do{
            System.out.println("*** ALERTAS METEOROLÓGICAS ***");
            System.out.println("1) Cargar alertas");
            System.out.println("2) Mostrar alertas");
            System.out.println("3) Clasificar alertas por tipo");
            System.out.println("4) Promedio de severidad");
            System.out.println("5) Verificar alerta critica Nivel 5");
            System.out.println("6) Ciudades afectadas (Nivel 4 - 5)");
            System.out.println("7) Salir");
            op = Helper.getValidNumber("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR ALERTAS ***");
                    if (alertas.isFull()){
                        System.out.println("No se pueden cargar más alertas (QUEUE LLENA)");
                    }else{
                        alertas = cargarAlertas(alertas);
                        System.out.println("Alerta/s cargada/s...");
                    }
                    break;
                case 2:
                    System.out.println("*** ALERTAS ***");
                    if (!alertas.isEmpty()){
                        mostrarAlertas(alertas);
                    }else{
                        System.out.println("No se cargaron alertas aún...");
                    }
                    break;
                case 3:
                    System.out.println("*** ALERTAS POR TIPO ***");
                    if (!alertas.isEmpty()){
                        String tipo = Helper.getValidType();
                        Queue <Alerta> alertas_tipo = generarCola(alertas,tipo);
                        if (alertas_tipo.isEmpty()){
                            System.out.println("No se encontraron alertas de este tipo...");
                        }else{
                            mostrarAlertas(alertas_tipo);
                        }
                    }else{
                        System.out.println("No se cargaron alertas aún...");
                    }
                    break;
                case 4:
                    System.out.println("*** PROMEDIO DE SEVERIDAD ***");
                    if (!alertas.isEmpty()){
                        System.out.printf("PROMEDIO: %.2f%n" , promedioSeveridad(alertas)); // Se da formato para que muestre 2 decimales
                    }else{
                        System.out.println("No se cargaron alertas aún...");
                    }
                    break;
                case 5:
                    System.out.println("*** PRIMER ALERTA CRITICA ***");
                    if (!alertas.isEmpty()){
                        Alerta alertaCritica = obtenerPrimerAlertaCritica(alertas);
                        if (alertaCritica != null){
                            System.out.println("ALERTA CRITICA -> " + alertaCritica);
                        }else{
                            System.out.println("No se encontraron alertas criticas...");
                        }
                    }else{
                        System.out.println("No se cargaron alertas aún...");
                    }
                    break;
                case 6:
                    System.out.println("*** CIUDADES AFECTADAS ***");
                    if (!alertas.isEmpty()){
                        String [] ciudades = ciudadesAfectadas(alertas);
                        if (ciudades.length == 0){
                            System.out.println("No se encontraron ciudades afectadas...");
                        }else{
                            mostrarCiudades(ciudades);
                        }
                    }else{
                        System.out.println("No se cargaron alertas aún...");
                    }
                    break;
                case 7:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;

                default:
                    System.out.println("Elija una opción correcta!");

            }
        }while(op!=7);

    }
}
