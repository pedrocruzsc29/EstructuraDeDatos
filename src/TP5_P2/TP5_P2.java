package TP5_P2;

public class TP5_P2 {

    // CARGAR LIBROS

    public static DoubleLinkedList <Libro> cargarLibros(DoubleLinkedList <Libro> libros){
        String resp = "S";
        do{
            String titulo = Helper.getValidStrings("Titulo: ");
            String autor = Helper.getValidStrings("Autor: ");
            int year = Helper.getValidIntegers("Año: ");
            String genero = Helper.getValidStrings("Genero: ");
            libros.addLast(new Libro(titulo,autor,year,genero));
            resp = Helper.getValidStrings("Desea cargar más libros? (S/N): ");
        }while(resp.equalsIgnoreCase("S"));
        return libros;
    }

    // OBTENER LIBRO MÁS ANTIGÜO

    public static Libro libroAntiguo(DoubleLinkedList<Libro> libros){
        Libro libroMin = libros.getFirst();
        for (Libro libro : libros){
            if (libro.compareTo(libroMin) < 0){
                libroMin  = libro;
            }
        }
        return libroMin;
    }

    // CLASIFICAR LIBROS SEGÚN GÉNERO

    public static DoubleLinkedList <Libro> clasificarLibros(DoubleLinkedList <Libro> libros, String genero){
        DoubleLinkedList <Libro> librosGenero = new DoubleLinkedList<Libro>();
        for (Libro libro : libros){
            if (libro.getGenero().equalsIgnoreCase(genero)){
                librosGenero.addLast(libro);
            }
        }
        return librosGenero;
    }

    // MOSTRAR LIBROS

    public static void mostrarLibros(DoubleLinkedList <Libro> libros){
        for (Libro libro : libros){
            System.out.println(libro);
        }
    }

    // MOSTRAR AUTORES Y CANTIDAD DE LIBROS

    public static void mostrarAutores(DoubleLinkedList <LibrosEscritos> libros){
        for (LibrosEscritos libroE : libros){
            System.out.println(libroE);
        }
    }


    // CONTAR LIBROS

    public static DoubleLinkedList <LibrosEscritos> librosPorAutor(DoubleLinkedList <Libro> libros){
        DoubleLinkedList <LibrosEscritos> librosAutores = new DoubleLinkedList<LibrosEscritos>();
        for (Libro libro : libros){
            String autor = libro.getAutor(); // Se actualiza el nombre del autor de la lista original
            LibrosEscritos existente = null; // Se declara un elemento a llenar para comprobar si el autor ya existe en la nueva lista
            for (LibrosEscritos librosEscritos : librosAutores){
                if (librosEscritos.getName().equals(autor)){
                    existente = librosEscritos; // Existente pasa a tener los valores del primer libro cargado
                    break; // Si lo encuentra deja de recorrer la lista
                }
            }
            if (existente != null){ // Significa que el autor ya existe, por lo tanto,
                existente.setCantidad(existente.getCantidad() + 1); // Se incrementa su cantidad de libros
            }else{ // Caso contrario
                librosAutores.AddInOrder(new LibrosEscritos(autor,1)); // Se lo agrega a la lista con 1 como cantidad inicial
            }
        }
        return librosAutores;
    }

    // MAIN CONTROLLER
    public static void main (String [] args){
        DoubleLinkedList <Libro> libros = new DoubleLinkedList<Libro>();
        libros.addLast(new Libro("Hamlet","Shakespeare",1603, "Drama"));
        libros.addLast(new Libro("Romeo and Juliet", "Shakespeare", 1597, "Tragedia"));
        libros.addLast(new Libro("1984", "George Orwell", 1949, "Distópico"));
        libros.addLast(new Libro("Animal Farm", "George Orwell", 1945, "Drama"));
        libros.addLast(new Libro("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Novel"));
        int op = 0;
        do{
            System.out.println("*** BIBLIOTECA ***");
            System.out.println("1) Cargar libros");
            System.out.println("2) Mostrar libros");
            System.out.println("3) Ver libro más antigüo");
            System.out.println("4) Clasificar libros por genero");
            System.out.println("5) Libros por autor");
            System.out.println("6) Salir");
            op = Helper.getValidIntegers("Elija una opción: ");

            switch (op){
                case 1:
                    System.out.println("*** CARGAR LIBRO ***");
                    libros = cargarLibros(libros);
                    System.out.println("Se cargaron exitosamente...");
                    break;
                case 2:
                    if (libros.size() > 0){
                        System.out.println("*** LIBROS ***");
                        mostrarLibros(libros);
                    }else{
                        System.out.println("No se cargaron libros aún...");
                    }
                    break;
                case 3:
                    if (libros.size() > 0){
                        System.out.println("*** LIBRO MÁS ANTIGÜO ***");
                        System.out.println(libroAntiguo(libros));
                    }else{
                        System.out.println("No se cargaron libros aún...");
                    }
                    break;
                case 4:
                    System.out.println("*** LIBROS ***");
                    String genero = Helper.getValidStrings("Genero: ");
                    DoubleLinkedList<Libro> librosClasificados = clasificarLibros(libros,genero);
                    if (librosClasificados.size() > 0){
                        System.out.println("*** LIBROS DE " + genero.toUpperCase() + " ***");
                        mostrarLibros(librosClasificados);
                    }else{
                        System.out.println("No se encontraron libros de ese genero...");
                    }
                    break;
                case 5:
                    System.out.println("*** AUTORES ***");
                    if (libros.size() > 0){
                        DoubleLinkedList <LibrosEscritos> librosEscritos = librosPorAutor(libros);
                        mostrarAutores(librosEscritos);
                    }else{
                        System.out.println("No se cargaron libros aún...");
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
