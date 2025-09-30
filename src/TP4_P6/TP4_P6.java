package TP4_P6;

import java.time.LocalTime;

public class TP4_P6 {


    // TOMAR DATOS DE REGISTRO

    public static Registro cargarRegistro() {
        int dni = Helper.getValidNumber("DNI: ");
        String motivo = Helper.getValidString("Motivo: ");
        LocalTime hora = Helper.getValidTime("Hora: ");
        boolean fueAutorizado = Helper.getValidStatus();
        return new Registro(dni, motivo, hora, fueAutorizado);
    }

    // CARGAR REGISTROS A LA COLA

    public static Queue<Registro> cargarRegistros(Queue<Registro> registros) {
        String resp = "s";
        do {
            Registro registro = cargarRegistro();
            registros.add(registro);
            resp = Helper.getValidString("Desea cargar más registros? (S/N): ");

        } while (resp.equals("s") || resp.equals("S"));
        return registros;
    }

    // MOSTRAR REGISTROS

    public static void mostrarRegistros(Queue<Registro> registros) {
        Queue<Registro> aux_queue = new Queue<Registro>();

        while (!registros.isEmpty()) {
            Registro registro = registros.remove();
            System.out.println(registro);
            aux_queue.add(registro);
        }
        while (!aux_queue.isEmpty()) {
            registros.add(aux_queue.remove());
        }
    }

    // VER ACCESOS NO AUTORIZADOS

    public static Queue<Registro> accesosNoAutorizados(Queue<Registro> registros) {
        Queue<Registro> aux_queue = new Queue<Registro>();
        Queue<Registro> noAutorizados = new Queue<Registro>();

        while (!registros.isEmpty()) {
            Registro registro = registros.remove();
            if (!registro.getFueAutorizado()) {
                noAutorizados.add(registro);
            }
            aux_queue.add(registro);
        }
        while (!aux_queue.isEmpty()) {
            registros.add(aux_queue.remove());
        }

        return noAutorizados;
    }

    // CONTADOR DE MOTIVO PARTICULAR

    public static int contadorDeMotivos(Queue<Registro> registros, String motivo) {
        Queue<Registro> aux_queue = new Queue<Registro>();
        int counter = 0;
        while (!registros.isEmpty()) {
            Registro registro = registros.remove();
            if (registro.getMotivo().equalsIgnoreCase(motivo)) {
                counter++;
            }
            aux_queue.add(registro);
        }
        while (!aux_queue.isEmpty()) {
            registros.add(aux_queue.remove());
        }
        return counter;
    }

    // VERIFICAR DNI EXISTENTE

    public static boolean verificarDNI(Queue<Registro> registros, int dni) {
        Queue<Registro> aux_queue = new Queue<Registro>();
        boolean existe = false;
        while (!registros.isEmpty()) {
            Registro registro = registros.remove();
            if (registro.getDni() == dni) {
                existe = true;
            }
            aux_queue.add(registro);
        }
        while (!aux_queue.isEmpty()) {
            registros.add(aux_queue.remove());
        }
        return existe;
    }


    // VERIFICAR POR DNI EL INGRESO AUTORIZADO

    public static boolean verificarIngreso(Queue<Registro> registros, int dni) {
        Queue<Registro> aux_queue = new Queue<Registro>();
        boolean estado = false;
        while (!registros.isEmpty()) {
            Registro registro = registros.remove();
            if (registro.getDni() == dni) {
                estado = registro.getFueAutorizado();
            }
            aux_queue.add(registro);
        }
        while (!aux_queue.isEmpty()) {
            registros.add(aux_queue.remove());
        }
        return estado;
    }


    public static void main(String[] args) {

        Queue<Registro> registros = new Queue<Registro>();
        int op = 0;
        do {
            System.out.println("### REGISTRO DE ZONA RESTRINGIDA ###");
            System.out.println("1) Cargar registros");
            System.out.println("2) Mostrar registros");
            System.out.println("3) Ver accesos no autorizados");
            System.out.println("4) Registros con motivo particular");
            System.out.println("5) Verificar acceso por DNI");
            System.out.println("6) Salir");
            op = Helper.getValidNumber("Elija una opción: ");
            switch (op) {
                case 1:

                    if (registros.isFull()) {
                        System.out.println("Se cargaron todos los registros (COLA LLENA)");
                    } else {
                        System.out.println("*** CARGAR REGISTROS ***");
                        registros = cargarRegistros(registros);
                        System.out.println("Se cargaron los registros...");
                    }

                    break;
                case 2:
                    System.out.println("*** REGISTROS ***");
                    if (registros.isEmpty()) {
                        System.out.println("No se cargaron registros aún...");
                    } else {
                        mostrarRegistros(registros);
                    }
                    break;

                case 3:
                    System.out.println("*** REGISTROS NO AUTORIZADOS ***");
                    if (registros.isEmpty()) {
                        System.out.println("No se cargaron registros aún...");
                    } else {
                        Queue<Registro> noAutorizados = accesosNoAutorizados(registros);
                        mostrarRegistros(noAutorizados);
                    }
                    break;

                case 4:
                    System.out.println("*** REGISTROS PARTICULARES ***");
                    if (registros.isEmpty()) {
                        System.out.println("No se cargaron registros aún...");
                    } else {
                        String motivo = Helper.getValidString("Ingrese el motivo a consultar: ");
                        int counter = contadorDeMotivos(registros, motivo);
                        if (counter == 0) {
                            System.out.println("No existen registros asociados a su motivo...");
                        } else {
                            System.out.println("CANTIDAD DE REGISTROS ASOCIADOS (" + motivo + "): " + counter);
                        }
                    }
                    break;
                case 5:
                    System.out.println("*** VERIFICAR INGRESO POR DNI ***");
                    if (registros.isEmpty()) {
                        System.out.println("No se cargaron registros aún...");
                    } else {
                        int dni = Helper.getValidNumber("Ingrese el DNI a consultar: ");
                        if (verificarDNI(registros, dni)) {
                            System.out.println("DNI: " + dni + " Estado de Autorización: " + verificarIngreso(registros, dni));

                        } else {
                            System.out.println("No existe registro asociado al DNI ingresado!");
                        }
                    }
                    break;
                case 6:
                    System.out.println("### FIN DEL PROGRAMA ###");
                    break;
                default:
                    System.out.println("Elija una opción valida!");
            }
        } while (op != 6);

    }
}