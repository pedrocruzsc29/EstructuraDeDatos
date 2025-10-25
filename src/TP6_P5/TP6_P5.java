package TP6_P5;

public class TP6_P5{

    // CARGAR PEDIDOS

    public static BinarySearchTree <Pedido> cargarPedidos (BinarySearchTree <Pedido> pedidos){
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




}
