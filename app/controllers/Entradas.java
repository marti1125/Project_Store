package controllers;

import java.lang.reflect.Constructor;

import models.EntradaDeProducto;
import models.ProductoDetalle;

import controllers.CRUD.*;
import play.*;
import play.data.binding.Binder;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import play.mvc.*;

@With(Secure.class)
@For(EntradaDeProducto.class)
public class Entradas extends CRUD{
	
	public static void create() throws Exception {
		
		EntradaDeProducto entradaDeProducto = new EntradaDeProducto();
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
        
        // Suma a la cantidad inicial de la tabla productos
        
        entradaDeProducto = (EntradaDeProducto) object;  
        
        productoDetalle =  productoDetalle.findById(entradaDeProducto.productoDetalle);        
        cantidadFinal = productoDetalle.cantidad + entradaDeProducto.cantidad;
        productoDetalle.cantidad = cantidadFinal;
        
        productoDetalle.save();
        
        System.out.println(productoDetalle.cantidad);        
        
        object._save();
        flash.success(play.i18n.Messages.get("crud.created", type.modelName));
        if (params.get("_save") != null) {
            redirect(request.controller + ".list");
        }
        if (params.get("_saveAndAddAnother") != null) {
            redirect(request.controller + ".blank");
        }
        redirect(request.controller + ".show", object._key());
    }

}
