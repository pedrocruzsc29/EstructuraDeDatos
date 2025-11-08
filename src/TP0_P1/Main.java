package TP0_P1;

public class Main { // TP 0 -> Punto Uno | Conversor de Medidas y Temperaturas

    // FUNCIONES

    public static void MenuLongitud(){
        System.out.println("1) Metros a centímetros");
        System.out.println("2) Centímetros a metros");
        int op1 = Helper.ValidOption("Ingrese una opción:");
        switch (op1){
            case 1:
                double metros = Helper.ValidNumber("Ingrese los metros: ");
                System.out.println("Medida Original: " + metros + " mts. Centímetros: " + metros * 100 + " cm.");
                break;
            case 2:
                double centimeters = Helper.ValidNumber("Ingrese los cm: ");
                System.out.println("Medida Original: " + centimeters + " cm. Metros: " + centimeters / 100 + " mts.");
                break;
            default:
                System.out.println("Elija una opción correcta!");
        }
    }

    public static void MenuTemperatura(){
        System.out.println("1) Celsius a Fahrenheit");
        System.out.println("2) Fahrenheit a Celsius");
        int op2 = Helper.ValidOption("Elija una opción: ");
        switch (op2){
            case 1:
                double celsius = Helper.ValidNumber("Ingrese T. Celsius: ");
                double temp1 = celsius * 9 / 5 + 32;
                System.out.println("Temp. Original: " + celsius + " Celsius en Fahrenheit: " + temp1 + "°");
                break;
            case 2:
                double fahrenheit = Helper.ValidNumber("Ingrese T. Fahrenheit: ");
                double temp2 = (fahrenheit - 32) * 5 / 9;
                System.out.println("Temp. Original: " + fahrenheit +  " Fahrenheit en Celsius: " + temp2 + "°");
                break;
            default:
                System.out.println("Elija una opción correcta");
        }
    }

    // CONTROL PRINCIPAL

    public static void main(String[] args) {
        System.out.println("### CONVERSOR DE UNIDADES ###");
        System.out.println("1) Conversor de Longitud");
        System.out.println("2) Conversor de Temperatura");
        int op = Helper.ValidOption("Elija una opción:");
        switch (op){
            case 1:
                MenuLongitud();
                break;
            case 2:
                MenuTemperatura();
                break;
            default:
                System.out.println("Elija una opción correcta!");
        }
        System.out.println("### FIN DEL PROGRAMA ###");
    }
}

// zerocool