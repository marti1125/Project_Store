package models;

import java.util.*;

import javax.persistence.*;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class SalidaDeProducto extends Model{
	
	@Required
	@ManyToOne
	public ProductoDetalle productoDetalle;
	
	@Required
    @ManyToOne
    public Tienda tienda;

	@Required
	public int cantidad;	
	
	@Required
	public Date fechaDeSalida;
	
	public String toString() {
		DateTimeFormatter formatterHora = DateTimeFormat.forPattern("dd/MM/yyyy");
		LocalDateTime localDateTime = new LocalDateTime(this.fechaDeSalida);
		return "Producto: " + this.productoDetalle.producto.descripcion + " Cantidad: "+
				String.valueOf(this.cantidad) + " Fecha: " +  localDateTime.toString(formatterHora);
	}	

}