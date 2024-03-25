package practica1.ejercicio05;

public class CalcularProcesos {
	private static Datos resultados;
	
	public static Datos getResultados() {
		return resultados;
	}

	private static int minimo(int x, int y) {
		int min;
		
		if(x < y)
			min = x;
		else
			min = y;
		
		return min;
	}
	
	private static int maximo(int x, int y) {
		int max;
		
		if(x > y)
			max = x;
		else
			max = y;
		
		return max;
	}
	
	//Crea una instancia Datos y la retorna
	public static Datos metodoA(int a[]) {
		int min = 99999;
		int max = -99999;
		int suma = 0;
		
		for(int var: a) {
			min = minimo(min, var);
			max = maximo(max, var);
			suma += var;
		}
		
		Datos d = new Datos();
		d.setMaximo(max);
		d.setMinimo(min);
		d.setPromedio((float) suma/a.length);
		
		return d;
	}
	
	//Interactúa con el parámetro instancia de Datos y lo retorna
	public static void metodoB(int[] a, Datos d) {
		int min = 99999;
		int max = -99999;
		int suma = 0;
		
		for(int var: a) {
			min = minimo(min, var);
			max = maximo(max, var);
			suma += var;
		}
		
		d.setMaximo(max);
		d.setMinimo(min);
		d.setPromedio((float) suma/a.length);
	}
	
	public static void metodoC(int[] a) {
		int min = 99999;
		int max = -99999;
		int suma = 0;
		
		for(int var: a) {
			min = minimo(min, var);
			max = maximo(max, var);
			suma += var;
		}
		
		resultados = new Datos();
		resultados.setMaximo(max);
		resultados.setMinimo(min);
		resultados.setPromedio((float) suma/a.length);
	}
}
