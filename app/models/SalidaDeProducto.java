package models;

import java.util.*;

import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class SalidaDeProducto extends Model{
	
	@Required
	@ManyToOne
	public ProductoDetalle productoDetalle;

	@Required
	public int cantidad;	
	
	@Required
	public Date fechaDeSalida;
	
	public String toString() {		
		return String.valueOf(this.cantidad);
	}

}