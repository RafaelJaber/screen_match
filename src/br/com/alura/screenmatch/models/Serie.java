package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.calculation.Classifiable;

public class Serie extends Title implements Classifiable {
    private int seasons;
    private int episodesBySeason;
    private boolean finished;
    private int minutesPerEpisode;
    private int totalViews;

    public Serie(String name, int releaseDate) {
        super(name, releaseDate);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodesBySeason() {
        return episodesBySeason;
    }

    public void setEpisodesBySeason(int episodesBySeason) {
        this.episodesBySeason = episodesBySeason;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public int getDurationInMinutes() {
        return this.seasons * this.episodesBySeason * this.minutesPerEpisode;
    }

    @Override
    public int getClassification() {
        if (this.totalViews > 100) {
            return 4;
        } else  {
          return 2;
        }
    }

    @Override
    public String toString() {
        return "Série: " + this.getName() + " (" + this.getReleaseDate() + ")";
    }
}
