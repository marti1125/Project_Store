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
	public int cantidad;
	
	@Required
	public Double costo;
	
	@Required
	public Double precioVenta;
	
	@Required
	public Date fechaDeIngreso;
	
	@Required
	@ManyToOne
	public Distribuidor distribuidor;
	
}
