package br.com.alura.screenmatch.models;

public class Movie {
    private String name;
    private int releaseDate;
    private boolean includedInPlan = false;
    private double sumOfRatings;
    private int totalRatings = 0;
    private int durationInMinutes;


    public void setName(String n) {
        this.name = n;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public double getSumOfRatings() {
        return this.sumOfRatings;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getTotalRatings() {
        return this.totalRatings;
    }

    public double getAverageRatings() {
        return this.sumOfRatings / this.totalRatings;
    }

    public void displayTechnicalSheet() {
        System.out.println("Nome do filme: "+ this.name);
        System.out.println("Ano de lançamento" + this.releaseDate);
    }

    public void evaluate(double note) {
        this.sumOfRatings += note;
        this.totalRatings++;
    }
}