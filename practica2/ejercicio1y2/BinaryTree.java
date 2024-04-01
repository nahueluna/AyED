package practica2.ejercicio1y2;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	//Constructor vacio
	public BinaryTree() {
		
	}
	
	//Construye el árbol con el dato y ambos hijos nulos
	public BinaryTree(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	//Retorna data
	public T getData() {
		return this.data;
	}
	
	//Setea data
	public void setData(T data) {
		this.data = data;
	}
	
	//Retorna hijo izquierdo
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	//Retorna hijo derecho
	public BinaryTree<T> getRightChild() {
		return rightChild;
	}
	
	//Crea hijo izquierdo
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	//Crea hijo derecho
	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}
	
	//Elimina hijo izquierdo
	public void removeLeftChild() {
		this.leftChild = null;
	}
	
	//Elimina hijo derecho
	public void removeRightChild() {
		this.rightChild = null;
	}
	
	//Indica si el árbol está vacío
	public boolean isEmpty() {
		return (this.isLeaf() && this.getData() == null);
	}
	
	//Indica si el árbol no tiene hijos
	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
	
	//Indica si tiene hijo izquierdo
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	//Indica si tiene hijo derecho
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
	
	@Override
	public String toString() {
		return this.getData().toString();
	}
	
	//Retorna cantidad de hojas del árbol
	public int contarHojas() {
		int leftLeaf = 0, rightLeaf = 0;
		
		if(!this.isEmpty()) {
			
			if(this.isLeaf())
				return 1;
			
			else {
				
				if(this.hasLeftChild())
					leftLeaf = this.getLeftChild().contarHojas();
				
				if(this.hasRightChild())
					rightLeaf = this.getRightChild().contarHojas();
				
				return leftLeaf + rightLeaf;
			}
		}
		
		else
			return 0;
	}
	
	//Retorna árbol espejo (todos sus nodos cambiados 
	//de derecha a izquierda y viceversa
	public BinaryTree<T> espejo() {
		if(!this.isEmpty()) {
			BinaryTree<T> reflectedTree = new BinaryTree<T>(this.data);
			
			if(this.hasLeftChild())
				reflectedTree.addRightChild(this.getLeftChild().espejo());
			
			if(this.hasRightChild())
				reflectedTree.addLeftChild(this.getRightChild().espejo());
			
			return reflectedTree;
		}
		
		else
			return null;
	}
	
	//Imprime recorrido por niveles entre n y m
	public void entreNiveles(int n, int m) {
		if(this.isEmpty() || n < 0 || m < n) return;
		
		int nivel = 0, elementosEncolados;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		BinaryTree<T> tree;
		
		cola.enqueue(this);
		
		while(!cola.isEmpty() && nivel <= m) {
			elementosEncolados = cola.size();
			
			for(int i = 0; i < elementosEncolados; i++) {
				tree = cola.dequeue();
				
				if(nivel >= n)
					System.out.println(tree.toString());
					
				if(tree.hasLeftChild())
					cola.enqueue(tree.getLeftChild());
					
				if(tree.hasRightChild())
					cola.enqueue(tree.getRightChild());
				
			}
						
			nivel++;
		}
		
		//Vacía la cola
		for(int h = 0; h < cola.size(); h++)
			cola.dequeue();
	}
	
	public void printTree() {
		if(this.isEmpty()) return;
		
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		BinaryTree<T> tree;
		
		cola.enqueue(this);
		
		while(!cola.isEmpty()) {
			
			tree = cola.dequeue();
			
			System.out.println(tree.toString());
					
			if(tree.hasLeftChild())
				cola.enqueue(tree.getLeftChild());
					
			if(tree.hasRightChild())
				cola.enqueue(tree.getRightChild());
		}
	}
	
}
