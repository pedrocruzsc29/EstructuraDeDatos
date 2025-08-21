package TP0_P2;

import java.util.Scanner;
public class TP0_P2 {

    public static Scanner sc = new Scanner(System.in);


    // NUMERO PAR E IMPAR

    public static boolean NumeroPar(int Number){
        return Number % 2 == 0;
    }

    // CONTROLADOR PRINCIPAL

    public static void main (String[] args){
        System.out.println("### LANZAMIENTO DE DADOS ###");
        int total_suma = 0;
        int cont_par = 0;
        int cont_impar = 0;
        int cant = Helper.GetValidNumber("Ingrese una cantidad: ");
        System.out.println("Cantidad: " + cant);
        for (int i = 0; i < cant; i++) {
            System.out.println("Lanzamiento: #" + (i+1));
            int dado1 = 1 + (int) (Math.random() * 6);
            int dado2 = 1 + (int) (Math.random() * 6);
            System.out.println("Dado #1: " + dado1);
            System.out.println("Dado #2: " + dado2);
            int result = dado1 + dado2;
            total_suma += result;
            System.out.println("Resultado: " + result);
            if (NumeroPar(result)){
                System.out.println("-> Es par");
                cont_par += 1;
            }else{
                System.out.println("-> No es par");
                cont_impar += 1;
            }
        }
        double prom = (double ) total_suma / (double) cant;
        System.out.println("Total Lanzamientos: " + total_suma);
        System.out.println("Promedio: " + prom);
        System.out.println("Cantidad Par: " + cont_par + " Cantidad Impar: " + cont_impar);
        System.out.println("### FIN DEL PROGRAMA ###");
        System.out.println("zerocool");
        System.out.println("Zerocool");
    }
}
//zerocool