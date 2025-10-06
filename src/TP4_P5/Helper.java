package TP4_P5;

import java.util.Scanner;

public class Helper {

    // OBJETO SCANNER
    public static Scanner sc = new Scanner(System.in);

    // OBTENER STRING VALIDOS

    public static String getValidString(String message){
        String entrance = "";
        boolean band = false;
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                if (entrance.matches(".*//d*./")){
                    System.out.println("Error: La entrada contiene numeros");
                }else{
                    band = true;
                }
            }
        }while(!band);
        return entrance;
    }

    // OBTENER NUMEROS ENTEROS VALIDOS

    public static int getValidNumber(String message){
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
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return num;
    }

    // OBTENER DECIMALES VALIDOS

    public static double getValidDouble(String message){
        double num = 0;
        boolean band = false;
        do{
            System.out.print(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe llenar el campo!");
            }else{
                try{
                    num = Double.parseDouble(entrance);
                    band = true;
                }catch(NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }

        }while(!band);
        return num;
    }

    // OBTENER ACTIVIDAD VALIDA

    public static String getValidActivity(){
        int op = 0;
        do{
            System.out.println("* ACTIVIDAD * ");
            System.out.println("1) Caminar");
            System.out.println("2) Correr");
            System.out.println("3) Bicicleta");
            op = getValidNumber("Elija una opción: ");
            if (!(op >= 1 && op <= 3)) {
                System.out.println("Elija una opción correcta!");
            }
        }while (!(op >= 1 && op <= 3));
        if (op == 1){
            return "Caminar";
        }else if (op == 2){
            return "Correr";
        }else {
            return "Bicicleta";
        }
    }

}
