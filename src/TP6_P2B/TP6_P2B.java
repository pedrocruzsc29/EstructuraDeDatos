package TP6_P2B;


public class TP6_P2B {

    public static void main (String [] args){

        // RAMA DERECHA
        BinaryTree<Integer> nodo180 = new BinaryTree<Integer>(180, new BinaryTree<Integer>(160), null);
        BinaryTree<Integer> nodo150 = new BinaryTree<Integer>(150, new BinaryTree<Integer>(140), nodo180);

        // RAMA IZQUIERDA
        BinaryTree<Integer> nodo98 = new BinaryTree<Integer>(98, new BinaryTree<Integer>(97), null);
        BinaryTree<Integer> nodo95 = new BinaryTree<Integer>(95, new BinaryTree<Integer>(93), nodo98);
        BinaryTree<Integer> nodo50 = new BinaryTree<Integer>(50, new BinaryTree<Integer>(20), null);
        BinaryTree<Integer> nodo90 = new BinaryTree<Integer>(90, nodo50, nodo95);

        //ÁRBOL
        BinaryTree<Integer> nodo100 = new BinaryTree<Integer>(100,nodo90,nodo150);

        // DATOS
        System.out.println("ÁRBOL: " + nodo100);
        System.out.println("Recorridos: ");
        System.out.print("In order: "); nodo100.InOrder();
        System.out.println(" ");
        System.out.print("Pre order: "); nodo100.PreOrder();
        System.out.println(" ");
        System.out.print("Post order: "); nodo100.PostOrder();
        System.out.println(" ");
        System.out.print("Descending order: ");nodo100.DescendingOrder();
    }
}
