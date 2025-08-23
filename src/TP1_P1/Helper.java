package TP1_P1;

import java.util.Scanner;
public class Helper {

    public static Scanner sc = new Scanner(System.in);

    public static int GetPositiveNumber (String message){
        int num = 0;
        boolean band = false;

        do{
            System.out.println(message);
            String entrance = sc.nextLine().trim();
            if (entrance.isEmpty()){
                System.out.println("Error: Debe completar el campo!");
            }else{
                try{
                    num = Integer.parseInt(entrance);
                    if (num > 0){
                        band = true;
                    }else{
                        System.out.println("Error: Ingrese un numero positivo!");
                    }
                }catch(NumberFormatException e){
                    System.out.println("Error: Debe ingresar un numero!");
                }
            }
        }while(!band);
        return num;
    }
}
