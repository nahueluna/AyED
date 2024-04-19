package practica2.ejercicio8;

import practica2.ejercicio1y2.BinaryTree;

public class ParcialArboles {

	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean isPrefix = false;
		
		if(!arbol1.isEmpty() && !arbol2.isEmpty())
			isPrefix = procesarArbolesPrefijo(arbol1, arbol2, true);
		
		return isPrefix;
	}
	
	private boolean procesarArbolesPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2, boolean continuar) {
		//si arbol2 == null es true, la segunda condicion no es evaluada
		if(arbol2 == null || !arbol1.getData().equals(arbol2.getData()))
			continuar = false;
			
		if(arbol1.hasLeftChild() && continuar)
			continuar = procesarArbolesPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild(), continuar);
			
		if(arbol1.hasRightChild() && continuar)
			continuar = procesarArbolesPrefijo(arbol1.getRightChild(), arbol2.getRightChild(), continuar);
			
		return continuar;
	}
}
