package models;

import javax.persistence.*;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class ProductoDetallePorTienda extends Model {
	
	@Required
    @ManyToOne
    public ProductoDetalle productoDetalle;
	
	@Required
    @ManyToOne
    public Tienda tienda;
	
	public String toString(){
		return "Producto: " + this.productoDetalle.producto.descripcion+" Tienda:  "+this.tienda.toString();
	}
	
}
