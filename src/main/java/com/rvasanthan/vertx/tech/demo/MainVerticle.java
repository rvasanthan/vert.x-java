package com.rvasanthan.vertx.tech.demo;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
              req.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Vert.x!");
            }).listen(9081);
        System.out.println("HTTP server started on port 9081");
    }
}
