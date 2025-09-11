package TP2_P6;

import java.util.ArrayList;

public class TP2_P6 {


    // MOSTRAR CONTACTOS
    public static void ShowContacts (ArrayList<Contacto> contacts){
        for (int i = 0; i < contacts.size(); i++){
            System.out.print("Contacto N°" + (i+1));
            System.out.println(": Nombre " + contacts.get(i).GetName() + " Telefono: " +
                    contacts.get(i).GetTelephone() + " Email: " + contacts.get(i).GetMail());
        }
    }


    // BUSCAR CONTACTO REPETIDO
    public static boolean SearchRepeated(ArrayList<Contacto> contact, String name){
        boolean band = false;
        for (Contacto contacto : contact) {
            if (name.equals(contacto.GetName())) {
                band = true;
                break;
            }
        }
        return band;

    }

    // CARGAR CONTACTOS
    public static ArrayList<Contacto> LoadContacts (ArrayList<Contacto> contacts){
        System.out.println("### CARGAR CONTACTOS ###");
        int cant = Helper.GetValidNumber("Ingrese la cantidad de contactos: ");
        for (int i = 0; i < cant;i++){
            System.out.println("Contacto N°" + (i+1));
            String name;
            do{
                name = Helper.GetValidString("Nombre: ");
                if (SearchRepeated(contacts,name)) {
                    System.out.println("Nombre repetido!");
                }
            }while(SearchRepeated(contacts,name));
                int telefono = Helper.GetValidPhoneNumber("Telefono: ");
                String mail = Helper.GetValidString("Email: "); // Se puede mejorar validando que tenga @
                contacts.add(new Contacto(name,telefono,mail));

        }
        return contacts;
    }

    // BUSCAR CONTACTO POR NOMBRE

    public static int SearchByName(ArrayList<Contacto> contact){
        String name = Helper.GetValidString("Nombre a buscar: ");
        int pos = -1;
        for (int i = 0; i < contact.size();i++){
            if (name.equals(contact.get(i).GetName())){
                pos = i;
            }
        }
        return pos;
    }

    // MODIFICAR DATOS (TELEFONO O MAIL)

    public static void ModifyData(){

    }

    public static void main (String[] args){
        int op = 0;
        int Modify = 0;

        ArrayList<Contacto> contact = new ArrayList<>();

        do{
            System.out.println("### AGENDA ###");
            System.out.println("1) Cargar contactos");
            System.out.println("2) Ver agenda");
            System.out.println("3) Buscar contacto");
            System.out.println("4) Modificar contacto");
            System.out.println("5) Eliminar contacto");
            System.out.println("6) Salir");
            op = Helper.GetValidNumber("Elija una opción: ");
            switch (op){
                case 1:
                    contact = LoadContacts(contact);
                    System.out.println("Contactos cargados...");
                    break;
                case 2:
                    if (!contact.isEmpty()){
                        System.out.println("### CONTACTOS ###");
                        ShowContacts(contact);
                    }else {
                        System.out.println("No se cargaron contactos...");
                    }
                    break;
                case 3:
                    if (!contact.isEmpty()){
                        int pos = SearchByName(contact);
                        if (pos == -1){
                            System.out.println("No se encontro el contacto...");
                        }else{
                            System.out.println("Contacto encontrado!");
                            System.out.println("Contacto N°"+ (pos+1) + " - "+ contact.get(pos));
                        }
                    }else{
                        System.out.println("No se cargaron contactos...");
                    }
                    break;
                case 4:
                    if (!contact.isEmpty()){
                        System.out.println("### MODIFICAR DATOS ###");
                        int pos2 = SearchByName(contact);
                        if (pos2 != -1){
                            Modify = Helper.ChooseData();
                            if (Modify == 1){
                                contact.get(pos2).SetTelephone(Helper.GetValidPhoneNumber("Ingrese un numero nuevo: "));
                                System.out.println("Dato modificado!");
                            }else{
                                contact.get(pos2).SetMail(Helper.GetValidString("Ingrese un nuevo email: "));
                                System.out.println("Dato modificado!");
                            }
                        }else{
                            System.out.println("No se encontro!");
                        }
                    }else{
                        System.out.println("No se cargaron contactos...");
                    }
                    break;
                case 5:
                    if (!contact.isEmpty()){
                        System.out.println("### ELIMINAR CONTACTO ###");
                        int posName = SearchByName(contact);
                        if (posName != -1){
                            contact.remove(posName);
                            System.out.println("Contacto eliminado!");
                        }else{
                            System.out.println("No se encontro el nombre...");
                        }
                    }else{
                        System.out.println("No se cargaron contactos...");
                    }
                    break;
                default:
                    System.out.println("Elija una opción correcta!");

            }
        }while(op!=6);
    }
}
