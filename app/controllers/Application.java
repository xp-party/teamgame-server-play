package controllers;

import play.data.validation.*;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void sayHello(@Required String myName) {
        if (Validation.hasErrors()) {
            flash.error("Oops, please enter your name!");
            index();
        }
    	render(myName);
    }
}