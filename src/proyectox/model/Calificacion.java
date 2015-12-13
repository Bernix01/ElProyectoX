package proyectox.model;


import java.util.Date;
/**
 *
 * @CarlosCedeniio
 */
public class Calificacion {
    private int cid;
    private int rating;
    private Date date;
    private int mid;

    public Calificacion (int cid, int rating, Date date, int mid){
        this.cid=cid;
        this.rating=rating;
        this.date=date;
        this.mid=mid;
    }

    public int getCid() {
        return cid;
    }

    public int getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    public int getMid() {
        return mid;
    }




}
