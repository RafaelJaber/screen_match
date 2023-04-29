import br.com.alura.screenmatch.models.Movie;

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
    }
}