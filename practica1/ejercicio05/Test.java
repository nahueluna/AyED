package practica1.ejercicio05;

public class Test {

	public static void main(String[] args) {
		int[] arreglo = new int[5];
		Datos d;
		
		arreglo[0] = 15;
		arreglo[1] = -19;
		arreglo[2] = -20;
		arreglo[3] = 45;
		arreglo[4] = 27;
		
		System.out.println(CalcularProcesos.metodoA(arreglo).toString());
		
		System.out.println();
		
		d = new Datos();
		CalcularProcesos.metodoB(arreglo, d);
		System.out.println(d.toString());
		
		System.out.println();
		
		CalcularProcesos.metodoC(arreglo);
		System.out.println(CalcularProcesos.getResultados().toString());

	}

}
