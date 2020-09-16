package com.company;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Main {
    static final String PLATAFORMA = "pc";
    static final String REGIAO     = "us";

    public static void main(String[] args) throws Exception{
        String usr = "ProfCarvalho-11536";
        JSONObject json = getByUsrName(usr);
    }

    public static JSONObject getByUsrName(String usr) throws Exception {
        URI uri = URI.create("https://ow-api.com/v1/stats/" + PLATAFORMA + "/" + REGIAO + "/" + usr + "/complete");

        HttpClient client = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("        URI : " + uri);
        System.out.println("     Status : " + response.statusCode());
        System.out.println("       Body : " + response.body());

        return new JSONObject(response.body());
    }
}