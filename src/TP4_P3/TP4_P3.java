package TP4_P3;

public class TP4_P3 {

    // CARGAR QUEUE DE PALABRAS

    public static Queue <String> cargarPalabras (Queue <String> colaPalabras){
        String resp = "S";
        do{
            String entrance = Helper.getValidString("Palabra: ");
            colaPalabras.add(entrance);
            resp = Helper.getValidString("Desea cargar más palabras? (S/N): ");
        }while(resp.equalsIgnoreCase("s"));
        return colaPalabras;
    }

    public static void mostrarPalabras(Queue <String> colaPalabras){
        Queue <String> aux_queue = new Queue<String>();
        while (!colaPalabras.isEmpty()){
            String entrance = colaPalabras.remove();
            System.out.println(entrance);
            aux_queue.add(entrance);
        }
        while(!aux_queue.isEmpty()){
            colaPalabras.add(aux_queue.remove());
        }
    }

    // DIVIDIR QUEUE -> PALABRAS CHICAS, MEDIANAS Y LARGAS

    public static void dividirQueue(Queue <String> palabrasCortas, Queue <String> palabrasMedianas, Queue <String> palabrasLargas, Queue <String> colaPalabras){
        Queue <String> aux_queue = new Queue<String>();
        while (!colaPalabras.isEmpty()){
            String entrance = colaPalabras.remove();
            if (!entrance.isEmpty() && entrance.length() <= 3){
                palabrasCortas.add(entrance);
            }else {
                if (entrance.length() >= 4 && entrance.length()<=6){
                    palabrasMedianas.add(entrance);
                }else{
                    if (entrance.length() >= 7){
                        palabrasLargas.add(entrance);
                    }
                }
            }
            aux_queue.add(entrance);
            }
        while (!aux_queue.isEmpty()){
            colaPalabras.add(aux_queue.remove());
        }
    }

    // CANTIDAD DE PALABRAS -> ALTERNATIVA USAR .size();

    public static int cantidadPalabras(Queue <String> colaPalabras){
        Queue <String> aux_queue = new Queue<String>();
        int counter = 0;
        while(!colaPalabras.isEmpty()){
            String entrance = colaPalabras.remove();
            counter++;
            aux_queue.add(entrance);
        }
        while (!aux_queue.isEmpty()){
            colaPalabras.add(aux_queue.remove());
        }
        return counter;
    }

    // VERIFICAR PALABRA MÁS LARGA

    public static String palabraMasLarga(Queue <String> colaPalabras){
        Queue <String> aux_queue = new Queue<String>();
        String palabraMax = "";
        while (!colaPalabras.isEmpty()){
            String entrance = colaPalabras.remove();
            if (palabraMax.length() < entrance.length()){
                palabraMax = entrance;
            }
            aux_queue.add(entrance);
        }
        while (!aux_queue.isEmpty()){
            colaPalabras.add(aux_queue.remove());
        }
        return palabraMax;
    }

    // RECONSTRUIR FRASE

    public static String reconstruirFrase(Queue <String> colaPalabras){
        Queue <String> aux_queue = new Queue <String>();
        String frase = "";
        while(!colaPalabras.isEmpty()){
            String entrance = colaPalabras.remove();
            frase = frase + entrance + " ";
            aux_queue.add(entrance);
        }
        while(!aux_queue.isEmpty()){
            colaPalabras.add(aux_queue.remove());
        }
        return frase.trim(); // trim() va a borrar el último espacio
    }

    public static void main (String[]args){
        Queue <String> colaPalabras = new Queue<String>();
        Queue <String> palabrasCortas = new Queue<String>();
        Queue <String> palabrasMedianas = new Queue<String>();
        Queue <String> palabrasLargas = new Queue<String>();
        int op = 0;
        do{

            System.out.println("*** RADIO EMISORA ***");
            System.out.println("1) Cargar palabras");
            System.out.println("2) Mostrar palabras");
            System.out.println("3) Clasificar palabras");
            System.out.println("4) Cantidad de palabras (3 Queues)");
            System.out.println("5) Palabra más larga (3 Queues)");
            System.out.println("6) Frases reconstruidas (3 Queues)");
            System.out.println("7) Salir");
            op = Helper.getValidNumber("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR PALABRAS ***");
                    if (colaPalabras.isFull()){
                        System.out.println("No se pueden cargar más palabras...");
                    }else{
                        colaPalabras = cargarPalabras(colaPalabras);
                        System.out.println("Carga exitosa...");
                    }
                    break;
                case 2:
                    System.out.println("*** PALABRAS ***");
                    if (colaPalabras.isEmpty()){
                        System.out.println("No se cargaron palabras aún...");
                    }else{
                        mostrarPalabras(colaPalabras);
                    }
                    break;
                case 3:
                    System.out.println("*** CLASIFICACIÓN DE PALABRAS ***");
                    if (colaPalabras.isEmpty()){
                        System.out.println("No se cargaron palabras aún...");
                    }else{
                        dividirQueue(palabrasCortas,palabrasMedianas,palabrasLargas,colaPalabras);
                        System.out.println("Palabras cortas:");
                        mostrarPalabras(palabrasCortas);
                        System.out.println("Palabras medianas:");
                        mostrarPalabras(palabrasMedianas);
                        System.out.println("Palabras largas:");
                        mostrarPalabras(palabrasLargas);
                    }
                    break;
                case 4:
                    System.out.println("*** CANTIDAD DE PALABRAS ***");
                    if (colaPalabras.isEmpty()){
                        System.out.println("No se cargaron palabras aún...");
                    }else{
                        System.out.println("Palabras cortas: " + cantidadPalabras(palabrasCortas));
                        System.out.println("Palabras medianas: " + cantidadPalabras(palabrasMedianas));
                        System.out.println("Palabras largas: " + cantidadPalabras(palabrasLargas));
                    }
                    break;
                case 5:
                    System.out.println("*** PALABRAS MÁS LARGAS ***");
                    if (colaPalabras.isEmpty()){
                        System.out.println("No se cargaron palabras aún...");
                    }else{
                        System.out.println("Palabras cortas: " + palabraMasLarga(palabrasCortas));
                        System.out.println("Palabras medianas: " + palabraMasLarga(palabrasMedianas));
                        System.out.println("Palabras largas: " + palabraMasLarga(palabrasLargas));
                    }
                    break;
                case 6:
                    System.out.println("*** FRASES OBTENIDAS ***");
                    if (colaPalabras.isEmpty()){
                        System.out.println("NO se cargaron palabras aún...");
                    }else{
                        System.out.println("Palabras cortas: " + reconstruirFrase(palabrasCortas));
                        System.out.println("Palabras medianas: " + reconstruirFrase(palabrasMedianas));
                        System.out.println("Palabras largas: " + reconstruirFrase(palabrasLargas));
                    }
                    break;
                case 7:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }

        }while(op != 7);

    }
}

//Autor: zerocool - Pedro Cruz
