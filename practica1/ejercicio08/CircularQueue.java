package practica1.ejercicio08;

public class CircularQueue<T> extends Queue<T>{
	
	/*
	
	If a constructor body does not begin with an explicit constructor invocation 
	and the constructor being declared is not part of the primordial class Object, 
	then the constructor body implicitly begins with a superclass constructor 
	invocation "super();", an invocation of the constructor of its direct superclass 
	that takes no arguments.
	
	No poner constructor en una clase no primordial (que hereda, en Java todo es subclase de Object) es
	una forma implicita de poner lo siguiente:
	
	public CircularQueue() {
		super();
	}
	
	Es decir, un constructor que llama al constructor de su superclase.
	
	*/
	
	//Desencola dato del principio, encola al final y lo devuelve
	public T shift() {
		T data = dequeue();
		
		enqueue(data);
		
		return data;
	}
	
}
