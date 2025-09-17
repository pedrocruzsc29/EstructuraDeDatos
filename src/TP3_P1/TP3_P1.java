package TP3_P1;
import java.util.Random;
public class TP3_P1 {


    private static final int Size = 20; // CONSTANTE DE ELEMENTOS QUE VA A POSEER



    // MUESTRA LOS NUMEROS ALMACENADOS EN EL STACK
    public static void ShowStack(Stack <Integer> stack){
        Stack <Integer> Aux_Stack = new Stack<Integer>(stack.size());
        while(!stack.isEmpty()){
            int num = stack.pop();
            System.out.print(num + " ");
            Aux_Stack.push(num);
        }

        while(!Aux_Stack.isEmpty()){
            stack.push(Aux_Stack.pop());
        }
    }

    // GENERADOR DE ELEMENTOS

    public static void Generator(Stack<Integer> stack){
        Random random = new Random();
        for (int i = 0; i < Size; i++) {
            stack.push(random.nextInt(100) + 1);
        }
    }

    // CLASIFICACIÓN PARES E IMPARES -> PENDIENTE DE EVITAR MODIFICACIONES EN LA PILA ORIGINAL

    public static void Classifier(Stack <Integer> Original, Stack <Integer> Pares, Stack <Integer> Impares){
        Stack <Integer> aux_stack = new Stack<Integer>();
        while (!Original.isEmpty()){
            int num = Original.pop();
            if (num % 2 == 0){
                Pares.push(num);
            }else{
                Impares.push(num);
            }
        }
    }

    // CALCULAR PROMEDIO

    public static double AmountStack(Stack<Integer> stack){
        int acumulador = 0;
        Stack<Integer>aux_stack = new Stack<Integer>();
        while(!stack.isEmpty()){
            int num = stack.pop();
            acumulador = acumulador + num;
            aux_stack.push(num);
        }
        while (!aux_stack.isEmpty()){
            aux_stack.push(stack.pop());
        }

        return acumulador;
    }


    // MAIN CONTROLLER

    public static void main (String[] args){

        Stack <Integer> FirstStack = new Stack<Integer>();
        Stack <Integer> StackPares = new Stack<Integer>();
        Stack <Integer> StackImpares = new Stack<Integer>();
        System.out.println("### GENERADOR DE STACKS ###");
        Generator(FirstStack);
        System.out.println("### STACK CARGADO ###");
        ShowStack(FirstStack);
        Classifier(FirstStack,StackPares,StackImpares);
        System.out.println();
        System.out.println("### STACK PARES ###");
        ShowStack(StackPares);
        System.out.println();
        System.out.println("### STACK IMPARES ###");
        ShowStack(StackImpares);
        System.out.println();
        System.out.println("### PROMEDIOS Y SUMAS ###");
        System.out.println("# STACK PARES # -> SUMA: " + AmountStack(StackPares) + " PROMEDIO: " + (double) AmountStack(StackPares) / StackPares.size());
    }







}


