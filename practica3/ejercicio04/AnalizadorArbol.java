package practica3.ejercicio04;

import java.util.List;

import practica1.ejercicio08.Queue;
import practica3.ejercicio01_03_05.GeneralTree;

public class AnalizadorArbol {
	
	public AnalizadorArbol() {
		
	}
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
		GeneralTree<AreaEmpresa> aux_tree;
		int suma_retardos = 0, cant_nodos = 0;
		double promedio, max = -1;
		
		cola.enqueue(arbol);
		cola.enqueue(null);
		
		while(!cola.isEmpty()) {
			aux_tree = cola.dequeue();
			
			if(aux_tree != null) {
				suma_retardos += aux_tree.getData().getRetardo();
				cant_nodos++;
				
				List<GeneralTree<AreaEmpresa>> children = aux_tree.getChildren();
				for(GeneralTree<AreaEmpresa> child: children)
					cola.enqueue(child);
			}
			else {
				promedio = (double) suma_retardos / cant_nodos;
				max = maximo(max, promedio);
				cant_nodos = 0;
				suma_retardos = 0;
				
				if(!cola.isEmpty())
					cola.enqueue(null);
			}
		}
		
		return max;
	}
	
	private double maximo(double x, double y) {
		double max;
		
		if(x >= y)
			max = x;
		else
			max = y;
		
		return max;
	}
}
