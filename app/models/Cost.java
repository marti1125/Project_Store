package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class Cost extends Model{

	@Required
    @ManyToOne
    public Product product;

	@Required
	public Double cost;	
	
	@Required
	public Double price;

	@Required
	public Date costEntry;

}