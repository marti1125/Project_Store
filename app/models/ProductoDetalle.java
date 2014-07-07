package models;

import java.util.Date;

import javax.persistence.*;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
	
	public boolean activo;
	
	public String toString(){
		DateTimeFormatter formatterHora = DateTimeFormat.forPattern("dd/MM/yyyy");
		LocalDateTime localDateTime = new LocalDateTime(this.fechaDeIngreso);
		return "Producto: " + this.producto.descripcion + " Cantidad: " + this.cantidad + 
				" Fecha de Ingreso: " + localDateTime.toString(formatterHora) + "" +
						" Costo: " + this.costo.toString();
	}
	
}
