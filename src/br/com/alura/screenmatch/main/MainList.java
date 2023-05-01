package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Title;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainList {
    public static void main(String[] args) {
        Movie movie = new Movie("O Protetor", 2014);
        movie.evaluate(10);
        Movie movie2 = new Movie("O Avatar 2", 2022);
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


    }

}
