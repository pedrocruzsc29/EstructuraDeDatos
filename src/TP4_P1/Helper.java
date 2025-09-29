package TP4_P1;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner(System.in);

    // OBTENER NUMEROS VALIDOS

    public static int GetValidNumber (String message){
        int num = 0;
        boolean band = false;
        do {
            System.out.print(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                try{
                    num = Integer.parseInt(entrance);
                    band = true;
                }catch (NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return num;
    }
}

// zerocool
