package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class Producto extends Model{
	
	@Lob
    @Required
    @MaxSize(10000)
	public String descripcion;	
	
	@Required
	public int cantidadInicial = 0;
	
	@ManyToOne
    public Usuario usuario;
	
	public String toString() {
		return descripcion + " Cantidad: " + cantidadInicial;
	}
	
}
