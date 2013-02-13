package controllers;


import models.User;
import play.*;
import play.mvc.*;
import play.data.validation.*;

@Check("webmaster")
@With(Secure.class)
public class ProductFronts extends CRUD{

}
