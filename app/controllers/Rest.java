package controllers;

import java.util.List;

import models.*;

import org.codehaus.jackson.map.ObjectMapper;

import play.mvc.Controller;
import play.mvc.Http.Header;

public class Rest extends Controller {
	
	public static void listaDeTiendas() throws Exception {
		response.headers.put("Access-Control-Allow-Origin", new Header("Access-Control-Allow-Origin", "*"));
		List<Tienda> tiendas = Tienda.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(tiendas));		
	}
	
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
	
	public static void buscarProducto(String codigo) throws Exception {
		response.headers.put("Access-Control-Allow-Origin", new Header("Access-Control-Allow-Origin", "*"));
		Producto producto = Producto.find("codigo = ? ", codigo).first();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(producto));		
	}
	
}