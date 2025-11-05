package TP5_P4;

import java.time.LocalDate;

public class SistemaCitas {

    // ATRIBUTOS
    private SimpleLinkedList<CitaMedica> citasMedicas;

    // CONSTRUCTOR PREDETERMINADO

    public SistemaCitas(){
        citasMedicas = new SimpleLinkedList<CitaMedica>();
    }

    // MÉTODOS

    // CARGAR UNA CITA

    public void agregarCita(CitaMedica cita){
        citasMedicas.addLast(cita);
    }

    // CONFIRMAR CITA

    public void confirmarCita(int numeroCita){
        boolean existe = false;
        for (CitaMedica cita : citasMedicas){
            if(numeroCita == cita.getNumeroCita()){
                cita.setConfirmada(true);
                existe = true;
            }
        }
        if (!existe){
            System.out.println("No se encontró el numero de cita...");
        }
    }

    // CITAS POR MEDICO

    public SimpleLinkedList <CitaMedica> citasPorMedico(String medico){
        SimpleLinkedList <CitaMedica> citasMedico = new SimpleLinkedList<CitaMedica>();
        for (CitaMedica cita : citasMedicas){
            if (cita.getMedico().equalsIgnoreCase(medico)){
                citasMedico.addLast(cita);
            }
        }
        return citasMedico;
    }

    // CITAS CONFIRMADAS

    public void citasConfirmadas(){
        boolean existe = false;
        for (CitaMedica cita : citasMedicas){
            if (cita.getConfirmada()){
                System.out.println(cita);
                existe = true;
            }
        }
        if (!existe){
            System.out.println("No existen citas confirmadas...");
        }
    }

    // CANCELAR CITA

    public void cancelarCita(int numeroCita){
        int pos = 0;
        boolean existe = false;
        for (CitaMedica cita : citasMedicas){
            if (cita.getNumeroCita() == numeroCita){
                citasMedicas.DeleteElement(pos);
                System.out.println("Cita: " + numeroCita + " se cancelo exitosamente...");
                existe = true;
                break;
            }
            pos++;
        }
        if (!existe){
            System.out.println("No se encontró la cita...");
        }
    }

    // PRÓXIMAS CITAS

    public SimpleLinkedList <CitaMedica> proximasCitas(String paciente){
        SimpleLinkedList <CitaMedica> proximas = new SimpleLinkedList<CitaMedica>();
        for (CitaMedica cita : citasMedicas){
            if (cita.getPaciente().equalsIgnoreCase(paciente)){
                if (LocalDate.now().isBefore(cita.getFecha())){
                    proximas.addLast(cita);
                }
            }
        }
        return proximas;
    }

    // MOSTRAR CITAS

    public void mostrarCitas(){
        for (CitaMedica cita : citasMedicas){
            System.out.println(cita);
        }
    }

}
