package TP2_P7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner(System.in);

    // GET VALID NUMBER

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

    // GET VALID STRING

    public static String GetValidString (String message){

        System.out.print(message);
        String entrance = sc.nextLine();
        return entrance;

    }

    // GET VALID DATE

    public static LocalDate GetValidDate(String message){
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
}

// zerocool