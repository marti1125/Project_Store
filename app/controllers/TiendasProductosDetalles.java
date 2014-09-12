package controllers;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import controllers.CRUD.For;
import play.mvc.With;
import models.*;

@With(Secure.class)
@For(TiendaProductoDetalle.class)
public class TiendasProductosDetalles extends CRUD{
	
	public static void listar() throws Exception {
		List<TiendaProductoDetalle> tiendasProductosDetalles = TiendaProductoDetalle.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(tiendasProductosDetalles));		
	}
	
}
