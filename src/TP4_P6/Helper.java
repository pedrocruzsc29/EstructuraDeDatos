package TP4_P6;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalTime;
import java.util.Scanner;

public class Helper {


    public static Scanner sc = new Scanner (System.in);


    // OBTENER HORA VÁLIDA

    public static LocalTime getValidTime(String message){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = null;
        boolean valido = false;
        do{
            try{
                System.out.print(message);
                String entrance = sc.nextLine();
                hora = LocalTime.parse(entrance, formatter);
                valido = true;

            }catch(DateTimeParseException e){
                System.out.println("Error: Ingrese un formato valido -> (HH:MM)");
            }
        }while(!valido);
        return hora;
    }

    // OBTENER NUMERO VALIDO

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
                }catch(NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return num;
    }

    // OBTENER STRING VALIDOS

    public static String getValidString (String message){
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

    // OBTENER ESTADO VÁLIDO

    public static boolean getValidStatus(){
        boolean status = false;
        boolean band = false;
        do{
            System.out.println("* AUTORIZACIÓN *");
            System.out.println("1) Autorizado");
            System.out.println("2) No autorizado");
            int op = getValidNumber("Elija una opción correcta: ");
            if (!(op >= 1 && op <= 2)){
                System.out.println("Error: Elija una opción valida!");
            }else{
                if (op == 1){
                    status = true;
                }
                band = true;
            }

        }while(!band);
        return status;
    }
}