package Exams;

public class Parcial {

    public static int [] ordenarArreglo(int [] numeros){

        // SE INICIALIZAN LAS VARIABLES

        int counterPos = 0;
        int counterNeg = 0;
        int counterZero = 0;

        // SE CLASIFICAN LOS NUMEROS

        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] < 0){
                counterNeg++;
            }else if (numeros[i] == 0){
                counterZero++;
            }else{
                counterPos++;
            }
        }

        // SE CARGAN LAS LONGITUDES A LOS NUEVOS ARREGLOS

        int [] positivos = new int [counterPos];
        int [] negativos = new int [counterNeg];
        int [] ceros = new int [counterZero];

        int iPos = 0; int iNeg = 0; int iCero = 0;
        for (int numero : numeros) {
            if (numero < 0) {
                negativos[iNeg++] = numero;
            } else if (numero == 0) {
                ceros[iCero++] = numero;
            } else {
                positivos[iPos++] = numero;
            }
        }
        // SE CARGAN LOS NUMEROS EN EL ORDEN DADO
        int index = 0;
        int [] arreglo_aux = new int [numeros.length];
        for (int positivo : positivos) {
            arreglo_aux[index++] = positivo;
        }
        for (int negativo : negativos) {
            arreglo_aux[index++] = negativo;
        }
        for (int cero : ceros) {
            arreglo_aux[index++] = cero;
        }
        return arreglo_aux;


    }

    // MOSTRAR ARREGLO
    public static void mostrarArreglo(int [] numeros){
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }

    // MAIN CONTROLLER
    public static void main(String [] args){
        int[] numeros = {8, 6, 5, 0, 7, -9, -2, 1, 3, 0, 4};
        mostrarArreglo(numeros);
        System.out.println(" ");
        int[] resultado = ordenarArreglo(numeros);
        mostrarArreglo(resultado);

    }

}
