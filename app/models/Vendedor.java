package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Vendedor extends Model {
	
	public String apPaterno;
	
	public String apMaterno;
	
	public String nombres;
	
	public String email;
	
	public String telefono;
	
	public String telefono_mobil;

}
