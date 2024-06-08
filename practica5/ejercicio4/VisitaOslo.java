package practica5.ejercicio4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import practica5.ejercicio1.*;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo,
            List<String> lugaresRestringidos) {

        if (lugares.isEmpty())
            return null;

        Vertex<String> v = lugares.search("Ayuntamiento");
        List<String> caminoAux = new LinkedList<>();
        List<String> caminoDef = new LinkedList<>();
        boolean[] marca = new boolean[lugares.getSize()];

        // Marco los lugares restringidos
        for (String lugar : lugaresRestringidos) {
            Vertex<String> vert = lugares.search(lugar);
            if (vert != null)
                marca[vert.getPosition()] = true;
        }

        if (v != null && !lugaresRestringidos.contains("Ayuntamiento"))
            dfsPaseoBici(lugares, caminoAux, caminoDef, v.getPosition(), destino, maxTiempo, marca);

        return caminoDef;
    }

    private void dfsPaseoBici(Graph<String> lugares, List<String> caminoAux, List<String> caminoDef, int i,
            String destino,
            int tiempo, boolean[] marca) {

        marca[i] = true;
        Vertex<String> v = lugares.getVertex(i);
        caminoAux.add(v.getData());

        if (v.getData().equals(destino) && tiempo >= 0)
            caminoDef.addAll(caminoAux);
        else if (tiempo > 0) {
            List<Edge<String>> adyacentes = lugares.getEdges(v);
            Iterator<Edge<String>> it = adyacentes.iterator();

            while (it.hasNext() && caminoDef.isEmpty()) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();

                if (!marca[j])
                    dfsPaseoBici(lugares, caminoAux, caminoDef, j, destino, tiempo - e.getWeight(), marca);
            }
        }

        marca[i] = false;
        caminoAux.remove(caminoAux.size() - 1);
    }
}
