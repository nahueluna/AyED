package practica5.ejercicio5;

import java.util.List;

import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.adjList.AdjListGraph;

public class Test {
    public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex<Persona> v1 = grafo.createVertex(new Persona("Empleado", "Matias", "AAA", true));
        Vertex<Persona> v2 = grafo.createVertex(new Persona("Jubilado", "Julian", "BBB", false));
        Vertex<Persona> v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", "CCC", false));
        Vertex<Persona> v4 = grafo.createVertex(new Persona("Empleado", "Valentin", "DDD", true));
        Vertex<Persona> v5 = grafo.createVertex(new Persona("Jubilado", "Omar", "EEE", true));
        Vertex<Persona> v6 = grafo.createVertex(new Persona("Empleado", "Rosana", "FFF", true));
        Vertex<Persona> v7 = grafo.createVertex(new Persona("Jubilado", "Maria", "GGG", false));
        Vertex<Persona> v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", "HHH", true));
        Vertex<Persona> v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", "III", false));

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);

        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);

        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);

        Banco itau = new Banco();

        List<Persona> jubilados = itau.listaJubiladosCorrespondientes(grafo, v1.getData(), 3);

        for (Persona p : jubilados)
            System.out.println(p.getNombre());
    }
}
