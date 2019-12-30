package co.id.dicoding.movieappdesign.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import co.id.dicoding.movieappdesign.BuildConfig;
import co.id.dicoding.movieappdesign.api.ApiClient;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.rest.ListMovieResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private final String apiKey = BuildConfig.TMDB_API_KEY;
    private final String TAG = MovieRepository.class.getSimpleName();
    private String lang = "id";

    private static MovieRepository movieRepository;

    public static MovieRepository getInstance() {
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public MutableLiveData<ListMovieResponse> loadMovies() {
        Log.e(TAG, "loadMovies: hit");
        final MutableLiveData<ListMovieResponse> moviesData = new MutableLiveData<>();
        Call<ListMovieResponse> movies = ApiClient.getApi().getMovies(
                apiKey,
                lang.equals(Constant.KEY_LANG_EN) ? Constant.API_LANG_ENGLISH : Constant.API_LANG_INDONESIAN);
        movies.enqueue(new Callback<ListMovieResponse>() {
            @Override
            public void onResponse(Call<ListMovieResponse> call, Response<ListMovieResponse> response) {
                Log.d(TAG, "onResponse: first movie is " + response.body().getResults().get(0).getId());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        moviesData.setValue(response.body());
                    }
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ListMovieResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });

        return moviesData;
    }

    public MutableLiveData<ListMovieResponse> loadPopularMovies() {
        Log.e(TAG, "loadPopularMovies: hit");
        final MutableLiveData<ListMovieResponse> moviesData = new MutableLiveData<>();
        Call<ListMovieResponse> movies = ApiClient.getApi().getPopularMovies(
                apiKey,
                lang.equals(Constant.KEY_LANG_EN) ? Constant.API_LANG_ENGLISH : Constant.API_LANG_INDONESIAN,
                Constant.KEY_QUERY_SORTBY);
        movies.enqueue(new Callback<ListMovieResponse>() {
            @Override
            public void onResponse(Call<ListMovieResponse> call, Response<ListMovieResponse> response) {
                Log.d(TAG, "onResponse: first movie is " + response.body().getResults().get(0).getId());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        moviesData.setValue(response.body());
                    }
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ListMovieResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });

        return moviesData;
    }
}
