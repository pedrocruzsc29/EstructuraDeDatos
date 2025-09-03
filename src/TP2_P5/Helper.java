package TP2_P5;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner (System.in);

    // OBTENER UN NUMERO VALIDO
    public static int GetValidNumber(String message){

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
                }catch(NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return num;
    }

    // OBTENER UN NOMBRE VALIDO
    public static String GetValidString(String message){
        boolean band = false;
        String entrance;
        do{
            System.out.print(message);
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

    // OBTENER UN PRECIO VALIDO

    public static double GetValidDouble(String message){
        double num = 0.0;
        boolean band = false;
        do{
            System.out.print(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                try{
                    num = Double.parseDouble(entrance);
                    band = true;
                }catch(NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero valido!");
                }
            }
        }while(!band);
        return num;
    }
}

// zerocool
