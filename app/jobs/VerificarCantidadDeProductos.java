package jobs;

import java.util.List;

import enums.Estado;

import models.Producto;
import models.ProductoEstado;
import play.jobs.*;

@Every("1mn")
public class VerificarCantidadDeProductos extends Job {
	
	public void doJob() {	
		
		List<Producto> productos = Producto.findAll();
		
		for(Producto p : productos){
			ProductoEstado productoEstado = new ProductoEstado();
			if(p.cantidadInicial == 0){
				// No tiene Stock
				productoEstado.producto = p.descripcion;
				productoEstado.estado = Estado.V;
				productoEstado.save();
			} else if(p.cantidadInicial <= 5){
				// Ya esta por acabarse, 5 productos
				productoEstado.producto = p.descripcion;
				productoEstado.estado = Estado.P;
				productoEstado.save();
			} else {
				// Hay Stock
			}
		}
		
	}

}
