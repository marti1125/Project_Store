package controllers;

import controllers.CRUD.For;
import play.mvc.With;
import models.*;

@With(Secure.class)
@For(ProductoDetalle.class)
public class ProductosDetalles extends CRUD {

}
