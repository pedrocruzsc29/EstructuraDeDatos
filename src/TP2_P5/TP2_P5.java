package TP2_P5;

public class TP2_P5 {

    // CARGAR ARREGLO
    public static Componente [] LoadArray(int ammount){
        Componente [] arreglo = new Componente[ammount];
        for (int i = 0; i<arreglo.length; i++){
            System.out.println("Cargar elemento N°" + (i+1));
            int codigo = Helper.GetValidNumber("Ingrese un codigo: ");
            String name = Helper.GetValidString("Ingrese el nombre: ");
            double precio = Helper.GetValidDouble("Ingrese el precio: ");
            int stock = Helper.GetValidNumber("Ingrese el stock: ");
            arreglo[i] = new Componente(codigo,name,precio,stock);
        }
        return arreglo;
    }

    // MOSTRAR ARREGLO

    public static void ShowArray(Componente[] arreglo){
        for (int i = 0; i<arreglo.length; i++){
            System.out.println("Elemento [" + (i+1) + "]: Codigo: " + arreglo[i].GetCodigo()
            + " Nombre: " + arreglo[i].GetNombre() + " Precio: " + arreglo[i].GetPrecioUnitario()
            + " Stock: " + arreglo[i].GetCantidadStock());
        }
    }

    // BUSCAR ELEMENTO

    public static int SearchElement (Componente[]arreglo){
        int pos = -1;
        int num = Helper.GetValidNumber("Ingrese el codigo a buscar: ");
        for (int i = 0; i< arreglo.length; i++){
            if (arreglo[i].GetCodigo() == num){
                pos = i;
            }
        }
        return pos;
    }

    // CALCULAR STOCK TOTAL

    public static int TotalStock(Componente[]arreglo){
        int sum = 0;
        for (Componente objeto : arreglo) { // For each / For mejorado
            sum = sum + objeto.GetCantidadStock();
        }
        return sum;
    }

    // CALCULAR TOTAL VENTAS

    public static double TotalSales(Componente[]arreglo){
        double total = 0.0;
        for (Componente objeto : arreglo){
            total = total + objeto.GetPrecioUnitario();
        }
        return total;
    }

    // COMPONENTE DE STOCK MINIMO

    public static int MinimumComponent(Componente [] arreglo){
        boolean band = true;
        int min = 0;
        int pos = 0;
        for (int i = 0; i<arreglo.length;i++){
            if (band){
                min = arreglo[i].GetCantidadStock();
                band = false;
            }else{
                if (min > arreglo[i].GetCantidadStock()){
                    min = arreglo[i].GetCantidadStock();
                    pos = i;
                }
            }
        }
        return pos;
    }

    // MOSTRAR STOCKS MENORES EN BASE A UN VALOR

    public static void ShowStockElements(Componente[]arreglo){
        int stocks = Helper.GetValidNumber("Ingrese un valor stock: ");
        for (Componente objeto : arreglo){
            if (objeto.GetCantidadStock() < stocks){
                System.out.println(objeto);
            }
        }
    }


    public static void main (String[] args){
        int op = 0;
        Componente [] ArrayComponent = null;
        boolean loaded = false;
        do{
            System.out.println("### FERRETERIA ###");
            System.out.println("1) Cargar componentes");
            System.out.println("2) Mostrar componentes");
            System.out.println("3) Actualizar stock por codigo");
            System.out.println("4) Total Stock");
            System.out.println("5) Total Ventas");
            System.out.println("6) Stocks minimos");
            System.out.println("7) Listar stocks");
            System.out.println("8) Salir");
            op = Helper.GetValidNumber("Elija una opción: ");

            switch (op){
                case 1:
                    System.out.println("### CARGAR COMPONENTES ###");
                    int cant = Helper.GetValidNumber("Ingrese la cantidad de componentes: ");
                    ArrayComponent = LoadArray(cant);
                    loaded = true;
                    System.out.println("Componentes cargados...");
                    break;
                case 2:
                    if (!loaded){
                        System.out.println("No se cargaron componentes...");
                    }else{
                        ShowArray(ArrayComponent);
                    }
                    break;
                case 3:
                    if (!loaded){
                        System.out.println("No se cargaron componentes...");
                    }else{
                        System.out.println("### UPDATE STOCK ###");
                        int pos = SearchElement(ArrayComponent);
                        if (pos != -1){
                            ArrayComponent[pos].Update_Stock();
                            ShowArray(ArrayComponent);
                        }else{
                            System.out.println("El codigo no se encontro!");
                        }
                    }
                    break;
                case 4:
                    if (!loaded){
                        System.out.println("No se cargaron componentes...");
                    }else{
                        System.out.println("### TOTAL STOCK ###");
                        ShowArray(ArrayComponent);
                        System.out.println("TOTAL: " + TotalStock(ArrayComponent));
                    }
                    break;
                case 5:
                    if (!loaded){
                        System.out.println("No se cargaron componentes...");
                    }else{
                        System.out.println("### TOTAL VENTAS ###");
                        ShowArray(ArrayComponent);
                        System.out.println("TOTAL: " + TotalSales(ArrayComponent));
                    }
                    break;
                case 6:
                    if (!loaded){
                        System.out.println("No se cargaron componentes...");
                    }else{
                        System.out.println("### COMPONENTE MINIMO ###");
                        int pos_min = MinimumComponent(ArrayComponent);
                        System.out.println("Elemento N°" + (pos_min+1));
                        System.out.println(ArrayComponent[pos_min]);
                    }
                    break;
                case 7:
                    if (!loaded){
                        System.out.println("No se cargaron componentes...");
                    }else{
                        System.out.println("### STOCKS MINIMOS ###");
                        ShowStockElements(ArrayComponent);
                    }
                    break;
                case 8:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;
                default:
                    System.out.println("Ingrese una opción correcta!");
            }

        }while(op!=8);
    }
}


// zerocool