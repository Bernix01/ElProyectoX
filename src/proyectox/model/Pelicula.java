package proyectox.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @CarlosCedeniio
 */
public class Pelicula {
	private int id;
	private int ano;
	private String titulo;
	private String fechaPrimeraValoracion;
	private String fechaUltimaValoracion;
	private float rating;

	/**
	 * @param id
	 *            - el id de la pelicula
	 * @param ano
	 *            - el año de la pelicula
	 * @param titulo
	 *            - el titulo de la pelicula
	 * @param fechaPrimeraValoracion
	 *            - primera valoracion
	 * @param fechaUltimaValoracion
	 * @param rating
	 */
	public Pelicula(int id, int ano, String titulo, String fechaPrimeraValoracion, String fechaUltimaValoracion,
			float rating) {
		this.id = id;
		this.ano = ano;
		this.titulo = titulo;
		this.fechaPrimeraValoracion = fechaPrimeraValoracion;
		this.fechaUltimaValoracion = fechaUltimaValoracion;
		this.rating = rating;
	}

	public Pelicula(int id){
		this.id = id;
	}

	public Pelicula(int idPelicula, int ano, String titulo) {
		this.id = idPelicula;
		this.ano = ano;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public int getAno() {
		return ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public float getRating() {
		return rating;
	}

	public void agregarDatosResumidos(float ratingPromedio, String primera, String ultima) {
		this.rating = ratingPromedio;
		this.fechaPrimeraValoracion = primera;
		this.fechaUltimaValoracion = ultima;
	}
	@Override
	public String toString() {
		return id + "|"+rating+"|"+fechaPrimeraValoracion+"|"+fechaUltimaValoracion+"|"+ano+"|"+titulo;
	}

	public String paraGuardar(){
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.CEILING);
		String roundedRating = df.format(rating);
		return "{\"id\":"+id
				+",\"calificacion\":\""+roundedRating
				+"\",\"primeraValoracion\":\""+fechaPrimeraValoracion
				+"\",\"ultimaValoracion\":\""+fechaUltimaValoracion
				+"\",\"titulo\":\""+StringEscapeUtils.escapeJava(titulo)
				+"\",\"ano\":\""+(ano == -1 ? "-":ano)
				+"\"}";
	}
}
