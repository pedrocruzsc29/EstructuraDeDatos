package TP1_P5;

public class Auto extends Vehiculo{

    // ATRIBUTOS
    private int numeroPuertas;
    private String tipoCombustible;
    private double capacidadBaulLitros;

    // CONSTRUCTOR PREDETERMINADO

    public Auto(){
        super(); // Se utiliza para heredar los atributos de la clase vehículo
        this.numeroPuertas = 0;
        this.tipoCombustible = "a definir";
        this.capacidadBaulLitros = 0.0;
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Auto(String marca, int model, int year, double precio,
                int numeroPuertas, String tipoCombustible, double capacidadBaulLitros){
        super(marca,model,year,precio);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
        this.capacidadBaulLitros = capacidadBaulLitros;
    }

    // GETTERS Y SETTERS

    public int getNumeroPuertas(){
        return this.numeroPuertas;
    }
    public void setNumeroPuertas(int numeroPuertas){
        this.numeroPuertas = numeroPuertas;
    }

    public String getTipoCombustible(){
        return this.tipoCombustible;
    }
    public void setTipoCombustible(String tipoCombustible){
        this.tipoCombustible = tipoCombustible;
    }

    public double getCapacidadBaulLitros(){
        return this.capacidadBaulLitros;
    }
    public void setCapacidadBaulLitros(double capacidadBaulLitros){
        this.capacidadBaulLitros = capacidadBaulLitros;
    }

    // CANTIDAD DE PUERTAS

    public boolean esFamiliar(){
        return getNumeroPuertas() == 4 || getNumeroPuertas() == 5;
    }

    // VERIFICAR EL TIPO DE COMBUSTIBLE

    public boolean esEcoAmigable(){
        return getTipoCombustible().equals("Eléctrico") || getTipoCombustible().equals("Híbrido");

    }

}
