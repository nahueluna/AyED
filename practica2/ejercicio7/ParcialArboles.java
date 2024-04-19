package practica2.ejercicio7;

import practica2.ejercicio1y2.*;

public class ParcialArboles {
	private BinaryTree<Integer> binaryTree;
	
	public ParcialArboles(BinaryTree<Integer> binaryTree) {
		this.binaryTree = binaryTree;
	}
	
	public BinaryTree<Integer> getBinaryTree() {
		return this.binaryTree;
	}
	
	//Verifica si el subarbol izquierdo cuya raíz contiene num posee mayor cantidad de nodos con hijos únicos
	//que el subarbol derecho
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> root = buscarNodo(getBinaryTree(), num);;
		int subArbolIzq = -1, subArbolDer = -1;
		
		if(root != null) {
			subArbolIzq = procesarSubArbol(root.getLeftChild());
			subArbolDer = procesarSubArbol(root.getRightChild());
		}
		
		return subArbolIzq > subArbolDer;
	}
	
	//Busca y retorna la dirección de memoria del árbol cuya raíz contiene el dato num. Devulve null si no se halla
	//Se presupone que los datos numéricos de los nodos no se repiten
	private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> pTree, int num) {
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		BinaryTree<Integer> tempTree = null;
		boolean found = false;
		
		cola.enqueue(this.getBinaryTree());
		
		while(!cola.isEmpty() && !found) {
			tempTree = cola.dequeue();
			
			if(tempTree.getData().equals(num))
				found = true;
			
			else {
				if(tempTree.hasLeftChild())
					cola.enqueue(tempTree.getLeftChild());
				
				if(tempTree.hasRightChild())
					cola.enqueue(tempTree.getRightChild());
			}
		}
		
		if(found) return tempTree;
		else return null;
	}
	
	//Toma un subarbol y cuenta la cantidad de nodos con hijos únicos (nodos de grado 1)
	private int procesarSubArbol(BinaryTree<Integer> subTree) {
		int cantUnico = 0;
			
		if(subTree.hasLeftChild() ^ subTree.hasRightChild())
			cantUnico += 1;
			
		if(subTree.hasLeftChild())
			cantUnico += procesarSubArbol(subTree.getLeftChild());
			
		if(subTree.hasRightChild())
			cantUnico += procesarSubArbol(subTree.getRightChild());
			
		
		return cantUnico;
	}
}
