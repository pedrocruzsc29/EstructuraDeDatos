package TP2_P3;


import java.util.Scanner;
public class Helper {

    //OBTENER UN NUMERO VALIDO

    public static Scanner sc = new Scanner (System.in);
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
                } catch (NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return num;
    }

    public static String GetValidStatus(){
        int op = 0;
        boolean band = false;
        String status = "";

        do{
            System.out.println("### ESTADOS ###");
            System.out.println("1) Pendiente");
            System.out.println("2) Procesando");
            System.out.println("3) Enviado");
            System.out.println("4) Entregado");
            op = GetValidNumber("Elija una opción: ");
            switch (op){
                case 1:
                    status = "Pendiente";
                    band = true;
                    break;
                case 2:
                    status = "Procesando";
                    band = true;
                    break;
                case 3:
                    status = "Enviado";
                    band = true;
                    break;
                case 4:
                    status = "Entregado";
                    band = true;
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }

        }while(!band);
        return status;

    }

    public static String GetValidString (String message){
        String entrance;
        boolean band = false;
        do{
            System.out.println(message);
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
}
