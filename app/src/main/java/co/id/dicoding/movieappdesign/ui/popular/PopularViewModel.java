package co.id.dicoding.movieappdesign.ui.popular;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import co.id.dicoding.movieappdesign.repo.TrendRepository;
import co.id.dicoding.movieappdesign.rest.ListTrendingResponse;

public class PopularViewModel extends ViewModel {

    private MutableLiveData<ListTrendingResponse> trendingResponseMutableLiveData;

    public PopularViewModel() {
        TrendRepository trendRepository = TrendRepository.getInstance();
        trendingResponseMutableLiveData = trendRepository.loadTrending();
    }

    LiveData<ListTrendingResponse> getTrending() {
        return trendingResponseMutableLiveData;
    }
}