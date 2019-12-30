package co.id.dicoding.movieappdesign.rest;

import java.util.ArrayList;

import co.id.dicoding.movieappdesign.model.Movie;

public class ListMovieResponse {

    private ArrayList<Movie> results;

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}
