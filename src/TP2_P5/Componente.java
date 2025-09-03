package TP2_P5;

public class Componente {

    // DECLARACIÓN DE VARIABLES

    private int codigo;
    private String nombre;
    private double precioUnitario;
    private int cantidadStock;


    // CONSTRUCTOR PREDETERMINADO
    public Componente(){
        this.codigo = 0;
        this.nombre = "";
        this.precioUnitario = 0.0;
        this.cantidadStock = 0;
    }

    // CONSTRUCTOR CON PARAMETROS
    public Componente(int codigo, String nombre, double precioUnitario, int cantidadStock){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadStock = cantidadStock;
    }

    // GETTERS & SETTERS

    public int GetCodigo(){
        return this.codigo;
    }

    public void SetCodigo(int codigo){
        this.codigo = codigo;

    }
    public String GetNombre(){
        return this.nombre;
    }

    public void SetNombre(String nombre){
        this.nombre = nombre;
    }

    public double GetPrecioUnitario(){
        return this.precioUnitario;
    }

    public void SetPrecioUnitario(double precioUnitario){
        this.precioUnitario = precioUnitario;
    }

    public int GetCantidadStock(){
        return this.cantidadStock;
    }

    public void SetCantidadStock(int cantidadStock){
        this.cantidadStock = cantidadStock;
    }

    // ACTUALIZAR STOCK

    public void Update_Stock(){
        System.out.println("### MENU ###");
        System.out.println("1) Aumentar Stock");
        System.out.println("2) Disminuir Stock");
        int op = Helper.GetValidNumber("Elija una opción: ");
        switch (op){
            case 1:
                int stock1 = Helper.GetValidNumber("Ingrese el stock: ");
                this.cantidadStock = this.cantidadStock + stock1;
                break;
            case 2:
                int stock2 = Helper.GetValidNumber("Ingrese el stock: ");
                if (GetCantidadStock() < stock2){
                    System.out.println("El stock es menor a la cantidad");
                }else{
                    this.cantidadStock = this.cantidadStock - stock2;
                }
                break;
            default:
                System.out.println("Ingrese una opción correcta");

        }

    }

    @Override

    public String toString(){
        return "Codigo: " + GetCodigo() + " Nombre: " + GetNombre() + " Precio: " + GetPrecioUnitario()
                + " Stock: " + GetCantidadStock();
    }

    // zerocool


}
