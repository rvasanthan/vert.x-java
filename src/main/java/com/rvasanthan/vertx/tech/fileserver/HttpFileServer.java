package com.rvasanthan.vertx.tech.fileserver;

import io.vertx.core.AbstractVerticle;

public class HttpFileServer extends AbstractVerticle {
	
	@Override
	  public void start() throws Exception {

	    // In reality it's highly recommend you use Vert.x-Web for applications like this.

	    vertx.createHttpServer().requestHandler(req -> {
	      String filename = null;
	      if (req.path().equals("/")) {
	        filename = "index.html";
	      } else if (req.path().equals("/diwali.html")) {
	        filename = "diwali.html";
	      } else if (req.path().equals("/halloween.html")) {
	        filename = "halloween.html";
	      } else {
	        req.response().setStatusCode(404).end();
	      }
	      if (filename != null) {
	        req.response().sendFile(filename);
	      }
	    }).listen(9083);
	    System.out.println("Access the File server on http://localhost:9083");
	  }

}
