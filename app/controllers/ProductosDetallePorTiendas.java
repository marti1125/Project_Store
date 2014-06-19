package controllers;

import controllers.CRUD.For;
import play.mvc.With;
import models.*;

@With(Secure.class)
@For(ProductoDetallePorTienda.class)
public class ProductosDetallePorTiendas extends CRUD{

}
