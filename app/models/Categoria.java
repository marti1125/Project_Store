package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Categoria extends Model{
	
	@Required
    @ManyToOne
    public Producto producto;
	
	@Required
	public String descripcion;
	
	public String toString() {		
		return producto.toString() +  " " + descripcion;
	}

}
