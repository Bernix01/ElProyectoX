package proyectox;

public class ProyectoX {
  public LinkedList<Pelicula> Top10Categoria (LinkedList<> P,String Categoria){
    LinkedList<> C = New Linked List<>;
    Iterator <> iter = P.iterator();
    while (P.hasNext()){
      Pelicula T = (Pelicula) P.next();
      if (T.categoria == this.Categoria)
        C.add(T);
    }
    Collections.sort(C, new Comparator() {
	  @Override
	  public int compare(Pelicula p1, Pelicula p2) {
	  	return new Integer(p2.getRating()).compareTo(new Integer(p1.getRating()));
	  }
      }
  
  public LinkedList<Calificacion> CalificacionesFecha (LinkedList<> C){
    Collection.sort(C, new Comparator(){
      @override
      public int compare(Calificacion c1, Calificacion c2){
        return c1.getDateTime().compareTo(c2.getDateTime());
        
      }
    }
  }
    
    
  
  }
  

}
