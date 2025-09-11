package TP2_P6;

import java.util.Scanner;
public class Helper {


    public static Scanner sc = new Scanner(System.in);

    // OBTENER UNA OPCION

    public static int ChooseData(){
        boolean band = false;
        System.out.println("### DATO A MODIFICAR ###");
        System.out.println("1) Telefono");
        System.out.println("2) Email");
        int op = Helper.GetValidNumber("Elija una opción: ");
        int output = 0;
        switch(op){
            case 1:
                output = 1;
                break;
            case 2:
                output = 2;
                break;
            default:
                System.out.println("Ingrese una opción correcta");

        }
        return output;
    }

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


    // OBTENER UN NUMERO DE TELEFONO VALIDO

    public static int GetValidPhoneNumber (String message){
        String entrance;
        int num = 0;
        boolean band = false;

        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else {
                if (entrance.length() != 9){
                    System.out.println("Error: Debe tener 9 digitos!");
                } else{
                    try {
                        num = Integer.parseInt(entrance);
                        band = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Debe ingresar un numero!");
                    }
                }

            }
        }while(!band);
        return num;
    }


    // OBTENER STRINGS VALIDOS
    public static String GetValidString(String message) {
        String entrance;
        boolean band = false;
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if(entrance.isEmpty()){
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


}
