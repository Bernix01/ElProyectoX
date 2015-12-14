package proyectox;

public class ProyectoX {
	public LinkedList<Pelicula> Top10Categoria(LinkedList<> P,String Categoria){
		LinkedList<> C = new Linked List<>;
    		Iterator <> iter = P.iterator();
    		while (iter.hasNext()){
	      		Pelicula T = (Pelicula) iter.next();
	      		if (T.categoria == this.Categoria)
	        		C.add(T);
	    		}
    		Collections.sort(C, new Comparator() {
	  		@Override
	  		public int compare(Pelicula p1, Pelicula p2) {
	  			if !(p2.getRating()).compareTo(new Integer(p1.getRating()))==0){
			  		return new Integer(p2.getRating()).compareTo(new Integer(p1.getRating()));
			  	}
			  	else{
			  		return new Integer(p1.getId()).compareTo(new Integer(p2.getId()));
			  	}
			  }
		}
	      	return (C);
	}
	public LinkedList<Calificacion> CalificacionesFecha (LinkedList<> C){
	  	Collection.sort(C, new Comparator(){
	  		@override
	      		public int compare(Calificacion c1, Calificacion c2){
	      			if (c1.getDate() == null || c2.getDate() == null)
	        			return 0;
	        		return c2.getDate().compareTo(c1.getDate());
	      		}
	  	}
	      	return (C);
	}
  
	public LinkedList<LinkedList<Pelicula>> ListaPeliculasAño (LinkedList<> C){
	  	LinkedList<LinkedList<Pelicula>> L = new LinkedList<>;
	  	Collections.sort(C, new Comparator() {
			@Override
			public int compare(Pelicula p1, Pelicula p2) {
		  		if !(p2.getDate()).compareTo(new Integer(p1.getDate()))==0){
		  			return new Integer(p2.getDate()).compareTo(new Integer(p1.getDate()));
		  		}
		  		else{
		  			return new Integer(p1.getId()).compareTo(new Integer(p2.getId()));
		  		}
			}
	      	}
	      	Iterator <> iter = P.iterator();
    		while (iter.hasNext()){
    		//No se como hacer para hacer la lista de listas de años :(
    		}
    		
      				
      				
      				
	}
	
	public LinkedList<LinkedList<Pelicula>> ListaOrdenadaPorCalificacion (LinkedList<> C){
		Collections.sort(C, new Comparator() {
	  		@Override
	  		public int compare(Pelicula p1, Pelicula p2) {
	  			if (p2.getRating()).compareTo(new Integer(p1.getRating()))==0){
			  		return new Integer(p1.getRating()).compareTo(new Integer(p2.getRating()));
			  	}
			  	else{
			  		return new Integer(p2.getId()).compareTo(new Integer(p1.getId()));
			  	}
			  }
		}
	      	return (C);
	}
	
	public LinkedList<LinkedList<Pelicula>> ListaOrdenadaAlfabetica (LinkedList<> C){
		Collections.sort(C, new Comparator() {
			@override
			public int compare(Pelicula p1, Pelicula p2) {
				return new String(p1.getNombre()).compareTo(new String(p1.getNombe()));
			}
		}
		return (C);
	}
	
	
    
}
