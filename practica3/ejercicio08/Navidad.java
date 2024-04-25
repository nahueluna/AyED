package practica3.ejercicio08;

import java.util.Iterator;

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
			
		if(gt.getChildren().size() >= 3) {
			Iterator<GeneralTree<T>> children = gt.getChildren().iterator();
			
			while(children.hasNext()) {
				GeneralTree<T> child = children.next();
				
				if(child.isLeaf()) cantHojas++;
				else if (!procesarAbeto(child)) return false;
			}
		}
		
		return cantHojas >= 3;
	}
}
