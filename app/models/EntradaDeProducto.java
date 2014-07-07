package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class EntradaDeProducto extends Model{

	@Required
    @ManyToOne
    public ProductoDetalle productoDetalle;

	@Required
	public int cantidad;	
	
	@Required
	public Date fechaDeEntrada;
	
	public String toString() {
		DateTimeFormatter formatterHora = DateTimeFormat.forPattern("dd/MM/yyyy");
		LocalDateTime localDateTime = new LocalDateTime(this.fechaDeEntrada);
		return "Producto: " + this.productoDetalle.producto.descripcion + " Cantidad: "+
				String.valueOf(this.cantidad) + " Fecha: " +  localDateTime.toString(formatterHora);
	}	
	
}