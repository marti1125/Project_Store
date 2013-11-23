package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

import enums.*;

@Entity
public class EstadoDelProducto extends Model{
	
    @ManyToOne
    public Producto producto;
	
	@Enumerated(EnumType.STRING)
	public Estado estado;
	
	public String getEstado(){
		if(estado.toString() == "V"){
			return Estado.V.descripcion;
		} else if(estado.toString() == "P") {
			return Estado.P.descripcion;
		} else {
			return "";
		}
	}
}
