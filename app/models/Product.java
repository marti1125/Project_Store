package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class Product extends Model{
	
	@Lob
    @Required
    @MaxSize(10000)
	public String description;
	
	@Required
    @ManyToOne
    public User client;
	
	public Product(User client, String description, int amount){
		this.client = client;
		this.description = description;
		this.amount = amount;
	}
	
	public String toString() {
		return description + ' ' + amount;
	}
	
}
