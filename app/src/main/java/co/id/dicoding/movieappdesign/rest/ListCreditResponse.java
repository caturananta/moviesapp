package co.id.dicoding.movieappdesign.rest;

import java.util.ArrayList;

import co.id.dicoding.movieappdesign.model.Cast;
import co.id.dicoding.movieappdesign.model.Crew;

public class ListCreditResponse {

    private ArrayList<Cast> cast;
    private ArrayList<Crew> crew;

    public ArrayList<Cast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Cast> cast) {
        this.cast = cast;
    }

    public ArrayList<Crew> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<Crew> crew) {
        this.crew = crew;
    }
}
