package practica2.ejercicio3;

import java.util.LinkedList;

import practica2.ejercicio1y2.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> binaryTree;
	
	public ContadorArbol(BinaryTree<Integer> binaryTree) {
		this.binaryTree = binaryTree;
	}
	
	public BinaryTree<Integer> getBinaryTree() {
		return binaryTree;
	}


	public void setBinaryTree(BinaryTree<Integer> binaryTree) {
		this.binaryTree = binaryTree;
	}


	//Inorden
	public LinkedList<Integer> numerosParesA() {
		LinkedList<Integer> listaPares = new LinkedList<Integer>();
		
		procesarParesA(getBinaryTree(), listaPares);
		
		return listaPares;
	}
	
	private void procesarParesA(BinaryTree<Integer> tree, LinkedList<Integer> pares) {
		if(!tree.isEmpty()) {
			
			if(tree.hasLeftChild()) {
				procesarParesA(tree.getLeftChild(), pares);
			}
			
			if(tree.getData() % 2 == 0) {
				pares.add(tree.getData());
			}
			
			if(tree.hasRightChild()) {
				procesarParesA(tree.getRightChild(), pares);
			}
			
		}
	}
	
	//Postorden
	public LinkedList<Integer> numerosParesB() {
		LinkedList<Integer> listaPares = new LinkedList<Integer>();
		
		procesarParesB(getBinaryTree(), listaPares);
		
		return listaPares;
	}
	
	private void procesarParesB(BinaryTree<Integer> tree, LinkedList<Integer> pares) {
		if(!tree.isEmpty()) {
			
			if(tree.hasLeftChild()) {
				procesarParesA(tree.getLeftChild(), pares);
			}
			
			if(tree.hasRightChild()) {
				procesarParesA(tree.getRightChild(), pares);
			}
			
			if(tree.getData() % 2 == 0) {
				pares.add(tree.getData());
			}
			
		}
	}
}
