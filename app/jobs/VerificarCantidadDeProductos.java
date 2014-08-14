package jobs;

import java.util.List;

import enums.Estado;

import models.Producto;
import play.jobs.*;

//@Every("1mn")
public class VerificarCantidadDeProductos extends Job {
	
	/*public void doJob() {	
		
		List<Producto> productos = Producto.findAll();
		for(Producto p : productos){
			Producto productoEncontrado = Producto.findById(p.codigo);
			EstadoDelProducto estadoProducto = new EstadoDelProducto();
			EstadoDelProducto existeProducto = EstadoDelProducto.find("producto.codigo",p.codigo).first();
			if(p.cantidadInicial == 0 && existeProducto == null){
				estadoProducto.producto = productoEncontrado;
				estadoProducto.estado = Estado.V;
				estadoProducto.save();
			} else if(p.cantidadInicial <= 5 && existeProducto == null){
				estadoProducto.producto = productoEncontrado;
				estadoProducto.estado = Estado.P;
				estadoProducto.save();
			} else {
				// Hay Stock
			}
		}
		
	}*/

}
