package practica1.ejercicio05;

public class Datos {
	private int minimo;
	private int maximo;
	private float promedio;
	
	public int getMinimo() {
		return minimo;
	}
	
	public int getMaximo() {
		return maximo;
	}
	
	public float getPromedio() {
		return promedio;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	
	@Override
	public String toString() {
		String aux = "Maximo: " + getMaximo() + "\n" +
					 "Minimo: " + getMinimo() + "\n" +
					 "Promedio: " + getPromedio();
		
		return aux;
	}
}
