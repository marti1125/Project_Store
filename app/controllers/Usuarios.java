package controllers;

import java.util.List;

import models.Usuario;

import org.codehaus.jackson.map.ObjectMapper;

import play.*;
import play.mvc.*;
import play.mvc.Http.Header;

@With(Secure.class)
public class Usuarios extends CRUD{
	
	public static void listar() throws Exception {
		List<Usuario> usuarios = Usuario.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(usuarios));		
	}

}
