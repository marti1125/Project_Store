package models;

import models.deadbolt.Role;

public class MyRole implements Role {

	private String name;

	public MyRole(String name) {
		this.name = name;
	}

	public String getRoleName() {
		return name;
	}

}