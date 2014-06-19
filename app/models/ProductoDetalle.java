package models;

import java.util.Date;

import javax.persistence.*;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class ProductoDetalle extends Model {
	
	@Required
	@ManyToOne
	public Producto producto;
	
	@Required
	@ManyToOne
	public Categoria categoria;
	
	@Required
	@ManyToOne
	public Proveedor proveedor;
	
	@Required
	public int cantidad;
	
	@Required
	public Double costo;
	
	@Required
	public Date fechaDeIngreso;
	
}
