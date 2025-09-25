package TP3_P4;

public class TP3_P4 {


    // CARGAR DATOS
    public static Evento LoadData(){
        String tipo = Helper.GetType();
        String desc = Helper.GetValidString("Descripción: ");
        int code = Helper.GetValidNumber("Código: ");
        return new Evento(tipo,desc,code);
    }

    // AGREGAR EVENTO A STACK
    public static void LoadStack(Stack <Evento> stack, Evento event){
        String resp = "S";
        do{
            stack.push(LoadData());
            resp = Helper.GetValidString("Desea cargar más eventos? (S/N): ");
        }while(resp.equals("s") || resp.equals("S"));
    }

    // MOSTRAR EVENTOS

    public static void ShowEvents(Stack <Evento> stack){
        Stack <Evento> aux_event = new Stack<Evento>();
        while(!stack.isEmpty()){
            Evento event = stack.pop();
        }
    }



    public static void main (String [] args){

        System.out.println("### EVENTOS ###");

    }


}


// zerocool