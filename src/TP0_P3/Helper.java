package TP0_P3;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner(System.in);

    // VALIDAR NUMERO REAL

    public static double GetValidDouble (String message){
        double number = 0;
        boolean band = false;
        do {
            System.out.println(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()) {
                System.out.println("Error: Debe completar el campo!");
            } else {
                try {
                    number = Double.parseDouble(entrance);
                    band = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return number;
    }

    // VALIDAR CARACTER
    public static String GetCharacter (String message){
        boolean band = false;
        String entrance;
        do {
            System.out.println(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                band = true;
            }
        }while(!band);
        return entrance;
    }
}
//zerocool
