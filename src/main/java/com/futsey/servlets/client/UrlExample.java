package com.futsey.servlets.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        var diskUrl = new URL(
                "file:C:\\Users\\Fut\\IdeaProjects\\servlets_starter\\src\\main\\java\\com\\futsey\\servlets\\DatagramRunner.java");
        var diskConnect = diskUrl.openConnection();

        System.out.println(new String(diskConnect.getInputStream().readAllBytes()));
    }

    public void checkGoogle() throws IOException {
        var url = new URL("https://google.com");
        var urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);

        try (var outputStream = urlConnection.getOutputStream()) {
        }

        System.out.println("");
    }
}
