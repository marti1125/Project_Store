package models;

import javax.persistence.*;

import play.data.validation.Required;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;

@Entity
public class Tienda extends GenericModel {
	
	@Id
	@Required
	public String codigo;
	
	public String nombre;
	
	public String direccion;
	
	public String telefono;
	
	@ManyToOne
	public Usuario usuario;
	
	public String toString(){
		return this.nombre;
	}
	
}