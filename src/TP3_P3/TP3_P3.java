package TP3_P3;


public class TP3_P3 {


    // GENERAR STACK DE ENTEROS ALEATORIOS

    public static Stack <Integer> LoadStack (){
        Stack <Integer> stack = new Stack<Integer>();
        int n = Helper.GetValidNumber("Ingrese N: ");
        int num = 0;
        for (int i = 0; i < n; i++){
            num = 1 + (int) (Math.random() * 100);
            stack.push(num);
        }
        return stack;
    }

    // MOSTRAR STACK

    public static void ShowStack(Stack <Integer> stack){
        Stack <Integer> aux_stack = new Stack <Integer>();
        int num = 0;
        while(!stack.isEmpty()){
            num = stack.pop();
            System.out.println("Elemento: " + num);
            aux_stack.push(num);
        }

        while (!aux_stack.isEmpty()){
            stack.push(aux_stack.pop());
        }
    }

    // ELIMINAR MAYORES Y MENORES

    public static void DeleteHighLow(Stack <Integer> stack, int menor, int mayor){
        Stack <Integer> aux_stack = new Stack<Integer>();
        int num = 0;
        while (!stack.isEmpty()){
            num = stack.pop();
            if ((num > menor) && (num < mayor)){
                aux_stack.push(num);
            }
        }

        while (!aux_stack.isEmpty()){
            stack.push(aux_stack.pop());
        }
    }

    // DUPLICAR PARES (SIGUIENTE)

    public static void DuplicateEvenNumbers(Stack <Integer> stack){
        Stack <Integer> aux_stack = new Stack<Integer>();
        int num = 0;
        while(!stack.isEmpty()){
            num = stack.pop();
            if (num % 2 == 0){
                aux_stack.push(num);
            }
            aux_stack.push(num);
        }

        while(!aux_stack.isEmpty()){
            stack.push(aux_stack.pop());
        }
    }

    // INTERCAMBIAR PRIMER ELEMENTO CON ULTIMO

    public static void SwapElements(Stack<Integer>stack){
        int cima = stack.pop(); // Se separa el elemento que esta en la cima
        int base = 0; // Se inicializa la variable base para almacenar este valor
        Stack <Integer> aux_stack = new Stack<Integer>(); // Nuevo stack auxiliar para mover los elementos
        while (!stack.isEmpty()){ // Bucle while
            if (stack.count() == 1){ // Si la cantidad de elementos es 1, entonces tenemos la base
                base = stack.pop(); // Guardamos la base en una variable
                aux_stack.push(base); // E igualmente cargamos el valor en el stack auxiliar
            }else{
                aux_stack.push(stack.pop()); // En caso contrario continuaremos cargando el valor al stack auxiliar "desapilando"
            }
        }
        while(!aux_stack.isEmpty()){ // Bucle while para volver a cargar el stack original
            int num = aux_stack.pop(); // Se usa para verificar si cargamos el número u otro valor
            if (!aux_stack.isEmpty() && num == base){ // Verificamos que la pila no este vaciá y que numero sea igual a base
                stack.push(cima); // Para poder reemplazar el valor base por el de la cima
            }else{
                stack.push(num); // en caso contrario, se siguen cargando los valores a la pila original
            }
        }
        stack.push(base); // Se carga el valor base en la cima, es decir se reemplaza como último paso, recordemos que la primera vez, la pila quedo sin este elemento
    }

    // MITAD MAYOR

    public static void Halves(Stack <Integer> stack){
        int first_half = 0;
        int second_half = 0;
        int suma_primer_mitad = 0;
        int suma_segunda_mitad = 0;
        Stack <Integer> aux_stack = new Stack<Integer>();

        System.out.println(stack.count());
        first_half = stack.count() / 2;
        second_half = stack.count();

        while(!stack.isEmpty()){

        }

        System.out.println("Primer mitad: " + first_half);

        System.out.println("Segunda mitad: " + second_half);

    }

    public static void main (String [] args){
        Stack <Integer> stack = new Stack<Integer>();
        stack = LoadStack();
        ShowStack(stack);
        //int menor = Helper.GetValidNumber("Ingrese un Nª menor: ");
        //int mayor = Helper.GetValidNumber("Ingrese un Nª mayor: ");
        //DeleteHighLow(stack, menor, mayor);
        System.out.println("Elementos eliminados...");
        ShowStack(stack);
        //System.out.println("* Pares duplicados *");
        //DuplicateEvenNumbers(stack);
        //ShowStack(stack);
        System.out.println("* Intercambio de Elementos *");
        SwapElements(stack);
        ShowStack(stack);
        System.out.println("* Sumas de Mitades *");
        Halves(stack);




    }
}
