package TP5_P7;

public class TP5_P7 {

    // CARGAR NUMEROS ALEATORIOS

    public static Queue <Integer> cargarNumeros(Queue <Integer> numeros){
        int cant = Helper.getValidIntegers("Ingrese cantidad de n° a generar: ");
        for (int i = 0; i < cant; i++){
            int num = (int) (Math.random() * 11);
            numeros.add(num);
        }
        return numeros;
    }

    // MOSTRAR NÚMEROS

    public static void mostrarNumeros(Queue <Integer> numeros){
        Queue <Integer> num_aux = new Queue<Integer>();
        while(!numeros.isEmpty()){
            int num = numeros.remove();
            System.out.print(num + " ");
            num_aux.add(num);
        }
        System.out.println(" ");

        while(!num_aux.isEmpty()){
            numeros.add(num_aux.remove());
        }
    }

    // ELIMINAR REGISTROS

    public static void eliminarValores(Queue <Integer> numeros){
        Queue <Integer> aux_num = new Queue<Integer>();
        int cont = 0;
        while(!numeros.isEmpty()){
            int num = numeros.remove();
            if (num == 0) {
                while(!aux_num.isEmpty()){
                    aux_num.remove();
                }
            }else{
                aux_num.add(num);
            }
        }

        while(!aux_num.isEmpty()){
            numeros.add(aux_num.remove());
        }
    }

    // PROMEDIO

    public static double promedioSensores(Queue <Integer> numeros){
        Queue <Integer> aux_num = new Queue<Integer>();
        int total = 0;
        while(!numeros.isEmpty()){
            int num = numeros.remove();
            total = total + num;
            aux_num.add(num);
        }
        while(!aux_num.isEmpty()){
            numeros.add(aux_num.remove());
        }
        return (double) total/numeros.size();
    }

    // MAIN CONTROLLER

    public static void main (String [] args){
        Queue <Integer> numeros = new Queue<Integer>();
        int op = 0;
        do{
            System.out.println("*** NÚMEROS GENERADOS ***");
            System.out.println("1) Cargar números");
            System.out.println("2) Mostrar números");
            System.out.println("3) Promedio");
            System.out.println("4) Salir");
            op = Helper.getValidIntegers("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** GENERAR NÚMEROS ***");
                    numeros = cargarNumeros(numeros);
                    System.out.println("Números generados exitosamente...");
                    break;
                case 2:
                    System.out.println("*** NÚMEROS GENERADOS ***");
                    if (numeros.isEmpty()){
                        System.out.println("No se cargaron números aún...");
                    }else{
                        mostrarNumeros(numeros);
                    }
                    break;
                case 3:
                    System.out.println("*** PROMEDIO ***");
                    if (numeros.isEmpty()){
                        System.out.println("No se cargaron números aún...");
                    }else{
                        eliminarValores(numeros);
                        mostrarNumeros(numeros);
                        System.out.println("Promedio: " + (String.format("%.2f",promedioSensores(numeros))));
                    }
                    break;

                case 4:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;
            }
        }while(op != 4);
    }
}

// Autor: zerocool
