package TP0_P4;

public class TP0_P4 {

    // SUMAR
    public static int Suma(int a, int b) {
        return a + b;
    }

    // RESTAR
    public static int Resta(int a, int b){
        return a - b;
    }

    // MULTIPLICAR
    public static int Multiply(int a, int b){
        return a * b;
    }

    // DIVIDIR
    public static double Divide(int a, int b){
        if (Helper.Cero(a) || Helper.Cero(b)) {
            return 0;
        } else{
            return (double) a / (double) b;
        }
    }

    // CONTROLADOR PRINCIPAL

    public static void main (String[] args){
        int op = 0;
        do{
            int a = 0;
            int b = 0;
            System.out.println("### CALCULADORA ###");
            System.out.println("1) Sumar");
            System.out.println("2) Restar");
            System.out.println("3) Multiplicar");
            System.out.println("4) Dividir");
            System.out.println("5) Salir");
            op = Helper.GetValidNumber("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("### SUMA ###");
                    a = Helper.GetValidNumber("Numero #1: ");
                    b = Helper.GetValidNumber("Numero #2: ");
                    System.out.println("Resultado = " + Suma(a,b));
                    break;
                case 2:
                    System.out.println("### RESTA ###");
                    a = Helper.GetValidNumber("Numero #1: ");
                    b = Helper.GetValidNumber("Numero #2: ");
                    System.out.println("Resultado = " + Resta(a,b));
                    break;
                case 3:
                    System.out.println("### MULTIPLICAR ###");
                    a = Helper.GetValidNumber("Numero #1: ");
                    b = Helper.GetValidNumber("Numero #2: ");
                    System.out.println("Resultado = " + Multiply(a,b));
                    break;
                case 4:
                    System.out.println("### DIVIDIR ###");
                    a = Helper.GetValidNumber("Numero #1: ");
                    b = Helper.GetValidNumber("Numero #2: ");
                    if (Divide(a,b) == 0){
                        System.out.println("Ingreso un n° cero!");
                    }else{
                        System.out.println("Resultado = " + Divide(a,b));
                    }
                    break;
                case 5:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;
                default:
                    System.out.println("Elija una opción correcta!");
            }
        }while(op != 5);
    }
}
