package br.com.alura.screenmatch.models;

public class Serie extends Title{
    private int seasons;
    private int episodesBySeason;
    private boolean finished;
    private int minutesPerEpisode;


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
}
