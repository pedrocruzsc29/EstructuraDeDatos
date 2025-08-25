package TP1_P2;

import java.util.Scanner;

public class Helper {

    public static Scanner sc = new Scanner (System.in);
    public static boolean ValidStock(int stock, int cant){
        return stock >= cant;
    }

    public static int GetValidNumber(String message){

        int num = 0;
        boolean band = false;
        do{
            System.out.println(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar este campo!");
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
}

// zerocool