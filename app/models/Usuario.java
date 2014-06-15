package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class Usuario extends Model{	
	
	@Required
	public String usuario;
	
	@Required
	public String clave;
	
	@Required
	public String nombreCompleto;

	public boolean esAdministrador;
	
	@ManyToOne
    public Tienda tienda;
	
	public boolean todosLasTiendas;
	
	public Usuario(String usuario, String clave, String nombreCompleto){
		this.usuario = usuario;
		this.clave = clave;
		this.nombreCompleto = nombreCompleto;
	}
	
	public static Usuario connect(String usuario, String clave){
		return find("byUsuarioAndClave", usuario, clave ).first();
	}
	
	public String toString() {
		String adm = "";
		if(esAdministrador){
			adm = "(Administrador)";
		}
		return nombreCompleto + ' ' + adm;
	}
	

}
