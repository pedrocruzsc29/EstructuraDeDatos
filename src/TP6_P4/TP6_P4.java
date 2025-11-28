package TP6_P4;

public class TP6_P4 {

    // BUSCAR CÓDIGOS



    public static boolean searchCode(int code, BinarySearchTree <Producto> productos){
        Producto producto = new Producto(code,"",0,0.0);
        if (productos.searchElement(producto) != null){
            return true;
        }else{
            return false;
        }
    }

    // CARGAR PRODUCTOS

    public static BinarySearchTree <Producto> cargarProductos(BinarySearchTree <Producto> productos){
        int cant = Helper.getValidIntegers("Ingrese la cantidad de productos a cargar: ");
        for (int i = 0; i < cant; i++){
            int code = Helper.getValidIntegers("Código: ");
            while (searchCode(code,productos)){
                System.out.println("El código ya existe!");
                code = Helper.getValidIntegers("Código: ");
            }
            String nombre = Helper.getValidStrings("Nombre: ");
            int stock = Helper.getValidIntegers("Stock: ");
            double precio = Helper.getValidDouble("Precio: ");
            productos.add(new Producto(code,nombre,stock,precio));

        }

        return productos;
    }

    // BUSCAR PRODUCTO POR CÓDIGO

    public static Producto buscarProducto(int code, BinarySearchTree <Producto> productos){
        Producto producto = new Producto(code, "", 0, 0.0);
        boolean existe = false;
        if (productos.searchElement(producto) != null){
            producto = productos.searchElement(producto);
            existe = true;
        }
        if (!existe){
            producto = null;
        }
        return producto;
    }



    public static void main (String [] args){

        BinarySearchTree <Producto> productos = new BinarySearchTree<Producto>();
        productos.add(new Producto(25, "teclado", 30, 15000.0));
        productos.add(new Producto(65, "mouse", 45, 8000.0));
        productos.add(new Producto(15, "impresora", 8, 120000.0));
        productos.add(new Producto(55, "notebook", 5, 750000.0));
        productos.add(new Producto(35, "parlantes", 10, 22000.0));
        productos.add(new Producto(75, "router", 20, 18000.0));
        productos.add(new Producto(85, "tablet", 7, 110000.0));
        int op = 0;
        do {
            System.out.println("*** PRODUCTOS ***");
            System.out.println("1) Cargar productos");
            System.out.println("2) Mostrar Preorder - In order");
            System.out.println("3) Buscar producto");
            System.out.println("4) Salir");
            op = Helper.getValidIntegers("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR PRODUCTOS ***");
                    productos = cargarProductos(productos);
                    System.out.println("Productos cargados exitosamente...");
                    break;
                case 2:
                    if (!productos.isEmpty()){
                        System.out.println("*** PRODUCTOS PRE-ORDER ***");
                        productos.PreOrder();
                        System.out.println(" ");
                        System.out.println("*** PRODUCTOS IN-ORDER ***");
                        productos.InOrder();
                        System.out.println(" ");
                    }else{
                        System.out.println("No se cargaron productos aún...");
                    }
                    break;
                case 3:
                    if (!productos.isEmpty()){
                        int code = Helper.getValidIntegers("Código a buscar: ");
                        Producto producto = buscarProducto(code, productos);
                        if (producto != null){
                            System.out.println("* DATOS DEL PRODUCTO *");
                            System.out.println(producto);
                        }else{
                            System.out.println("No se encontró el producto...");
                        }
                    }else{
                        System.out.println("No se cargaron productos aún...");
                    }
                    break;
                case 4:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;
                default:
                    System.out.println("Elija una opción correcta!");
            }
        }while(op != 4);
    }
}
