package TP1_P4;

public class Estudiante {

    // ATTRIBUTES

    private String name;
    private int lu;
    private double notaPrimerParcial;
    private double notaSegundoParcial;

    // CONSTRUCTOR PREDETERMINADO

    public Estudiante(){
        this.name = "a definir";
        this.lu = 0;
        this.notaPrimerParcial = 0.0;
        this.notaSegundoParcial = 0.0;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Estudiante(String name, int lu, double notaPrimerParcial, double notaSegundoParcial){
        this.name = name;
        this.lu = lu;
        this.notaPrimerParcial = notaPrimerParcial;
        this.notaSegundoParcial = notaSegundoParcial;
    }

    // GETTERS Y SETTERS

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getLu(){
        return this.lu;
    }
    public void setLu(int lu){
        this.lu = lu;
    }

    public double getNotaPrimerParcial(){
        return this.notaPrimerParcial;
    }
    public void setNotaPrimerParcial(double notaPrimerParcial){
        this.notaPrimerParcial = notaPrimerParcial;
    }

    public double getNotaSegundoParcial(){
        return this.notaSegundoParcial;
    }
    public void setNotaSegundoParcial(double notaSegundoParcial){
        this.notaSegundoParcial = notaSegundoParcial;
    }

    // MÉTODOS

    // CARGAR DATOS

    public Estudiante cargarDatos(){
        String nombre = Helper.getValidString(("Nombre: "));
        int lu = Helper.getValidInteger("LU: ");
        double notaPrimerParcial = Helper.getValidDouble("Nota Primer Parcial: ");
        double notaSegundoParcial = Helper.getValidDouble("Nota Segundo Parcial: ");
        return new Estudiante(nombre,lu,notaPrimerParcial,notaSegundoParcial);
    }

    // PROMEDIO DE NOTAS

    public double promedioNotas(Estudiante estudiante){

        return (estudiante.getNotaPrimerParcial() + estudiante.getNotaSegundoParcial()) / 2;
    }

    // ESTADO DEL ALUMNO

    public String estadoAlumno(double promedio){
        if (promedio >= 7){
            return "PROMOCIÓN";
        }else if (promedio < 7 && promedio >= 4){
            return "REGULAR";
        }else{
            return "LIBRE";
        }
    }

    @Override

    public String toString(){
        return "Alumno: " + getName() +" LU: " + getLu() +
                " Nota 1° Parcial: " + getNotaPrimerParcial() +
                " Nota 2° Parcial: " + getNotaSegundoParcial();
    }

}
