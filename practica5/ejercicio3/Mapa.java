package practica5.ejercicio3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import practica5.ejercicio1.*;

public class Mapa {
	private Graph<String> mapaCiudades;

	public Mapa(Graph<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	public List<String> devolverCamino(String ciudad1, String ciudad2) {
		if (mapaCiudades.isEmpty())
			return null;

		Vertex<String> v = mapaCiudades.search(ciudad1);
		List<String> caminoAux = new LinkedList<>();
		List<String> caminoDef = new LinkedList<>();
		boolean[] marca = new boolean[mapaCiudades.getSize()];

		if (v != null)
			dfsCamino(caminoAux, caminoDef, marca, v.getPosition(), ciudad2);

		return caminoDef;
	}

	private void dfsCamino(List<String> caminoAux, List<String> caminoDef, boolean[] marca, int i, String destino) {
		marca[i] = true;
		Vertex<String> v = this.mapaCiudades.getVertex(i);
		caminoAux.add(v.getData());

		if (v.getData().equals(destino))
			caminoDef.addAll(caminoAux);
		else {
			List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(v);
			Iterator<Edge<String>> it = adyacentes.iterator();

			while (it.hasNext() && caminoDef.isEmpty()) {
				int j = it.next().getTarget().getPosition();
				if (!marca[j]) {
					dfsCamino(caminoAux, caminoDef, marca, j, destino);
				}
			}

			caminoAux.remove(v.getData());
		}
	}

	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
		if (mapaCiudades.isEmpty())
			return null;

		Vertex<String> v = mapaCiudades.search(ciudad1);
		List<String> caminoAux = new LinkedList<>();
		List<String> caminoDef = new LinkedList<>();
		boolean[] marca = new boolean[mapaCiudades.getSize()];

		// Marco las ciudades a evitar como ya visitadas (para no considerarlas en el
		// camino)
		for (String c : ciudades) {
			Vertex<String> vertice = this.mapaCiudades.search(c);
			if (vertice != null)
				marca[vertice.getPosition()] = true;

		}

		if (v != null && !ciudades.contains(ciudad1) && !ciudades.contains(ciudad2))
			dfsCamino(caminoAux, caminoDef, marca, v.getPosition(), ciudad2);

		return caminoDef;
	}

	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
		if (mapaCiudades.isEmpty())
			return null;

		Vertex<String> v = mapaCiudades.search(ciudad1);
		Camino caminoAux = new Camino();
		Camino caminoMin = new Camino();
		caminoMin.setDistancia(Integer.MAX_VALUE);
		boolean[] marca = new boolean[mapaCiudades.getSize()];

		if (v != null)
			dfsCaminoMinimo(caminoAux, caminoMin, marca, v.getPosition(), 0, ciudad2);

		return caminoMin.getRecorrido();
	}

	private void dfsCaminoMinimo(Camino caminoAux, Camino caminoMin, boolean[] marca, int i, int distancia,
			String destino) {
		marca[i] = true;
		Vertex<String> v = this.mapaCiudades.getVertex(i);
		caminoAux.getRecorrido().add(v.getData());
		caminoAux.setDistancia(caminoAux.getDistancia() + distancia);

		if (v.getData().equals(destino) && caminoAux.getDistancia() < caminoMin.getDistancia()) {
			caminoMin.getRecorrido().clear();
			caminoMin.getRecorrido().addAll(caminoAux.getRecorrido());
			caminoMin.setDistancia(caminoAux.getDistancia());
		} else {
			List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(v);
			Iterator<Edge<String>> it = adyacentes.iterator();

			while (it.hasNext() && caminoAux.getDistancia() < caminoMin.getDistancia()) {
				Edge<String> e = it.next();
				int j = e.getTarget().getPosition();
				if (!marca[j])
					dfsCaminoMinimo(caminoAux, caminoMin, marca, j, e.getWeight(), destino);
			}
		}

		marca[i] = false;
		caminoAux.getRecorrido().remove(v.getData());
		caminoAux.setDistancia(caminoAux.getDistancia() - distancia);
	}

	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		if (this.mapaCiudades.isEmpty())
			return null;

		Vertex<String> v = this.mapaCiudades.search(ciudad1);
		List<String> caminoAux = new LinkedList<>();
		List<String> caminoDef = new LinkedList<>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];

		if (v != null)
			dfsCaminoSinCargarCombustible(caminoAux, caminoDef, marca, v.getPosition(), tanqueAuto, ciudad2);

		return caminoDef;
	}

	private void dfsCaminoSinCargarCombustible(List<String> caminoAux, List<String> caminoDef, boolean[] marca, int i,
			int tanqueAuto, String destino) {

		marca[i] = true;
		Vertex<String> v = mapaCiudades.getVertex(i);
		caminoAux.add(v.getData());
		if (v.getData().equals(destino) && tanqueAuto > 0)
			caminoDef.addAll(caminoAux);
		else if (tanqueAuto > 0) {
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(v);
			Iterator<Edge<String>> it = adyacentes.iterator();

			while (it.hasNext() && caminoDef.isEmpty()) {
				Edge<String> e = it.next();
				int j = e.getTarget().getPosition();
				if (!marca[j])
					dfsCaminoSinCargarCombustible(caminoAux, caminoDef, marca, j, tanqueAuto - e.getWeight(), destino);
			}
		}

		marca[i] = false;
		caminoAux.remove(v.getData());
	}

	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		if (this.mapaCiudades.isEmpty())
			return null;

		Vertex<String> v = this.mapaCiudades.search(ciudad1);
		List<String> caminoAux = new LinkedList<>();
		List<String> caminoDef = new LinkedList<>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];

		if (v != null)
			dfsCaminoMenorCargaCombustible(caminoAux, caminoDef, marca, v.getPosition(), tanqueAuto, tanqueAuto, 0,
					Integer.MAX_VALUE,
					ciudad2);

		return caminoDef;
	}

	private int dfsCaminoMenorCargaCombustible(List<String> caminoAux, List<String> caminoDef, boolean[] marca, int i,
			int tanqueActual, int tanqueTotal,
			int recargasAct, int recargasMin, String destino) {

		marca[i] = true;
		Vertex<String> v = this.mapaCiudades.getVertex(i);
		caminoAux.add(v.getData());
		if (v.getData().equals(destino) && recargasAct < recargasMin) {
			caminoDef.clear();
			caminoDef.addAll(caminoAux);
			recargasMin = recargasAct;
		} else {
			List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(v);
			Iterator<Edge<String>> it = adyacentes.iterator();

			while (it.hasNext() && recargasAct < recargasMin) {
				Edge<String> e = it.next();
				int j = e.getTarget().getPosition();
				int distancia = e.getWeight();

				if (!marca[j]) {
					// El tanque de combustible posee suficiente para llegar al destino
					if (tanqueActual >= distancia)
						recargasMin = dfsCaminoMenorCargaCombustible(caminoAux, caminoDef, marca, j,
								tanqueActual - distancia,
								tanqueTotal, recargasAct, recargasMin, destino);
					// El tanque de combustible no posee suficiente. Debe recargar (tanqueActual =
					// tanqueTotal y recargasAct++). La capacidad del tanque lleno debe ser
					// suficiente
					else if (tanqueTotal >= distancia)
						recargasMin = dfsCaminoMenorCargaCombustible(caminoAux, caminoDef, marca, j,
								tanqueTotal - distancia,
								tanqueTotal,
								recargasAct + 1, recargasMin, destino);
				}
			}
		}

		marca[i] = false;
		caminoAux.remove(v.getData());
		return recargasMin;
	}
}
