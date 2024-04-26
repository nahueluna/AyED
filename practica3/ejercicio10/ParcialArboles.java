package practica3.ejercicio10;

import java.util.List;

import practica3.ejercicio01_03_05.GeneralTree;

public class ParcialArboles {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		Camino caminoActual = new Camino(0);
		Camino caminoDefinitivo = new Camino(0);
		
		if(!arbol.isEmpty())
			procesarCaminos(arbol, caminoActual, caminoDefinitivo, 0);
		
		return caminoDefinitivo.getLista();
	}
	
	private static void procesarCaminos(GeneralTree<Integer> arbol, Camino camAct, Camino camDef, int nivel) {
		int data = arbol.getData();
		if(data == 1) {
			camAct.addValue(data * nivel);
			camAct.add(data);
		}
			
		if(!arbol.isLeaf()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child: children)
				procesarCaminos(child, camAct, camDef, nivel + 1);
		}
		else if(camAct.getValor() > camDef.getValor())
			camDef.replace(camAct);
		
		if(data == 1) {	//solo borro si agrego
			camAct.substractValue(data * nivel);
			camAct.removeLast();
		}
	}
}
