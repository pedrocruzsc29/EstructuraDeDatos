package TP1_P5;
import java.util.Scanner;


public class Helper {

    // OBJETO SCANNER

    public static Scanner sc = new Scanner(System.in);

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

    // OBTENER STRINGS VALIDOS

    public static String getValidStrings(String message){
        String entrance = "";
        boolean band = false;
        do{
            System.out.print(message);
            entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                if (entrance.matches(".*\\d.*")){
                    System.out.println("Error: La entrada contiene números");
                }else{
                    band = true;
                }
            }
        }while(!band);
        return entrance;
    }

    // OBTENER DOUBLES VALIDOS
    public static double getValidDouble(String message){
        double num = 0.0;
        boolean band = false;
        do{
            System.out.print(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                try{
                    num = Double.parseDouble(entrance);
                    band = true;
                } catch (NumberFormatException e){
                    System.out.println("Error: Debe ingresar un número!");
                }
            }
        }while(!band);
        return num;
    }

    // OBTENER TIPO DE COMBUSTIBLE VALIDO

    public static String getCombustible(){
        int op = 0;
        boolean band = false;
        do{
            System.out.println("*** COMBUSTIBLE ***");
            System.out.println("1) Gasolina");
            System.out.println("2) Diesel");
            System.out.println("3) Eléctrico");
            op = getValidIntegers("Elija una opción: ");
            if (op < 1 || op > 3){
                op = getValidIntegers("Opción invalida. Elija una opción: ");
            }else{
                band = true;
            }
        }while(!band);
        if (op == 1){
            return "Gasolina";
        }else if (op == 2) {
            return "Diesel";
        }else{
            return "Eléctrico";
        }
    }

    // OBTENER TIPO DE MANILLAR VALIDO

    public static String getManillar(){
        int op = 0;
        boolean band = false;
        do{
            System.out.println("*** TIPO DE MANILLAR ***");
            System.out.println("1) Deportivo");
            System.out.println("2) Cruiser");
            System.out.println("3) Enduro");
            op = getValidIntegers("Elija una opción: ");
            if (op < 1 || op > 3){
                op = getValidIntegers("Opción invalida. Elija una opción: ");
            }else{
                band = true;
            }
        }while(!band);
        if (op == 1){
            return "Deportivo";
        }else if (op == 2) {
            return "Cruiser";
        }else{
            return "Enduro";
        }
    }

    // OBTENER TIPO DE CARROCERÍA

    public static String getBodyType(){
        int op = 0;
        boolean band = false;
        do{
            System.out.println("*** TIPO DE CARROCERÍA ***");
            System.out.println("1) Volquete");
            System.out.println("2) Caja seca");
            System.out.println("3) Plataforma");
            op = getValidIntegers("Elija una opción: ");
            if (op < 1 || op > 3){
                op = getValidIntegers("Opción invalida. Elija una opción: ");
            }else{
                band = true;
            }
        }while(!band);
        if (op == 1){
            return "Volquete";
        }else if (op == 2) {
            return "Caja seca";
        }else{
            return "Plataforma";
        }
    }
}
