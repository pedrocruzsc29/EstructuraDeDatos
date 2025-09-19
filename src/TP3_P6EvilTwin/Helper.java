package TP3_P6EvilTwin;

import java.util.Scanner;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner(System.in);

    // OBTENER STRINGS VALIDOS (SIN NUMEROS INCLUIDOS)

    public static String GetValidString (String message){
        String entrance;
        boolean band = false;
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                if (entrance.matches(".*\\d.*\"")){
                    System.out.println("La entrada contiene numeros!");
                }else{
                    band = true;
                }
            }
        }while(!band);
        return entrance;
    }

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

    // OBTENER UN BOOLEAN TRUE OR FALSE

    public static boolean GetStatus() {
        boolean band = false;
        int op;
        do {
            op = GetValidNumber("ENTREGADO? -> 1) SI 2) NO: ");
            if (op == 1 || op == 2) {
                band = true;
            }else{
                System.out.println("Elija una opción correcta!");
            }
        } while (!band);
        if (op == 1) {
            return true;
        } else {
            return false;
        }
    }
}
