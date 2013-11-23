package controllers;

import java.util.List;

import models.*;

import org.codehaus.jackson.map.ObjectMapper;

import play.mvc.Controller;
import play.mvc.Http.Header;

public class Rest extends Controller {
	
	public static void listaDeProductos() throws Exception {
		response.headers.put("Access-Control-Allow-Origin", new Header("Access-Control-Allow-Origin", "*"));
		List<Producto> productos = Producto.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(productos));		
	}
	
	public static void listaDeProductosFaltantes() throws Exception {
		response.headers.put("Access-Control-Allow-Origin", new Header("Access-Control-Allow-Origin", "*"));
		List<EstadoDelProducto> productosFaltantes = EstadoDelProducto.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(productosFaltantes));		
	}
	
}
