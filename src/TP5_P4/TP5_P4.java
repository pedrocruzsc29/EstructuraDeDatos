package TP5_P4;

import java.time.LocalDate;

public class TP5_P4 {

    // MOSTRAR LISTADOS

    public static void mostrarListados(SimpleLinkedList <CitaMedica> citas){
        for (CitaMedica cita : citas){
            System.out.println(cita);
        }
    }

    // MAIN CONTROLLER
    public static void main(String [] args){
        SistemaCitas sistema = new SistemaCitas();
        int op = 0;
       do{
            System.out.println("*** HOSPITAL PABLO SORIA ***");
            System.out.println("1) Cargar citas médicas");
            System.out.println("2) Mostrar citas médicas");
            System.out.println("3) Confirmar cita");
            System.out.println("4) Citas por médico");
            System.out.println("5) Citas confirmadas");
            System.out.println("6) Cancelar cita");
            System.out.println("7) Próximas citas");
            System.out.println("8) Salir");
            op = Helper.getValidIntegers("Elija una opción: ");
            switch (op){
                case 1:
                    String resp = "S";
                    System.out.println("*** CARGAR CITAS ***");
                    sistema = new SistemaCitas();

                    do{
                        int numeroCita = Helper.getValidIntegers("Numero de Cita: ");
                        String paciente = Helper.getValidStrings("Paciente: ");
                        String medico = Helper.getValidStrings("Médico: ");
                        LocalDate fecha = Helper.getValidDate("Fecha ");
                        String especialidad = Helper.getValidStrings("Especialidad: ");
                        boolean confirmada = Helper.getValidConfirmation();
                        CitaMedica cita = new CitaMedica(numeroCita,paciente,medico,fecha,especialidad,confirmada);
                        sistema.agregarCita(cita);
                        resp = Helper.getValidStrings("Desea agregar más citas? (S/N): ");
                    }while(resp.equalsIgnoreCase("S"));
                    System.out.println("Citas cargadas exitosamente...");
                    break;
                case 2:
                    System.out.println("*** CITAS AGENDADAS ***");
                    if (sistema != null){
                        sistema.mostrarCitas();
                    }else{
                        System.out.println("No se cargaron citas aún...");
                    }
                    break;
                case 3:
                    System.out.println("*** CONFIRMAR CITA ***");
                    if (sistema != null){
                        int numeroCita = Helper.getValidIntegers("Numero de cita: ");
                        sistema.confirmarCita(numeroCita);
                        System.out.println("*** CITAS AGENDADAS ***");
                        sistema.mostrarCitas();
                    }else{
                        System.out.println("No se cargaron citas aún...");
                    }
                    break;

                case 4:
                    System.out.println("*** CITAS POR MÉDICO ***");
                    if (sistema != null){
                        SimpleLinkedList <CitaMedica> citasMedico = new SimpleLinkedList<CitaMedica>();
                        String medico = Helper.getValidStrings("Médico: ");
                        citasMedico = sistema.citasPorMedico(medico);
                        if (citasMedico.size() == 0){
                            System.out.println("No se encontró el médico...");
                        }else{
                            mostrarListados(citasMedico);
                        }
                    }else{
                        System.out.println("No se cargaron citas aún...");
                    }
                    break;
                case 5:
                    System.out.println("*** CITAS CONFIRMADAS ***");
                    if (sistema != null){
                        sistema.citasConfirmadas();
                    }else{
                        System.out.println("No se cargaron citas aún...");
                    }
                    break;
                case 6:
                    System.out.println("*** CANCELAR CITA ***");
                    if (sistema != null){
                        int numeroCita = Helper.getValidIntegers("Numero de cita: ");
                        sistema.cancelarCita(numeroCita);
                    }else{
                        System.out.println("No se cargaron citas aún...");
                    }
                    break;
                case 7:
                    System.out.println("*** PRÓXIMAS CITAS ***");
                    if (sistema != null){
                        String paciente = Helper.getValidStrings("Paciente: ");
                        SimpleLinkedList <CitaMedica> citasPaciente = new SimpleLinkedList<CitaMedica>();
                        citasPaciente = sistema.proximasCitas(paciente);
                        if (citasPaciente.size() > 0){
                            mostrarListados(citasPaciente);
                        }else{
                            System.out.println("No se encontraron citas próximas de este paciente...");
                        }
                    }
                    break;
                case 8:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }

        }while (op != 8);
    }
}

// Autor: zerocool