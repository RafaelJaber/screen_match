public class Movie {
    String name;
    int releaseDate;
    boolean includedInPlan;
    double sumOfRatings;
    int totalRatings = 0;
    int durationInMinutes;


    void displayTechnicalSheet() {
        System.out.println("Nome do filme: "+ this.name);
        System.out.println("Ano de lançamento" + this.releaseDate);
    }

    void evaluate(double note) {
        this.sumOfRatings += note;
        this.totalRatings ++;
    }

    double getAverageRatings() {
        return this.sumOfRatings / this.totalRatings;
    }
}
