package TP0_P6;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner(System.in);

    public static String GetValidString(String message){
        boolean band = false;
        String entrance;
        do{
            System.out.println(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else {
                if (entrance.matches(".*\\d.*")) {
                    System.out.println("La entrada contiene numeros!");
                } else {
                    band = true;
                }
            }
        }while(!band);
        return entrance;
    }
}

// zerocool