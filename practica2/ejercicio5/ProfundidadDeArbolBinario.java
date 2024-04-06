package practica2.ejercicio5;

import practica2.ejercicio1y2.*;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> binaryTree;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> binaryTree) {
		this.binaryTree = binaryTree;
	}
		
	public BinaryTree<Integer> getBinaryTree() {
		return binaryTree;
	}

	public void setBinaryTree(BinaryTree<Integer> binaryTree) {
		this.binaryTree = binaryTree;
	}

	public int sumaElementosProfundidad(int p) {
		if(getBinaryTree().isEmpty()) { return 0; }
		
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		BinaryTree<Integer> tree;
		int nivel = 0, sumaNodos = 0;
		
		cola.enqueue(getBinaryTree());
		cola.enqueue(null);
		
		while(!cola.isEmpty() && nivel <= p) {
			tree = cola.dequeue();
			
			if(tree != null) {				
				if(nivel == p)
					sumaNodos += tree.getData();
			
				if(tree.hasLeftChild())
					cola.enqueue(tree.getLeftChild());
				
				if(tree.hasRightChild())
					cola.enqueue(tree.getRightChild());
			}
			else if(!cola.isEmpty()) {
				cola.enqueue(null);
				nivel++;
			}

		}
		
		return sumaNodos;
	}
}
