package TP4_P2;

public class QueueVelocidad<ELEMENT> {

    //region Constants
    private final static Integer defaulDimension = 10;

    //endregion
    //region Attributes
    private ELEMENT[] data;
    private int head;
    private int tail;

    //endregion
    //region Constructors
    public QueueVelocidad() {
        this(QueueVelocidad.defaulDimension);
    }

    public QueueVelocidad(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
    }
    //endregion

    //region Queue Internal Methods
    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }
    //endregion

    //region Queue Methods

    /**
     * <b>Operacion EnQueue en la teoría de Estructura de Datos</b>
     * <br>
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning true upon
     * success and throwing an IllegalStateException if no space is currently
     * available.
     */
    public boolean add(ELEMENT element) {

        if (this.isFull()) {
            throw new IllegalStateException("Cola llena ...");
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);

        return true;
    }

    /**
     * <b>Operacion peek en la teoría de Estructura de Datos</b>
     * <br>
     * Retrieves, but does not remove, the head of this queue. This method differs
     * from peek only in that it throws an exception if this queue is empty.
     */
    public ELEMENT element() {

        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía ...");
        }

        return this.data[this.head];
    }

    /**
     * <b>Operacion EnQueue en la teoría de Estructura de Datos</b>
     * <br>
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions. When using a
     * capacity-restricted queue, this method is generally preferable to add(E),
     * which can fail to insert an element only by throwing an exception.
     **/
    public boolean offer(ELEMENT element) {

        if (this.isFull()) {
            return false;
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);

        return true;
    }

    // Retrieves, but does not remove, the head of this queue, or returns null if
    // this queue is empty.
    public ELEMENT peek() {
        if (this.isEmpty()) {
            return null;
        }

        return this.data[this.head];
    }

    /**
     * <b>Operacion DeQueue en la teoría de Estructura de Datos</b>
     * <br>
     * Retrieves and removes the head of this queue, or returns null if this queue
     * is empty.
     **/
    public ELEMENT pull() {
        if (this.isEmpty()) {
            return null;
        }

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);

        return result;
    }

    /**
     * <b>Operacion DeQueue en la teoría de Estructura de Datos</b>
     * <br>
     * Retrieves and removes the head of this queue. This method differs from poll()
     * only in that it throws an exception if this queue is empty.
     **/
    public ELEMENT remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía ...");
        }

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);

        return result;
    }
    //endregion

    //region Override Object basic methods
    @Override
    public String toString() {

        if (this.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.data[this.head].toString());

        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", ").append(this.data[pos].toString());
        }

        sb.append("]");
        return sb.toString();
    }
    //endregion

    //region Collection Methods
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public boolean isFull() {
        return this.head == next(this.tail);
    }


    /**
     * Debido a que se elimino el atributo `count`
     * entonces se modifica el metodo size para que funcione
     * correctamente, si `tail` es mayor que `head` la diferencia es directa
     * si es menor (es decir la cola ha dado la vuelta) se ajusta la formula
     *
     * @return int tamaño del contador
     **/
    public int size() {
        if (this.tail >= this.head) {
            return this.tail - this.head;
        } else {
            return this.data.length - this.head + this.tail;
        }
    }


}
