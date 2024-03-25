package practica1.ejercicio02;

import java.util.Scanner;

public class TestMultiplos {

	public static void main(String[] args) {
		
		System.out.print("Ingrese un valor n: ");
		Scanner s = new Scanner(System.in);
		
		for(int aux: MultiplosN.nMultiplos(s.nextInt()))
			System.out.println(aux);
		
		s.close();
	}

}
