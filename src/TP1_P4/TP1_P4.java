package TP1_P4;

public class TP1_P4 {


    public static void main (String [] args){
        int op = 0;
        Estudiante estudiante = null;
        do{
            System.out.println("### FACULTAD ###");
            System.out.println("1) Cargar estudiante");
            System.out.println("2) Mostrar datos");
            System.out.println("3) Promedio");
            System.out.println("4) Estado del alumno");
            System.out.println("5) Salir");
            op = Helper.getValidInteger("Ingrese una opción: ");
            switch (op){
                case 1:
                    estudiante = new Estudiante();
                    estudiante = estudiante.cargarDatos();
                    System.out.println("Estudiante cargado... :)");
                    break;
                case 2:
                    if (estudiante == null){
                        System.out.println("No se cargaron estudiantes aún...");
                    }else{
                        System.out.println("*** DATOS DE ESTUDIANTE ***");
                        System.out.println(estudiante.toString());
                    }
                    break;
                case 3:
                    if (estudiante == null){
                        System.out.println("No se cargaron estudiantes aún...");
                    }else {
                        System.out.println("PROMEDIO de  " + estudiante.getName() + ": " + estudiante.promedioNotas(estudiante));
                    }
                    break;
                case 4:
                    if (estudiante == null){
                        System.out.println("No se cargaron estudiantes aún...");
                    }else {
                        System.out.println("ESTADO de " + estudiante.getName() + ": " + estudiante.estadoAlumno(estudiante.promedioNotas(estudiante)));
                    }
                    break;
                case 5:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }

        }while (op != 5);





    }
}
