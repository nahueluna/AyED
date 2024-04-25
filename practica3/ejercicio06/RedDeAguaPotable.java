package practica3.ejercicio06;

import practica3.ejercicio01_03_05.GeneralTree;
import java.util.List;

public class RedDeAguaPotable {
	private GeneralTree<Character> red_agua;
	
	public RedDeAguaPotable() {
		this.red_agua = new GeneralTree<Character>();
	}
	
	public RedDeAguaPotable(GeneralTree<Character> red_agua) {
		this.red_agua = red_agua;
	}
	
	public double minimoCaudal(double caudal) {
		double min = -1;
		
		if(!red_agua.isEmpty())
			min = procesarRedMinimoCaudal(red_agua, caudal);
		
		return min;
	}
	
	private double procesarRedMinimoCaudal(GeneralTree<Character> tree, double caudal) {
		if(!tree.isLeaf()) {
			double min = Double.MAX_VALUE;
			
			List<GeneralTree<Character>> children = tree.getChildren();
			for(GeneralTree<Character> child: children)
				 min = minimo(min, procesarRedMinimoCaudal(child, (double)caudal/children.size()));
			
			return min;
		}
		else return caudal;
	}
	
	private double minimo(double x, double y) {
		double min;
		
		if(x <= y)
			min = x;
		else
			min = y;
		
		return min;
	}
}
