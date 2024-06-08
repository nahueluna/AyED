package practica5.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import practica5.ejercicio1.*;
import practica1.ejercicio08.Queue;

public class Banco {
    private static final int MAX_JUBILADOS = 3;

    public List<Persona> listaJubiladosCorrespondientes(Graph<Persona> grafo, Persona empleado, int separacion) {
        if (grafo.isEmpty() || !empleado.getTipo().equals("Empleado"))
            return null;

        Vertex<Persona> v = grafo.search(empleado);
        List<Persona> jubilados = new ArrayList<>();
        boolean[] marca = new boolean[grafo.getSize()];

        if (v != null)
            bfsJubiladosCercanos(grafo, empleado, jubilados, separacion, marca, v.getPosition());

        return jubilados;
    }

    /*
     * Me quedo con los adyacentes del empleado dado, debido a que este es el unico
     * empleado cuyos
     * adyacentes seran procesados. El bucle solo procesa aquellos vertices que
     * tengan jubilados. Para continuar
     * el procesamiento se cerciora que no se haya superado la cantidad maxima y que
     * sea un jubilado.
     * Se agrega si el jubilado si, ademas, no ha cobrado. Si se llega al final de
     * "nivel", disminuye el grado
     * de separacion e inmediatamente chequea que sea mayor a 0 (sino sale)
     */
    private void bfsJubiladosCercanos(Graph<Persona> grafo, Persona empleado, List<Persona> jubilados, int separacion,
            boolean[] marca,
            int pos) {

        Queue<Vertex<Persona>> cola = new Queue<>();

        List<Edge<Persona>> adyacentes_empleado = grafo.getEdges(grafo.getVertex(pos));
        for (Edge<Persona> e : adyacentes_empleado) {
            Vertex<Persona> p = e.getTarget();
            if (p != null && p.getData().esJubilado()) {
                cola.enqueue(p);
                marca[p.getPosition()] = true;
            }
        }
        cola.enqueue(null);

        while (!cola.isEmpty() && separacion > 0 && jubilados.size() < MAX_JUBILADOS) {
            Vertex<Persona> v = cola.dequeue();

            if (v != null) {
                if (jubilados.size() < MAX_JUBILADOS && v.getData().esJubilado()) {
                    if (!v.getData().haCobrado())
                        jubilados.add(v.getData());

                    List<Edge<Persona>> adyacentes = grafo.getEdges(v);
                    for (Edge<Persona> e : adyacentes) {
                        Vertex<Persona> vert = e.getTarget();
                        if (!marca[vert.getPosition()]) {
                            marca[vert.getPosition()] = true;
                            cola.enqueue(vert);
                        }
                    }
                }

            } else if (!cola.isEmpty()) {
                cola.enqueue(null);
                separacion--;
            }
        }
    }
}
