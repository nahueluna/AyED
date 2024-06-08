package practica5.ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import practica1.ejercicio08.Queue;
import practica5.ejercicio1.*;

public class Recorridos<T> {
	
	// O(|V| + |E|) --> dfs recursivo se ejecuta E veces. El dfs publico llama por cada vertice (V veces) 
	public List<T> dfs(Graph<T> grafo) {
		LinkedList<T> datos = new LinkedList<>();
		boolean[] marca = new boolean[grafo.getSize()];
		
		for(int i = 0; i < grafo.getSize(); i++) {
			if(!marca[i])
				dfs(grafo, datos, marca, i);
		}
		
		return datos;
	}
	
	private void dfs(Graph<T> grafo, List<T> datos, boolean[] marca, int i) {
		marca[i] = true;
		Vertex<T> vertice = grafo.getVertex(i);
		datos.add(vertice.getData());
		
		List<Edge<T>> adyacentes = grafo.getEdges(vertice);
		Iterator<Edge<T>> it = adyacentes.iterator();
		
		while(it.hasNext()) {
			int j = it.next().getTarget().getPosition();
			if(!marca[j])
				dfs(grafo, datos, marca, j);
		}
	}
	
	// O(|V| + |E|) --> sigue una logica similar al anterior (solo que no hay recursion)
	public List<T> bfs(Graph<T> grafo) {
		List<T> datos = new LinkedList<>();
		boolean[] marca = new boolean[grafo.getSize()];
		
		for(int i = 0; i < grafo.getSize(); i++) {
			if(!marca[i])
				bfs(grafo, datos, marca, i);
		}
		
		return datos;
	}
	
	private void bfs(Graph<T> grafo, List<T> datos, boolean[] marca, int i) {
		Queue<Vertex<T>> cola = new Queue<>();
		cola.enqueue(grafo.getVertex(i));
		marca[i] = true;
		
		while(!cola.isEmpty()) {
			Vertex<T> v = cola.dequeue();
			datos.add(v.getData());
			
			List<Edge<T>> adyacentes = grafo.getEdges(v);
			for (Edge<T> e: adyacentes) {
				int j = e.getTarget().getPosition();
				if(!marca[j]) {
					cola.enqueue(e.getTarget());
					marca[j] = true;
				}
			}
		}
		
	}
}
