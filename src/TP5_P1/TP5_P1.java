package TP5_P1;

import java.time.LocalDate;

public class TP5_P1 {

    // CARGAR DATOS DE EMPLEADO

    public static Empleado cargarEmpleado(){
        int legajo = Helper.getValidIntegers("Legajo: ");
        int dni = Helper.getValidIntegers("Dni: ");
        String name = Helper.getValidStrings("Nombre: ");
        LocalDate fecha = Helper.getValidDate("Fecha ");
        String correo = Helper.getValidStrings("Correo: ");
        return new Empleado(legajo,dni,name,fecha,correo);
    }


    // CARGAR EMPLEADOS -> FORMA COMÚN

    public static SimpleLinkedList <Empleado> cargarEmpleados(SimpleLinkedList <Empleado> empleados){

        String resp = "S";
        do{
            empleados.addLast(cargarEmpleado());
            resp = Helper.getValidStrings("Desea agregar más empleados? (S/N): ");

        }while(resp.equalsIgnoreCase("S"));
        return empleados;
    }

    // MOSTRAR EMPLEADOS

    public static void mostrarEmpleados(SimpleLinkedList <Empleado> empleados){
        for (Empleado empleado : empleados){
            System.out.println(empleado);
        }
    }

    // AGREGAR SEGÚN POSICIÓN

    public static void agregarEmpleado(SimpleLinkedList <Empleado> empleados){
        System.out.println("Empleados: " + empleados.size());
        int pos = Helper.getValidIntegers("Ingrese posición: ");
        pos = pos - 1;
        if (pos < 0 || pos >= empleados.size()){
            throw new IndexOutOfBoundsException("Posición no valida (" + pos + 1 + ")");
        }else{
            Empleado empleado = cargarEmpleado();
            empleados.InsertElement(empleado,pos);
            System.out.println("Se agrego el empleado...");
        }
    }


    // ELIMINAR SEGÚN POSICIÓN

    public static void eliminarEmpleado(SimpleLinkedList <Empleado> empleados){
        System.out.println("Empleados: " + empleados.size());
        int pos = Helper.getValidIntegers("Ingrese posición: ");
        pos = pos - 1;
        if (pos < 0 || pos >= empleados.size()){
            throw new IndexOutOfBoundsException("Posición no valida (" + pos + 1 + ") ");
        }else{
            empleados.DeleteElement(pos);
            System.out.println("Se elimino el empleado...");
        }
    }

    // MAIN CONTROLLER
    public static void main (String [] args){
        SimpleLinkedList <Empleado> empleados = new SimpleLinkedList<Empleado>();

        empleados.addLast(new Empleado(33,401,"Pedro",LocalDate.of(1999,5,29),"pedro@"));
        empleados.addLast(new Empleado(44,402,"Alfredo",LocalDate.of(1983,2,15),"alf@"));
        empleados.addLast(new Empleado(55,403,"Ana",LocalDate.of(1958,2,18),"ana@"));

        int op = 0;
        do{
            System.out.println("*** EMPLEADOS ***");
            System.out.println("1) Cargar empleados");
            System.out.println("2) Mostrar empleados");
            System.out.println("3) Agregar empleado");
            System.out.println("4) Eliminar empleado");
            System.out.println("5) Salir");
            op = Helper.getValidIntegers("Elija una opción: ");
            switch (op){
                case 1:
                    empleados = cargarEmpleados(empleados);
                    System.out.println("Se cargaron empleados...");
                    break;
                case 2:
                    System.out.println("*** EMPLEADOS ***");
                    if (empleados.size() == 0){
                        System.out.println("No se cargaron empleados aún...");
                    }else{
                        mostrarEmpleados(empleados);
                    }
                    break;
                case 3:
                    System.out.println("*** AGREGAR EMPLEADO ***");
                    if (empleados.size() == 0){
                        System.out.println("No se cargaron empleados aún...");
                    }else{
                        agregarEmpleado(empleados);
                    }
                    break;
                case 4:
                    System.out.println("*** ELIMINAR EMPLEADO ***");
                    if (empleados.size() == 0){
                        System.out.println("No se cargaron empleados aún...");
                    }else{
                        eliminarEmpleado(empleados);
                    }
                    break;
                case 5:
                    System.out.println("*** FIN DEL PROGRAMA ***");
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }
        }while(op != 5);
    }
}



