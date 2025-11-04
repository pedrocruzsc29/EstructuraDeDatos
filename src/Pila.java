import Trabajo_PracticoN6.Ejercicio8.SimpleLinkedList;
    public class Pila<Element> {
        private SimpleLinkedList<Element> list;

        public Pila() {
            this.list = new SimpleLinkedList<Element>();
        }

        public void push(Element element) {
            this.list.addFirst(element);
        }

        public Element pop() {
            if (this.empty()) {
                throw new RuntimeException("La pila esta vacía...");
            }
            return this.list.removeFirst();
        }

        public Element peek() {
            if (this.empty()) {
                throw new RuntimeException("La pila esta vacía...");
            }
            return this.list.getFirst();
        }

        public boolean empty() {
            return this.list.size() == 0;
        }

        public int size() {
            return this.list.size();
        }

        @Override
        public String toString() {
            return list.toString();// llama al toString de la lista
        }
    }


}
