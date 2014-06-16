package models;

import org.hibernate.annotations.Entity;

import play.db.jpa.Model;

@Entity
public class Proveedor extends Model {
	
	public String descripcion;
	
	public String toString(){
		return this.descripcion;
	}
	
}
