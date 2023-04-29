public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.name = "O Protetor";
        movie.releaseDate = 2014;
        movie.durationInMinutes = 140;

        movie.displayTechnicalSheet();
        movie.evaluate(5.8);
        movie.evaluate(4.8);
        movie.evaluate(3.2);

        System.out.println("Média das avaliações: " + movie.getAverageRatings());
    }
}