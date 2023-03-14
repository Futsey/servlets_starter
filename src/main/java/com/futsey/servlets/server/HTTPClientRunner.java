package com.futsey.servlets.server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

import static java.net.http.HttpRequest.BodyPublishers.ofFile;
import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class HTTPClientRunner {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("content-type", "application/json")
                .POST(ofFile(Path.of("src/main/resources", "first.json")))
                .build();
        var response = httpClient.sendAsync(httpRequest, ofString());
        var response1 = httpClient.sendAsync(httpRequest, ofString());
        var response2 = httpClient.sendAsync(httpRequest, ofString());
//        System.out.println(response.headers());
//        System.out.println(response.body());
        System.out.println(response2.get().body());
    }
}
