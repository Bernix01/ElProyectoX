/**
 *
 */
package proyectox.model;

/**
 * @author gbern
 *
 */
public class Resumen {

	private int idPelicula;
	private float promedio;
	private String fechaPrimeraValoracion;
	private String fechaUltimaValoracion;

	public Resumen(int idPelicula, float promedio, String fechaPrimeraValoracion, String fechaUltimaValoracion) {
		this.idPelicula = idPelicula;
		this.promedio = promedio;
		this.fechaPrimeraValoracion = fechaPrimeraValoracion;
		this.fechaUltimaValoracion = fechaUltimaValoracion;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public float getPromedio() {
		return promedio;
	}

	public String getFechaPrimeraValoracion() {
		return fechaPrimeraValoracion;
	}

	public String getFechaUltimaValoracion() {
		return fechaUltimaValoracion;
	}

	@Override
	public String toString() {
		return idPelicula + "|"+promedio+"|"+fechaPrimeraValoracion+"|"+fechaUltimaValoracion;
	}

}
