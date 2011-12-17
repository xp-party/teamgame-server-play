package controllers;

import models.StatefulModel;
import play.Logger;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.WebSocketController;

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

    public static class WebSocket extends WebSocketController
    {
        public static void listen() {
            while (inbound.isOpen()) {
                String event = await(StatefulModel.instance.nextEvent());
                outbound.send(event);
            }
        }

        public static void postMessage(String message) {
            Logger.debug("Message = " + message);
            StatefulModel.instance.publishMessage(message != null ? message : "empty message");
//            while (inbound.isOpen()) {
//                waitAndProcessMessage();
//            }
        }

        private static void waitAndProcessMessage()
        {
            Logger.debug("before await");
            Http.WebSocketEvent e = await(inbound.nextEvent());
            Logger.debug("after await");

            if (e instanceof Http.WebSocketFrame)
            {
                Http.WebSocketFrame frame = (Http.WebSocketFrame)e;
                Logger.debug("frame = " + frame);
                String data = frame.textData;
                Logger.debug("frame.textData = " + data);
                if (!data.equals("ping"))
                {
                    StatefulModel.instance.publishMessage(data);
                }
            }
        }
    }


}