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
			min = procesarRedMinimoCaudal(red_agua, caudal, Double.MAX_VALUE);
		
		return min;
	}
	
	private double procesarRedMinimoCaudal(GeneralTree<Character> tree, double caudal, double min) {
		if(tree.isLeaf())
			min = minimo(min, caudal);
		
		else {
			List<GeneralTree<Character>> children = tree.getChildren();
			for(GeneralTree<Character> child: children)
				min = procesarRedMinimoCaudal(child, (double)caudal/children.size(), min);
		}
		
		return min;
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
