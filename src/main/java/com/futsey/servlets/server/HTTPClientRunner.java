package com.futsey.servlets.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class HTTPClientRunner {

    public static void main(String[] args) throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("content-type", "application/json")
                .POST(BodyPublishers.ofFile(Path.of("resources", "first.json")))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, ofString());
        System.out.println(response.headers());
        System.out.println(response.body());
    }
}
