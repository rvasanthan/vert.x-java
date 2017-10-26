package com.rvasanthan.vertx.tech.websockets;

import io.vertx.core.AbstractVerticle;

public class WebSocketServer extends AbstractVerticle {
	
	@Override
	  public void start() throws Exception {
	    vertx.createHttpServer().websocketHandler(ws -> ws.handler(ws::writeBinaryMessage)).requestHandler(req -> {
	      if (req.uri().equals("/")) {
	    	  req.response().sendFile("index.html");
	      }
	    }).listen(9082);
	  }

}
	