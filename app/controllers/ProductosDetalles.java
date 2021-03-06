package controllers;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import controllers.CRUD.For;
import play.mvc.With;
import models.*;

@With(Secure.class)
@For(ProductoDetalle.class)
public class ProductosDetalles extends CRUD {
	
	public static void listar() throws Exception {
		List<ProductoDetalle> productosDetalles = ProductoDetalle.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(productosDetalles));		
	}
	
}
