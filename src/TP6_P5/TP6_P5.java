package TP6_P5;

import TP6_P1.BinaryTree;

public class TP6_P5{

    // CARGAR PEDIDOS

    public static BinarySearchTree cargarPedidos (BinarySearchTree<Pedido> pedidos){
        String resp = "S";
        do{
            int numeroPedido = Helper.getValidIntegers("N° Pedido: ");
            String nombreCliente = Helper.getValidStrings("Nombre del Cliente: ");
            String nombreProducto = Helper.getValidStrings("Nombre del Producto: ");
            int cantidad = Helper.getValidIntegers("Cantidad: ");
            pedidos.add(new Pedido(numeroPedido,nombreCliente,nombreProducto,cantidad));
            resp = Helper.getValidStrings("Desea cargar otro pedido? (S/N): ");

        }while (resp.equalsIgnoreCase("S"));

        return pedidos;
    }

    // MOSTRAR PEDIDOS POST ORDEN -> IZQUIERDA -> DERECHA -> RAÍZ

    public static void mostrarPedidos(BinarySearchTree<Pedido> pedidos){
        pedidos.PostOrder();
    }

    // MODIFICAR POR NOMBRE DE CLIENTE

    public static void modificarNombre(BinarySearchTree <Pedido> pedidos, String nombreCliente){
        Pedido pedido = new Pedido(0,nombreCliente,"",0);
        Pedido encontrado = pedidos.searchElement(pedido);
        if (encontrado != null){
            encontrado.setNombreCliente(Helper.getValidStrings("Ingrese el nuevo nombre:"));
            System.out.println("Se modificó el nombre...");
        }else{
            System.out.println("No se encontró el nombre a modificar...");
        }
    }



    // VALIDAR NO REPETIDOS


    // ELIMINAR

    public static void eliminarPedido(BinarySearchTree <Pedido> pedidos){}


    // MAIN CONTROLLER


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
                    if (pedidos.isEmpty()){
                        System.out.println("No se cargaron pedidos aún...");
                    }else{
                        mostrarPedidos(pedidos);
                    }
                    break;
                case 3:
                    System.out.println("*** MODIFICAR NOMBRE ***");
                    if (pedidos.isEmpty()){
                        System.out.println("No se cargaron pedidos aún...");
                    }else{
                        String nombreCliente = Helper.getValidStrings("Nombre a buscar: ");
                        modificarNombre(pedidos,nombreCliente);
                    }
                    break;
                case 4:
                    System.out.println("*** ELIMINAR PEDIDOS ***");
                default:
                    System.out.print("xd");

            }

        }while(op != 5);

    }
}
