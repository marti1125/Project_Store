package jobs;

import java.util.List;

import enums.Estado;

import models.Producto;
import models.EstadoDelProducto;
import play.jobs.*;

@Every("1mn")
public class VerificarCantidadDeProductos extends Job {
	
	public void doJob() {	
		
		List<Producto> productos = Producto.findAll();
		
		for(Producto p : productos){
			EstadoDelProducto estadoDelProducto = new EstadoDelProducto();
			if(p.cantidadInicial == 0){
				// No tiene Stock
				estadoDelProducto.producto = p.descripcion;
				estadoDelProducto.estado = Estado.V;
				estadoDelProducto.save();
			} else if(p.cantidadInicial <= 5){
				// Ya esta por acabarse, 5 productos
				estadoDelProducto.producto = p.descripcion;
				estadoDelProducto.estado = Estado.P;
				estadoDelProducto.save();
			} else {
				// Hay Stock
			}
		}
		
	}

}
