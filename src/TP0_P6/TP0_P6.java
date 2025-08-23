package TP0_P6;

public class TP0_P6 {

    //LONGITUD STRING
    public static int Length(String word){
        return word.length();
    }
    //COMPARAR STRINGS
    public static boolean Compare(String a, String b){
        return a.equals(b);
    }

    //BUSCAR CARACTERES
    public static boolean Search(String x){
        return x.contains("la");
    }

    // CONTROL PRINCIPAL

    public static void main (String[] args){
        System.out.println("### STRINGS ###");
        String word1 = Helper.GetValidString("Palabra N°1: ");
        String word2 = Helper.GetValidString("Palabra N°2: ");
        //MOSTRAR PALABRAS Y LONGITUD
        System.out.println("Palabra 1: " + word1 + " - Longitud: " + Length(word1) +
                " | Palabra 2: " +  word2 + " - Longitud: " + Length(word2));
        // COMPARISON
        System.out.println("### COMPARACIÓN ###");
        if (Compare(word1,word2)){
            System.out.println("Ambas palabras son iguales!");
        }else{
            System.out.println("Son palabras distintas!");
        }
        // BUSQUEDA CADENA "LA"

        System.out.println("### BUSQUEDA ###");
        if (Search(word1)){
            System.out.println("Palabra 1: " + word1 + " - Contiene 'la'" );
        }else{
            System.out.println("Palabra 1: " + word1 + " - No contiene 'la'");
        }
        // UPPER CASE

        System.out.println("### MAYUSCULAS ###");
        System.out.println("Palabra 1: " + word1.toUpperCase() + " Palabra 2: " + word2.toUpperCase());
        System.out.println("RESULTADO: " + word1.toUpperCase() + " " + word2.toUpperCase());




    }
}
