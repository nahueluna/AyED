package practica2.ejercicio6;

import practica2.ejercicio1y2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> binaryTree;
	
	public Transformacion(BinaryTree<Integer> binaryTree) {
		this.binaryTree = binaryTree;
	}
	
	public BinaryTree<Integer> getBinaryTree() {
		return this.binaryTree;
	}
	
	public BinaryTree<Integer> suma() {
		if(!getBinaryTree().isEmpty())
			procesarSumaNodos(getBinaryTree());
		
		return getBinaryTree();
	}
	
	private int procesarSumaNodos(BinaryTree<Integer> tree) {
		int sumaIzq = 0, sumaDer = 0, dataActual;
			
		if(tree.hasLeftChild())
			sumaIzq = procesarSumaNodos(tree.getLeftChild());
			
		if(tree.hasRightChild())
			sumaDer = procesarSumaNodos(tree.getRightChild());
				
			
		dataActual = tree.getData();
		tree.setData(sumaDer + sumaIzq);
			
		return (dataActual + sumaDer + sumaIzq);
			
	}
}
