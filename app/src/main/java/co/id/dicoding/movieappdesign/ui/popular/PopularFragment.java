package co.id.dicoding.movieappdesign.ui.popular;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.id.dicoding.movieappdesign.R;
import co.id.dicoding.movieappdesign.adapter.PopularAdapter;
import co.id.dicoding.movieappdesign.model.Trend;
import co.id.dicoding.movieappdesign.rest.ListTrendingResponse;

public class PopularFragment extends Fragment {

    private PopularViewModel popularViewModel;
    private RecyclerView recyclerView;
    private PopularAdapter popularAdapter;
    private ArrayList<Trend> trends = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        popularViewModel = ViewModelProviders.of(this).get(PopularViewModel.class);
        View root = inflater.inflate(R.layout.fragment_popular, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.rv_popular);

        popularViewModel.getTrending().observe(this, new Observer<ListTrendingResponse>() {
            @Override
            public void onChanged(ListTrendingResponse listTrendingResponse) {
                List<Trend> datas = listTrendingResponse.getResults();
                trends.addAll(datas);
                showMovieList(trends);
            }
        });

        return root;
    }

    private void showMovieList(ArrayList<Trend> movies) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        popularAdapter = new PopularAdapter(movies, getActivity());
        recyclerView.setAdapter(popularAdapter);
    }
}