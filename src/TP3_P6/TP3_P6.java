package TP3_P6;

import TP3_P1.Stack;

public class TP3_P6 {


    // CARGAR DATOS DE UN DESTINATARIO
    public static Entrega cargarDatos() {

        Entrega entrega = new Entrega();
        String destinatario = Helper.GetValidString("Destinatario: ");
        int piso = Helper.GetValidNumber("Piso: ");
        boolean entregado = Helper.GetStatus();
        entrega = new Entrega(destinatario, piso, entregado);

        return entrega;
    }


    // CARGAR ENTREGAS
    public static void cargarEntrega(Stack<Entrega> stack) {
        stack.push(cargarDatos());
    }

    // MOSTRAR ENTREGAS
    public static void mostrarEntregas(Stack<Entrega> stack) {
        Stack<Entrega> aux_stack = new Stack<Entrega>();
        Entrega entrega = new Entrega();
        while (!stack.isEmpty()) {
            entrega = stack.pop();
            System.out.println(entrega);
            aux_stack.push(entrega);
        }

        while (!aux_stack.isEmpty()) {
            stack.push(aux_stack.pop());
        }
    }

    // CAMBIAR ESTADO DE ENTREGAS
    public static void marcarComoEntregado(Stack<Entrega> stack, String destinatario) {
        Stack<Entrega> aux_stack = new Stack<Entrega>();
        boolean encontrado = false;
        while (!stack.isEmpty()) {
            Entrega entrega = stack.pop();
            if (entrega.getDestinatario().equalsIgnoreCase(destinatario)) {
                if (entrega.getFueEntregado()) {
                    System.out.println("Entrega realizada...");
                } else {
                    entrega.setFueEntregado(true);
                    System.out.println("Estado cambiado. Se realizó la entrega...");
                }
                encontrado = true;
            }
            aux_stack.push(entrega);
        }

        while (!aux_stack.isEmpty()) {
            stack.push(aux_stack.pop());
        }
        if (!encontrado) {
            System.out.println("No se encontró destinatario...");
        }
    }

    // BUSCAR PISO EXISTENTE

    public static boolean buscarPiso(Stack <Entrega> stack,int piso){
        Stack <Entrega> aux_stack = new Stack<Entrega>();
        Entrega entrega = new Entrega();
        boolean existe = false;
        while(!stack.isEmpty()){
            entrega = stack.pop();
            if (entrega.getPiso() == piso){
                existe = true;
            }
            aux_stack.push(entrega);
        }

        while(!aux_stack.isEmpty()){
            stack.push(aux_stack.pop());
        }
        return existe;
    }

    // OBTENER ENTREGAS PENDIENTES DE UN PISO

    public static int obtenerPendientesPorPiso(Stack<Entrega> stack, int piso) {
        int cantidad = 0;
        Entrega entrega = new Entrega();
        Stack<Entrega> aux_stack = new Stack<Entrega>();
        while (!stack.isEmpty()) {
            entrega = stack.pop();
            if (entrega.getPiso() == piso && !entrega.getFueEntregado()) {
                cantidad++;
            }
            aux_stack.push(entrega);
        }

        while (!aux_stack.isEmpty()) {
            stack.push(aux_stack.pop());
        }

        return cantidad;
    }

    // ELIMINAR DESTINATARIOS CON ENTREGAS REALIZADAS

    public static void vaciarEntregados(Stack <Entrega> stack){
        Entrega entrega = new Entrega();
        Stack <Entrega> aux_stack = new Stack<Entrega>();
        while(!stack.isEmpty()){
            entrega = stack.pop();
            if (!entrega.getFueEntregado()){
                aux_stack.push(entrega);
            }
        }

        while(!aux_stack.isEmpty()){
            stack.push(aux_stack.pop());
        }
    }

    // CONTROLADOR PRINCIPAL

    public static void main (String[] args){

        Stack <Entrega> entregaStack = new Stack<Entrega>();

        int op = 0;
        do{
            System.out.println("### ENTREGAS ###");
            System.out.println("1) Cargar entrega");
            System.out.println("2) Mostrar entregas");
            System.out.println("3) Marcar como entregado");
            System.out.println("4) Obtener entregas pendientes");
            System.out.println("5) Eliminar entregas realizadas");
            System.out.println("6) Salir");
            op = Helper.GetValidNumber("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("### CARGAR ENTREGA ###");
                    cargarEntrega(entregaStack);
                    break;
                case 2:
                    System.out.println("### DATOS DE ENTREGAS ###");
                    mostrarEntregas(entregaStack);
                    break;
                case 3:
                    System.out.println("### MARCAR COMO ENTREGADO ###");
                    String dest = Helper.GetValidString("Destinatario a buscar: ");
                    marcarComoEntregado(entregaStack,dest);
                    break;
                case 4:
                    System.out.println("### CANTIDAD DE PENDIENTES ###");
                    int piso = Helper.GetValidNumber("Piso: ");
                    if (buscarPiso(entregaStack,piso)){
                        if (obtenerPendientesPorPiso(entregaStack,piso) == 0){
                            System.out.println("No hay entregas pendientes...");
                        }else{
                            System.out.println("Cantidad de Pendientes: " + obtenerPendientesPorPiso(entregaStack,piso));
                        }
                    }else{
                        System.out.println("Piso inexistente...");
                    }
                    break;
                case 5:
                    System.out.println("### ELIMINAR ENTREGADOS ###");
                    mostrarEntregas(entregaStack);
                    vaciarEntregados(entregaStack);
                    System.out.println("### DATOS DE ENTREGA ACTUALIZADOS ###");
                    mostrarEntregas(entregaStack);
                    break;
                case 6:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }

        }while(op!=6);


    }
}
