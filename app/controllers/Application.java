package controllers;

import play.*;

import play.mvc.*;
import play.mvc.Scope.Session;

import java.util.*;

import models.*;

//@With(Secure.class)
public class Application extends Controller {
	
	public static void index() {
		//Session session = Scope.Session.current();
		//Usuario usuario = Usuario.findById(Long.valueOf(session.get("idUsuario")));
		//render(usuario);
		render();
	}

}