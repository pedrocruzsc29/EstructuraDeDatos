package TP5_P3;

import java.time.LocalDate;
import java.util.Objects;

public class TP5_P3 {

    // CARGAR RESERVAS
    public static SimpleLinkedList <Reserva> cargarReservas(SimpleLinkedList <Reserva> reservas){
        String resp = "S";
        do{
            int code = Helper.getValidInteger("Código: ");
            String recurso = Helper.getValidStrings("Recurso: ");
            LocalDate fechaReserva = Helper.getValidDate("Fecha ");
            String solicitante = Helper.getValidStrings("Solicitante: ");
            reservas.addLast(new Reserva(code,recurso,fechaReserva,solicitante));
            resp = Helper.getValidStrings("Desea cargar más reservas? (S/N): ");
        }while(resp.equalsIgnoreCase("S"));
        return reservas;
    }

    // MOSTRAR RESERVAS

    public static void mostrarReservas (SimpleLinkedList <Reserva> reservas){
        for (Reserva reserva : reservas){
            System.out.println(reserva);
        }
    }

    // LISTA CON RECURSOS IGUALES

    public static SimpleLinkedList <Reserva> recursosCompartidos(SimpleLinkedList <Reserva> reservasOne, SimpleLinkedList <Reserva> reservasTwo){
        SimpleLinkedList <Reserva> recursos = new SimpleLinkedList<Reserva>();

        for (Reserva reservaOne : reservasOne){
            Reserva actual = reservaOne;
            for (Reserva reservaTwo : reservasTwo){
                if (actual.getRecurso().equals(reservaTwo.getRecurso()) && (!actual.getSolicitante().equals(reservaTwo.getSolicitante()))){
                    recursos.addLast(actual);
                    recursos.addLast(reservaTwo);
                    break;
                }
            }
        }
        return recursos;
    }

    // CONTAR SOLICITANTES

    public static int contarSolicitantes(SimpleLinkedList <Reserva> reservas, String solicitante){
        int cont = 0;
        for (Reserva reserva : reservas){
            if (reserva.getSolicitante().equalsIgnoreCase(solicitante)){
                cont = cont + 1;
            }
        }
        return cont;
    }

    // UNIR LISTAS DE MANERA ORDENADA POR FECHA
    public static SimpleLinkedList <Reserva> fechaReservas(SimpleLinkedList <Reserva> reservasOne, SimpleLinkedList <Reserva> reservasTwo){
        SimpleLinkedList <Reserva> fechasReservadas = new SimpleLinkedList<Reserva>();
        for (Reserva reservaOne : reservasOne){
            fechasReservadas.addInOrder(reservaOne);
        }
        for (Reserva reservaTwo : reservasTwo){
            fechasReservadas.addInOrder(reservaTwo);
        }
        return fechasReservadas;
    }

    public static void main(String [] args){

        SimpleLinkedList <Reserva> reservasOne = new SimpleLinkedList<Reserva>();
        reservasOne.addLast(new Reserva(333,"Conferencia",LocalDate.of(2023,5,29),"Amanda"));
        reservasOne.addLast(new Reserva(444,"Reunión",LocalDate.of(2024,6,15),"Amanda"));
        reservasOne.addLast(new Reserva(555,"Aula 101",LocalDate.of(2021,2,24),"Gabriela"));
        SimpleLinkedList <Reserva> reservasTwo = new SimpleLinkedList<Reserva>();
        reservasTwo.addLast(new Reserva(777,"Aula 101",LocalDate.of(2022,2,15),"Alfredo"));
        reservasTwo.addLast(new Reserva(666,"Conferencia",LocalDate.of(2020,2,6),"Amelia"));
        reservasTwo.addLast(new Reserva(999,"Quorum",LocalDate.of(2019,8,20),"Amelia"));
        reservasTwo.addLast(new Reserva(666,"Conferencia",LocalDate.of(2016,10,8),"Amelia"));
        int op = 0;
        do{
            System.out.println("*** RESERVAS ***");
            System.out.println("1) Cargar una reserva");
            System.out.println("2) Mostrar reservas");
            System.out.println("3) Reservas con recursos compartidos");
            System.out.println("4) Solicitantes");
            System.out.println("5) Reservas (Fechas)");
            System.out.println("6) Salir");
            op = Helper.getValidInteger("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR RESERVAS (1°) ***");
                    reservasOne = cargarReservas(reservasOne);
                    System.out.println("*** CARGAR RESERVAS (2°) ***");
                    reservasTwo = cargarReservas(reservasTwo);
                    System.out.println("Se cargaron exitosamente...");
                    break;
                case 2:
                    System.out.println("*** DATOS ***");
                    if (reservasOne.size() > 0 || reservasTwo.size() > 0){
                        System.out.println("*** RESERVAS (1°) ***");
                        mostrarReservas(reservasOne);
                        System.out.println("*** RESERVAS (2°) ***");
                        mostrarReservas(reservasTwo);
                    }else{
                        System.out.println("No se cargaron reservas aún...");
                    }
                    break;
                case 3:
                    System.out.println("*** RESERVAS CON RECURSOS COMPARTIDOS ***");
                    SimpleLinkedList <Reserva> recursos = recursosCompartidos(reservasOne,reservasTwo);
                    if (recursos.size() > 0){
                        mostrarReservas(recursos);
                    }else{
                        System.out.println("No se encontraron recursos compartidos...");
                    }
                    break;
                case 4:
                    System.out.println("*** SOLICITANTES ***");
                    String solicitante1 = Helper.getValidStrings("Nombre del Solicitante: ");
                    int cant1 = contarSolicitantes(reservasOne,solicitante1);
                    if (cant1 != 0){
                        System.out.println("RESERVAS 1° -> Nombre: " + solicitante1.toUpperCase() + " Cantidad de Reservas: " + cant1);
                    }else{
                        System.out.println("Esta persona no tiene reservas...");
                    }
                    String solicitante2 = Helper.getValidStrings("Nombre del Solicitante: ");
                    int cant2 = contarSolicitantes(reservasTwo,solicitante2);
                    if (cant2 != 0){
                        System.out.println("Nombre: " + solicitante2.toUpperCase() + " Cantidad de Reservas: " + cant2);
                    }else{
                        System.out.println("Esta persona no tiene reservas...");
                    }
                    break;
                case 5:
                    System.out.println("*** FECHAS RESERVADAS ***");
                    SimpleLinkedList <Reserva> fechasReservadas = fechaReservas(reservasOne,reservasTwo);
                    if (fechasReservadas.size() > 0){
                        mostrarReservas(fechasReservadas);
                    }else{
                        System.out.println("No se cargaron reservas aún...");
                    }
                    break;
                case 6:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;

                default:
                    System.out.println("Elija una opción valida!");
            }
        }while(op != 6);
    }
}
