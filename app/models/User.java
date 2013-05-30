package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class User extends Model{
	
	@Email
	@Required
	public String username;
	
	@Required
	public String password;
	
	public String fullname;
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
		return fullname;
	}
	

}
