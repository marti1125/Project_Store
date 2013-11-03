package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

import enums.*;

@Entity
public class EstadoDelProducto extends Model{
	
	public String producto;
	
	@Enumerated(EnumType.STRING)
	public Estado estado;
}
