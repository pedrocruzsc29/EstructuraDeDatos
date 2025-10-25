package TP6_P1;

import java.util.Scanner;

public class Helper {

    // OBJETO SCANNER

    public static Scanner sc = new Scanner (System.in);

    // OBTENER INTEGERS VALIDOS

    public static int getValidIntegers(String message){
        int num = 0;
        boolean band = false;
        do{
            System.out.print(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                try{
                    num = Integer.parseInt(entrance);
                    band = true;
                }catch (NumberFormatException e){
                    System.out.println("Error: Debe ingresar un número!");
                }
            }
        }while(!band);
        return num;
    }

    // OBTENER STRINGS VALIDOS
    public static String getValidStrings(String message) {
        String entrance = "";
        boolean band = false;
        do {
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()) {
                System.out.println("Error: Debe completar el campo!");
            } else {
                if (entrance.matches(".*\\d.*")) {
                    System.out.println("Error: La entrada contiene números!");
                } else {
                    band = true;
                }
            }

        } while (!band);
        return entrance;

    }
}
