package TP4_P3;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner (System.in);

    // OBTENER STRINGS VALIDOS

    public static String getValidString(String message){

        boolean band = false;
        String entrance = "";
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe ingresar un numero!");
            }else{
                if (entrance.matches(".*//d.*/")){
                    System.out.println("La entrada contiene numeros!");
                }else{
                    band = true;
                }
            }
            return entrance;
        }while(!band);
    }

    // OBTENER UN NUMERO VALIDO

    public static int getValidNumber(String message){
        boolean band = false;
        int num = 0;
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
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return num;
    }


}
