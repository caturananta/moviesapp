package co.id.dicoding.movieappdesign.repo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import co.id.dicoding.movieappdesign.BuildConfig;
import co.id.dicoding.movieappdesign.api.ApiClient;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.rest.ListVideoResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoRepository {

    @SuppressWarnings("FieldCanBeLocal")
    private final String apiKey = BuildConfig.TMDB_API_KEY;
    private final String TAG = VideoRepository.class.getSimpleName();

    private static VideoRepository videoRepository;

    public static VideoRepository getInstance() {
        if (videoRepository == null) {
            videoRepository = new VideoRepository();
        }
        return videoRepository;
    }

    public MutableLiveData<ListVideoResponse> loadVideos(String state, int id) {
        Log.e(TAG, "loadVideos: " + id);
        final MutableLiveData<ListVideoResponse> videosData = new MutableLiveData<>();
        Call<ListVideoResponse> videoResponseCall = state.equals(Constant.FLAG_MOVIE) ?
                ApiClient.getApiMovie().getVideo(id, apiKey) : ApiClient.getApiTvShow().getVideoTv(id, apiKey);
        videoResponseCall.enqueue(new Callback<ListVideoResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListVideoResponse> call, @NonNull Response<ListVideoResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        videosData.setValue(response.body());
                    }
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListVideoResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });

        return videosData;
    }
}
