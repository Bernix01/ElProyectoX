package proyectox.model;

/**
 *
 * @CarlosCedeniio
 */
public class Pelicula implements Comparable<Pelicula> {
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

	@Override
	public int compareTo(Pelicula arg0) {
		return this.id - arg0.id;
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
		return "{\"id\":\""+id
				+"\",\"calificacion\":"+rating
				+"\",\"primeraValoracion\":\""+fechaPrimeraValoracion
				+"\",\"ultimaValoracion\":\""+fechaUltimaValoracion
				+"\",\"titulo\":\""+titulo
				+"\",\"ano\":\""+ano
				+"\"}";
	}
}
