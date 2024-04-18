package practica3.ejercicio02;

import java.util.ArrayList;
import java.util.List;

import practica3.ejercicio01.GeneralTree;

public class RecorridosAG {

	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a, Integer n) {
		List<Integer> valores_impares = new ArrayList<Integer>();
		
		if(!a.isEmpty())
			imparesMayoresPreOrden(a, valores_impares, n);
		
		return valores_impares;
	}
	
	private void imparesMayoresPreOrden(GeneralTree <Integer> a, List<Integer> lista, Integer n) {
		int data = a.getData();
		if(((data % 2) != 0) && (data > n))
			lista.add(data);
		
		List<GeneralTree<Integer>> children = a.getChildren();
			
		for(GeneralTree<Integer> child: children)
			imparesMayoresPreOrden(child, lista, n);
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> valores_impares = new ArrayList<Integer>();
		
		if(!a.isEmpty())
			imparesMayoresInOrden(a, valores_impares, n);
		
		return valores_impares;
	}
	
	private void imparesMayoresInOrden(GeneralTree<Integer> a, List<Integer> lista, Integer n) {
		if(a.hasChildren()) {
			imparesMayoresInOrden(a.getChildren().get(0), lista, n);
		}
		
		int data = a.getData();
		if(((data % 2) != 0) && (data > n))
			lista.add(data);
		
		if(a.hasChildren()) {
			int size = a.getChildren().size();
			
			for(int i = 1; i < size; i++)
				imparesMayoresInOrden(a.getChildren().get(i), lista, n);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
