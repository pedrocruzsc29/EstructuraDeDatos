package TP0_P5;

public class TP0_P5 {

    // GENERADOR NUMEROS A Y B
    public static int Generator(){
        return 1 + (int) (Math.random() * 100);
    }
    // VALIDAR NUMERO MAYOR QUE OTRO
    public static boolean Validate(int a,int b){
        return a < b;
    }
    // AUTOMATIC FOR
    public static void Automatic_For(int a, int b, int c){
        int suma = 0; int cont_paso = 0; int prom = 0;
        for (int i = a;i < b; i = i + c) {
            System.out.println(i);
            cont_paso = cont_paso + 1;
            suma = suma + i;
        }
        System.out.println("Promedio: " + (suma / cont_paso));
    }

    // CONTROL PRINCIPAL
    public static void main (String[] args){
        int num1 = Generator();
        int num2 = Generator();
        boolean band = false;
        do{
            System.out.println("#### FOR ####");
            if (Validate(num1,num2)){ // Si el valor a es menor a b, se procede a operar
                System.out.println("Inicio: " + num1);
                System.out.println("Final: " + num2);
                int num3 = 2 + (int) (Math.random() * 7); // El valor paso es generado
                System.out.println("Paso: " + num3);
                System.out.println("############");
                Automatic_For(num1,num2,num3);
                band = true; // Evita la repetición
            }else{
                System.out.println("Inicio: " + num1);
                System.out.println("Final: " + num2);
                System.out.println("############");
                System.out.println("Inicio mayor a final. Regenerando...");
                num2 = Generator();
            }
        }while(!band);

    }
}
