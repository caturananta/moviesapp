package co.id.dicoding.movieappdesign.ui.search;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import co.id.dicoding.movieappdesign.R;

public class SearchActivity extends AppCompatActivity {
    SearchViewModel searchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
    }
}
