package TP2_P8;

import java.util.Scanner;
public class Helper {

    // OBTENER NUMERO VALIDO

    public static Scanner sc = new Scanner (System.in);
    public static int GetValidNumber(String message){
        int num = 0;
        boolean band = false;
        do{
            System.out.print(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: debe completar el campo!");
            }else{
                try{
                    num = Integer.parseInt(entrance);
                    band = true;

                }catch(NumberFormatException e){
                    System.out.println("Error: debe ingresar un numero!");
                }
            }

        }while(!band);
        return num;
    }

    // OBTENER DECIMAL

    public static double GetValidDouble(String message){
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

    // OBTENER COLUMNA VALIDA A PARTIR DE UNA MATRIZ
    public static int GetValidSubjectIndex(double [][] notes){
        int num = 0;
        int columnas = notes[0].length;
        boolean band = false;
        do{
            num = GetValidNumber("Ingrese el N° de la materia (1 - " + columnas +"): ");
            if ((num > 1) && (num <= columnas)){
                band = true;
            }else{
                System.out.println("Materia fuera de rango!");
            }
        }while(!band);
        return num - 1;
    }
}

// zerocool
