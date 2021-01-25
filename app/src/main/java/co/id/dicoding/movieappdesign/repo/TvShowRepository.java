package co.id.dicoding.movieappdesign.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import co.id.dicoding.movieappdesign.BuildConfig;
import co.id.dicoding.movieappdesign.api.ApiClient;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.rest.ListTvShowResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings({"FieldCanBeLocal", "NullableProblems"})
public class TvShowRepository {

    private final String apiKey = BuildConfig.TMDB_API_KEY;
    private final String TAG = TvShowRepository.class.getSimpleName();
    private String lang = "en";

    private static TvShowRepository tvShowRepository;

    public static TvShowRepository getInstance() {
        if (tvShowRepository == null) {
            tvShowRepository = new TvShowRepository();
        }
        return tvShowRepository;
    }

    public MutableLiveData<ListTvShowResponse> loadTvShows() {
        final MutableLiveData<ListTvShowResponse> tvShowsData = new MutableLiveData<>();
        final Call<ListTvShowResponse> tvs = ApiClient.getApi().getTvShows(
                apiKey,
                lang.equals(Constant.KEY_LANG_EN) ? Constant.API_LANG_ENGLISH : Constant.API_LANG_INDONESIAN);
        tvs.enqueue(new Callback<ListTvShowResponse>() {
            @Override
            public void onResponse(Call<ListTvShowResponse> call, Response<ListTvShowResponse> response) {
                Log.d(TAG, "onResponse: first tv show is " + (response.body() != null ? response.body().getResults().get(0).getName() : 0));
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        tvShowsData.setValue(response.body());
                    }
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ListTvShowResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
        return tvShowsData;
    }
}
