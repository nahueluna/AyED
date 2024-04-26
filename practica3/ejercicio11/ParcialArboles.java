package practica3.ejercicio11;

import java.util.List;

import practica1.ejercicio08.Queue;
import practica3.ejercicio01_03_05.GeneralTree;

public class ParcialArboles {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		if(arbol == null || arbol.isLeaf()) return true;
		
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		GeneralTree<Integer> aux;
		boolean esCreciente = true;
		int nodosActual = 0, nodosAnterior = 0;
		
		cola.enqueue(arbol);
		cola.enqueue(null);
		
		while(!cola.isEmpty() && esCreciente) {
			aux = cola.dequeue();
			
			if(aux != null) {
				nodosActual++;
				List<GeneralTree<Integer>> children = aux.getChildren();
				for(GeneralTree<Integer> child: children)
					cola.enqueue(child);
			}
			else {
				if(nodosActual != nodosAnterior + 1) esCreciente = false;
				else {
					nodosAnterior = nodosActual;
					nodosActual = 0;
					if(!cola.isEmpty()) cola.enqueue(null);
				}
			}
		}
		
		return esCreciente;
	}
}
