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

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import proyectox.model.Calificacion;
import proyectox.model.Pelicula;
import proyectox.model.Pelicula;
import proyectox.view.GUI;

/**
 * @author gbern
 *
 */
public class ProyectoX {

	public LinkedList<Pelicula> top10Categoria(LinkedList<Pelicula> r) {

		LinkedList<Pelicula> C = new LinkedList<>();
		Iterator iter = r.iterator();
		while (iter.hasNext()) {
			Pelicula T = (Pelicula) iter.next();
			/*
			 * if (T.categoria == this.Categoria) C.add(T); }
			 */
			Collections.sort(C, new Comparator<Pelicula>() {
				@Override
				public int compare(Pelicula p1, Pelicula p2) {
					return Math.round(p1.getRating() - p2.getRating());
				}
			});
		}
		return (C);
	}

	public LinkedList<Calificacion> calificacionesFecha(LinkedList<Calificacion> C) {
		Collections.sort(C, new Comparator<Calificacion>() {
			@Override
			public int compare(Calificacion c1, Calificacion c2) {
				return c2.getDate().compareTo(c1.getDate());
			}
		});
		return (C);
	}

	public LinkedList<Pelicula> listaPeliculasanio(LinkedList<Pelicula> C) {
		LinkedList<Pelicula> L = new LinkedList<>();
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

	public LinkedList<Pelicula> listaOrdenadaPorCalificacion(LinkedList<Pelicula> C) {
		Collections.sort(C, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
				return p2.getId() - p1.getId();
			}
		});
		return (C);
	}

	public LinkedList<Pelicula> listaOrdenadaAlfabetica(LinkedList<Pelicula> C) {
		Collections.sort(C, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
				return p1.getTitulo().compareTo(p1.getTitulo());
			}
		});
		return C;
	}

	public static LinkedList<Pelicula> cargar(boolean b) {
		if (b)
			return resumir();
		long tiempoInicio = System.currentTimeMillis();
		FileReader fr;
		BufferedReader br;
		String linea;
		String datos[];
		Pelicula r;
		LinkedList<Pelicula> lista = new LinkedList<>();
		try {
			fr = new FileReader(GUI.nombreResumen);
			br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				datos = linea.split("|");
				int idPelicula = Integer.parseInt(datos[0]);
				float promedio = Float.parseFloat(datos[1]);
				String primera = datos[2];
				String ultima = datos[3];
				int ano = Integer.parseInt(datos[4]);
				String titulo = datos[5];
				r = new Pelicula(idPelicula,ano,titulo,primera,ultima,promedio);
				lista.add(r);
				System.out.println("Resumen cargado en " + (tiempoInicio - System.currentTimeMillis()));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Archivo con mal formato");
		} catch (FileNotFoundException ex) {
			System.out.println("El archivo no existe");
		} catch (IOException ex) {
			System.out.println("Error de lectura de archivo!!");
		}
		System.out.println("Resumen cargado en " + (tiempoInicio - System.currentTimeMillis()));
		return lista;
	}

	@SuppressWarnings("finally")
	public static LinkedList<Pelicula> resumir() {
		LinkedList<Pelicula> res = cargarTitulos();
		ArrayList<Pelicula> pelis = new ArrayList<>(res.size());
		File folder = new File("data/download/training_set/");
		File[] listOfFiles = folder.listFiles();
		FileWriter fileWriter;
		long tiempoInicio = System.currentTimeMillis();
		try {
			fileWriter = new FileWriter(GUI.nombreResumen);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < listOfFiles.length; i++) {
				long startTime = System.currentTimeMillis();
				File file = listOfFiles[i];
				if (file.isFile() && file.getName().endsWith(".txt")) {
					Pelicula r = resumirArchivo(file,res);
					pelis.add(r);
					bufferedWriter.write(r.toString());
					bufferedWriter.newLine();
				}
			}
			JOptionPane.showMessageDialog(null,"Pelicula generado exitosamente en " + (System.currentTimeMillis()- tiempoInicio));
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return res;
		}

	}

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
				int ano = datos[1] == "NULL" ? Integer.parseInt(datos[1]) : -1;
				String titulo = datos[2];
				r = new Pelicula(idPelicula,ano,titulo);
				lista.add(r);
			}
			System.out.println("Titulos cargados en: "+(System.currentTimeMillis() - inicial)/100 + "s \t Total: "+lista.size() );

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
	 *
	 * @param arch
	 * @return
	 */
	public static Pelicula resumirArchivo(File arch, LinkedList<Pelicula>  peliculas) {
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
			int pos = Collections.binarySearch(peliculas, new Pelicula(idPelicula));
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

	public static LinkedList<Pelicula> consolidarPelicula(LinkedList<Pelicula> resumen){
		for(Pelicula r : resumen){

		}
		return resumen;
	}

	public static void genTop10(LinkedList<Pelicula> r){
		String escrito;

	}

	public static void genListA(LinkedList<Pelicula> r){

	}
	public static LinkedList<Pelicula> buscarPelicula(LinkedList<Pelicula> resumenes,String palabra){
		LinkedList<Pelicula> coincidencias = new LinkedList<>();
		for(Pelicula r:resumenes)
			if(r.getTitulo().contains(palabra))
				coincidencias.add(r);
		return coincidencias;
	}
}
