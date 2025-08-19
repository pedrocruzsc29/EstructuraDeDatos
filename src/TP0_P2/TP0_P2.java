package TP0_P2;

import java.util.Scanner;
public class TP0_P2 {

    public static Scanner sc = new Scanner(System.in);

    public static void main (String[] args){
        System.out.println("### LANZAMIENTO DE DADOS ###");
        int cant = Helper.GetValidNumber("Ingrese una cantidad: ");
        System.out.println("Cantidad: " + cant);
        int num1 = 1 + (int) (Math.random() * 6);
        System.out.println("El primer numero generado es: " + num1);

    }
}
