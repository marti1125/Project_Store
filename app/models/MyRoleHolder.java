package models;

import models.deadbolt.Role;
import models.deadbolt.RoleHolder;
import java.util.Arrays;
import java.util.List;

public class MyRoleHolder implements RoleHolder {
	public List<? extends Role> getRoles() {
		return Arrays.asList(new MyRole("admin"), new MyRole("webmaster"));
	}
}