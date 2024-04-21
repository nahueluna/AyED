package practica3.ejercicio02;

import java.util.ArrayList;
import java.util.List;
import practica1.ejercicio08.Queue;
import practica3.ejercicio01_03_05.GeneralTree;

/* 
 * Si se quisieran implementar estos metodos en GeneralTree no seria necesario
 * pasar el arbol por parametro, puesto que se trabajaria con la propia instancia
 * desde dentro (se haria referencia a ella mediante this). La firma solo requeriria
 * el valor n.
 * En la implementacion del metodo, de igual forma se operaria con el arbol mediante
 * this, obteniendo sus hijos con this.getChildren(), y luego llamando al metodo mediante
 * sus hijos.
 * IMPORTANTE:
 * Cuando se hace child.metodo() y luego, en la recursion dentro de dicho child encuentra un
 * this, ese this corresponde al propio child que llamo al metodo (pues tambien es instancia
 * de esa clase), no al arbol principal original.
 * 
 * Sin embargo, tener en cuenta que GeneralTree<T> es parametrizada con tipo generico, por lo que
 * las comparaciones con enteros no serian validas en un metodo dentro de la propia clase
 * */

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
		
		//GeneralTree crea la lista al instanciarlo, por lo que .size será siempre válido
		int size = a.getChildren().size();
			
		for(int i = 1; i < size; i++)
			imparesMayoresInOrden(a.getChildren().get(i), lista, n);
		
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> valores_impares = new ArrayList<Integer>();
		
		if(!a.isEmpty())
			imparesMayoresPostOrden(a, valores_impares, n);
		
		return valores_impares;
	}
	
	private void imparesMayoresPostOrden(GeneralTree<Integer> a, List<Integer> lista, Integer n) {
		List<GeneralTree<Integer>> children = a.getChildren();
		
		for(GeneralTree<Integer> child: children)
			imparesMayoresPostOrden(child, lista, n);
		
		int data = a.getData();
		if(data % 2 != 0 && data > n)
			lista.add(data);
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
		List<Integer> valores_impares = new ArrayList<>();
		
		if(!a.isEmpty())
			imparesMayoresPorNiveles(a, valores_impares, n);
		
		return valores_impares;
	}
	
	private void imparesMayoresPorNiveles(GeneralTree<Integer> a, List<Integer> lista, Integer n) {
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		GeneralTree<Integer> aux;
		
		cola.enqueue(a);
		
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			
			int data = aux.getData();
			if(data % 2 != 0 && data > n)
				lista.add(data);
				
			List<GeneralTree<Integer>> children = aux.getChildren();
			for(GeneralTree<Integer> child: children)
				cola.enqueue(child);
		}
	}

}
