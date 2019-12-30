package co.id.dicoding.movieappdesign.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/discover/";
    private static final String QUERY_URL = "https://api.themoviedb.org/3/search/";
    private static final String BASE_URL_MOVIE = "https://api.themoviedb.org/3/movie/";
    private static final String TRENDING_URL = "https://api.themoviedb.org/3/trending/all/";

    public static PlaceholderAPI getApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceholderAPI apiService = retrofit.create(PlaceholderAPI.class);

        return apiService;
    }

    public static PlaceholderAPI getQueryApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(QUERY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceholderAPI apiService = retrofit.create(PlaceholderAPI.class);

        return apiService;
    }

    public static PlaceholderAPI getApiMovie() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_MOVIE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceholderAPI apiService = retrofit.create(PlaceholderAPI.class);

        return apiService;
    }

    public static PlaceholderAPI trend() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TRENDING_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceholderAPI apiService = retrofit.create(PlaceholderAPI.class);

        return apiService;
    }
}
