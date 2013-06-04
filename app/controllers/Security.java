package controllers;

import models.Usuario;

public class Security extends Secure.Security {

	static boolean authenticate(String username, String password) {
		return Usuario.connect(username, password) != null;
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
		Usuario user = Usuario.find("byUsername", connected()).first();
		if ("admin".equals(profile)) {
			return user.isAdmin;			
		} else {
			return false;
		}
	}

	

}
