package TP1_P3;

import javax.swing.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.LocalDate;
public class Licencia {

    private int numeroIdentificacion;
    private String tipoLicencia;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;

    // CONSTRUCTORES - PREDETERMINADO / PARAMETRIZADO
    public Licencia(){
        this.numeroIdentificacion = 000;
        this.tipoLicencia = "a definir";
        this.fechaEmision = LocalDate.now();
        this.fechaVencimiento = this.fechaEmision.plusMonths(1);
    }

    public Licencia (int numeroIdentificacion, String tipoLicencia, LocalDate fechaEmision, LocalDate fechaVencimiento){
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoLicencia = tipoLicencia;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }

    // GETTERS Y SETTERS

    public int GetnumeroIdentificacio(){
        return this.numeroIdentificacion;
    }

    public void SetnumeroIdenticacion(int numeroIdentificacion){
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String GettipoLicencia(){
        return this.tipoLicencia;
    }

    public void SettipoLicencia(String tipoLicencia){
        this.tipoLicencia = tipoLicencia;
    }

    public LocalDate GetfechaEmision(){
        return this.fechaEmision;
    }

    public void SetfechaEmision(LocalDate fechaEmision){
        this.fechaEmision = fechaEmision;
    }

    public LocalDate GetfechaVencimiento(){
        return this.fechaVencimiento;
    }

    public void SetfechaVencimiento(LocalDate fechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }

    // VALIDATE DATE METHOD

    public boolean ValidateDates(LocalDate date1, LocalDate date2) {
        LocalDate today = LocalDate.now();
        if (date1.isAfter(today)) { // LICENCIA FUTURA
            return false;
        } else {
            if (date1.isAfter(date2)) { // FECHA FIN ESTA ANTES DE FECHA EMISION
                return false;
            } else { // SUPONIENDO QUE NO FUERA ASI
                long days = ChronoUnit.DAYS.between(date1, date2); // OBTENER DIAS
                return days <= 30; // SI SON MENORES O IGUALES A 30 NO SE VENCIO (TRUE), SI SON MAYORES, SI (FALSE)
            }
        }

    }

    // CARGAR FECHAS

    public void LoadDates(){

        LocalDate fechaEmision = Helper.GetValidDate("Ingrese fecha de Emisión: ");
        LocalDate fechaVencimiento = Helper.GetValidDate("Ingrese fecha de Vencimiento: ");
        if (ValidateDates(fechaEmision,fechaVencimiento)){
            this.fechaEmision = fechaEmision;
            this.fechaVencimiento = fechaVencimiento;
        }else{
            System.out.println("Fechas fuera de termino! Se actualizaron...");
            this.fechaEmision = LocalDate.now();
            this.fechaVencimiento = this.fechaEmision.plusMonths(1);
        }
    }

    //CARGAR TIPO DE LICENCIA
    public String LoadLicenceType(){

        String type = "a definir";

        System.out.println("# TIPO DE LICENCIA #");
        System.out.println("1) Conducir");
        System.out.println("2) Porte de Armas");
        System.out.println("3) Habilitación comercial");
        int op = Helper.GetValidOption();
        if (op == 1) {
            type = "Conducir";
        }else if (op == 2){
            type = "Porte de Armas";
        } else if (op == 3){
            type = "Habilitación comercial";
        }
        return type;
    }

    // CARGAR LICENCIA
    public void LoadLicense(){
        this.numeroIdentificacion = Helper.GetValidNumber("Ingrese el numero de identificación: ");
        this.tipoLicencia = LoadLicenceType();
        LoadDates();
    }

    // ESTADO DE LICENCIA

    public boolean fechaConsulta(LocalDate fechaCons,LocalDate fechaEmision, LocalDate fechaVencimiento){
        boolean vigente = false;

        if (( fechaCons.equals(fechaEmision) || fechaCons.isAfter(fechaEmision)) && (fechaCons.equals(fechaVencimiento)||fechaCons.isBefore(fechaVencimiento))){
            vigente = true;
        }
        return vigente;
    }



    // CALCULAR DIAS RESTANTES -> ERROR

    public int calcularDiasRestantesOVencidos(LocalDate fechaCons, LocalDate fechaEmision,LocalDate fechaVencimiento){
        if (fechaConsulta(fechaCons,fechaEmision,fechaVencimiento)){
            long Days = ChronoUnit.DAYS.between(fechaCons,fechaVencimiento);
            return (int) Days;
        }else{
            long Days = ChronoUnit.DAYS.between(fechaCons,fechaVencimiento);
            return (int) Days;
        }
    }

    // CATEGORIES

    public void estaVigente(int dias){
        if (dias>0){
            System.out.println("Dias restastantes para vencimiento: " + dias);
        }else if (dias < 0){
            System.out.println("Dias transcurridos desde el vencimiento: " + dias);
        }else{
            System.out.println("Su fecha de vencimiento es hoy!");
        }
    }

    // RENOVACIÓN

    public void simularRenovacion(int cantidadYears){
        this.fechaVencimiento = this.fechaVencimiento.plusYears(cantidadYears);
    }



    @Override

    public String toString(){
        return "# LICENCIAS # LICENCIA N°: " + this.numeroIdentificacion + " TIPO: " +
                this.tipoLicencia + " EMISION: " + this.fechaEmision + " VENCIMIENTO: " + this.fechaVencimiento;
    }
}

// zerocool