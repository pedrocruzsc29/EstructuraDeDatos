package TP1_P3;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Helper {

    public static Scanner sc = new Scanner(System.in);

    // GET A VALID DATE

    public static LocalDate GetValidDate(String message){
        boolean valid = false;
        LocalDate date = null;
        do{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.println(message + "(formato: DD-MM-AAAA)");
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

    // GET A VALID OPTION
    public static int GetValidOption(){
        boolean band = false;
        int op = GetValidNumber("Ingrese una opción:");
        do{
            if (op >= 1 && op <=3){
                band = true;
            }else{
                op = GetValidNumber("Opción incorrecta! Ingrese una opción:");
            }
        }while(!band);
        return op;
    }

    // GET A VALID NUMBER
    public static int GetValidNumber(String message){
        boolean band = false;
        int num = 0;
        do{
            System.out.println(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                try{
                    num = Integer.parseInt(entrance);
                    band = true;
                }catch(NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero");
                }
            }
        }while(!band);
        return num;
    }

}
