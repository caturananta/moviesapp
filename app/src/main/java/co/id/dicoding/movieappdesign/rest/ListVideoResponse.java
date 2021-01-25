package co.id.dicoding.movieappdesign.rest;

import java.util.ArrayList;

import co.id.dicoding.movieappdesign.model.Video;

public class ListVideoResponse {

    private int id;
    private ArrayList<Video> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Video> getResults() {
        return results;
    }

    public void setResults(ArrayList<Video> results) {
        this.results = results;
    }
}
