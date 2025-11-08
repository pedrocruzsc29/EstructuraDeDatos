package TP5_P6;

import java.awt.desktop.ScreenSleepEvent;

public class TP5_P6 {


    // GENERAR NÚMEROS ALEATORIOS - DISCRIMINAR PARES E IMPARES

    public static SimpleLinkedList <Integer> generarNumeros(SimpleLinkedList <Integer> numeros){
        int cant = Helper.getValidIntegers("Ingrese la cantidad de n° a generar: ");
        for (int i = 0; i < cant; i++){
            int num = 1 + (int) (Math.random() * 100);
            if (num % 2 == 0){
                numeros.addFirst(num);
            }else{
                numeros.addLast(num);
            }
        }
        return numeros;
    }

    // MOSTRAR NUMEROS

    public static void mostrarNumeros(SimpleLinkedList <Integer> numeros){
        for (Integer num : numeros){
            System.out.print(num + " ");
        }
        System.out.println(" ");
    }

    // INTERVALO

    public static int sumaIntervalo(SimpleLinkedList <Integer> numeros){
        int inicio;
        int fin;
        do{
            inicio = Helper.getValidIntegers("Inicio: ");
            fin = Helper.getValidIntegers("Fin: ");
            if (inicio < 1 || fin > 100){
                System.out.println("Los valores deben estar entre 1 y 100!");
            }else if (inicio >= fin){
                System.out.println("Fin (" + fin +  ") no puede ser menor a inicio (" + inicio + ")");
            }
        }while((inicio < 1 || fin > 100 || inicio >= fin));

        int sum = 0;
        for (Integer num : numeros){
            if (num >= inicio && num <= fin){
                sum = sum + num;
            }
        }
        return sum;
    }

    // ORDENAR NÚMEROS
    public static SimpleLinkedList <Integer> ordenarNumeros(SimpleLinkedList <Integer> numeros){
        SimpleLinkedList <Integer> ordenados = new SimpleLinkedList<Integer>();
        for (Integer num : numeros){
            ordenados.addInOrder(num);
        }
        return ordenados;
    }

    // MAIN CONTROLLER
    public static void main (String [] args){
        SimpleLinkedList<Integer> numeros = new SimpleLinkedList<Integer>();

        int op = 0;
        do{
            System.out.println("### NÚMEROS ALEATORIOS ###");
            System.out.println("1) Generar números aleatorios");
            System.out.println("2) Mostrar numeros generados");
            System.out.println("3) Suma de intervalo");
            System.out.println("4) Mostrar números ordenados");
            System.out.println("5) Salir");

            op = Helper.getValidIntegers("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** GENERAR NÚMEROS ***");
                    numeros = generarNumeros(numeros);
                    System.out.println("Se cargaron exitosamente...");
                    break;

                case 2:
                    System.out.println("*** NÚMEROS GENERADOS ***");
                    if (numeros.size() > 0){
                        mostrarNumeros(numeros);
                    }else{
                        System.out.println("No se cargaron números aún...");
                    }
                    break;
                case 3:
                    System.out.println("*** INTERVALO ***");
                    if (numeros.size() > 0){
                        int suma = sumaIntervalo(numeros);
                        System.out.println("Suma del Intervalo: " + suma);
                    }else{
                        System.out.println("No se cargaron números aún...");
                    }
                    break;
                case 4:
                    System.out.println("*** NÚMEROS ORDENADOS ***");
                    if (numeros.size() > 0){
                        SimpleLinkedList <Integer> ordenados = ordenarNumeros(numeros);
                        mostrarNumeros(ordenados);
                    }else{
                        System.out.println("No se cargaron números aún...");
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

// Autor: zerocool
