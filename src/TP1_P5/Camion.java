package TP1_P5;

public class Camion extends Vehiculo{

    // ATRIBUTOS

    private double capacidadCarga;
    private int numeroEjes;
    private String bodyType;

    // CONSTRUCTOR PREDETERMINADO

    public Camion(){
        super();
        this.capacidadCarga = 0.0;
        this.numeroEjes = 0;
        this.bodyType = "a definir";
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Camion(String marca, int model, int year, double precio, double capacidadCarga, int numeroEjes, String bodyType){
        super(marca,model,year,precio);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
        this.bodyType = bodyType;
    }

    // GETTERS AND SETTERS

    public double getCapacidadCarga(){
        return this.capacidadCarga;
    }
    public void setCapacidadCarga(double capacidadCarga){
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumeroEjes(){
        return this.numeroEjes;
    }
    public void setNumeroEjes(int numeroEjes){
        this.numeroEjes = numeroEjes;
    }

    public String getBodyType(){
        return this.bodyType;
    }
    public void setBodyType(String bodyType){
        this.bodyType = bodyType;
    }

    // TIPO DE LICENCIA

    public boolean requiereLicenciaEspecial(){
        return getNumeroEjes() > 2;
    }

    // CAPACIDADES ESPECIALES

    public String describirCapacidadesEspeciales(){
        if (getBodyType().equals("Volquete")){
            return "Ideal para el movimiento de tierras y materiales a granel";
        }else if (getBodyType().equals("Caja seca")){
            return "Apto para transporte de mercancías protegidas";
        }else{
            return "Útil para todo tipo de carga";
        }
    }
}
