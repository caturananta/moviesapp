package co.id.dicoding.movieappdesign.utils;

import java.util.ArrayList;

public class Genres {

    public ArrayList<String> getGenres(ArrayList<String> data){

        ArrayList<String> n = data;

        for (int i = 0; i < n.size(); i++) {
            if (n.get(i).equals("28")) {
                n.set(n.indexOf("28"), "Action");
            }
            if (n.get(i).equals("12")) {
                n.set(n.indexOf("12"), "Adventure");
            }
            if (n.get(i).equals("16")) {
                n.set(n.indexOf("16"), "Animation");
            }
            if (n.get(i).equals("35")) {
                n.set(n.indexOf("35"), "Comedy");
            }
            if (n.get(i).equals("80")) {
                n.set(n.indexOf("80"), "Crime");
            }
            if (n.get(i).equals("99")) {
                n.set(n.indexOf("99"), "Documentary");
            }

            if (n.get(i).equals("18")) {
                n.set(n.indexOf("18"), "Drama");
            }
            if (n.get(i).equals("10751")) {
                n.set(n.indexOf("10751"), "Family");
            }
            if (n.get(i).equals("14")) {
                n.set(n.indexOf("14"), "Fantasy");
            }
            if (n.get(i).equals("36")) {
                n.set(n.indexOf("36"), "History");
            }
            if (n.get(i).equals("27")) {
                n.set(n.indexOf("27"), "Horror");
            }
            if (n.get(i).equals("10402")) {
                n.set(n.indexOf("10402"), "Music");
            }

            if (n.get(i).equals("9648")) {
                n.set(n.indexOf("9648"), "Mystery");
            }
            if (n.get(i).equals("27")) {
                n.set(n.indexOf("27"), "Horror");
            }
            if (n.get(i).equals("10402")) {
                n.set(n.indexOf("10402"), "Music");
            }

            if (n.get(i).equals("9648")) {
                n.set(n.indexOf("9648"), "Mystery");
            }
            if (n.get(i).equals("10749")) {
                n.set(n.indexOf("10749"), "Romance");
            }
            if (n.get(i).equals("878")) {
                n.set(n.indexOf("878"), "Science Fiction");
            }
            if (n.get(i).equals("10770")) {
                n.set(n.indexOf("10770"), "TV Movie");
            }

            if (n.get(i).equals("53")) {
                n.set(n.indexOf("53"), "Thriller");
            }
            if (n.get(i).equals("10752")) {
                n.set(n.indexOf("10752"), "War");
            }
            if (n.get(i).equals("37")) {
                n.set(n.indexOf("37"), "Western");
            }
            if (n.get(i).equals("10759")) {
                n.set(n.indexOf("10759"), "Action & Adventure");
            }
            if (n.get(i).equals("10762")) {
                n.set(n.indexOf("10762"), "Kids");
            }
            if (n.get(i).equals("10765")) {
                n.set(n.indexOf("10765"), "Sci-Fi & Fantasy");
            }
        }

        return n;
    }

}
