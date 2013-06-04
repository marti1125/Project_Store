package controllers;

import models.Usuario;

public class Security extends Secure.Security {

	static boolean authenticate(String usuario, String clave) {
		return Usuario.connect(usuario, clave) != null;
	}

	static void onDisconnected() {
		try {
			Secure.login();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void onAuthenticated() {
		Application.index();
	}

	static boolean check(String profile) {
		Usuario usuario = Usuario.find("byUsuario", connected()).first();
		if ("admin".equals(profile)) {
			return usuario.esAdministrador;			
		} else {
			return false;
		}
	}

	

}
