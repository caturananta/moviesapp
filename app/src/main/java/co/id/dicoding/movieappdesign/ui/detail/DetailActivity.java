package co.id.dicoding.movieappdesign.ui.detail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import co.id.dicoding.movieappdesign.R;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.model.Movie;
import co.id.dicoding.movieappdesign.model.TvShow;
import co.id.dicoding.movieappdesign.utils.Genres;

public class DetailActivity extends AppCompatActivity {
    private Movie movie;
    private TvShow tvShow;
    private ImageView imgPoster, imgBackDrop, imgNotFound;
    private TextView tvTitle, tvGenres, tvRating;
    private RatingBar ratingBar;
    private Boolean isMovie = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent().getStringExtra(Constant.EXTRA_FLAG).equals(Constant.FLAG_MOVIE)) {
            movie = getIntent().getParcelableExtra(Constant.EXTRA_DATA);
            isMovie = true;
        } else {
            tvShow = getIntent().getParcelableExtra(Constant.EXTRA_DATA);
        }

        imgPoster = findViewById(R.id.iv_poster_detail);
        imgBackDrop = findViewById(R.id.iv_backdrop_detail);
        imgNotFound = findViewById(R.id.iv_not_found);
        tvTitle = findViewById(R.id.tv_title_detail);
        tvGenres = findViewById(R.id.tv_genre_detail);
        tvRating = findViewById(R.id.tv_rating_detail);
        ratingBar = findViewById(R.id.rb_rating_detail);

        imgNotFound.setVisibility(View.GONE);
        init();
    }

    private void init() {

        double d = isMovie ? movie.getVote_average() : tvShow.getVote_average();
        float onerm = (float) (d);

        tvTitle.setText(isMovie ? movie.getTitle() : tvShow.getName());
        tvRating.setText(isMovie ? movie.getVote_average().toString() : tvShow.getVote_average().toString());
        ratingBar.setRating(onerm / 2);

        Glide.with(this)
                .load(isMovie ? Constant.POSTER_URL + movie.getPoster_path() : Constant.POSTER_URL + tvShow.getPoster_path())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imgPoster);

        Glide.with(this)
                .load(isMovie ? Constant.POSTER_URL + movie.getBackdrop_path() : Constant.POSTER_URL + tvShow.getBackdrop_path())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        imgNotFound.setVisibility(View.VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        imgNotFound.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imgBackDrop);

        ArrayList<String> n = new ArrayList<String>();
        for (Integer i : isMovie ? movie.getGenre_ids() : tvShow.getGenre_ids()) {
            n.add(String.valueOf(i));
        }

        Genres genres = new Genres();
        genres.getGenres(n);

        tvGenres.setText(TextUtils.join(", ", n));

    }
}
