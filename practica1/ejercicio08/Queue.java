package practica1.ejercicio08;

import java.util.*;

public class Queue<T> extends Sequence<T>{
	private List<T> data;
	
	public Queue() {
		this.data = new LinkedList<T>(); 
	}
	
	public List<T> getData() {
		return this.data;
	}
	
	//Agrega al final
	public void enqueue(T dato) {
		this.data.add(dato);
	}
	
	//Quita primer elemento
	public T dequeue() {
		return this.data.remove(0);
	}
	
	//Retorna primer elemento
	public T head() {
		return this.data.get(0);
	}
	
	//Devuelve cantidad de elementos
	@Override
	public int size() {
		return this.data.size();
	}
	
	//Retorna true si la cola está vacía
	@Override
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	
	//Retorna String con elementos de la cola
	@Override
	public String toString() {
		String str = new String();
		Iterator<T> it = this.data.iterator();
		
		while(it.hasNext()) {
			str = it.next().toString() + "\n";
		}
		
		return str;
	}
	
}
