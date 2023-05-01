package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Title;
import br.com.alura.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        System.out.print("Digite um filme para busca: ");
        String movieName = scanner.nextLine().replace(" ", "+");
        String url = "http://www.omdbapi.com/?t=" + movieName + "&apikey=aa5e4c59";


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        //Title myTitle = gson.fromJson(json, Title.class);
        TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
        System.out.println(myTitleOmdb);

        System.out.println("Imprimindo o titulo pela API usando a conversão");
        Title myTitle = new Title(myTitleOmdb);
        System.out.println(myTitle.getName() + " (" + myTitle.getReleaseDate() + ") - " + myTitle.getDurationInMinutes() + " minutos");
    }
}
