package models;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
public class Tienda extends Model {
	
	public String descripcion;
	
	public String direccion;
	
	public String toString(){
		return this.descripcion;
	}
	
}