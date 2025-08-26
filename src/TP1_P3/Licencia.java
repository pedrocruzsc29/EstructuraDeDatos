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

    public void LoadDates(LocalDate fechaEmision, LocalDate fechaVencimiento){
        if (ValidateDates(fechaEmision,fechaVencimiento)){
            this.fechaEmision = fechaEmision;
            this.fechaVencimiento = fechaVencimiento;
        }else{
            this.fechaEmision = LocalDate.now();
            this.fechaVencimiento = this.fechaEmision.plusMonths(1);
        }
    }




    @Override

    public String toString(){
        return "# LICENCIAS # LICENCIA N°: " + this.numeroIdentificacion + " TIPO: " +
                this.tipoLicencia + " EMISION: " + this.fechaEmision + " VENCIMIENTO: " + this.fechaVencimiento;
    }

}


// zerocool