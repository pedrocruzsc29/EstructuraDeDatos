package TP4_P4;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner(System.in);

    // OBTENER NUMEROS VALIDOS

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
                }catch(NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return num;
    }

    // OBTENER STRINGS VALIDOS

    public static String getValidString(String message){
        boolean band = false;
        String entrance = "";
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                if (entrance.matches(".*//d.*/")){
                    System.out.println("La entrada contiene numeros");
                }else{
                    band = true;
                }
            }
        }while(!band);
        return entrance;


    }

    // OBTENER UN TIPO VÁLIDO

    public static String getValidType(){
        int op = 0;
        do{
            System.out.println("* TIPO *");
            System.out.println("1) Tormenta");
            System.out.println("2) Viento");
            System.out.println("3) Granizo");
            op = getValidNumber("Elija una opción: ");
            if (!(op>= 1 && op <= 3)){
                System.out.println("Ingrese una opción valida");
            }
        }while(!(op>=1 && op<= 3));
        if (op == 1){
            return "Tormenta";
        } else if (op == 2){
            return "Viento";
        } else{ // Última opción es 3, no es necesario declarar
            return "Granizo";
        }
    }

    // OBTENER UN NIVEL VÁLIDO

    public static int getValidLevel(){
        int nivel = 0;
        do{
            nivel = getValidNumber("Nivel (1-5): ");
            if (!(nivel>=1 && nivel<=5)){
                System.out.println("Ingrese un nivel valido (1-5)!");
            }
        }while(!(nivel>=1 && nivel<=5));
        return nivel;
    }


}
