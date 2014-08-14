package models;

import javax.persistence.*;

import play.data.validation.Required;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;

@Entity
public class Distribuidor extends GenericModel {
	
	@Id
	@Required
	public int ruc;
	
	public String nombre;
	
	public String direccion;
	
	public String telefono;
	
	@ManyToOne
	public Vendedor vendedor;
	
	public String toString(){
		return this.nombre;
	}
	
}
