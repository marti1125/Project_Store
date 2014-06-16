package controllers;

import models.ProductoPorTienda;
import controllers.CRUD.For;
import play.mvc.With;

@With(Secure.class)
@For(ProductoPorTienda.class)
public class ProductosPorTiendas extends CRUD {
	
}
