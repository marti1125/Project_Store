package controllers;

import play.*;
import play.mvc.*;

@Check("webmaster")
@With(Secure.class)
public class ProductsFront extends CRUD{

}
