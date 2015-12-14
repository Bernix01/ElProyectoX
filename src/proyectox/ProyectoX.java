package proyectox;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.stage.Stage;
import proyectox.model.Calificacion;
import proyectox.model.Pelicula;

/**
 * @author gbern
 *
 */
public class ProyectoX {

	public LinkedList<Pelicula> Top10Categoria(LinkedList<Pelicula> P, String Categoria) {
		LinkedList<Pelicula> C = new LinkedList<>();
		Iterator iter = P.iterator();
		while (iter.hasNext()) {
			Pelicula T = (Pelicula) iter.next();
			/*
			 * if (T.categoria == this.Categoria) C.add(T); }
			 */
			Collections.sort(C, new Comparator<Pelicula>() {
				@Override
				public int compare(Pelicula p1, Pelicula p2) {
					return p1.getcRating() - p2.getRating();
				}
			});
		}
		return (C);
	}

	public LinkedList<Calificacion> CalificacionesFecha(LinkedList<Calificacion> C) {
		Collections.sort(C, new Comparator<Calificacion>() {
			@Override
			public int compare(Calificacion c1, Calificacion c2) {
				return c2.getDate().compareTo(c1.getDate());
			}
		});
		return (C);
	}

	public LinkedList<LinkedList<Pelicula>> listaPeliculasanio(LinkedList<Pelicula> C) {
		LinkedList<LinkedList<Pelicula>> L = new LinkedList<>();
		Collections.sort(C, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
				return p1.getAno() - p2.getAno();
			}
		});
		Iterator iter = C.iterator();
		while (iter.hasNext()) {
			// No se como hacer para hacer la lista de listas de años :(
		}
		return L;

	}

	public LinkedList<Pelicula> ListaOrdenadaPorCalificacion(LinkedList<Pelicula> C) {
		Collections.sort(C, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
				return p2.getId() - p1.getId();

			}
		});
		return (C);
	}

	public LinkedList<Pelicula> ListaOrdenadaAlfabetica(LinkedList<Pelicula> C) {
		Collections.sort(C, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
				return p1.getTitulo().compareTo(p1.getTitulo());
			}
		});
		return C;
	}



}
