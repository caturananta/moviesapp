package co.id.dicoding.movieappdesign.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Trend implements Parcelable {

    private int id;
    private int vote_count;
    private Double vote_average;
    private String title;
    private String name;
    private String first_air_date;
    private String release_date;
    private String original_language;
    private String backdrop_path;
    private String overview;
    private String poster_path;
    private String media_type;
    private ArrayList<Integer> genre_ids;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public ArrayList<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(ArrayList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.vote_count);
        dest.writeValue(this.vote_average);
        dest.writeString(this.title);
        dest.writeString(this.name);
        dest.writeString(this.first_air_date);
        dest.writeString(this.release_date);
        dest.writeString(this.original_language);
        dest.writeString(this.backdrop_path);
        dest.writeString(this.overview);
        dest.writeString(this.poster_path);
        dest.writeString(this.media_type);
        dest.writeList(this.genre_ids);
    }

    public Trend() {
    }

    protected Trend(Parcel in) {
        this.id = in.readInt();
        this.vote_count = in.readInt();
        this.vote_average = (Double) in.readValue(Double.class.getClassLoader());
        this.title = in.readString();
        this.name = in.readString();
        this.first_air_date = in.readString();
        this.release_date = in.readString();
        this.original_language = in.readString();
        this.backdrop_path = in.readString();
        this.overview = in.readString();
        this.poster_path = in.readString();
        this.media_type = in.readString();
        this.genre_ids = new ArrayList<Integer>();
        in.readList(this.genre_ids, Integer.class.getClassLoader());
    }

    public static final Creator<Trend> CREATOR = new Creator<Trend>() {
        @Override
        public Trend createFromParcel(Parcel source) {
            return new Trend(source);
        }

        @Override
        public Trend[] newArray(int size) {
            return new Trend[size];
        }
    };
}
