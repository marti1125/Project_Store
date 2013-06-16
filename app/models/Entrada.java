package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class Entrada extends Model{

	@Required
    @ManyToOne
    public Producto producto;

	@Required
	public int cantidad;	
	
	@Required
	public Date fechaDeEntrada;
	
	public String toString() {
		return this.producto.toString() + " "+"Cantidad: "+ this.cantidad;
	}
	
}