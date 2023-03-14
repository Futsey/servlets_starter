package com.futsey.servlets.server;

public class HTTPServerRunner {

    public static void main(String[] args) {
        HTTPServer httpServer = new HTTPServer(9000, 50);
        httpServer.run();
    }
}
