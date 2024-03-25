package practica1.ejercicio10_11;

public class Ej10_Ej11 {
	/* EJERCICIO 10
	Considere el siguiente problema: Se quiere modelar la cola de atención en un banco. A medida
	que la gente llega al banco toma un ticket para ser atendido, sin embargo, de acuerdo a la LEY
	14564 de la Provincia de Buenos Aires, se establece la obligatoriedad de otorgar prioridad de
	atención a mujeres embarazadas, a personas con necesidades especiales o movilidad reducida
	y a personas mayores de setenta (70) años. De acuerdo a las estructuras de datos vistas en
	esta práctica, ¿qué estructura de datos sugeriría para el modelado de la cola del banco?
	
	
		El modelado de la cola del banco se realizaría con una DoubleEndedQueue. Esto debido a que
		este tipo de cola tiene un comportamiento tal que el elemento ingresado va al final de la
		estructura, mientras que el primer elemento es el primero en salir (tal como una Queue).
		Sin embargo, también permite encolar al inicio, lo que permitiría agregar elementos al comienzo
		de la estructura, tal como el inciso exhibe.
	 */
	
	
	/* EJERCICIO 11
	Considere el siguiente problema: Se quiere modelar el transporte público de la ciudad de La
	Plata, lo cual involucra las líneas de colectivos y sus respectivas paradas. Cada línea de
	colectivos tiene asignado un conjunto de paradas donde se detiene de manera repetida
	durante un mismo día. De acuerdo a las estructuras de datos vistas en esta práctica, que
	estructura de datos sugeriría para el modelado de las paradas de una línea de colectivos?


		Se implementa mediante el uso de una CircularQueue ya que, como su nombre lo indica, se 
		comporta como una cola circular, lo que permite rotar elementos. Cuando el colectivo (elemento)
		ha recorrido todas sus paradas, se lo quita y vuelve a empezar. De esta forma, los elementos
		van rotando por las mismas posiciones (tal como los colectivos recorren repetidamente las paradas).
	 */
	
	
	
	
}
