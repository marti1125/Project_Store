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
	public int cantidadInicial;
	
	@Required
    @ManyToOne
    public Usuario usuario;
	
	public Producto(Usuario usuario, String descripcion, int cantidadInicial){
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.cantidadInicial = cantidadInicial;
	}
	
	public String toString() {
		return descripcion;
	}
	
}
