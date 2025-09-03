package TP1_P2;

import java.util.Scanner;

public class TP1_P2 {

    public static Scanner sc = new Scanner(System.in);
    public static void main (String[] args){
        int op = 0;
        Producto product = new Producto();
        do{

            String name = "";
            double precio = 0.0;
            int stock = 0;
            double total = 0.0;
            int update_stock = 0;
            System.out.println("### FERRETERIA ###");
            System.out.println("1) Cargar producto");
            System.out.println("2) Comprar");
            System.out.println("3) Reponer stock");
            System.out.println("4) Mostrar productos");
            System.out.println("5) Salir");
            op = Helper.GetValidNumber("Ingrese una opción: ");
            switch (op){
                case 1:
                    System.out.println("Ingrese el nombre del producto: ");
                    name = sc.nextLine();
                    product.SetName(name);
                    //System.out.println("Ingrese el nombre del producto: ");
                    //product.SetName(sc.nextLine());
                    precio = (double) Helper.GetValidNumber("Ingrese el precio: ");
                    product.SetPrice(precio);
                    stock = Helper.GetValidNumber("Ingrese el stock: ");
                    product.SetStock(stock);
                    System.out.println(product.toString());
                    break;
                case 2:
                    System.out.println("### COMPRAR ###");
                    int cant = Helper.GetValidNumber("Ingrese la cantidad: ");
                    if(Helper.ValidStock(product.GetStock(), cant)){
                        total = product.Vender(cant);
                        System.out.println("Stock: " + product.GetStock());
                        System.out.println("TOTAL: " + total);
                    }else{
                        System.out.println("Stock: " + product.GetStock());
                        System.out.println("No hay suficiente stock");
                        System.out.println("TOTAL: " + total);
                    }
                    break;

                case 3:
                    System.out.println("### STOCK ###");
                    System.out.println("Stock Actual: " + product.GetStock());
                    update_stock = Helper.GetValidNumber("Stock a agregar: ");
                    product.Update_Stock(update_stock);
                    System.out.println("Stock Actualizado: " + product.GetStock());
                    break;

                case 4:
                    System.out.println(product.toString());
                    break;

                case 5:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;
                default:
                    System.out.println("Elija una opción correcta!");

            }

        }while(op != 5);
    }
}

// zerocool