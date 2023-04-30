import br.com.alura.screenmatch.calculation.RecommendationFilter;
import br.com.alura.screenmatch.calculation.TimeCalculator;
import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setName("O Protetor");
        movie.setReleaseDate(2014);
        movie.setDurationInMinutes(140);

        movie.displayTechnicalSheet();
        movie.evaluate(5.8);
        movie.evaluate(4.8);
        movie.evaluate(3.2);

        System.out.println("Média das avaliações: " + movie.getAverageRatings());
        System.out.println("Total avaliações: " + movie.getTotalRatings());
        System.out.println("Soma das avaliações: " + movie.getSumOfRatings());


        Serie lost = new Serie();
        lost.setName("Lost");
        lost.setReleaseDate(2007);
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
    }
}