package co.id.dicoding.movieappdesign.model;

import java.util.ArrayList;

@SuppressWarnings({"unused", "WeakerAccess"})
public class MovieData {
    public static String[][] data = new String[][]{
            {"Avenger", ""},
            {"Aquaman", ""},
            {"Deadpool", ""},
            {"Marry", ""},
    };

    public static ArrayList<Movie> getListData() {
        ArrayList<Movie> list = new ArrayList<>();
        for (String[] aData : data) {
            Movie item = new Movie();
            item.setTitle(aData[0]);
            list.add(item);
        }
        return list;
    }
}
