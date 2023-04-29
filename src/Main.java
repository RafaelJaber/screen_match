public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.name = "O Protetor";
        movie.releaseDate = 2014;
        movie.durationInMinutes = 140;
        movie.assessment = 8.9;
        movie.totalRatings = 5;

        System.out.println(movie.name);
    }
}