package com.futsey.servlets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerRunner {

    public static void main(String[] args) throws IOException {
        try (var datagramServer = new DatagramSocket(7777)) {
            var buffer = new byte[512];
            var packet = new DatagramPacket(buffer, buffer.length);
            datagramServer.receive(packet);
            System.out.println(new String(buffer));
        }
    }
}
