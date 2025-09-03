package TP1_P3;

import java.time.LocalDate;
import java.util.Scanner;
public class TP1_P3 {

    public static Scanner sc = new Scanner(System.in);

    public static void MenuConsulta(Licencia licencia1, Licencia licencia2){
        int op = 0;
        do{
            System.out.println("1) Licencia N°1");
            System.out.println("2) Licencia N°2");
            System.out.println("3) Salir");
            op = Helper.GetValidOption();
            switch (op){
                case 1:
                    LocalDate fechaCons1 = Helper.GetValidDate("Ingrese la fecha a consultar: ");
                    if (licencia1.fechaConsulta(fechaCons1,licencia1.GetfechaEmision(),licencia1.GetfechaVencimiento())){
                        System.out.println("La licencia se encuentra en vigencia!");
                    }else{
                        System.out.println("La licencia se encuentra fuera de vigencia!");
                    }
                    break;
                case 2:
                    LocalDate fechaCons2 = Helper.GetValidDate("Ingrese la fecha a consultar: ");
                    if (licencia2.fechaConsulta(fechaCons2,licencia2.GetfechaEmision(),licencia2.GetfechaVencimiento())){
                        System.out.println("La licencia se encuentra en vigencia!");
                    }else{
                        System.out.println("La licencia se encuentra fuera de vigencia!");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opción correcta");
                }

            }while (op != 3);

        }



        public static void main (String[] args){

            int op = 0;
            Licencia license1 = new Licencia();
            Licencia license2 = new Licencia();
            do{
                System.out.println(" ### LICENCIAS ###");
                System.out.println("1) Crear Licencia N°1");
                System.out.println("2) Crear Licencia N°2");
                System.out.println("3) Mostrar Licencias");
                System.out.println("4) Consultar fecha");
                System.out.println("5) Dias Restantes de Licencia");
                System.out.println("6) Renovar licencias");
                System.out.println("7) Salir");
                op = Helper.GetValidNumber("Ingrese una opción: ");
                switch (op) {
                    case 1:
                        System.out.println("### LICENCIA N°1 ###");
                        license1.LoadLicense();
                        System.out.println(license1.toString());
                        break;
                    case 2:
                        System.out.println("### LICENCIA N°2 ###");
                        license2.LoadLicense();
                        System.out.println(license2.toString());
                        break;
                    case 3:
                        System.out.println("### LICENCIAS ###");
                        System.out.println(license1.toString());
                        System.out.println(license2.toString());
                        break;
                    case 4:
                        System.out.println("### CONSULTA ###");
                        MenuConsulta(license1,license2);
                        break;
                    case 5:
                        System.out.println("### DIAS RESTANTES / FALTANTES ###");
                        System.out.println("# LICENCIA N°1: ");
                        LocalDate fechaCons1 = Helper.GetValidDate("Ingrese la fecha a consultar: ");
                        license1.estaVigente(license1.calcularDiasRestantesOVencidos(fechaCons1,license1.GetfechaEmision(),license1.GetfechaVencimiento()));
                        System.out.println("# LICENCIA N°2: ");
                        LocalDate fechaCons2 = Helper.GetValidDate("Ingrese la fecha a consultar: ");
                        license2.estaVigente(license2.calcularDiasRestantesOVencidos(fechaCons2,license2.GetfechaEmision(),license2.GetfechaVencimiento()));
                        break;
                    case 6:
                        System.out.println(("### RENOVACIÓN ###"));
                        System.out.println("# LICENCIA N°1: ");
                        int cant1 = Helper.GetValidNumber("Ingrese la cantidad de años:");
                        license1.simularRenovacion(cant1);
                        System.out.println(license1.toString());
                        System.out.println("# LICENCIA N°2: ");
                        int cant2 = Helper.GetValidNumber("Ingrese la cantidad de años:");
                        license2.simularRenovacion(cant2);
                        System.out.println(license2.toString());
                        break;

                    case 7:
                        System.out.println("### FIN DEL PROGRAMA ###");
                        break;
                    default:
                        System.out.println("Elija una opción correcta!");
                }
            }while (op != 7);

    }
}
// zerocool
