package TP1_P4;

import java.util.Scanner;

public class Helper {

    // OBJETO SCANNER
    public static Scanner sc = new Scanner(System.in);

    // OBTENER NUMERO ENTERO
    public static int getValidInteger(String message){
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

    // OBTENER NUMERO DECIMAL

    public static double getValidDouble(String message){
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
                }catch (NumberFormatException e){
                    System.out.println("Error: Debe ingresar un número!s");
                }
            }
        }while(!band);
        return num;
    }

    // OBTENER STRING VALIDO

    public static String getValidString(String message){
        String entrance = "";
        boolean band = false;
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                if (entrance.matches(".*//d.*/")){
                    System.out.println("Error: La entrada tiene numeros!");
                }else{
                    band = true;
                }
            }
        }while(!band);
        return entrance;
    }
}
