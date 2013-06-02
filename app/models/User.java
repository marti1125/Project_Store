package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class User extends Model{	
	
	@Required
	public String username;
	
	@Required
	public String password;
	
	@Required
	public String fullname;

	@Required
	public boolean isAdmin;	
	
	public User(String username, String password, String fullname){
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}
	
	public static User connect(String username, String password){
		return find("byUsernameAndPassword", username, password ).first();
	}
	
	public String toString() {
		String adm = "";
		if(isAdmin){
			adm = "(Administrador)";
		}
		return fullname + ' ' + adm;
	}
	

}
