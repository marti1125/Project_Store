package controllers;

import models.*;
import controllers.CRUD.For;
import play.mvc.With;

@With(Secure.class)
@For(Proveedor.class)
public class Proveedores extends CRUD {

}
