package TP3_P6;

public class Entrega {


    private String destinatario;
    private int piso;
    private boolean fueEntregado;



    // CONSTRUCTOR PREDETERMINADO
    public Entrega(){
        this.destinatario = "a definir";
        this.piso = 0;
        this.fueEntregado = false;
    }

    // CONSTRUCTOR PARAMETRIZADO
    public Entrega(String destinatario, int piso, boolean fueEntregado){
        this.destinatario = destinatario;
        this.piso = piso;
        this.fueEntregado = fueEntregado;
    }

    // GETTERS Y SETTERS

    public String getDestinatario(){
        return this.destinatario;
    }
    public void setDestinatario(String destinatario){
        this.destinatario = destinatario;
    }

    public int getPiso(){
        return this.piso;
    }
    public void setPiso(int piso){
        this.piso = piso;
    }

    public boolean getFueEntregado(){
        return this.fueEntregado;
    }
    public void setFueEntregado(boolean fueEntregado){
        this.fueEntregado = fueEntregado;
    }


    @Override

    public String toString(){
        return "ENTREGA-> DESTINATARIO: " + getDestinatario() + " PISO: " + getPiso() + " ENTREGADO: " + getFueEntregado();
    }

}
