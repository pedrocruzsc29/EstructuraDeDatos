package TP6_P5;

import TP6_P1.BinaryTree;

public class TP6_P5{

    // CARGAR PEDIDOS

    public static BinarySearchTree cargarPedidos (BinarySearchTree<Pedido> pedidos){
        String resp = "S";
        do{
            int numeroPedido = Helper.getValidIntegers("N° Pedido: ");
            String nombrePedido = Helper.getValidStrings("Nombre del Pedido: ");
            String nombreProducto = Helper.getValidStrings("Nombre del Producto: ");
            int cantidad = Helper.getValidIntegers("Cantidad: ");
            pedidos.add(new Pedido(numeroPedido,nombrePedido,nombreProducto,cantidad));
            resp = Helper.getValidStrings("Desea cargar otro pedido? (S/N): ");

        }while (resp.equalsIgnoreCase("S"));

        return pedidos;
    }

    // MOSTRAR PEDIDOS POST ORDEN -> IZQUIERDA -> DERECHA -> RAÍZ

    public static void mostrarPedidos(BinarySearchTree<Pedido> pedidos){
        pedidos.PostOrder();
    }

    // BUSCAR POR NOMBRE

    public static boolean buscarNombre(BinarySearchTree <Pedido> pedidos, String nombre){


    }


    // MODIFICAR POR NOMBRE DE CLIENTE



    // VALIDAR NO REPETIDOS


    public static void main (String [] args){

        BinarySearchTree <Pedido> pedidos = new BinarySearchTree<Pedido>();

        int op = 0;

        do{
            System.out.println("*** PEDIDOS TRINITY ***");
            System.out.println("1) Cargar pedidos");
            System.out.println("2) Ver pedidos (post order)");
            System.out.println("3) Modificar nombre");
            System.out.println("4) Eliminar pedido");
            System.out.println("5) Salir");

            op = Helper.getValidIntegers("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR PEDIDOS ***");
                    pedidos = cargarPedidos(pedidos);
                    System.out.println("Pedidos cargados exitosamente...");
                    break;
                case 2:
                    System.out.println("*** PEDIDOS REALIZADOS ***");
                    mostrarPedidos(pedidos);
                    break;
                case 3:

                    
                default:
                    System.out.print("xd");

            }




        }while(op != 5);




    }




}
