package controllers;

import play.*;
import play.mvc.*;

@Check("admin")
@With(Secure.class)
public class Categorias extends CRUD{
	
	public static void index() {
        render("CRUD/index.html");
    }

}
