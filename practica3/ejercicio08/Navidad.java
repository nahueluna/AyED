package practica3.ejercicio08;

import java.util.List;

import practica3.ejercicio01_03_05.GeneralTree;

public class Navidad<T> {
	private GeneralTree<T> abeto = new GeneralTree<>();

	public Navidad(GeneralTree<T> abeto) {
		this.abeto = abeto;
	}
	
	public String esAbetoNavidenio() {
		boolean esAbeto = false;
		if(!abeto.isEmpty()) esAbeto = procesarAbeto(abeto);
		
		// if esAbeto = true return "Yes". Else return "No"
		return esAbeto ? "Yes" : "No";
		
	}
	
	private boolean procesarAbeto(GeneralTree<T> gt) {
		int cantHojas = 0;
		boolean esAbeto = true;
		
		List<GeneralTree<T>> children = gt.getChildren();
			
		if(children.size() >= 3) {
			for(GeneralTree<T> child: children) {
				if(child.isLeaf()) cantHojas++;
				else esAbeto = procesarAbeto(child);
			}
				
			esAbeto = esAbeto && cantHojas >= 3;
		}
		
		return esAbeto;
	}
}
