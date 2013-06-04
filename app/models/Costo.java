package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class Costo extends Model{

	@Required
    @ManyToOne
    public Producto producto;

	@Required
	public Double costo;	
	
	@Required
	public Double precio;

	@Required
	public Date fechaCostoIngresado;

}