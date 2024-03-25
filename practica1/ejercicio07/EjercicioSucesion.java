package practica1.ejercicio07;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {
	public static List<Integer> devolverSucesion(int n){
		List<Integer> sucesion = new ArrayList<Integer>();
		
		calcularSucesion(sucesion, n);
		
		return sucesion;
	}
	
	private static void calcularSucesion(List<Integer> sucesion, int n) {
		if(n != 1) {
			if(n % 2 == 0) {
				calcularSucesion(sucesion, n/2);
			}
			else
				calcularSucesion(sucesion, (3*n + 1));
		}
		
		sucesion.add(0,n);
	}
}
