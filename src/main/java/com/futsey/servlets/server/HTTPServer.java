package com.futsey.servlets.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HTTPServer {

    private final int port;

    public HTTPServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            var server = new ServerSocket();
            var socket = server.accept();
            processSocket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
                var inputStream = new DataInputStream(socket.getInputStream());
                var outputStream = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Request: " + new String(inputStream.readNBytes(400)));
            var body = Files.readAllBytes(Path.of("resources", "example.html"));
            var headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes();
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
