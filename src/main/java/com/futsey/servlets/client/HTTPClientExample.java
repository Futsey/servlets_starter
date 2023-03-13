package com.futsey.servlets.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;

public class HTTPClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest requestGet = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();
        HttpRequest requestPost = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .POST(BodyPublishers.ofFile(Path.of("path", "to", "file")))
                .build();
        var response = httpClient.send(requestGet, BodyHandlers.ofString());

        System.out.println(response.headers());
        System.out.println("=============");
        System.out.println(response.body());
    }
}
