package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.Exception.ConvertionYearException;
import br.com.alura.screenmatch.models.Title;
import br.com.alura.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        System.out.println("Para sair, digite 'sair'");
        System.out.print("Digite um filme para busca: ");
        String movieName = "";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        List<Title> titles = new ArrayList<>();

        while (!movieName.equalsIgnoreCase("sair")) {
            movieName = scanner.nextLine().replace(" ", "+");

            String url = "http://www.omdbapi.com/?t=" + movieName + "&apikey=aa5e4c59";

            if (movieName.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                //Title myTitle = gson.fromJson(json, Title.class);
                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(myTitleOmdb);

                System.out.println("Imprimindo o titulo pela API usando a conversão");

                Title myTitle = new Title(myTitleOmdb);
                System.out.println(myTitle.getName() + " (" + myTitle.getReleaseDate() + ") - " + myTitle.getDurationInMinutes() + " minutos");

                titles.add(myTitle);
                System.out.println(titles);

            } catch (ConvertionYearException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            }
            finally {

                FileWriter fw = new FileWriter("filmes.json");
                fw.write(gson.toJson(titles));
                fw.close();
                System.out.print("Digite o nome do filme: ");
            }
        }

    }
}
