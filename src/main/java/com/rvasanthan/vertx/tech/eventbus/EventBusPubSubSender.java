package com.rvasanthan.vertx.tech.eventbus;

import java.util.Random;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class EventBusPubSubSender extends AbstractVerticle {

	  @Override
	  public void start() throws Exception {

	    EventBus eb = vertx.eventBus();

	    // Send a message every second

	    vertx.setPeriodic(1000, v -> eb.publish("news-feed", "Some news !"+ new Random().nextInt(100000)));
	  }
}
