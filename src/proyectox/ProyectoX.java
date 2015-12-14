package proyectox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import proyectox.model.Calificacion;
import proyectox.model.Pelicula;
import proyectox.model.Resumen;
import proyectox.view.GUI;

/**
 * @author gbern
 *
 */
public class ProyectoX {

	public LinkedList<Pelicula> top10Categoria(LinkedList<Pelicula> P, String Categoria) {
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

	public LinkedList<Calificacion> calificacionesFecha(LinkedList<Calificacion> C) {
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

	public static LinkedList<Resumen> cargar(boolean b) {
		if (b)
			return resumir();
		long tiempoInicio = System.currentTimeMillis();
		FileReader fr;
		BufferedReader br;
		String linea;
		String datos[];
		Resumen r;
		LinkedList<Resumen> lista = new LinkedList<>();
		try {
			fr = new FileReader(GUI.nombreResumen);
			br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				datos = linea.split("|");
				int idPelicula = Integer.parseInt(datos[0]);
				float promedio = Float.parseFloat(datos[1]);
				String primera = datos[2];
				String ultima = datos[3];
				r = new Resumen(idPelicula, promedio, primera, ultima);
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
		System.out.println("Resumen generado en " + (tiempoInicio - System.currentTimeMillis()));
		return lista;
	}

	@SuppressWarnings("finally")
	public static LinkedList<Resumen> resumir() {
		LinkedList<Resumen> res = new LinkedList<>();
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
					Resumen r = resumirArchivo(file);
					res.add(r);
					bufferedWriter.write(r.toString());
					bufferedWriter.newLine();
				}
				System.out.println("Pelicula #" + file.getName().replaceAll("\\D+", "") + ", tiempo de resumen: "
						+ (System.currentTimeMillis() - startTime) + "ms");
			}
			JOptionPane.showMessageDialog(null,"Resumen generado exitosamente en " + (System.currentTimeMillis()- tiempoInicio));

			bufferedWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			return res;
		}

	}

	public static Resumen resumirArchivo(File arch) {
		FileReader fr;
		BufferedReader br;
		String linea;
		String datos[];
		float promedio = 0;
		int idPelicula;
		String primera = "", ultima = "";
		int c = 0; // contador de lineas

		try {
			fr = new FileReader(arch);
			br = new BufferedReader(fr);
			idPelicula = Integer.parseInt(br.readLine().replaceAll("\\D+", ""));

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
			Resumen r = new Resumen(idPelicula, promedio, primera, ultima);
			return r;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Archivo con mal formato");
		} catch (FileNotFoundException ex) {
			System.out.println("El archivo no existe");
		} catch (IOException ex) {
			System.out.println("Error de lectura de archivo!!");
		}
		return null;
	}

}
