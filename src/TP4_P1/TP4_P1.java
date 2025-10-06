package TP4_P1;

public class TP4_P1 {

    // CARGAR ELEMENTOS

    public static Queue<Integer> cargarEnteros() {
        Queue <Integer> colaEnteros = new Queue<Integer>();
        int N = Helper.GetValidNumber("Ingrese la cantidad de elementos: ");
        for (int i = 0; i < N; i++){
            int num = 1 + (int) (Math.random() * 100);
            colaEnteros.add(num);
        }
        return colaEnteros;
    }

    // MOSTRAR ELEMENTOS

    public static void showElements(Queue <Integer> colaEnteros){
        Queue <Integer> aux_queue = new Queue<Integer>();
        while(!colaEnteros.isEmpty()){
            int num = colaEnteros.remove();
            System.out.println("Elemento: " + num);
            aux_queue.add(num);
        }

        while (!aux_queue.isEmpty()){
            colaEnteros.add(aux_queue.remove());
        }
    }

    // VALOR MAXIMO

    public static Queue<Integer> separarElementos(Queue <Integer> colaEnteros, int max){
        Queue <Integer> aux_queue = new Queue<Integer>();
        Queue <Integer> elementosMax = new Queue<Integer>();

        while (!colaEnteros.isEmpty()){
            int num = colaEnteros.remove();
            if (num > max){
                elementosMax.add(num);
            }else{
                aux_queue.add(num);
            }
        }
        while(!aux_queue.isEmpty()){
            colaEnteros.add(aux_queue.remove());
        }
        return elementosMax;
    }

    // REUBICAR ELEMENTOS

    public static void reubicarElementos(Queue <Integer> colaEnteros, Queue<Integer>elementosMax){
        Queue <Integer> aux_queue = new Queue<Integer>();
        while (!elementosMax.isEmpty()){
            int num = elementosMax.remove();
            colaEnteros.add(num);
        }
        while(!aux_queue.isEmpty()){
            elementosMax.add(aux_queue.remove());
        }
    }

    // CONTADOR DE ELEMENTOS QUE NO SUPERAN EL MAXIMO

    public static int elementosMin(Queue <Integer> colaEnteros, int max){
        Queue <Integer> aux_queue = new Queue<Integer>();
        int counter = 0;

        while (!colaEnteros.isEmpty()){
            int num = colaEnteros.remove();
            if (num < max){
                counter++;
            }else{
                aux_queue.add(num);
            }

        }
        while(!aux_queue.isEmpty()){
            colaEnteros.add(aux_queue.remove());
        }
        return counter;
    }

    // MAIN CONTROLLER

    public static void main (String[] args) {
        System.out.println("* CARGAR ELEMENTOS *");
        Queue<Integer> colaEnteros = cargarEnteros();
        System.out.println("* ELEMENTOS CARGADOS *");
        showElements(colaEnteros);
        System.out.println("* SEPARAR ELEMENTOS QUE SUPEREN EL VALOR MAXIMO *");
        int max = Helper.GetValidNumber("Ingrese el valor maximo: ");
        Queue<Integer> elementosMax = separarElementos(colaEnteros, max);
        System.out.println("* ELEMENTOS MAXIMOS *");
        showElements(elementosMax);
        System.out.println("* ELEMENTOS SEPARADOS (COLA ORIGINAL) *");
        showElements(colaEnteros);
        System.out.println("* ELEMENTOS AGREGADOS (COLA ORIGINAL) *");
        reubicarElementos(colaEnteros, elementosMax);
        showElements(colaEnteros);
        System.out.println("* CONTAR ELEMENTOS QUE NO SUPERAN EL VALOR MAXIMO (VALORES MENORES) *");
        System.out.println(elementosMin(colaEnteros, max));


    }


}

// zerocool
