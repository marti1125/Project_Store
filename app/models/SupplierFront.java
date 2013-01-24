package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class SupplierFront extends Model{
	@Required
	public String name;
	
	public String description;
	
	@Required
	public Blob image;
	
	public SupplierFront(String name, String description, Blob image){
		this.name = name;
		this.description = description;
		this.image = image;
	}
	
	public String toString() {
		return name;
	}

}
