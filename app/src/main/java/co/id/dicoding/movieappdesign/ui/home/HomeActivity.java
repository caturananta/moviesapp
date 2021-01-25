package co.id.dicoding.movieappdesign.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import co.id.dicoding.movieappdesign.R;
import co.id.dicoding.movieappdesign.ui.search.SearchActivity;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_popular, R.id.navigation_notifications, R.id.navigation_favorite)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        final MenuItem alertMenuItem = menu.findItem(R.id.search);
        alertMenuItem.setActionView(R.layout.search_view);
        RelativeLayout relativeLayout = (RelativeLayout) alertMenuItem.getActionView();
        RelativeLayout parent = relativeLayout.findViewById(R.id.parent_badge);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSearch();
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

    private void moveToSearch() {
        Intent searchMovie = new Intent(this, SearchActivity.class);
        this.startActivity(searchMovie);
    }
}
