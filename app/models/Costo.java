package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class Costo extends Model{

	@Required
	public Double costo;
	
	@Required
	public Date fechaCostoIngresado;

}