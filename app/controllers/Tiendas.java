package controllers;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import models.*;
import controllers.CRUD.For;
import play.mvc.With;

@With(Secure.class)
@For(Tienda.class)
public class Tiendas extends CRUD {
	
	public static void listar() throws Exception {
		List<Tienda> tiendas = Tienda.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(tiendas));		
	}
	
}