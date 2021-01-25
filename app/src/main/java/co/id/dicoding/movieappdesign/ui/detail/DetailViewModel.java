package co.id.dicoding.movieappdesign.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import co.id.dicoding.movieappdesign.repo.CasterRepository;
import co.id.dicoding.movieappdesign.repo.VideoRepository;
import co.id.dicoding.movieappdesign.rest.ListCreditResponse;
import co.id.dicoding.movieappdesign.rest.ListVideoResponse;

@SuppressWarnings("FieldCanBeLocal")
public class DetailViewModel extends ViewModel {

    private MutableLiveData<ListCreditResponse> creditResponseMutableLiveData;
    private MutableLiveData<ListVideoResponse> videoResponseMutableLiveData;
    private CasterRepository casterRepository;
    private VideoRepository videoRepository;
    @SuppressWarnings("unused")
    private final String TAG = DetailActivity.class.getSimpleName();

    public DetailViewModel() {
        casterRepository = CasterRepository.getInstance();
        videoRepository = VideoRepository.getInstance();
    }

    LiveData<ListCreditResponse> getCredits(String state, int id) {
        creditResponseMutableLiveData = casterRepository.loadCredits(state, id);
        return creditResponseMutableLiveData;
    }

    LiveData<ListVideoResponse> getVideos(String state, int id) {
        videoResponseMutableLiveData = videoRepository.loadVideos(state, id);
        return videoResponseMutableLiveData;
    }
}
