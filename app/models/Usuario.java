package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class Usuario extends GenericModel {	
	
	@Id
	@Required
	public String usuario;
	
	@Required
	public String clave;
	
	public String apPaterno;
	
	public String apMaterno;
	
	public String nombres;

	public boolean esAdministrador;

}
