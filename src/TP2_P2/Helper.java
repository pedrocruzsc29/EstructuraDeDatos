package TP2_P2;


import java.util.Scanner;
public class Helper {



    public static Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
            int num;
            while (true) {
                try {
                    System.out.print(mensaje);
                    num = Integer.parseInt(sc.nextLine());
                    if (num > 1) {
                        return num;
                    } else {
                        System.out.println("El número debe ser mayor a 1.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Ingrese un número entero.");
                }
            }
        }
}
