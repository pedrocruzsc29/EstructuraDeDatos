package TP5_P5;

import javax.swing.text.html.HTMLEditorKit;
import java.awt.desktop.SystemSleepEvent;

public class TP5_P5 {

    // CARGAR ESTUDIANTES

    public static SimpleLinkedList <Estudiante> cargarEstudiantes(SimpleLinkedList <Estudiante> estudiantes){
        String resp = "S";
        do{
            int lu = Helper.getValidIntegers("LU: ");
            String nombre = Helper.getValidStrings("Nombre: ");
            String apellido = Helper.getValidStrings("Apellido: ");
            double nota1 = Helper.getValidDoubles("Nota 1°: ");
            double nota2 = Helper.getValidDoubles("Nota 2°: ");
            double nota3 = Helper.getValidDoubles("Nota 3°: ");
            resp = Helper.getValidStrings("Desea cargar más estudiantes? (S/N): ");
            estudiantes.addLast(new Estudiante(lu,nombre,apellido,nota1,nota2,nota3));
        }while(resp.equalsIgnoreCase("S"));
        return estudiantes;
    }

    // CALCULAR PROMEDIO

    public static double calcularPromedio(Estudiante estudiante){
        double total = 0;
        total = estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3();
        return (double) total/3;
    }

    // MOSTRAR PROMEDIOS

    public static void mostrarPromedios(SimpleLinkedList <Estudiante> estudiantes){
        for (Estudiante estudiante : estudiantes){
            System.out.println("Promedio de " + estudiante.getNombre() + " " + estudiante.getApellido() + " : " + String.format("%.2f",calcularPromedio(estudiante)));
        }
    }

    // ESTUDIANTE CON LA NOTA PROMEDIO MÁS ALTA

    public static Estudiante notaPromedioMax(SimpleLinkedList <Estudiante> estudiantes){
        Estudiante estudianteMax = new Estudiante();
        double promMax = 0;
        for (Estudiante estudiante : estudiantes){
            if (promMax < calcularPromedio(estudiante)){
                promMax = calcularPromedio(estudiante);
                estudianteMax = estudiante;
            }
        }
        return estudianteMax;
    }

    // LISTA DE ESTUDIANTES APROBADOS

    public static SimpleLinkedList <Estudiante> estudiantesAprobados(SimpleLinkedList <Estudiante> estudiantes){
        SimpleLinkedList <Estudiante> estudiantesAprobados = new SimpleLinkedList<Estudiante>();
        for (Estudiante estudiante : estudiantes){
            if (calcularPromedio(estudiante) >= 6){
                estudiantesAprobados.addLast(estudiante);
            }
        }
        return estudiantesAprobados;
    }

    public static void mostrarEstudiantes(SimpleLinkedList <Estudiante> estudiantes){
        for (Estudiante estudiante : estudiantes){
            System.out.println(estudiante);
        }
    }

    // MAIN CONTROLLER
    public static void main (String [] args){
        SimpleLinkedList <Estudiante> estudiantes = new SimpleLinkedList<Estudiante>();
        int op = 0;
        do{
            System.out.println("*** FACULTAD UNJU ***");
            System.out.println("1) Cargar estudiantes");
            System.out.println("2) Mostrar estudiantes");
            System.out.println("3) Mostrar Promedios");
            System.out.println("4) Promedio más alto");
            System.out.println("5) Estudiantes aprobados (>= 6)");
            System.out.println("6) Salir");
            op = Helper.getValidIntegers("Elija una opción: ");
            switch (op){
                case 1:
                    System.out.println("*** CARGAR ESTUDIANTES ***");
                    estudiantes = cargarEstudiantes(estudiantes);
                    System.out.println("Estudiantes cargados exitosamente...");
                    break;
                case 2:
                    System.out.println("*** ESTUDIANTES ***");
                    if (estudiantes.size() > 0){
                        mostrarEstudiantes(estudiantes);
                    }else{
                        System.out.println("No se cargaron estudiantes aún...");
                    }
                    break;

                case 3:
                    System.out.println("*** PROMEDIOS ***");
                    if (estudiantes.size() > 0){
                        mostrarPromedios(estudiantes);
                    }else{
                        System.out.println("No se cargaron estudiantes aún...");
                    }
                    break;
                case 4:
                    System.out.println("*** ESTUDIANTE DE PROMEDIO MÁXIMO ***");
                    if (estudiantes.size() > 0){
                        Estudiante estudianteMax = notaPromedioMax(estudiantes);
                        System.out.println(estudianteMax);
                        System.out.println("Promedio: " + String.format("%.2f",calcularPromedio(estudianteMax)));
                    }else{
                        System.out.println("No se cargaron estudiantes aún...");
                    }
                    break;
                case 5:
                    System.out.println("*** ESTUDIANTES APROBADOS (>=6) ***");
                    if (estudiantes.size() > 0){
                        mostrarEstudiantes(estudiantesAprobados(estudiantes));
                    }else{
                        System.out.println("No se cargaron estudiantes aún...");
                    }
                    break;
                case 6:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;

                default:
                    System.out.println("Elija una opción valida!");
            }
        }while(op!=6);
    }
}

// Autor: zerocool
