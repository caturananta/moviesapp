package co.id.dicoding.movieappdesign.rest;

import java.util.ArrayList;

import co.id.dicoding.movieappdesign.model.Trend;

public class ListTrendingResponse {

    private ArrayList<Trend> results;

    public ArrayList<Trend> getResults() {
        return results;
    }

    public void setResults(ArrayList<Trend> results) {
        this.results = results;
    }
}
