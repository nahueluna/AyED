package practica2.ejercicio9;

import practica2.ejercicio1y2.BinaryTree;

public class ParcialArboles {
	
	public BinaryTree<int[]> sumAndDif(BinaryTree<Integer> arbol) {
		BinaryTree<int[]> newTree = new BinaryTree<int[]>();
		
		if(!arbol.isEmpty())
			newTree = procesarArbolSumAndDif(arbol, 0, 0);
		
		return newTree;
	}
	
	private BinaryTree<int[]> procesarArbolSumAndDif(BinaryTree<Integer> arbol, int datoSuma, int datoPadre) {
		BinaryTree<int[]> newTree = new BinaryTree<int[]>();
		
		if(arbol.hasLeftChild())
			newTree.addLeftChild(procesarArbolSumAndDif(arbol.getLeftChild(), (datoSuma + arbol.getData()), arbol.getData()));
		
		if(arbol.hasRightChild())
			newTree.addRightChild(procesarArbolSumAndDif(arbol.getRightChild(), (datoSuma + arbol.getData()), arbol.getData()));
		
		int[] data = new int[2];
		data[0] = arbol.getData() + datoSuma;
		data[1] = arbol.getData() - datoPadre;
		
		newTree.setData(data);
		
		return newTree;
	}
}
