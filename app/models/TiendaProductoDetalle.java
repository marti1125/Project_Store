package models;

import javax.persistence.*;
import play.data.validation.Required;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;

@Entity
public class TiendaProductoDetalle extends GenericModel {
	
	@Id
	@Required
    @ManyToOne
    public ProductoDetalle productoDetalle;
	
	@Id
	@Required
    @ManyToOne
    public Tienda tienda;
	
}
