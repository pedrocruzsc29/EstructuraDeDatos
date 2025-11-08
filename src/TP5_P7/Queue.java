package TP5_P7;

public class Queue <ELEMENT> {

    // ATRIBUTOS

    private SimpleLinkedList <ELEMENT> list;

    // CONSTRUCTOR PREDETERMINADO

    public Queue(){
        this.list = new SimpleLinkedList<ELEMENT>();
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Queue(int n, ELEMENT element) {
        this.list = new SimpleLinkedList<ELEMENT>();
        for (int i = 0; i < n; i++) {
            this.list.addLast(element);
        }
    }

    // MÉTODOS


    // AGREGAR ELEMENTOS
    public void add(ELEMENT element){
        this.list.addLast(element);
    }

    // ELEMENT -> OFFERS THE FIRST ELEMENT

    public ELEMENT element(){
        if (this.list.size() == 0){
            throw new IllegalStateException("Empty queue...");
        }
        return this.list.getFirst();
    }

    // OFFER -> BOOLEAN

    public boolean offer (ELEMENT element){
        try{
            this.list.addLast(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // PEEK -> OFFERS THE FIRST ELEMENT

    public ELEMENT peek(){
        if (this.list.size() == 0){
            return null;
        }
        return this.list.getFirst();
    }

    // PULL
    public ELEMENT pull(){
        if (isEmpty()){
            return null;
        }
        return this.list.removeFirst();
    }

    // IS EMPTY

    public boolean isEmpty(){
        return this.list.size() == 0;
    }

    // REMOVE

    public ELEMENT remove(){
        if (this.list.size() == 0){
            throw new IllegalStateException("Empty queue...");
        }
        return this.list.removeFirst();
    }

    // SIZE

    public int size(){
        return this.list.size();
    }

    // TO ARRAY
    public Object[] toArray() {
        Object[] array = new Object[this.list.size()]; // Se le pasa la dimensión de la lista
        int i = 0;
        for (ELEMENT element : this.list) { // Se recorre la lista
            array[i++] = element; // Se van asignando los elementos de la lista al arreglo
        }
        return array;
    }
}

// Autor: zerocool