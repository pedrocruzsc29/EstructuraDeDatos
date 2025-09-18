package TP3_P6;
public class Stack<T> {
    private final int maxSize = 100;
    private T[] data;
    private int count;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        data = (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public Stack() {
        this.data = (T[]) new Object[maxSize];
        this.count = 0;
    }
    // INSERT ELEMENT AT THE TOP - PUSH
    public T push(T element) {
        if (this.size() >= this.data.length) {
            throw new RuntimeException("Stack Full");
        }
        this.data[this.count] = element;
        ++this.count;
        return element;
    }

    // DELETE AND RETURN ELEMENT FROM THE TOP - POP
    public T pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack Vació");
        }
        T element = this.data[this.count - 1];
        --this.count;
        return element;
    }

    // GET ELEMENT FROM THE TOP WITHOUT DELETION - PEEK
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack lleno");
        }
        T element = this.data[this.count - 1];
        return element;
    }

    // GET ELEMENT IN AN SPECIFIED POSITION WITHOUT DELETION - GET
    public T get(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return this.data[index];
    }

    // VERIFY IF ELEMENT EXISTS
    public boolean exist(T element) {
        boolean founded = false;

        for (int i = 0; i < size(); i++) {
            if (get(i).equals(element)) {
                founded = true;
                break;
            }
        }
        return founded;
    }

    // VERIFY IF THE STACK IS EMPTY
    public boolean isEmpty() {
        return this.count <= 0;
    }

    // RETURN STACK'S SIZE
    public int size() {
        return this.count;
    }

}
