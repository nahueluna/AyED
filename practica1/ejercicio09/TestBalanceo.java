package practica1.ejercicio09;

public class TestBalanceo {
	
	/* Se opta por usar una pila, ya que el elemento ingresante
	 * se coloca en la primer posición. De igual forma, el que
	 * sale es aquel que se encuentra en dicha posicion.
	 * De esta forma, se guarda en la pila los caracteres de
	 * apertura y, cuando llega uno de cierre, se lo puede 
	 * comparar con el último ingresado y sacarlo de la pila
	 * (gracias a su cualidad de estructura LIFO).
	 */
	
	public static boolean comprobarBalanceo(String S) {
		Stack<Character> pila = new Stack<Character>();
		boolean balanceado = true;
		char c;
		int index = 0;
		
		while(index < S.length() && balanceado) {
			c = S.charAt(index);
			
			if(c == '{' || c == '[' || c == '(')
				pila.push(c);
			else {
				if(c == '}') {
					balanceado = pila.pop().equals('{');
				}
				else if(c == ']') {
					balanceado = pila.pop().equals('[');
				}
				else if(c == ')') {
					balanceado = pila.pop().equals('(');
				}
			}
			
			index++;
		}
			
		
		return balanceado;
	}
}

//Ej 8 = cerrar lo último que abrí. Utilizar cola, 
//ingresar elementos de apertura y comparar cuando llega cierre
