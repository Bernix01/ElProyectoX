/**
 *
 * @CarlosCedeniio
 */
public class Pelicula {
    private int id;
    private int año;
    private String titulo;
    private int rating;
    private int cRating;
    
    public Pelicula(){
        id=0;
        año= 0;
        titulo= null;
        rating= 0;
        cRating=0;
    }
    
    public Pelicula(int id, int año, String titulo, int rating, int cRating){
        this.id=id;
        this.año=año;
        this.titulo=titulo;
        this.rating=rating;
        this.cRating=cRating;
    }

    public int getId() {
        return id;
    }

    public int getAño() {
        return año;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getRating() {
        return rating;
    }

    public int getcRating() {
        return cRating;
    }
    
    public void addRating(int voto){
        this.rating=(voto+this.rating)/2;
        this.cRating++;    
    }
    
}
