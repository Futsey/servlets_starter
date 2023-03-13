package com.futsey.servlets;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {

    public static void main(String[] args) throws IOException {
        var inetAddress = InetAddress.getByName("localhost");
        try (var datagram = new DatagramSocket()) {
            var bytes = "Hello from UDP client".getBytes();
            var packet = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            datagram.send(packet);

        }
    }
}
