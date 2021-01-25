package co.id.dicoding.movieappdesign.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.id.dicoding.movieappdesign.R;
import co.id.dicoding.movieappdesign.adapter.HomeAdapter;
import co.id.dicoding.movieappdesign.adapter.MovieAdapter;
import co.id.dicoding.movieappdesign.adapter.TvShowAdapter;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.model.Movie;
import co.id.dicoding.movieappdesign.model.TvShow;
import co.id.dicoding.movieappdesign.rest.ListMovieResponse;
import co.id.dicoding.movieappdesign.rest.ListTvShowResponse;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView, recyclerViewMovie, recyclerViewTvShow;
    private ArrayList<String> banner = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<TvShow> tvShows = new ArrayList<>();
    private ShimmerFrameLayout shimmerFrameLayout, shimmerFrameLayout2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recycler);
        recyclerViewMovie = root.findViewById(R.id.recycler_movie);
        recyclerViewTvShow = root.findViewById(R.id.recycler_tvshow);
        final LinearLayoutManager layoutManagerCenter = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManagerCenter);
        recyclerView.post(new Runnable() {
            public void run() {
                int padding = getResources().getDimensionPixelSize(R.dimen.len_4dp);
                int rvWidth = recyclerView.getWidth();
                int itemWidth = getResources().getDimensionPixelSize(R.dimen.banner_width);
                int offset = (rvWidth - itemWidth - padding) / 2;
                layoutManagerCenter.scrollToPositionWithOffset(1, offset);
            }
        });
        HomeAdapter itemAdapter = new HomeAdapter(banner, getActivity());
        recyclerView.setAdapter(itemAdapter);
        SnapHelper snapHelperCenter = new LinearSnapHelper();
        snapHelperCenter.attachToRecyclerView(recyclerView);

        shimmerFrameLayout = root.findViewById(R.id.parentShimmerLayout);
        shimmerFrameLayout2 = root.findViewById(R.id.parentShimmerLayout2);

        if (savedInstanceState != null) {
            movies = savedInstanceState.getParcelableArrayList(Constant.STATE_MOVIES);
            tvShows = savedInstanceState.getParcelableArrayList(Constant.STATE_TV_SHOWS);
            showMovieList(movies);
            showTvShowList(tvShows);
        } else {
            homeViewModel.getMovies().observe(this, new Observer<ListMovieResponse>() {
                @Override
                public void onChanged(ListMovieResponse listMovieResponse) {
                    List<Movie> datas = listMovieResponse.getResults();
                    movies.addAll(datas);
                    showMovieList(movies);
                }
            });

            homeViewModel.getTvShows().observe(this, new Observer<ListTvShowResponse>() {
                @Override
                public void onChanged(ListTvShowResponse listTvShowResponse) {
                    List<TvShow> datas = listTvShowResponse.getResults();
                    tvShows.addAll(datas);
                    showTvShowList(tvShows);
                }
            });
        }
        return root;
    }

    private void showMovieList(ArrayList<Movie> movies) {
        if (!movies.isEmpty()) {
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            recyclerViewMovie.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            //    private final String TAG = HomeFragment.class.getSimpleName();
            MovieAdapter movieAdapter = new MovieAdapter(movies, getActivity());
            recyclerViewMovie.setAdapter(movieAdapter);
        }
    }

    private void showTvShowList(ArrayList<TvShow> tvShows) {
        if (!tvShows.isEmpty()) {
            shimmerFrameLayout2.stopShimmer();
            shimmerFrameLayout2.setVisibility(View.GONE);
            recyclerViewTvShow.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            TvShowAdapter tvShowAdapter = new TvShowAdapter(tvShows, getActivity());
            recyclerViewTvShow.setAdapter(tvShowAdapter);
        }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Constant.STATE_MOVIES, movies);
        outState.putParcelableArrayList(Constant.STATE_TV_SHOWS, tvShows);
    }
}