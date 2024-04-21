package practica3.ejercicio01_03_05;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

import practica1.ejercicio08.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		Queue<GeneralTree<T>> cola = new Queue<>();
		GeneralTree<T> aux_tree;
		int nivel = 0;
		
		cola.enqueue(this);
		cola.enqueue(null);
		
		while(!cola.isEmpty()) {
			aux_tree = cola.dequeue();
			
			if(aux_tree != null) {
				List<GeneralTree<T>> children = aux_tree.getChildren();
				for(GeneralTree<T> child: children)
					cola.enqueue(child);
			}
			else if(!cola.isEmpty()) {
				cola.enqueue(null);
				nivel++;
			}
		}
		
		return nivel;
	}
	
	public int nivel(T dato){
		Queue<GeneralTree<T>> cola = new Queue<>();
		GeneralTree<T> aux_tree;
		int nivel = 0;
		boolean found = false;
		
		cola.enqueue(this);
		cola.enqueue(null);
		
		while(!cola.isEmpty() && !found) {
			aux_tree = cola.dequeue();
			
			if(aux_tree != null) {
				if(aux_tree.getData().equals(dato))
					found = true;
				
				if(!found) {
					List<GeneralTree<T>> children = aux_tree.getChildren();
					for(GeneralTree<T> child: children)
						cola.enqueue(child);
				}
			}
			else if(!cola.isEmpty()) {
				cola.enqueue(null);
				nivel++;
			}
		}
		
		if(found) return nivel;
		else return -1;
	  }

	public int ancho(){
		Queue<GeneralTree<T>> cola = new Queue<>();
		GeneralTree<T> aux_tree;
		int cant_nodos = 0, max = -1;
		
		cola.enqueue(this);
		cola.enqueue(null);
		
		while(!cola.isEmpty()) {
			aux_tree = cola.dequeue();
			
			if(aux_tree != null) {
				cant_nodos++;
				
				List<GeneralTree<T>> children = aux_tree.getChildren();
				for(GeneralTree<T> child: children)
					cola.enqueue(child);
			}
			else {
				max = maximo(max, cant_nodos);
				cant_nodos = 0;
				if(!cola.isEmpty())
					cola.enqueue(null);
			}
		}
		
		return max;
	}
	
	//Se presupone que a y b aparecen una sola vez en la estructura
	public boolean esAncestro(T a, T b) {
		boolean isAncestor = false;
		
		if(!this.isEmpty()) {
			GeneralTree<T> node_a = buscarNodo(a);
			isAncestor = buscarAncestro(node_a, b);
		}
		
		return isAncestor;
		
	}
	
	private GeneralTree<T> buscarNodo(T value) {
		
		if(this.getData().equals(value))
			return this;
		
		GeneralTree<T> aux_tree = null;
		
		Iterator<GeneralTree<T>> children = this.getChildren().iterator();	
		while(children.hasNext() && aux_tree == null)
			aux_tree = children.next().buscarNodo(value);
		
		return aux_tree;
	}
	
	private boolean buscarAncestro(GeneralTree<T> a, T b) {
		if(a.getData().equals(b))
			return true;
		
		boolean found = false;
		
		Iterator<GeneralTree<T>> children = a.getChildren().iterator();
		while(children.hasNext() && !found)
			found = buscarAncestro(children.next(), b);
		
		return found;
	}
	
	public void printTree() {
		Queue<GeneralTree<T>> cola = new Queue<>();
		GeneralTree<T> aux;
		
		cola.enqueue(this);
		cola.enqueue(null);
		
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			
			if(aux != null) {
				System.out.println(aux.getData().toString());
				
				List<GeneralTree<T>> children = aux.getChildren();
				
				for(GeneralTree<T> child: children)
					cola.enqueue(child);				
			}
			else if(!cola.isEmpty()){
				cola.enqueue(null);
				System.out.println("-------");
			}
		}
	}
	
	private int maximo(int x, int y) {
		int max;
		
		if(x >= y)
			max = x;
		else
			max = y;
		
		return max;
	}
}