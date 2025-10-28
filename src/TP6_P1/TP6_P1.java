package TP6_P1;

public class TP6_P1 {

    public static void main (String [] args){

        // RAMA DERECHA
        BinaryTree<Integer> nodo550 = new BinaryTree<Integer>(550, null, new BinaryTree<Integer>(580));
        BinaryTree<Integer> nodo600 = new BinaryTree<Integer>(600,nodo550,null);
        BinaryTree<Integer> nodo500 = new BinaryTree<Integer>(500,null,nodo600);
        BinaryTree<Integer> nodo450 = new BinaryTree<Integer>(450, new BinaryTree<Integer>(390),nodo500);

        // RAMA IZQUIERDA

        BinaryTree<Integer> nodo130 = new BinaryTree<Integer>(130, new BinaryTree<Integer>(90), null);
        BinaryTree<Integer> nodo290 = new BinaryTree<Integer>(290, null, new BinaryTree<Integer>(295));
        BinaryTree<Integer> nodo250 = new BinaryTree<Integer>(250,nodo130,nodo290);

        // ÁRBOL
        BinaryTree<Integer> nodo320 = new BinaryTree<Integer>(320,nodo250,nodo450);


        // DATOS
        System.out.println("Cantidad de nodos: " + nodo320.NodeCount());
        System.out.println("Cantidad de hojas: " + nodo320.LeafCount());
        System.out.println("Cantidad de nodos internos: " + nodo320.InternalCount());
        System.out.println("Nivel maximo: " + nodo320.MaxLevel());
        System.out.println("Altura del árbol: " + nodo320.Height());
        System.out.println("Orden Descendente");
        nodo320.DescendingOrder();
        System.out.println(" ");
        System.out.println("ÁRBOL (Representación Parentizada: " + nodo320);

    }
}
