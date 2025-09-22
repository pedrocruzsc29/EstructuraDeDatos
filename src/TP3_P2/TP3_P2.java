package TP3_P2;

public class TP3_P2 {

    // MOSTRAR ARREGLO
    public static void ShowArray(int [] Array){
        for (int i = 0; i < Array.length; i++){
            System.out.print(Array[i] + " ");
        }
    }

    // DISCRIMINAR NUMEROS NEGATIVOS
    public static Stack <Integer> NegativeStack(int [] Array){
        Stack <Integer> stack = new Stack<Integer>();
        for (int i = 0; i < Array.length; i++){
            if (Array[i] < 0){
                stack.push(Array[i]);
            }
        }
        return stack;
    }

    // MOSTRAR STACK

    public static void ShowStack(Stack <Integer> stack){
        int num = 0;
        Stack <Integer>  aux_stack = new Stack<Integer>();
        while(!stack.isEmpty()){
            num = stack.pop();
            System.out.println(num);
            aux_stack.push(num);
        }
        while (!aux_stack.isEmpty()){
            stack.push(aux_stack.pop());
        }
    }

    // INVIERTE LOS ELEMENTOS NEGATIVOS

    public static void InvertNegativeElements(int [] Array, Stack <Integer> NegaStack){




    }


    public static void main (String[] args){
        System.out.println("*** ARREGLOS ***");
        int [] OriginalArray = {4,-1,7,-3,-5,2,9,15,-8};
        Stack<Integer> NegaStack = new Stack<Integer>();
        ShowArray(OriginalArray);
        System.out.println("Negative Stack");
        NegaStack = NegativeStack(OriginalArray);
        ShowStack(NegaStack);

    }
}
