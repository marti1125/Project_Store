package controllers;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import models.*;
import play.mvc.With;
import controllers.CRUD.For;

@With(Secure.class)
@For(Vendedor.class)
public class Vendedores extends CRUD {
	
	public static void listar() throws Exception {
		List<Vendedor> vendedores = Vendedor.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(vendedores));		
	}
	
}
