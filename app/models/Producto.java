package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class Producto extends Model {
	
	@Required
	public String codigo;
	
	@Lob
    @Required
    @MaxSize(10000)
	public String descripcion;
	
	public String toString() {
		return this.codigo + " - " + this.descripcion;
	}
	
}
