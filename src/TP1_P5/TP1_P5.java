package TP1_P5;

public class TP1_P5 {




    // SOLICITAR DATOS DE VEHÍCULOS

    // CARGAR AUTO

    public static Auto cargarAuto(){
        String marca = Helper.getValidStrings("Marca: ");
        int model = Helper.getValidIntegers("Modelo: ");
        int year = Helper.getValidIntegers("Año de Fabricación: ");
        double precio = Helper.getValidDouble("Precio: ");
        int numeroPuertas = Helper.getValidIntegers("Número de Puertas: ");
        String tipoCombustible = Helper.getCombustible();
        double capacidadLitros = Helper.getValidDouble("Capacidad de Lts: ");
        return new Auto(marca,model,year, precio, numeroPuertas,tipoCombustible,capacidadLitros);
    }

    // CARGAR MOTO

    public static Moto cargarMoto(){
        String marca = Helper.getValidStrings("Marca: ");
        int model = Helper.getValidIntegers("Modelo: ");
        int year = Helper.getValidIntegers("Año de Fabricación: ");
        double precio = Helper.getValidDouble("Precio: ");
        int cilindrada = Helper.getValidIntegers("Cilindrada: ");
        String tipoManillar = Helper.getManillar();
        return new Moto(marca,model,year,precio,cilindrada,tipoManillar);
    }

    // CARGAR CAMIÓN

    public static Camion cargarCamion(){
        String marca = Helper.getValidStrings("Marca: ");
        int model = Helper.getValidIntegers("Modelo: ");
        int year = Helper.getValidIntegers("Año de Fabricación: ");
        double precio = Helper.getValidDouble("Precio: ");
        double capacidadCarga = Helper.getValidDouble("Capacidad de Carga: ");
        int numeroEjes = Helper.getValidIntegers("Número de Ejes: ");
        String bodyType = Helper.getBodyType();
        return new Camion(marca,model,year,precio,capacidadCarga,numeroEjes,bodyType);

    }


    public static void main (String [] args){
        Auto auto = new Auto();
        Moto moto = new Moto();
        Camion camion = new Camion();




    }





}
