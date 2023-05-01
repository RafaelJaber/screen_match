package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.calculation.RecommendationFilter;
import br.com.alura.screenmatch.calculation.TimeCalculator;
import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("O Protetor", 2014);
        movie.setDurationInMinutes(140);

        movie.displayTechnicalSheet();
        movie.evaluate(5.8);
        movie.evaluate(4.8);
        movie.evaluate(3.2);

        System.out.println("Média das avaliações: " + movie.getAverageRatings());
        System.out.println("Total avaliações: " + movie.getTotalRatings());
        System.out.println("Soma das avaliações: " + movie.getSumOfRatings());


        Serie lost = new Serie("Lost", 2007);
        lost.setMinutesPerEpisode(40);
        lost.setSeasons(5);
        lost.setEpisodesBySeason(20);

        lost.displayTechnicalSheet();

        System.out.println("Tempo para maratonar LOST: " + lost.getDurationInMinutes() + " minutos");


        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.add(movie);
        timeCalculator.add(lost);

        System.out.println("Tempo para maratonar durante as férias: " + timeCalculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(movie);

        Movie movie2 = new Movie("DogVille", 2022);
        movie2.setDurationInMinutes(200);
        movie2.evaluate(10);

        ArrayList<Movie> movieList = new ArrayList<Movie>();
        movieList.add(movie);
        movieList.add(movie2);

        System.out.println("Tamanho da lista de filmes: " + movieList.size());

        System.out.println(movie.toString());
    }
}