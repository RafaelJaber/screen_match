package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Title;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainList {
    public static void main(String[] args) {
        Movie movie = new Movie("O Protetor", 2014);
        movie.evaluate(10);
        Movie movie2 = new Movie("Avatar 2", 2022);
        movie2.evaluate(4);
        Movie movie3 = new Movie("Vingadores Ultimato", 2022);
        movie3.evaluate(7);

        Serie lost = new Serie("Lost", 2007);


        ArrayList<Title> watchlist = new ArrayList<>();
        watchlist.add(movie);
        watchlist.add(movie2);
        watchlist.add(movie3);
        watchlist.add(lost);


        for (Title item: watchlist) {
            System.out.println(item.toString());
            if (item instanceof Movie m && m.getClassification() > 2) {
                System.out.println("Classificação: " + m.getClassification());
            }
        }

        ArrayList<String> searchByArtist = new ArrayList<>();
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Robert Downey Jr.");
        searchByArtist.add("Chris Evans");
        searchByArtist.add("Henry Cavill");

        System.out.println(searchByArtist);

        Collections.sort(searchByArtist);
        System.out.println("Depois da ordenação");
        System.out.println(searchByArtist);


        System.out.println("Lista de títulos antes da ordenação");
        System.out.println(watchlist);
        Collections.sort(watchlist);
        System.out.println("Lista de títulos ordenados");
        System.out.println(watchlist);

        System.out.println("Ordenando pela data de lançamento");
        watchlist.sort(Comparator.comparing(Title::getReleaseDate).reversed());
        System.out.println(watchlist);

    }

}
