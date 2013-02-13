package controllers;

import models.User;

public class Security extends Secure.Security {

	static boolean authenticate(String username, String password) {
		return User.connect(username, password) != null;
	}

	static void onDisconnected() {
		Application.index();
	}

	static void onAuthenticated() {
		Admin.index();
	}

	static boolean check(String profile) {
		User user = User.find("byEmail", connected()).first();
		if ("admin".equals(profile)) {
			return user.isAdmin;
			// return User.find("byEmail", connected()).<User>first().isAdmin;
		} else if ("webmaster".equals(profile)) {
			return user.isWebmaster;
		} else {
			return false;
		}
	}

	

}
