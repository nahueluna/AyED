package practica1.ejercicio04;

public class SwapValores {
	public static void swap1 (int x, int y) {
		if (x < y) {
			int tmp = x ;
			x = y ;
			y = tmp;
		}
	}
	
	public static void swap2 (Integer x, Integer y) {
		if (x < y) {
			int tmp = x ;
			x = y ;
			y = tmp;
		}
	}

	public static void main(String[] args) {
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		swap1(a,b);
		swap2(c,d);
		System.out.println("a=" + a + " b=" + b) ;
		System.out.println("c=" + c + " d=" + d) ;
	}
}

/*
swap1 recibe parámetros enteros primitivos mientras que swap2 recibe wrapper de Integer.
Ambos guardan el menor valor en "y" y el mayor en "x" (esa es la condicion para el swap)
  
Sin embargo, dicho swap no se va a realizar porque el pasaje de parámetros en JAVA es por valor.
Es decir, se crea una copia del argumento dentro del método, por lo que se modifica esa copia.
En el caso de los wrapper, cuando se modifica el valor, se crea una nueva instancia con el nuevo
valor.

En definitiva, el valor real de la variable en main no es modificado
*/
