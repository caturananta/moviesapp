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

    private RecyclerView recyclerView;
    private ArrayList<Trend> trends = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PopularViewModel popularViewModel = ViewModelProviders.of(this).get(PopularViewModel.class);
        View root = inflater.inflate(R.layout.fragment_popular, container, false);

        recyclerView = root.findViewById(R.id.rv_popular);

        popularViewModel.getTrending().observe(getViewLifecycleOwner(), new Observer<ListTrendingResponse>() {
            @Override
            public void onChanged(ListTrendingResponse listTrendingResponse) {
                List<Trend> datas = listTrendingResponse.getResults();
                trends.addAll(datas);
                showMovieList(trends);
            }
        });

        return root;
    }

    private void showMovieList(ArrayList<Trend> trends) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        PopularAdapter popularAdapter = new PopularAdapter(trends, getActivity());
        recyclerView.setAdapter(popularAdapter);
    }
}