package TP0_P3;
import java.text.DecimalFormat;

public class TP0_P3 {

    // FORMAT FOR DECIMAL NUMBERS
    public static DecimalFormat df = new DecimalFormat("#.00");

    // CONTROLADOR PRINCIPAL
    public static void main(String[] args) {

        String resp = "S";

        do {
            System.out.println("### GOOD TRIP ###");
            double km = Helper.GetValidDouble("Ingrese los Km. recorridos:  ");
            double lts = Helper.GetValidDouble("Ingrese los lts. de combustible: ");
            double efi = km / lts;
            if (efi >= 15) {
                System.out.println("Eficiencia: " + df.format(efi) + " - Excelente :D");
            } else if (efi < 15 && efi >= 10) {
                System.out.println("Eficiencia: " + df.format(efi) + " - Buena :)");
            } else if (efi < 10 && efi >= 5) {
                System.out.println("Eficiencia: " + df.format(efi) + " - Regular :|");
            } else if (efi < 5) {
                System.out.println("Eficiencia: " + df.format(efi) + " - Baja :(");
            }
            resp = Helper.GetCharacter("Desea volver a operar? (S/N):");
        } while (resp.equals("S") || resp.equals("s"));

        System.out.println("### FIN DEL PROGRAMA ###");

    }
}

//zerocool
