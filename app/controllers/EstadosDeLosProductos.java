package controllers;

import controllers.CRUD.For;
import play.mvc.With;
import models.*;
import java.util.List;

@With(Secure.class)
@For(EstadoDelProducto.class)
public class EstadosDeLosProductos extends CRUD {
	
	public static void productosAgotados(){
		List<EstadoDelProducto> estadosProductos = EstadoDelProducto.find(" estado = 'V' ").fetch();
		render(estadosProductos);
	}
	
	public static void productosPorAgostarse() {
		List<EstadoDelProducto> estadosProductos = EstadoDelProducto.find(" estado = 'P' ").fetch();
		render(estadosProductos);
	}

}
