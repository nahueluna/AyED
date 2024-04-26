package practica3.ejercicio10;

import java.util.LinkedList;
import java.util.List;

public class Camino {
	private List<Integer> lista = new LinkedList<>();
	private int valor;
	
	public Camino() {
		
	}
	
	public Camino(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	public List<Integer> getLista() {
		return lista;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void add(int data) {
		lista.add(data);
	}
	
	public void removeLast() {
		lista.remove(lista.size() - 1);
	}
	
	public void replace(Camino otro_camino) {
		this.lista.clear();
		this.lista.addAll(otro_camino.getLista());
		this.valor = otro_camino.getValor();
	}
	
	public void addValue(int value) {
		valor = valor + value;
	}
	
	public void substractValue(int value) {
		valor = valor - value;
	}
}
