package practica5.ejercicio6;

import java.util.LinkedList;
import java.util.List;

import practica5.ejercicio1.*;

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguros() {
        if (bosque == null)
            return null;

        Vertex<String> v = bosque.search("Casa Caperucita");
        List<List<String>> caminos = new LinkedList<>();
        List<String> caminoAux = new LinkedList<>();
        boolean[] marca = new boolean[bosque.getSize()];

        if (v != null)
            dfsCaminosBosque(caminos, caminoAux, marca, v.getPosition(), "Casa Abuelita");

        return caminos;
    }

    private void dfsCaminosBosque(List<List<String>> caminos, List<String> caminoAux, boolean[] marca, int i,
            String destino) {

        marca[i] = true;
        Vertex<String> v = bosque.getVertex(i);
        caminoAux.add(v.getData());

        if (v.getData().equals(destino))
            caminos.add(new LinkedList<>(caminoAux));
        else {
            List<Edge<String>> adyacentes = bosque.getEdges(v);

            for (Edge<String> e : adyacentes) {
                if (e.getWeight() < 5) {
                    int j = e.getTarget().getPosition();
                    if (!marca[j])
                        dfsCaminosBosque(caminos, caminoAux, marca, j, destino);
                }
            }
        }

        marca[i] = false;
        caminoAux.remove(caminoAux.size() - 1);
    }
}
