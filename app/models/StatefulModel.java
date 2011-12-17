package models;

import play.Logger;
import play.libs.F;

public class StatefulModel {
    public static StatefulModel instance = new StatefulModel();
    private final F.EventStream<String> event = new F.EventStream<String>();

    private StatefulModel() {
    }

    public void publishMessage(String message) {
        event.publish(message);
        Logger.debug("Added message to EventStream: " + message);
    }

    public F.Promise<String> nextEvent() {
        return event.nextEvent();
    }
}
