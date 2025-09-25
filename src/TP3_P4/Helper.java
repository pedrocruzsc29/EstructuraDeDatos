package TP3_P4;

import java.util.Scanner;

public class Helper {


    public static Scanner sc = new Scanner(System.in);

    // OBTENER ESTADO

    public static String GetType(){
        int op = 0;
        boolean band = false;
        String tipo = "";
        do{
            System.out.println("# TIPO #");
            System.out.println("1) info");
            System.out.println("2) advertencia");
            System.out.println("3) error");
            op = GetValidNumber("Elija una opción: ");
            if (op >= 1 && op <=3){
                band = true;
            }else{
                System.out.println("Elija una opción correcta");
            }
        }while(!band);
        if (op == 1){
            tipo = "info";
        } else if (op == 2) {
            tipo = "advertencia";
        } else {
            tipo = "error";
        }
        return tipo;
    }

    // OBTENER NUMEROS VALIDOS

    public static int GetValidNumber(String message){
        int num = 0;
        boolean band = false;
        do{
            System.out.print(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo");
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

    // OBTENER STRING VALIDO

    public static String GetValidString (String message){
        String entrance = "";
        boolean band = false;
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                if (entrance.matches(".*\\d.*\"")){
                    System.out.println("Error: La entrada tiene numeros!");
                }else{
                    band = true;
                }
            }
        }while(!band);
        return entrance;
    }

}

// zerocool
