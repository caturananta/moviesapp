package co.id.dicoding.movieappdesign.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import co.id.dicoding.movieappdesign.BuildConfig;
import co.id.dicoding.movieappdesign.api.ApiClient;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.rest.ListTrendingResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings({"FieldCanBeLocal", "NullableProblems"})
public class TrendRepository {

    private final String apiKey = BuildConfig.TMDB_API_KEY;
    private final String TAG = TrendRepository.class.getSimpleName();
    private String lang = "en";

    private static TrendRepository trendRepository;

    public static TrendRepository getInstance() {
        if (trendRepository == null) {
            trendRepository = new TrendRepository();
        }
        return trendRepository;
    }

    public MutableLiveData<ListTrendingResponse> loadTrending() {
        Log.e(TAG, "loadMovies: hit");
        final MutableLiveData<ListTrendingResponse> trendingData = new MutableLiveData<>();
        Call<ListTrendingResponse> movies = ApiClient.trend().getTrending(
                apiKey,
                lang.equals(Constant.KEY_LANG_EN) ? Constant.API_LANG_ENGLISH : Constant.API_LANG_INDONESIAN);
        movies.enqueue(new Callback<ListTrendingResponse>() {
            @Override
            public void onResponse(Call<ListTrendingResponse> call, Response<ListTrendingResponse> response) {
                Log.d(TAG, "onResponse: first movie is " + (response.body() != null ? response.body().getResults().get(0).getId() : 0));
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        trendingData.setValue(response.body());
                    }
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ListTrendingResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });

        return trendingData;
    }
}
