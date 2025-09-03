package TP2_P2;

public class Arreglo {
    // SHOW ARRAY
    public static void mostrarArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // DESPLAZAR (ARREGLOS DE MISMA LONGITUD)
    public static int[] desplazarDerecha(int[] arreglo) {
        int [] nuevo = new int[arreglo.length];
        for (int i = 1; i < arreglo.length; i++) {
            nuevo[i] = arreglo[i-1];
        }
        return nuevo;
    }

    // DESPLAZAR (ARREGLO DESPLAZADO CAMBIA DE TAMAÑO)
    public static int [] desplazar(int[] arreglo){
        int [] nuevo_arreglo = new int [arreglo.length + 1];
        for (int i = 0; i < arreglo.length; i++){
            nuevo_arreglo[i+1] = arreglo[i];
        }
        return nuevo_arreglo;
    }

    // ODD AND EVEN NUMBERS
    public static void contarParesImpares(int[] arreglo) {
        int pares = 0;
        int impares = 0;
        for (int num : arreglo) {
            if (num % 2 == 0) pares++;
            else impares++;
        }
        System.out.println("Cantidad de números pares: " + pares);
        System.out.println("Cantidad de números impares: " + impares);
    }

    // REVERT
    public static int[] invertir(int[] arreglo) {
        int[] invertido = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            invertido[i] = arreglo[arreglo.length - 1 - i]; // DA VUELTA EL ARREGLO
        }
        return invertido;
    }
}
