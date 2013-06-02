package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.data.binding.*;
import play.db.jpa.*;

@Entity
public class Egress extends Model{

	@Required
    @ManyToOne
    public Product product;

	@Required
	public int amount;	
	
	@Required
	public Date dateEgress;

}