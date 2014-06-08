package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class ProductoPorTienda extends Model {
	
	@Required
    @ManyToOne
    public Tienda tienda;
	
	@Required
    @ManyToOne
    public Producto producto;
	
	public String toString(){
		return this.tienda.toString() + " - " + this.producto.toString();
	}
	
}
