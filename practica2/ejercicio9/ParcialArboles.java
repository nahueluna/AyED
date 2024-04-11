package practica2.ejercicio9;

import practica2.ejercicio1y2.BinaryTree;

public class ParcialArboles {
	
	public BinaryTree<SumAndDif> sumAndDif(BinaryTree<Integer> arbol) {
		BinaryTree<SumAndDif> newTree = new BinaryTree<SumAndDif>();
		
		if(!arbol.isEmpty())
			newTree = procesarArbolSumAndDif(arbol, 0, 0);
		
		return newTree;
	}
	
	private BinaryTree<SumAndDif> procesarArbolSumAndDif(BinaryTree<Integer> arbol, int datoSuma, int datoPadre) {
		BinaryTree<SumAndDif> newTree = new BinaryTree<SumAndDif>();
		
		if(arbol.hasLeftChild())
			newTree.addLeftChild(procesarArbolSumAndDif(arbol.getLeftChild(), (datoSuma + arbol.getData()), arbol.getData()));
		
		if(arbol.hasRightChild())
			newTree.addRightChild(procesarArbolSumAndDif(arbol.getRightChild(), (datoSuma + arbol.getData()), arbol.getData()));
		
		SumAndDif data = new SumAndDif((arbol.getData() + datoSuma), (arbol.getData() - datoPadre));
		
		newTree.setData(data);
		
		return newTree;
	}
}
