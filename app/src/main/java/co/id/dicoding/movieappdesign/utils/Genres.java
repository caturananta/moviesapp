package co.id.dicoding.movieappdesign.utils;

import java.util.ArrayList;

public class Genres {

    public ArrayList<String> getGenres(ArrayList<String> data) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals("28")) {
                data.set(data.indexOf("28"), "Action");
            }
            if (data.get(i).equals("12")) {
                data.set(data.indexOf("12"), "Adventure");
            }
            if (data.get(i).equals("16")) {
                data.set(data.indexOf("16"), "Animation");
            }
            if (data.get(i).equals("35")) {
                data.set(data.indexOf("35"), "Comedy");
            }
            if (data.get(i).equals("80")) {
                data.set(data.indexOf("80"), "Crime");
            }
            if (data.get(i).equals("99")) {
                data.set(data.indexOf("99"), "Documentary");
            }

            if (data.get(i).equals("18")) {
                data.set(data.indexOf("18"), "Drama");
            }
            if (data.get(i).equals("10751")) {
                data.set(data.indexOf("10751"), "Family");
            }
            if (data.get(i).equals("14")) {
                data.set(data.indexOf("14"), "Fantasy");
            }
            if (data.get(i).equals("36")) {
                data.set(data.indexOf("36"), "History");
            }
            if (data.get(i).equals("27")) {
                data.set(data.indexOf("27"), "Horror");
            }
            if (data.get(i).equals("10402")) {
                data.set(data.indexOf("10402"), "Music");
            }

            if (data.get(i).equals("9648")) {
                data.set(data.indexOf("9648"), "Mystery");
            }
            if (data.get(i).equals("27")) {
                data.set(data.indexOf("27"), "Horror");
            }
            if (data.get(i).equals("10402")) {
                data.set(data.indexOf("10402"), "Music");
            }

            if (data.get(i).equals("9648")) {
                data.set(data.indexOf("9648"), "Mystery");
            }
            if (data.get(i).equals("10749")) {
                data.set(data.indexOf("10749"), "Romance");
            }
            if (data.get(i).equals("878")) {
                data.set(data.indexOf("878"), "Science Fiction");
            }
            if (data.get(i).equals("10770")) {
                data.set(data.indexOf("10770"), "TV Movie");
            }

            if (data.get(i).equals("53")) {
                data.set(data.indexOf("53"), "Thriller");
            }
            if (data.get(i).equals("10752")) {
                data.set(data.indexOf("10752"), "War");
            }
            if (data.get(i).equals("37")) {
                data.set(data.indexOf("37"), "Western");
            }
            if (data.get(i).equals("10759")) {
                data.set(data.indexOf("10759"), "Action & Adventure");
            }
            if (data.get(i).equals("10762")) {
                data.set(data.indexOf("10762"), "Kids");
            }
            if (data.get(i).equals("10765")) {
                data.set(data.indexOf("10765"), "Sci-Fi & Fantasy");
            }
        }

        return data;
    }

}
