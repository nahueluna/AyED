package practica1.ejercicio07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TestList {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer num;
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		System.out.println("Ingrese numeros (0 para detenerse): ");
		num = input.nextInt();
		
		while(num != 0) {
			numeros.add(num);
			num = input.nextInt();
		}
		
		System.out.println("Array: ");
		for(Integer var: numeros) {
			System.out.println(var);
		}
		System.out.println();
		
			
		LinkedList<Integer> numList = new LinkedList<Integer>();
		
		System.out.println("Ingrese numeros (0 para detenerse): ");
		
		num = input.nextInt();
		
		while(num != 0) {
			numList.add(num);
			num = input.nextInt();
		}
		
		
		invertirArrayList(numeros);
		
		System.out.println();
		System.out.println("-------ArrayList invertido--------");
		for(Integer var: numeros) {
			System.out.println(var);
		}
		
		System.out.println();
		System.out.println("Suma de elementos de la LinkedList: " + sumarLinkedList(numList));
		
		
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		ArrayList<Integer> resultado;
		
		System.out.println("Lista1 - Ingrese numeros (0 para detenerse): ");
		num = input.nextInt();
		
		while(num != 0) {
			lista1.add(num);
			num = input.nextInt();
		}
		
		System.out.println();
		
		System.out.println("Lista2 - Ingrese numeros (0 para detenerse): ");
		num = input.nextInt();
		
		while(num != 0) {
			lista2.add(num);
			num = input.nextInt();
		}
		
		input.close();
		
		System.out.println();
		
		resultado = combinarOrdenado(lista1, lista2);
		
		System.out.println("----------LISTA COMBINADA-------------");
		for(int aux: resultado)
			System.out.println(aux);

	}
	
	public static void invertirArrayList(ArrayList<Integer> lista) {
		if(lista == null || lista.size() <= 1) {
			return;
		}
		
		int n = lista.remove(0);
		
		invertirArrayList(lista);
		
		lista.add(n);
	}
	
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		return sumaRecursiva(lista, 0);
	}
	
	private static int sumaRecursiva(LinkedList<Integer> lista, int indice) {
		if(lista == null || indice == lista.size()) {
			return 0;
		} 
		else {
			int num = lista.get(indice);
			return num + sumaRecursiva(lista, indice + 1);
		}
	
	}
	
	//Precondicion: las ArrayList ingresan ordenadas (las listas no están vacías)
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
		ArrayList<Integer> lista_resultado = new ArrayList<Integer>();
		int i = 0, j = 0;
		
		while(i < lista1.size() && j < lista2.size()) { 
			if(lista1.get(i) < lista2.get(j)) {
				lista_resultado.add(lista1.get(i));
				i++;
			}
			else {
				lista_resultado.add(lista2.get(j));
				j++;
			}
		}
		
		if(i < lista1.size()) {
			for(int k = i; k < lista1.size(); k++)
				lista_resultado.add(lista1.get(k));
		}
		else if(j < lista2.size()) {
			for(int k = j; k < lista2.size(); k++)
				lista_resultado.add(lista2.get(k));
		}
		
		return lista_resultado;
	}
}
