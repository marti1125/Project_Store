package controllers;

import java.util.List;

import models.*;

import org.codehaus.jackson.map.ObjectMapper;
import controllers.CRUD.For;
import play.mvc.With;

@With(Secure.class)
@For(Distribuidor.class)
public class Distribuidores extends CRUD {
	
	public static void listar() throws Exception {
		List<Distribuidor> distribuidores = Distribuidor.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(distribuidores));		
	}
	
}
