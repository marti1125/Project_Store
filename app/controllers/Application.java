package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void contact(String address, String message){
    	Mails mail = new Mails();
    	mail.message(address, message);
    	render();
    }
    

}