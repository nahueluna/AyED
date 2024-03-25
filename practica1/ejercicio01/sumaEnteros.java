package practica1.ejercicio01;

public class sumaEnteros {
	
	public static void sumaFor(int a, int b) {
		for(int i=a; i <= b; i++)
			System.out.println(i);
	}
	
	public static void sumaWhile(int a, int b) {
		
		while(a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void sumaNoIterativa(int a, int b) {
		if(a <= b) {
			System.out.println(a);
			sumaNoIterativa(a + 1, b);
		}
	}
}
