package TP0_P4;

import java.util.Scanner;

public class Helper {

    // NUMERO DISTINTO DE CERO

    public static boolean Cero(int Number){
        return Number == 0;
    }

    // NUMERO VALIDO

    public static Scanner sc = new Scanner(System.in);
    public static int GetValidNumber (String message){
        boolean band = false;
        int number = 0;

        do {
            System.out.println(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                try{
                    number = Integer.parseInt(entrance);
                    band = true;
                } catch (NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return number;
    }
}

// zerocool