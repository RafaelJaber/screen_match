package br.com.alura.screenmatch.calculation;

//import br.com.alura.screenmatch.models.Movie;
//import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;


    public int getTotalTime() {
        return totalTime;
    }


//    public void add(Movie m) {
//        totalTime += m.getDurationInMinutes();
//    }
//    public void add(Serie s) {
//        totalTime += s.getDurationInMinutes();
//    }

    public void add(Title t) {
        totalTime += t.getDurationInMinutes();
    }
}
