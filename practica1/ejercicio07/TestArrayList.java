package practica1.ejercicio07;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer num;
		List<Integer> numeros = new ArrayList<Integer>();
		
		System.out.println("Ingrese numeros (0 para detenerse): ");
		num = input.nextInt();
		
		while(num != 0) {
			numeros.add(num);
			num = input.nextInt();
		}
		
		for(Integer var: numeros) {
			System.out.println(var);
		}
		
		input.close();
		
		/* La implementación anterior con una LinkedList hubiese sido
		 * igual, ya que ambas tienen implementado el método ".add".
		 * Además, se optó por usar un for each, ya que permite recorrer
		 * tanto un ArrayList (recorrido indexado) como una LinkedList
		 * (recorrido secuencial).
		 * Se ha optimizado el recorrido por usar un for each. En caso de usar
		 * un for convencional (Java permite acceder una LinkedList con un indice)
		 * necesita comenzar la LinkedList desde el principio por cada elemento
		 * que se quiera acceder, lo que resulta muy ineficiente.
		 * 
		 * Como en este caso es un ArrayList, se puede recorrer también
		 * con un bucle for convencional, pues sus elementos corresponden
		 * a posiciones (está indexado).
		 * También se puede llamar al método foreach propio del ArrayList.
		 * Si fuera una LinkedList, solo podríamos usar for each, pues no
		 * está indexada.
		 * Para recorrer estas estructuras tambi�n existe el m�todo iterator, que
		 * permite iterar las colecciones y recorrer sus elementos.
		 */
		
		incisoD();
		
		System.out.println();
			
		//Determinar si es capicua
		System.out.println("La lista de enteros es capicua? " + esCapicua(numeros));
		
		//Sucesion a partir de un numero dado
		List<Integer> numerosSucesion = EjercicioSucesion.devolverSucesion(6);
		
		System.out.println("Sucesion: ");
		
		for(int aux:numerosSucesion) {
			System.out.println(aux);
		}
		
	}
	
	public static void incisoD() {
		//Cree una lista de 3 estudiantes
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		Estudiante e1, e2, e3;
		e1 = new Estudiante("Pablo", "Rodriguez", "example@gmail,com", 2, "Av Corrientes");
		e2 = new Estudiante("Alicia", "Kessel", "alikess@hotmail.com", 5, "157 y 54");
		e3 = new Estudiante("María", "Pérez", "mariaperez@gmail.com", 3, "5 y 50");
		
		estudiantes.add(e1);
		estudiantes.add(e2);
		estudiantes.add(e3);
		
		//Cree una copia de la lista
		List<Estudiante> estudiantesCopy = new ArrayList<Estudiante>(estudiantes);
		
		
		//Imprima ambas listas
		System.out.println("---------LISTA ORIGINAL---------");
		for(Estudiante aux: estudiantes) {
			System.out.println(aux.tusDatos());
		}
		
		System.out.println();
		
		System.out.println("---------LISTA COPIADA---------");
		for(Estudiante aux: estudiantesCopy) {
			System.out.println(aux.tusDatos());
		}
		
		//Modifique un dato de un estudiante y vuelva a imprimir
		e1.setDireccion("1 y 57");
		
		System.out.println("---------LISTA ORIGINAL---------");
		for(Estudiante aux: estudiantes) {
			System.out.println(aux.tusDatos());
		}
		
		System.out.println();
		
		System.out.println("---------LISTA COPIADA---------");
		for(Estudiante aux: estudiantesCopy) {
			System.out.println(aux.tusDatos());
		}
		
		/* Al modificar un dato de una instancia de clase (Estudiante en este caso),
		 * Se modifica el valor de la variable de instancia. Debido a que las instancias
		 * son referidas mediante punteros, dicha modificación repercute para ambas listas,
		 * ya que ambas poseen una referencia a la misma instancia de clase (e1 en este caso)
		 * Esto se denomina copia superficial (shallow copy)
		 * 
		 * Existen varias formas de copiar una lista en Java. Una de ellas es la utilizada,
		 * copiar la lista a partir del constructor de la misma, pasando como argumento la
		 * lista original a ser copiada.
		 * 
		 * Luego tenemos el método addAll() que agrega al final de una lista todos los elementos
		 * de otra. Si la lista copia está vacía, los unicos elementos resultantes serán los de la
		 * lista original, es decir, estamos copiando los mismos elementos.
		 * 
		 * Además, mediante el método stream(), a partir de la lista original, podemos llamar al
		 * método collect() y, dentro de este, Collectors.toList(). Básicamente, toma la lista original, 
		 * conforma una colección y la transforma en una lista.
		 * 
		 * Finalmente, Java tiene implementado el método clone(), que copia los elementos y devuelve una
		 * nueva lista, esta realiza una copia superficial (es decir, se tienen referencias a los elementos
		 * de la lista original. Una copia en uno repercute en ambas).
		 * 
		 * Las últimas dos alternativas requieren convertir el tipo de dato recibido antes de asignarlo, es decir,
		 * si tenemos un ArrayList de Strings, se debe anteponer (ArrayList<String>) a la llamada del método en la
		 * asignación. 
		 */
		
		//Agregar nuevo estudiante a lista original, verificando que no esté
		Estudiante e4 = new Estudiante("Nahuel","Luna","nahulu@example.com",7,"137 y 66");
		boolean iguales = false;
		
		for(Estudiante aux: estudiantes) {
			if(aux.equals(e4)) {
				iguales = true;
			}
		}
		if(!iguales) {
			estudiantes.add(e4);
		}
		else {
			System.out.println("El estudiante ya se encuentra registrado.");
		}
		
		//contains() devuelve true si el objeto especificado se encuentra en la lista
		Estudiante e5 = new Estudiante("Juan Ignacio", "Cristaldo", "juancristaldocontactos@hotmail.com",9,"44");
		if(!estudiantes.contains(e5))
			estudiantes.add(e5);
		
		for(Estudiante aux: estudiantes) {
			System.out.println(aux.tusDatos());
		}
	}
	
	public static boolean esCapicua(List<Integer> lista) {
		List<Integer> lisAux = new ArrayList<Integer>(lista);
		
		//Invierte la lista
		//Se puede verificar sin invertir, comparando primer elemento con último y así sucesivamente
		for(int i = 0, j = lisAux.size()-1; i < j; i++) {
			lisAux.add(i, lisAux.remove(j));
		}
		
		//Compara lista original con invertida
		//equals() para listas se ha implementado para comparar correctamente dos listas
		//Si no fuera así, se debería comparar elemento con elemento, si uno es distinto, las listas son distintas (no es capicua)
		return lista.equals(lisAux);
	}

}
