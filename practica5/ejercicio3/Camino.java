package practica5.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Camino {
	private List<String> recorrido;
	private int distancia;
	
	public Camino() {
		this.recorrido = new ArrayList<>();
		this.distancia = 0;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public List<String> getRecorrido() {
		return recorrido;
	}
	
	
}
