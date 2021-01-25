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

    public HomeViewModel() {
        MovieRepository movieRepository = MovieRepository.getInstance();
        movieResponseMutableLiveData = movieRepository.loadMovies();

        TvShowRepository tvShowRepository = TvShowRepository.getInstance();
        tvShowResponseMutableLiveData = tvShowRepository.loadTvShows();
    }

    LiveData<ListMovieResponse> getMovies() {
        return movieResponseMutableLiveData;
    }

    LiveData<ListTvShowResponse> getTvShows() {
        return tvShowResponseMutableLiveData;
    }

}