package TP2_P2;

import java.util.Random;
public class Main {
        public static void main(String[] args) {
            int N = Helper.leerEntero("Ingrese un valor entero N (mayor a 1): ");

            int[] arreglo = new int[N];
            int[] arreglo2 = new int[N];
            Random random = new Random();
            // RANDOM NUMBERS FROM 1 TO 100
            for (int i = 0; i < arreglo.length - 1; i++) { // Aqui estan los cambios
                arreglo[i] = random.nextInt(100) + 1;
            }

            System.out.println("Arreglo inicial:");
            Arreglo.mostrarArreglo(arreglo);

            // DESPLAZAR
            int[] desplazado = Arreglo.desplazarDerecha(arreglo);
            System.out.println("Arreglo desplazado a la derecha:");
            Arreglo.mostrarArreglo(desplazado);
            int [] desplazo = Arreglo.desplazar(arreglo);
            System.out.println("Arreglo desplazado a la derecha:");
            Arreglo.mostrarArreglo(desplazo);

            //CONTAR PARES E IMPARES
            Arreglo.contarParesImpares(arreglo);

            // REVERT
            int[] invertido = Arreglo.invertir(arreglo);
            System.out.println("Arreglo invertido:");
            Arreglo.mostrarArreglo(invertido);
        }
}

// Grupo 2
