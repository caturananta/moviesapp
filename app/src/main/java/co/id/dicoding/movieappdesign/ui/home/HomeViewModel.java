package co.id.dicoding.movieappdesign.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import co.id.dicoding.movieappdesign.repo.MovieRepository;
import co.id.dicoding.movieappdesign.repo.TvShowRepository;
import co.id.dicoding.movieappdesign.rest.ListMovieResponse;
import co.id.dicoding.movieappdesign.rest.ListTvShowResponse;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ListMovieResponse> movieResponseMutableLiveData;
    private MutableLiveData<ListTvShowResponse> tvShowResponseMutableLiveData;
    private MovieRepository movieRepository;
    private TvShowRepository tvShowRepository;

    public HomeViewModel() {
        movieRepository = MovieRepository.getInstance();
        movieResponseMutableLiveData = movieRepository.loadMovies();

        tvShowRepository = TvShowRepository.getInstance();
        tvShowResponseMutableLiveData = tvShowRepository.loadTvShows();
    }

    public LiveData<ListMovieResponse> getMovies() {
        return movieResponseMutableLiveData;
    }

    public LiveData<ListTvShowResponse> getTvShows() {
        return tvShowResponseMutableLiveData;
    }

}