package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

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
		return String.valueOf(this.cantidad);
	}	
	
}