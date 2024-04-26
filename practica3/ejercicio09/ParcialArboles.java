package practica3.ejercicio09;

import java.util.List;

import practica3.ejercicio01_03_05.GeneralTree;

public class ParcialArboles {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		if(arbol.isEmpty() || arbol.isLeaf()) return true;	//Se presupone que solo la raiz puede estar vacia
		
		return isSelection(arbol);
	}
	
	private static boolean isSelection(GeneralTree<Integer> arbol) {
		int min = Integer.MAX_VALUE;
		
		List<GeneralTree<Integer>> children = arbol.getChildren();
		for(GeneralTree<Integer> child: children) {
			if(!child.isLeaf())
				if(!isSelection(child)) return false;
			min = minimo(min, child.getData());
		}
		
		return arbol.getData().equals(min);
	}
	
	public static int minimo(int x, int y) {
		return x <= y ? x : y;
	}
}
