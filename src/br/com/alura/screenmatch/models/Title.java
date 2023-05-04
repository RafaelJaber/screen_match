package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.Exception.ConvertionYearException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title>{

    private final String name;
    private final int releaseDate;
    private boolean includedInPlan = false;
    private double sumOfRatings;
    private int totalRatings = 0;
   // @SerializedName("Runtime")
    private int durationInMinutes;


    public Title (String name, int releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public Title(TitleOmdb titleOmdb) {
        this.name = titleOmdb.title();
        if(titleOmdb.year().length() > 4) {
            throw new ConvertionYearException("Erro ao converter o ano, possui mais de 4 caracteres");
        }
        this.releaseDate = Integer.valueOf(titleOmdb.year());
        this.durationInMinutes = Integer.valueOf(titleOmdb.runtime().split(" ")[0]);
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
        System.out.println("Nome do titulo: "+ this.name);
        System.out.println("Ano de lançamento" + this.releaseDate);
    }

    public void evaluate(double note) {
        this.sumOfRatings += note;
        this.totalRatings++;
    }

    @Override
    public int compareTo(Title t) {
        return this.getName().compareTo(t.getName());
    }

    @Override
    public String toString() {
        return "Título: " + this.getName() + " (" + this.getReleaseDate() + ")";
    }
}
