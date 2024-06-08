package practica5.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.adjList.AdjListGraph;

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

        vert1 = grafo.createVertex("Ayuntamiento");
        vert2 = grafo.createVertex("Santiago");
        vert3 = grafo.createVertex("Roma");
        vert4 = grafo.createVertex("Asuncion");
        vert5 = grafo.createVertex("Madrid");
        vert6 = grafo.createVertex("Caracas");
        vert7 = grafo.createVertex("Tokio");

        grafo.connect(vert1, vert2, 10);
        grafo.connect(vert1, vert4, 30);

        grafo.connect(vert2, vert3, 20);

        grafo.connect(vert3, vert7, 1);

        grafo.connect(vert4, vert5, 40);
        grafo.connect(vert4, vert6, 5);

        grafo.connect(vert5, vert3, 1);
        grafo.connect(vert5, vert7, 5);

        grafo.connect(vert6, vert5, 3);
        grafo.connect(vert6, vert7, 10);

        VisitaOslo visita = new VisitaOslo();

        List<String> lugaresRestringidos = new LinkedList<>();
        lugaresRestringidos.add("Caracas");
        lugaresRestringidos.add("Madrid");

        List<String> camino = visita.paseoEnBici(grafo, "Tokio", 75, lugaresRestringidos);

        for (String c : camino)
            System.out.println(c);
    }
}
