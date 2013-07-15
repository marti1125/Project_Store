package jobs;

import java.util.List;

import models.Producto;
import play.jobs.*;

@Every("1mn")
public class VerificarCantidadDeProductos extends Job {
	
	public void doJob() {	
		
		List<Producto> productos = Producto.findAll();
		
		for(Producto p : productos){
			if(p.cantidadInicial == 0){
				System.out.println("No tiene Stock");
			} else {
				System.out.println("Hay Stock");
			}
		}
		
	}

}
