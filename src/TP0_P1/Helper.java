package TP0_P1;

import java.util.Scanner;
public class Helper {

    public static Scanner scanner = new Scanner(System.in);

    public static int ValidOption(String message) {
        int num = 0;
        boolean band = false;
        do {
            System.out.println(message);
            String entrance = scanner.nextLine().trim();
            if (entrance.isEmpty()) {
                System.out.println("Error: Debe completar el campo!");
            }else{
                try {
                    num = Integer.parseInt(entrance);
                    if (num >= 1 && num <= 2){
                        band = true;
                    }else{
                        System.out.println("Opción no valida!");
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un numero entero");
                }

            }

        }while(!band);
        return num;
    }

    public static double ValidNumber(String message) {
        double num = 0;
        boolean band = false;
        do {
            System.out.println(message);
            String entrance = scanner.nextLine().trim();
            if (entrance.isEmpty()) {
                System.out.println("Error: Debe completar el campo!");
            } else {
                try {
                    num = Double.parseDouble(entrance);
                    band = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un numero real!");
                }
            }
        } while (!band);
        return num;
    }
}