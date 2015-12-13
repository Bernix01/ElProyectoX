package proyectox.model;

/**
 *
 * @CarlosCedeniio
 */
public class Pelicula {
    private int id;
    private int ano;
    private String titulo;
    private int rating;
    private int cRating;

    public Pelicula(){
        id=0;
        ano= 0;
        titulo= null;
        rating= 0;
        cRating=0;
    }

    public Pelicula(int id, int ano, String titulo, int rating, int cRating){
        this.id=id;
        this.ano=ano;
        this.titulo=titulo;
        this.rating=rating;
        this.cRating=cRating;
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
