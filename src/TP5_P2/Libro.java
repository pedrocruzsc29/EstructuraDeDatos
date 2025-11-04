package TP5_P2;

public class Libro implements Comparable<Libro>{

    // ATRIBUTOS
    private String titulo;
    private String autor;
    private int year;
    private String genero;

    // CONSTRUCTOR PREDETERMINADO
    public Libro(){
        this.titulo = "a definir";
        this.autor = "a definir";
        this.year = 2025;
        this.genero = "a definir";
    }
    // CONSTRUCTOR PARAMETRIZADO
    public Libro(String titulo, String autor, int year, String genero){
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
        this.genero = genero;
    }

    // GETTERS AND SETTERS
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
        this.year = year;
    }

    public String getGenero(){
        return this.genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }

    // TO STRING
    @Override

    public String toString(){
        return "Titulo: " + getTitulo() + " Autor: " + getAutor() + " Año: " + getYear() + " Genero: " + getGenero();
    }

    @Override

    public int compareTo(Libro libro){
        return Integer.compare(this.year, libro.getYear());

    }


}
