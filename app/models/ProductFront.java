package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class ProductFront extends Model{
	
	@Required
	public String name;
	
	@Required
	public String description;
	
	@Required
	public Blob image;
	
	public ProductFront(String name, String description, Blob image) {
		this.name = name;
		this.description = description;
		this.image = image;
	}
	
	public String toString() {
		return name;
	}
}
