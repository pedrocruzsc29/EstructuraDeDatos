package TP5_P8;

public class TP5_P8 {

    // GENERAR NÚMEROS ALEATORIOS

    public static Stack<Integer> generarNumeros(Stack<Integer> numeros) {
        int cant = Helper.getValidIntegers("Ingrese la cantidad de números a generar: ");
        for (int i = 0; i < cant; i++) {
            int num = 1 + (int) (Math.random() * 100);
            numeros.push(num);
        }
        return numeros;
    }

    // MOSTRAR NÚMEROS

    public static void mostrarNumeros (Stack <Integer> numeros){
        Stack <Integer> aux_num = new Stack<Integer>();
        while(!numeros.isEmpty()){
            int num = numeros.pop();
            System.out.print(num + " ");
            aux_num.push(num);
        }
        System.out.println(" ");
        while (!aux_num.isEmpty()){
            numeros.push(aux_num.pop());
        }
    }

    // DUPLICAR NÚMEROS PARES

    public static void duplicarPares(Stack<Integer> numeros){
        Stack <Integer> aux_num = new Stack<Integer>();
        while(!numeros.isEmpty()){
            int num = numeros.pop();
            if (num % 2 == 0){
                aux_num.push(num);
                aux_num.push(num);
            }else{
                aux_num.push(num);
            }
        }
        while (!aux_num.isEmpty()){
            numeros.push(aux_num.pop());
        }
    }

    // MAIN CONTROLLER
    public static void main(String [] args){
        Stack <Integer> numeros = new Stack<Integer>();
        int op = 0;
        do{
            System.out.println("*** GENERAR NÚMEROS ***");
            System.out.println("1) Cargar números");
            System.out.println("2) Mostrar números");
            System.out.println("3) Duplicar numeros pares");
            System.out.println("4) Salir");
            op = Helper.getValidIntegers("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR NÚMEROS ***");
                    numeros = generarNumeros(numeros);
                    System.out.println("Números cargados exitosamente...");
                    break;
                case 2:
                    System.out.println("*** NÚMEROS GENERADOS ***");
                    if (numeros.isEmpty()){
                        System.out.println("No se cargaron números aún...");
                    }else{
                        mostrarNumeros(numeros);
                    }
                    break;
                case 3:
                    System.out.println("*** DUPLICAR NÚMEROS ***");
                    if (numeros.isEmpty()){
                        System.out.println("No se cargaron números aún...");
                    }else{
                        duplicarPares(numeros);
                        mostrarNumeros(numeros);
                    }
                    break;
                case 4:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;
                default:
                    System.out.println("Elija una opción correcta!");
            }
        }while(op!=4);
    }
}
