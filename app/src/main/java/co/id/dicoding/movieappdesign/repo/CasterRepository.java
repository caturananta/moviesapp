package co.id.dicoding.movieappdesign.repo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import co.id.dicoding.movieappdesign.BuildConfig;
import co.id.dicoding.movieappdesign.api.ApiClient;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.rest.ListCreditResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CasterRepository {

    @SuppressWarnings("FieldCanBeLocal")
    private final String apiKey = BuildConfig.TMDB_API_KEY;
    private final String TAG = MovieRepository.class.getSimpleName();

    private static CasterRepository casterRepository;

    public static CasterRepository getInstance() {
        if (casterRepository == null) {
            casterRepository = new CasterRepository();
        }
        return casterRepository;
    }

    public MutableLiveData<ListCreditResponse> loadCredits(String state, int id) {
        Log.e(TAG, "loadCredits: " + id);
        final MutableLiveData<ListCreditResponse> creditsData = new MutableLiveData<>();
        Call<ListCreditResponse> creditResponseCall = state.equals(Constant.FLAG_MOVIE) ?
                ApiClient.getApiMovie().getCredits(id, apiKey) : ApiClient.getApiTvShow().getCreditsTv(id, apiKey);
        creditResponseCall.enqueue(new Callback<ListCreditResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListCreditResponse> call, @NonNull Response<ListCreditResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        creditsData.setValue(response.body());
                    }
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListCreditResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });

        return creditsData;
    }

}
