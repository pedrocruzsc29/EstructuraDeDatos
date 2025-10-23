package TP2_P3;

public class TP2_P3 {

    // CARGAR PEDIDOS

    public static void LoadDeliveryCode(int [] codes, String [] estados){

        for (int i = 0; i < codes.length; i++){
            System.out.println("### PEDIDO N°" + (i+1));
            codes[i] = Helper.GetValidNumber("Código: ");
            estados[i] = Helper.GetValidStatus();
        }
    }

    // MOSTRAR PEDIDOS

    public static void ShowDeliveries(int [] codes, String [] estados){
        for(int i = 0; i < codes.length; i++){
            System.out.println("PEDIDO N°" + (i+1) + " Código: " + codes[i] + " Estado: " + estados[i]);
        }

    }

    // OBTENER CANTIDAD DE PEDIDOS

    public static int GetAmount(String [] estados, String estado){
        int cant = 0;
        for (int i = 0; i < estados.length; i++){
            if (estado.equals(estados[i])){
                cant = cant + 1;
            }
        }
        return cant;
    }

    // OBTENER ARREGLO CON LOS CÓDIGOS DE UN PEDIDO PARTICULAR

    public static int [] GetCodes(int [] codes, String [] estados, String estado){
        int [] CodeArray = new int[codes.length];
        for (int i = 0; i < codes.length; i++){
            if (estado.equals(estados[i])){
                CodeArray[i] = codes[i];
            }
        }
        return CodeArray;

    }

    //


    // MAIN CONTROLLER

    public static void main (String[] args){
        int [] codigos = null;
        String [] estados = null;
        int cant = 0;
        int op = 0;
        boolean band = false;
        do{
            System.out.println("### DELIVERY ###");
            System.out.println("1) Cargar pedidos");
            System.out.println("2) Listar pedidos");
            System.out.println("3) Cantidad de pedidos"); // Calcular la cantidad del estado de un pedido en particular
            System.out.println("4) Solicitar estados"); // Devolver arreglo con los codigos del estado a solicitar
            System.out.println("5) Listar pendientes");
            System.out.println("6) Salir");
            op = Helper.GetValidNumber("Elija una opción: ");
            switch(op){
                case 1:
                    System.out.println("### CARGAR PEDIDO ###");
                    cant = Helper.GetValidNumber("Cantidad de pedidos: ");
                    codigos = new int[cant];
                    estados = new String[cant];
                    LoadDeliveryCode(codigos,estados);
                    System.out.println("Pedidos cargados...");
                    break;
                case 2:
                    if (codigos != null){ // Si codigos es distinto de null, estados también
                        ShowDeliveries(codigos,estados);
                    }else{
                        System.out.println("No se cargaron pedidos aún...");
                    }
                    break;
                case 3:
                    if (codigos != null){
                        System.out.println("### PEDIDOS ###");
                        System.out.println("Se calcula la cantidad de pedidos en un estado particular");
                        String estado = Helper.GetValidStatus();
                        int cant_estado = GetAmount(estados,estado);
                        System.out.println("Cantidad de Pedidos con estado " + estado + ": " + cant_estado);
                    } else{
                        System.out.println("No se cargaron pedidos aún...");
                    }
                    break;

                case 4:
                    if (codigos != null){
                        System.out.println("### PEDIDOS ###");
                        String estado = Helper.GetValidStatus();
                        int cant_pedidos = GetAmount(estados,estado);
                        if (cant_pedidos > 0){
                            
                        }


                    }else{
                        System.out.println("No se cargaron pedidos aún...");


                    }
                    break;
                case 5:
                    if (codigos != null){
                        System.out.println("### PEDIDOS ###");
                        System.out.println("Otra cosa");
                    }else{
                        System.out.println("No se cargaron pedidos aún...");
                    }
                    break;



                case 6:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;
                default:
                    System.out.println("Ingrese una opción valida!");
            }

        }while(op!=5);

    }
}
