package TP5_P4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Helper {

    // OBJETO SCANNER

    public static Scanner sc = new Scanner(System.in);

    // OBTENER STRINGS VALIDOS

    public static String getValidStrings(String message){
        String entrance = " ";
        boolean band = false;
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                if (entrance.matches(".*\\d.*")){
                    System.out.println("Error: La entrada contiene numeros!");
                }else{
                    band = true;
                }
            }
        }while(!band);
        return entrance;
    }

    // OBTENER INTEGERS VALIDOS

    public static int getValidIntegers(String message){
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

    // OBTENER FECHAS VALIDAS

    public static LocalDate getValidDate(String message){
        boolean valid = false;
        LocalDate date = null;
        do{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.print(message + "(formato: DD-MM-AAAA): ");
            String fecha = sc.nextLine().trim();

            try{
                date = LocalDate.parse(fecha,formatter);
                valid = true;
            }catch(Exception e){
                System.out.println("Error: Fecha invalida (Error de formato)");
            }
        }while(!valid);
        return date;
    }

    // OBTENER CONFIRMACIÓN VALIDA

    public static boolean getValidConfirmation(){
        int op = 0;
        do{
            System.out.println("Se confirmo la cita con el médico?");
            System.out.print("1) CONFIRMADA 2) NO CONFIRMADA ");
            op = Helper.getValidIntegers("Digite la opción correspondiente: ");
        }while(!(op >= 1 && op <= 2));
        return op == 1;
    }
}

// Autor: zerocool