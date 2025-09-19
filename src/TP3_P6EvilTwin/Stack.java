package TP3_P6EvilTwin;

public class Stack<ELEMENT> {

    private final int maximoTamanio = 10;
    private ELEMENT[] datos;
    private int cuenta;

    public Stack() {
        this.datos = (ELEMENT[]) new Object[this.maximoTamanio];
        this.cuenta = 0;
    }

    public void push(ELEMENT elemento) {
        if (this.isFull()) {
            throw new RuntimeException("La pila est� llena...");
        }
        this.datos[this.cuenta] = elemento;
        ++this.cuenta;
    }

    public ELEMENT pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila est� vac�a...");
        }
        --this.cuenta;
        return this.datos[this.cuenta];
    }

    public ELEMENT peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila est� vac�a...");
        }
        return this.datos[this.cuenta - 1];
    }

    public boolean isEmpty() {
        return this.cuenta <= 0;
    }

    public boolean isFull() {
        return this.cuenta >= this.datos.length;
    }

    public int count() {
        return this.cuenta;
    }

}