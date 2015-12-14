package proyectox.model;

import java.util.Date;

/**
 *
 * @CarlosCedeniio
 */
public class Calificacion implements Comparable<Calificacion> {
	private int rating;
	private String date;
	private int mid;

	public Calificacion(int rating, String date, int mid) {
		this.rating = rating;
		this.date = date;
		this.mid = mid;
	}


	public int getRating() {
		return rating;
	}

	public String getDate() {
		return date;
	}

	public int getMid() {
		return mid;

	}


	@Override
	public int compareTo(Calificacion arg0) {
		return this.date.compareTo(arg0.getDate());
	}


}
