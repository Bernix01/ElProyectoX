package proyectox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import proyectox.model.Pelicula;
import proyectox.view.GUI;

/**
 * @author gbern
 *
 */
public class ProyectoX {

	public LinkedList<Pelicula> top10Categoria(ArrayList<Pelicula> r) {

//		LinkedList<Pelicula> Temporal = new LinkedList<>();
//		LinkedList<Pelicula> Top10
//		Iterator iter = r.iterator();
//		while (iter.hasNext()) {
//			Pelicula T = (Pelicula) iter.next();
//			if (T.rating == this.){
//				Temporal.add(T);
//			}
//		}
//		Collections.sort(Temporal, new Comparator<Pelicula>() {
//			@Override
//			public int compare(Pelicula p1, Pelicula p2) {
//				return Math.round(p2.getRating() - p1.getRating());
//			}
//		});
//		for (int i=1; i<=10 ;i++){
//			Top10.add(Temporal[i])
//		}
//		return (Top10);
		return null;
	}

	public static LinkedList<Pelicula> listaPeliculasanio(ArrayList<Pelicula> C, int ano) {
		/*
		 * Collections.sort(C, new Comparator<Pelicula>() {
		 *
		 * @Override public int compare(Pelicula p1, Pelicula p2) { return
		 * p1.getAno() - p2.getAno(); }
		 */
		LinkedList<Pelicula> ListaPorAnio = new LinkedList<>();
		Iterator iter = C.iterator();
		while (iter.hasNext()) {
			Pelicula T = (Pelicula) iter.next();
			if (T.getAno() == ano) {
				ListaPorAnio.add(T);
			}
		}

		return ListaPorAnio;

	}

	public static ArrayList<Pelicula> listaOrdenadaPorCalificacion(ArrayList<Pelicula> C) {
		Collections.sort(C, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
				return ((int)(p2.getRating() - p1.getRating()));
			}
		});
		return C;
	}

	public static ArrayList<Pelicula> listaPeliculasOrdenAnio(ArrayList<Pelicula> C) {
		Collections.sort(C, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
				return p2.getAno() - p1.getAno();
			}
		});
		return C;
	}

	public static ArrayList<Pelicula> listaOrdenadaAlfabetica(ArrayList<Pelicula> C) {
		Collections.sort(C, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
				return p1.getTitulo().compareTo(p2.getTitulo());
			}
		});
		return C;
	}

	/***
	 * Genera el resumen si recibe verdadero, caso contrario, carga el resumen
	 * existente. Este método no revisa si el resumen existe por lo que debe la
	 * verificación debe hacer antes.
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @param b
	 *            - Define si genera o carga el resumen.
	 * @return Lista de películas con datos resumidos.
	 */
	public static ArrayList<Pelicula> cargar(boolean b) {
		if (b)
			return resumir();
		long tiempoInicio = System.currentTimeMillis();
		FileReader fr;
		BufferedReader br;
		String linea;
		String datos[];
		Pelicula r;
		ArrayList<Pelicula> lista = new ArrayList<>();
		try {
			fr = new FileReader(GUI.NOMBRERESUMEN);
			br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				datos = linea.split("\\|");
				int idPelicula = Integer.parseInt(datos[0]);
				float promedio = Float.parseFloat(datos[1]);
				String primera = datos[2];
				String ultima = datos[3];
				int ano = Integer.parseInt(datos[4]);
				String titulo = datos[5];
				r = new Pelicula(idPelicula, ano, titulo, primera, ultima, promedio);
				lista.add(r);
			}
			System.out.println("Resumen cargado en " + (System.currentTimeMillis() - tiempoInicio) + "ms");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Archivo con mal formato");
		} catch (FileNotFoundException ex) {
			System.out.println("El archivo no existe");
		} catch (IOException ex) {
			System.out.println("Error de lectura de archivo!!");
		}
		return lista;
	}

	/***
	 * Resume los archivos de historial de calificaciones y retorna una lista de
	 * películas con los datos procesados.
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @return - lista de películas con historial procesado.
	 */
	public static ArrayList<Pelicula> resumir() {
		LinkedList<Pelicula> res = cargarTitulos();
		ArrayList<Pelicula> pelis = new ArrayList<>(res.size());
		File folder = new File("data/download/training_set/");
		File[] listOfFiles = folder.listFiles();
		FileWriter fileWriter;
		long tiempoInicio = System.currentTimeMillis();
		try {
			fileWriter = new FileWriter(GUI.NOMBRERESUMEN);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < listOfFiles.length; i++) {
				File file = listOfFiles[i];
				if (file.isFile() && file.getName().endsWith(".txt")) {
					Pelicula r = resumirArchivo(file, res);
					pelis.add(r);
					bufferedWriter.write(r.toString());
					bufferedWriter.newLine();
				}
			}
			JOptionPane.showMessageDialog(null,
					"Peliculas cargadas exitosamente en " + (System.currentTimeMillis() - tiempoInicio)+" ms");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pelis;

	}

	/***
	 * Carga el archivo movie titles dentro de una lista y los retorna. En caso
	 * de error, retornara una lista incompleta o vacía.
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @return Lista de pelicula
	 */
	private static LinkedList<Pelicula> cargarTitulos() {
		FileReader fr;
		BufferedReader br;
		String linea;
		String datos[];
		Pelicula r;
		LinkedList<Pelicula> lista = new LinkedList<>();
		Long inicial = System.currentTimeMillis();
		try {
			fr = new FileReader(GUI.MOVIES_TITLES);
			br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				datos = linea.split(",");
				int idPelicula = Integer.parseInt(datos[0]);
				int ano = !datos[1].equals("NULL") ? Integer.parseInt(datos[1]) : -1;
				String titulo = datos[2];
				r = new Pelicula(idPelicula, ano, titulo);
				lista.add(r);
			}
			System.out.println("Titulos cargados en: " + (System.currentTimeMillis() - inicial) / 100 + "s \t Total: "
					+ lista.size());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Archivo con mal formato");
		} catch (FileNotFoundException ex) {
			System.out.println("El archivo no existe");
		} catch (IOException ex) {
			System.out.println("Error de lectura de archivo!!");
		}
		return lista;
	}

	/**
	 * Resume un archivo de historial en una película, la pelicula se debe
	 * encontrar dentro de la lista de peliculas que se recibe, una vez que el
	 * historial es resumido, la pelicula es removida de la lista recibida y
	 * retornada. Retorna null si el historial no tiene su correspondiente
	 * película dentro de la lista.
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @param arch
	 *            - archivo con el historial
	 * @param peliculas
	 *            - lista de peliculas
	 * @return pelicula con historial procesado
	 */
	public static Pelicula resumirArchivo(File arch, LinkedList<Pelicula> peliculas) {
		FileReader fr;
		BufferedReader br;
		String linea;
		String datos[];
		float promedio = 0;
		int idPelicula;
		String primera = "", ultima = "";
		int c = 0; // contador de lineas
		Pelicula fi;
		Long inicial = System.currentTimeMillis();
		try {
			fr = new FileReader(arch);
			br = new BufferedReader(fr);
			idPelicula = Integer.parseInt(br.readLine().replaceAll("\\D+", ""));
			int pos = Collections.binarySearch(peliculas, new Pelicula(idPelicula),new Comparator<Pelicula>(){

				@Override
				public int compare(Pelicula o1, Pelicula o2) {
					return o1.getId() - o2.getId();
				}

			});
			if (pos < 0)
				return null;
			fi = peliculas.remove(pos);
			while ((linea = br.readLine()) != null) {
				datos = linea.split(",");
				promedio += Integer.parseInt(datos[1]);
				if (primera.compareTo(datos[2]) != -1)
					primera = datos[2];
				if (ultima.compareTo(datos[2]) != 1)
					ultima = datos[2];
				c++;
			}
			promedio = promedio / c;
			fi.agregarDatosResumidos(promedio, primera, ultima);
			br.close();
			return fi;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Archivo con mal formato");
		} catch (FileNotFoundException ex) {
			System.out.println("El archivo no existe");
		} catch (IOException ex) {
			System.out.println("Error de lectura de archivo!!");
		}
		return null;
	}

	/***
	 * Genera el TOP 10 de cada rating (1-5)
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @param r - lista de peliculas
	 */
	public static void genTop10(ArrayList<Pelicula> r) {
		String escrito;

	}

	public static void generarListaDeAnio(ArrayList<Pelicula> r, int anio){
		guardar(listaPeliculasanio(r, anio),"PeliculasDAnio");
	}

	/***
	 * Guarda la lista de peliculas ordenadas por año.
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @param r
	 */
	public static void generarListaXCalificacion(ArrayList<Pelicula> r) {
		guardar(listaOrdenadaPorCalificacion(r), "PeliculasXCalificacion");
	}

	/***
	 * Genera el archivo .json de la lista de peliculas ordenada por año
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @param r
	 *            - la lista de peliculas
	 */
	public static void generarListaXAno(ArrayList<Pelicula> r) {
		guardar(listaPeliculasOrdenAnio(r), "PeliculasXAnio");
	}

	/***
	 * Genera el archivo .json de la lista de peliculas ordenada alfabeticamente
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @param r
	 *            - Lista de peliculas
	 */
	public static void generarListaABC(ArrayList<Pelicula> r) {
		guardar(listaOrdenadaAlfabetica(r), "PeliculasABC");
	}

	/***
	 * Busca coincidencias de películas dentro de la lista dada y las guarda.
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @param resumenes
	 *            - lista de peículas
	 * @param palabra
	 *            - palabra a buscar dentro de los títulos de resumen
	 */
	public static void generarCoincidenciasDePalabra(ArrayList<Pelicula> resumenes, String palabra) {
		LinkedList<Pelicula> coincidencias = new LinkedList<>();
		for (Pelicula p : resumenes) {
			if (p.getTitulo().contains(palabra))
				coincidencias.add(p);
		}
		guardar(coincidencias, "coincidencias");
	}

	/***
	 * Guarda la lista de películas en un archivo de nombre dado, con formato
	 * .json
	 *
	 * @author Guillermo Bernal <gbernal096@gmail.com>
	 * @param peliculas
	 *            - lista de películas a guardar
	 * @param archivo
	 *            - nobre del archivo a guardar
	 */
	private static void guardar(List<Pelicula> peliculas, String archivo) {
		final String basePath = "html/dist/data/";
		FileWriter fileWriter;
		int i = 0;
		try {
			fileWriter = new FileWriter(basePath + archivo + ".json");
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("{\"peliculas\": [");
			for (Pelicula p : peliculas) {
				bufferedWriter.write(p.paraGuardar());
				if (i != peliculas.size() - 1) {
					bufferedWriter.write(",");
				}
				i++;
			}
			bufferedWriter.write("]}");
			bufferedWriter.close();
			JOptionPane.showMessageDialog(null, "Reporte generado con exito.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
