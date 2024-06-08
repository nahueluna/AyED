package practica5.ejercicio3;

import java.util.LinkedList;
import java.util.List;

import practica5.ejercicio1.*;
import practica5.ejercicio1.adjList.*;

public class Test {

	public static void main(String[] args) {
		AdjListGraph<String> grafo;
		Vertex<String> vert1;
		Vertex<String> vert2;
		Vertex<String> vert3;
		Vertex<String> vert4;
		Vertex<String> vert5;
		Vertex<String> vert6;
		Vertex<String> vert7;

		grafo = new AdjListGraph<>();

		vert1 = grafo.createVertex("Buenos Aires");
		vert2 = grafo.createVertex("Santiago");
		vert3 = grafo.createVertex("Roma");
		vert4 = grafo.createVertex("Asuncion");
		vert5 = grafo.createVertex("Madrid");
		vert6 = grafo.createVertex("Caracas");
		vert7 = grafo.createVertex("Tokio");

		grafo.connect(vert1, vert2, 10);
		grafo.connect(vert1, vert4, 30);

		grafo.connect(vert2, vert3, 20);

		grafo.connect(vert4, vert5, 40);
		grafo.connect(vert4, vert6, 5);

		grafo.connect(vert5, vert7, 5);

		grafo.connect(vert6, vert5, 3);
		grafo.connect(vert6, vert7, 10);

		Mapa mapa = new Mapa(grafo);

		// Camino comun
		System.out.println();
		System.out.println("Camino Buenos Aires - Tokio");

		List<String> camino = mapa.devolverCamino("Buenos Aires", "Tokio");

		for (String c : camino)
			System.out.println(c);

		// Camino evitando ciudades
		System.out.println();
		System.out.println("Camino evitando Santiago y Madrid");

		List<String> ciudadesEvitadas = new LinkedList<>();
		ciudadesEvitadas.add("Santiago");
		ciudadesEvitadas.add("Madrid");

		camino = mapa.devolverCaminoExceptuando("Buenos Aires", "Tokio", ciudadesEvitadas);

		for (String c : camino)
			System.out.println(c);

		// Camino minimo
		System.out.println();
		System.out.println("Camino mas corto");

		camino = mapa.caminoMasCorto("Buenos Aires", "Tokio");

		for (String c : camino)
			System.out.println(c);

		// Camino sin cargar combustible
		System.out.println();
		System.out.println("Camino con combustible suficiente (sin cargar)");

		camino = mapa.caminoSinCargarCombustible("Buenos Aires", "Tokio", 75);

		for (String c : camino)
			System.out.println(c);

		// Camino con menor cantidad de cargas de combustible
		System.out.println();
		System.out.println("Camino con menor cantidad de recargas de combustible");

		camino = mapa.caminoConMenorCargaDeCombustible("Buenos Aires", "Tokio", 40);

		for (String c : camino)
			System.out.println(c);

	}

}
