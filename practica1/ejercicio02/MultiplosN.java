package practica1.ejercicio02;

public class MultiplosN {
	
	public static int[] nMultiplos(int n) {
		int[] multiplos = new int[n];
		
		for(int i = 1; i <= n; i++)
			multiplos[i-1] = n*i;
		
		return multiplos;
	}
}
