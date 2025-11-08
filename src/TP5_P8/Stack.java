package TP5_P8;

public class Stack <ELEMENT> {

    // ATRIBUTOS

    private SimpleLinkedList <ELEMENT> list;

    // CONSTRUCTOR PREDETERMINADO

    public Stack(){
        this.list = new SimpleLinkedList<ELEMENT>();
    }

    // CONSTRUCTOR PARAMETRIZADO

    public Stack(int n, ELEMENT element){
        this.list = new SimpleLinkedList<ELEMENT>();
        for (int i = 0; i < n; i++) {
            this.list.addFirst(element);
        }
    }

    // MÉTODOS

    // PUSH -> ADD TO THE FIRST PLACE (LIFO)

    public void push(ELEMENT element){
        this.list.addFirst(element);
    }

    // POP -> REMOVE FROM THE FIRST PLACE

    public ELEMENT pop(){
        if (this.list.size() == 0){
            throw new IllegalStateException("Empty stack...");
        }
        return this.list.removeFirst();
    }

    // IS EMPTY

    public boolean isEmpty(){
        return this.list.size() == 0;
    }

    // PEEK

    public ELEMENT peek(){
        if (this.list.size() == 0){
            throw new IllegalStateException("Empty stack...");
        }
        return this.list.getFirst();
    }

    // SIZE

    public int size(){
        return this.list.size();
    }
}
