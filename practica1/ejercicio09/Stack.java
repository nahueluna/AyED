package practica1.ejercicio09;

import java.util.List;
import java.util.LinkedList;

public class Stack<T> extends Sequence<T>{
	private List<T> data;
	
	public Stack() {
		this.data = new LinkedList<T>();
	}

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	
	public void push(T dato) {
		this.data.add(0,dato);
	}
	
	public T pop() {
		return this.data.remove(0);
	}
	
	public T head() {
		return this.data.get(0);
	}
	
}
