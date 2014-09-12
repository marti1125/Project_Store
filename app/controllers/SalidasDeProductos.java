package controllers;

import java.lang.reflect.Constructor;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import models.*;
import controllers.CRUD.For;
import controllers.CRUD.ObjectType;
import play.*;
import play.data.binding.Binder;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import play.mvc.*;

@With(Secure.class)
@For(SalidaDeProducto.class)
public class SalidasDeProductos extends CRUD {
	
	public static void listar() throws Exception {
		List<SalidaDeProducto> salidaDeProducto = SalidaDeProducto.findAll();
		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();		
		renderJSON(mapper.writeValueAsString(salidaDeProducto));		
	}
	
	public static void create() throws Exception {
		
		SalidaDeProducto salidaDeProducto = new SalidaDeProducto();
		ProductoDetalle productoDetalle = new ProductoDetalle();
		int cantidadFinal = 0;
		
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Model object = (Model) constructor.newInstance();
        
        Binder.bindBean(params.getRootParamNode(), "object", object);
        validation.valid(object);
        if (validation.hasErrors()) {
            renderArgs.put("error", play.i18n.Messages.get("crud.hasErrors"));
            try {
                render(request.controller.replace(".", "/") + "/blank.html", type, object);
            } catch (TemplateNotFoundException e) {
                render("CRUD/blank.html", type, object);
            }
        }
        
        // Resta a la cantidad inicial de la tabla productos
        
        salidaDeProducto = (SalidaDeProducto) object;  
        
        productoDetalle = productoDetalle.findById(salidaDeProducto.productoDetalle.id);        
        cantidadFinal = productoDetalle.cantidad - salidaDeProducto.cantidad;
        
        if(cantidadFinal >= 0){
        	productoDetalle.cantidad = cantidadFinal;        
            productoDetalle.save();
            System.out.println("ya no tiene productos");
            
            object._save();
            
            flash.success(play.i18n.Messages.get("crud.created", type.modelName));
            if (params.get("_save") != null) {
                redirect(request.controller + ".list");
            }
            if (params.get("_saveAndAddAnother") != null) {
                redirect(request.controller + ".blank");
            }
            redirect(request.controller + ".show", object._key());
            
        } else {
        	flash.error(play.i18n.Messages.get("cantidad insuficiente", type.modelName));
        	redirect(request.controller + ".blank");
        	System.out.println("cantidad insuficiente");
        }
        
        
    }

}
