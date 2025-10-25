package TP6_P5;

public class Pedido implements Comparable <Pedido>{

    //ATRIBUTOS

    private int numeroPedido;
    private String nombreCliente;
    private String nombreProducto;
    private int cantidad;

    // CONSTRUCTOR PREDETERMINADO

    public Pedido(){
        this.numeroPedido = 0;
        this.nombreCliente = "a definir";
        this.nombreProducto = "a definir";
        this.cantidad = 0;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Pedido(int numeroPedido, String nombreCliente, String nombreProducto, int cantidad){
        this.numeroPedido = numeroPedido;
        this.nombreCliente = nombreCliente;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    // GETTERS AND SETTERS

    public int getNumeroPedido(){
        return this.numeroPedido;
    }
    public void setNumeroPedido(int numeroPedido){
        this.numeroPedido = numeroPedido;
    }

    public String getNombreCliente(){
        return this.nombreCliente;
    }
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }

    public String getNombreProducto(){
        return this.nombreProducto;
    }
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad(){
        return this.cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    @Override

    public int compareTo(Pedido pedido){
        return this.nombreCliente.compareTo(pedido.nombreCliente);
    }
}
