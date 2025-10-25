package TP6_P1;

public class TP6_P1 {

    public static void main (String [] args){

        BinaryTree<Integer> nodo450 = new BinaryTree<Integer>(450, new BinaryTree<Integer>(390), new BinaryTree<Integer>(500, null, new BinaryTree<Integer>(600, new BinaryTree<Integer>(550, null, new BinaryTree<Integer>(580)),null)));
        BinaryTree<Integer> nodo250 = new BinaryTree<Integer>(250,new BinaryTree<Integer>(130, new BinaryTree<Integer>(90),null),new BinaryTree<Integer>(290, null, new BinaryTree<Integer>(295)));
        BinaryTree<Integer> nodo320 = new BinaryTree<Integer>(320,nodo250,nodo450);

        System.out.println("Cantidad de nodos: " + nodo320.NodeCount());
        System.out.println("Cantidad de hojas: " + nodo320.LeafCount());
        System.out.println("Cantidad de nodos internos: " + nodo320.InternalCount());
        System.out.println("Altura del árbol: " + nodo320.Height());
        System.out.println("Orden Descendente");
        nodo320.DescendingOrder();
        System.out.println(" ");
        System.out.println("ÁRBOL: ");
        System.out.println(nodo320);



    }
}
