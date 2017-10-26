package com.rvasanthan.vertx.tech.executeblock;

import java.util.Random;

import io.vertx.core.AbstractVerticle;

public class ExecuteBlockingVerticle extends AbstractVerticle {
	
	@Override
	  public void start() throws Exception {

	    vertx.createHttpServer().requestHandler(request -> {

	      // Let's say we have to call a blocking API (e.g. JDBC) to execute a query for each
	      // request. We can't do this directly or it will block the event loop
	      // But you can do this using executeBlocking:

	      vertx.<String>executeBlocking(future -> {

	        // Do the blocking operation in here

	        // Imagine this was a call to a blocking API to get the result
	        try {
	        	Integer random = new Random().nextInt(1000000);
	        	for(int i=0;i<10;i++) {
	        		Thread.sleep(1000);
	        		System.out.println("Still executing a Blocking operation .."+random);
	        	}
	        } catch (Exception ignore) {
	        }
	        String result = "I am asynchronous and I won't wait!";

	        future.complete(result);

	      }, res -> {

	        if (res.succeeded()) {

	          request.response().putHeader("content-type", "text/plain").end(res.result());

	        } else {
	          res.cause().printStackTrace();
	        }
	      });

	    }).listen(9084);

	  }

}
