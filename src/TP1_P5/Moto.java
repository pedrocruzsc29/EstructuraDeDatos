package TP1_P5;

public class Moto extends Vehiculo {

    // ATRIBUTOS

    private int cilindradaCC;
    private String tipoManillar;

    // CONSTRUCTOR PREDETERMINADO
    public Moto(){
        super();
        this.cilindradaCC = 0;
        this.tipoManillar = "a definir";
    }

    // CONSTRUCTOR PARAMETRIZADO
    public Moto(String marca, int model, int year, double precio, int cilindradaCC, String tipoManillar){
        super(marca,model,year,precio);
        this.cilindradaCC = cilindradaCC;
        this.tipoManillar = tipoManillar;
    }

    // GETTERS AND SETTERS

    public int getCilindradaCC(){
        return this.cilindradaCC;
    }
    public void setCilindradaCC(int cilindradaCC){
        this.cilindradaCC = cilindradaCC;
    }

    public String getTipoManillar(){
        return this.tipoManillar;
    }
    public void setTipoManillar(String tipoManillar){
        this.tipoManillar = tipoManillar;
    }

    // CLASIFICACIÓN DE CILINDRADAS
    public String engineClassification(){
        if (getCilindradaCC() <= 250){
            return "Baja";
        }else if(getCilindradaCC() >= 251 && getCilindradaCC() < 600){
            return "Media";
        }else{
            return "Alta";
        }
    }

    // TO STRING
    @Override

    public String toString(){
        return "Cilindrada: " + getCilindradaCC() + "CC - Manillar: " + getTipoManillar();
    }

}
