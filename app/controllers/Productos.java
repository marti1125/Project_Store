package controllers;

import java.util.List;

import models.*;

import org.codehaus.jackson.map.ObjectMapper;

import play.*;
import play.mvc.*;

@With(Secure.class)
public class Productos extends CRUD{
	
	public static void listar() throws Exception {
		List<Producto> productos = Producto.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(productos));		
	}
	
}
