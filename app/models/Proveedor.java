package models;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
public class Proveedor extends Model {
	
	public String descripcion;
	
	public String toString(){
		return this.descripcion;
	}
	
}
