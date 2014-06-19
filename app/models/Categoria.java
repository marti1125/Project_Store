package models;

import javax.persistence.*;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Categoria extends Model{
	
	@Required
	public String descripcion;
	
	public String toString() {		
		return descripcion;
	}

}
