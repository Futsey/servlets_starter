package com.futsey.servlets.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;

public class SocketRunner {

    public static void main(String[] args) throws IOException {
        var inetAddress = Inet4Address.getByName("google.com");
        try (Socket socket = new Socket(inetAddress, 80);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
            outputStream.writeUTF("Hello TCP connect");
            var response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}
