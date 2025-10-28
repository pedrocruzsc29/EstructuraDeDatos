package TP6_P2A;

public class TP6_P2A {

    public static void main (String[]args){
        // RAMA DERECHA
        BinaryTree<Integer> nodo90 = new BinaryTree<Integer>(90,null, new BinaryTree<Integer>(95));
        BinaryTree<Integer> nodo80 = new BinaryTree<Integer>(80, new BinaryTree<Integer>(75), nodo90);

        // RAMA IZQUIERDA

        BinaryTree<Integer> nodo50 = new BinaryTree<Integer>(50, null, new BinaryTree<Integer>(55));
        BinaryTree<Integer> nodo20 = new BinaryTree<Integer>(20, new BinaryTree<Integer>(10), null);
        BinaryTree<Integer> nodo40 = new BinaryTree<Integer>(40,nodo20,nodo50);

        // ÁRBOL
        BinaryTree<Integer> nodo60 = new BinaryTree<Integer>(60,nodo40,nodo80);

        System.out.println("ÁRBOL: " + nodo60);

        System.out.println("Recorridos: ");
        System.out.print("In order: "); nodo60.InOrder();
        System.out.println(" ");
        System.out.print("Pre order: "); nodo60.PreOrder();
        System.out.println(" ");
        System.out.print("Post order: "); nodo60.PostOrder();
        System.out.println(" ");
        System.out.print("Descending order: ");nodo60.DescendingOrder();


    }


}
