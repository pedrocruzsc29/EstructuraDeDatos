package TP3_P5;

import java.util.Scanner;

public class TP3_P5 {

    // OBJETO SCANNER

    public static Scanner sc = new Scanner(System.in);

    // CARGAR PILA CON LOS VALORES

    public static Stack <Character> letrasABC(){
        Stack <Character> letras = new Stack<Character>();
        letras.push('a');
        letras.push('a');
        letras.push('a');
        letras.push('b');
        letras.push('b');
        letras.push('c');
        letras.push('a');
        letras.push('z');
        letras.push('z');
        return letras;
    }

    // MOSTRAR ELEMENTOS DE LA PILA -> TIPO CHAR

    public static void showCharacters(Stack<Character>palabras){
        Stack <Character> aux_stack = new Stack<Character>();

        while (!palabras.isEmpty()){
            char character = palabras.pop();
            System.out.println(character);
            aux_stack.push(character);
        }

        while (!aux_stack.isEmpty()){
            palabras.push(aux_stack.pop());
        }
    }

    // GENERAR ETIQUETAS

    public static Stack <String>  generarEtiquetas(Stack <Character> letras){
        Stack <Character> aux_letras = new Stack<Character>(); // Stack auxiliar para poder clasificar el original
        Stack <String> etiquetas = new Stack<String>(); // Stack saliente para almacenar las etiquetas

        char actual = letras.peek(); // Se consulta el elemento que esta en la cima de la pila para hacer las comparaciones
        int counter = 0; // Se inicializa el contador para las letras consecutivas
        while (!letras.isEmpty()){ // Vaciamos la pila original
            char letra = letras.pop(); // Guardamos el elemento de la cima en letra
            if (letra == actual){ // Si dicho elemento es igual al que se consulto 
                counter++; // Se incrementa el contador (se busca empezar con las comparaciones debidas) 
            }else{ // En caso contrario 
                etiquetas.push("" + actual + counter); // Se carga la etiqueta al stack del mismo nombre
                actual = letra; // Se reasigna la variable actual con el valor de letra para las comparaciones
                counter = 1; // El contador se reinicia en 1
            }
        }
        etiquetas.push("" + actual + counter); // Se carga la última etiqueta 

        while (!aux_letras.isEmpty()){ // Nuevamente se vuelven a cargar los valores al stack original
            letras.push(aux_letras.pop());  // Se pasan de la pila auxiliar a la original
        }
        return etiquetas; // Se devuelve el stack con las etiquetas generadas
    }

    // MOSTRAR ELEMENTOS -> TIPO STRING

    public static void showElements(Stack<String>etiquetas){
        Stack <String> aux_stack = new Stack<String>();

        while (!etiquetas.isEmpty()){
            String etiqueta = etiquetas.pop();
            System.out.println(etiqueta);
            aux_stack.push(etiqueta);
        }

        while (!aux_stack.isEmpty()){
            etiquetas.push(aux_stack.pop());
        }
    }

    // BUSCAR ETIQUETAS

    public static Stack<String> buscarEtiqueta(Stack <String> etiquetas, char letra){
        Stack <String> aux_etiquetas = new Stack<String>();
        Stack <String> encontradas = new Stack<String>();

        while (!etiquetas.isEmpty()){
            String etiqueta = etiquetas.pop();
            if (etiqueta.indexOf(letra) != -1){
                encontradas.push(etiqueta);
            }
            aux_etiquetas.push(etiqueta);
        }
        while(!aux_etiquetas.isEmpty()){
            etiquetas.push(aux_etiquetas.pop());
        }
        if (encontradas.isEmpty()){
            encontradas = null;
        }
        return encontradas;
    }

    // EXPANDIR ETIQUETAS

    public static Stack <Character> expandirEtiquetas(Stack<String> etiquetas){
        Stack <String> aux_etiquetas = new Stack<String>();
        Stack <Character> etiquetas_expanded = new Stack<Character>();

        while(!etiquetas.isEmpty()){
            String etiqueta = etiquetas.pop();
            char letter = etiqueta.charAt(0);
            int num = Integer.parseInt(etiqueta.substring(1));
            int counter = 0;
            while (counter < num) {
                etiquetas_expanded.push(letter);
                counter++;
            }
            aux_etiquetas.push(etiqueta);
        }
        while (!aux_etiquetas.isEmpty()){
            etiquetas.push(aux_etiquetas.pop());
        }
        return etiquetas_expanded;
    }


    // MAIN CONTROLLER
    public static void main (String [] args){

        System.out.println("### STACK CARACTERES ###");
        Stack <Character> letras = letrasABC();
        showCharacters(letras);
        System.out.println("### STACK DE ETIQUETAS ###");
        Stack <String> etiquetas = generarEtiquetas(letras);
        showElements(etiquetas);
        System.out.println("### BUSCAR ETIQUETAS ###");
        System.out.print("Ingrese una letra a buscar: ");
        char letter = sc.next().charAt(0);
        Stack <String> encontradas = buscarEtiqueta(etiquetas,letter);
        if (encontradas == null){
            System.out.println("No se encontraron etiquetas... (null)");
        }else{
            System.out.println("Etiquetas encontradas:");
            showElements(encontradas);
        }
        System.out.println("### ETIQUETAS EXPANDIDAS ###");
        Stack <Character> etiquetas_expanded = expandirEtiquetas(etiquetas);
        showCharacters(etiquetas_expanded);


    }
}
