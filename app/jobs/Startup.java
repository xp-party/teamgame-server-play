package jobs;

import play.Logger;
import play.jobs.*;
import models.StatefulModel;

@OnApplicationStart(async = true)
public class Startup extends Job {
   public void doJob() throws InterruptedException {
      int i = 0;
      while (true) {
          i++;
          String event = "On step " + i;
          StatefulModel.instance.publishMessage(event);
          Logger.info("event = " + event);
          Thread.sleep(5000);
      }
   }
}
