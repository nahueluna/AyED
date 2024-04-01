package practica2.ejercicio4;

import practica2.ejercicio1y2.BinaryTree;

public class RedBinariaLlena {
	
	/*
	 * Se recorre hasta la hoja ubicada a la izquierda del árbol.
	 * Luego se compara su valor con su hermana en la derecha y
	 * se toma el mayor de ellos, sumandolo a su nodo padre.
	 * Se procede de la misma forma con cada rama de un nodo padre,
	 * tomando ambos hermanos, quedandose con el mayor y sumandolo
	 * al nodo padre. De esta forma, cuando se vuelve a la raíz, se
	 * tiene el mayor retardo de todo el árbol (producto de comparar
	 * las sumatorias de toda la rama izquierda con la derecha, por
	 * partes (es decir, primero se compara las hojas hermanas, luego
	 * sus nodos padres y así sucesivamente)).
	 */
	
	public static int retardoEnvio(BinaryTree<Integer> tree) {
		int retardoIzq = 0, retardoDer = 0;
		
		if(tree.hasLeftChild()) {
			retardoIzq = retardoEnvio(tree.getLeftChild());
		}
		
		if(tree.hasRightChild()) {
			retardoDer = retardoEnvio(tree.getRightChild());
		}
		
		return (Math.max(retardoIzq, retardoDer) + tree.getData());
	}
	
}
