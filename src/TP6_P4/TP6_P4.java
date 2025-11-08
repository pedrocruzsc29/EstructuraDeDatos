package TP6_P4;

public class TP6_P4 {

    // BUSCAR CÓDIGOS



    /*public static boolean searchCode(int code, BinarySearchTree <Producto> productos){
    }*/

    // CARGAR PRODUCTOS

    public static BinarySearchTree <Producto> cargarProductos(BinarySearchTree <Producto> productos){
        String resp = "";
        do{
            int code = Helper.getValidIntegers("Código: ");
            String nombre = Helper.getValidStrings("Nombre: ");
            int stock = Helper.getValidIntegers("Stock: ");
            double precio = Helper.getValidDouble("Precio: ");
            productos.add(new Producto(code,nombre,stock,precio));
            resp = Helper.getValidStrings("Desea cargar más productos? (S/N): ");

        }while(resp.equalsIgnoreCase("S"));
        return productos;

    }



    public static void main (String [] args){

        BinarySearchTree <Producto> productos = new BinarySearchTree<Producto>();
        productos = cargarProductos(productos);
        System.out.println(productos);

    }
}
