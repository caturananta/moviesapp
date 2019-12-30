package co.id.dicoding.movieappdesign.api;

import co.id.dicoding.movieappdesign.rest.ListCreditResponse;
import co.id.dicoding.movieappdesign.rest.ListMovieResponse;
import co.id.dicoding.movieappdesign.rest.ListTrendingResponse;
import co.id.dicoding.movieappdesign.rest.ListTvShowResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceholderAPI {

    @GET("movie")
    Call<ListMovieResponse> getMovies(@Query("api_key") String api, @Query("language") String lang);

    @GET("movie")
    Call<ListMovieResponse> getPopularMovies(@Query("api_key") String api, @Query("language") String lang, @Query("sort_by") String sortBy);

    @GET("tv")
    Call<ListTvShowResponse> getTvShows(@Query("api_key") String api, @Query("language") String lang);

    @GET("movie")
    Call<ListMovieResponse> getReleaseToday(@Query("api_key") String api, @Query("primary_release_date.gte") String gte, @Query("primary_release_date.lte") String lte);

    @GET("movie")
    Call<ListMovieResponse> getQueryMovies(@Query("api_key") String api, @Query("language") String lang, @Query("query") String query);

    @GET("tv")
    Call<ListTvShowResponse> getQueryTvShows(@Query("api_key") String api, @Query("language") String lang, @Query("query") String query);

    @GET("{movieId}/credits")
    Call<ListCreditResponse> getCredits(@Path("movieId") int movieId, @Query("api_key") String api);

    @GET("week")
    Call<ListTrendingResponse> getTrending(@Query("api_key") String api, @Query("language") String lang);
}
