package practica3.ejercicio07;

import java.util.LinkedList;
import java.util.List;
import practica3.ejercicio01_03_05.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> generalTree = new GeneralTree<>();
	
	public Caminos() {
		
	}
	
	public Caminos(GeneralTree<Integer> generalTree) {
		this.generalTree = generalTree;
	}
	
	public GeneralTree<Integer> getGeneralTree() {
		return generalTree;
	}

	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> camino = new LinkedList<Integer>();
		List<Integer> lista = new LinkedList<Integer>();
		
		if(!getGeneralTree().isEmpty())
			procesarCamino(getGeneralTree(), lista, camino);
		
		return camino;
	}
	
	private void procesarCamino(GeneralTree<Integer> tree, List<Integer> lista, List<Integer> camino) {
		lista.add(tree.getData());
		
		if(!tree.isLeaf()) {
			List<GeneralTree<Integer>> children = tree.getChildren();
			for(GeneralTree<Integer> child: children)
				procesarCamino(child, lista, camino);
		}
		else if(lista.size() > camino.size()) {
			camino.removeAll(camino);
			camino.addAll(lista);
		}
		
		lista.remove(lista.size() - 1);
		
	}
}
