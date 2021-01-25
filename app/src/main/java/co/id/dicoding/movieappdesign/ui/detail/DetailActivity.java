package co.id.dicoding.movieappdesign.ui.detail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.Objects;

import co.id.dicoding.movieappdesign.R;
import co.id.dicoding.movieappdesign.adapter.CastAdapter;
import co.id.dicoding.movieappdesign.adapter.VideoAdapter;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.model.Movie;
import co.id.dicoding.movieappdesign.model.Trend;
import co.id.dicoding.movieappdesign.model.TvShow;
import co.id.dicoding.movieappdesign.rest.ListCreditResponse;
import co.id.dicoding.movieappdesign.rest.ListVideoResponse;
import co.id.dicoding.movieappdesign.utils.AppBarStateChangeListener;
import co.id.dicoding.movieappdesign.utils.Genres;

public class DetailActivity extends AppCompatActivity {
    private Movie movie;
    private TvShow tvShow;
    private Trend trend;
    private ImageView imgPoster, imgBackDrop, imgNotFound;
    private TextView tvTitle, tvGenres, tvRating, tvOverview;
    private RatingBar ratingBar;
    private RecyclerView recyclerViewCast, recyclerViewVideo;
    private Boolean isMovie = false;
    private Boolean isTvShow = false;
    private Toolbar toolbar;
    private DetailViewModel detailViewModel;
    private final String TAG = DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (Objects.equals(getIntent().getStringExtra(Constant.EXTRA_FLAG), Constant.FLAG_MOVIE)) {
            movie = getIntent().getParcelableExtra(Constant.EXTRA_DATA);
            isMovie = true;
        } else if (Objects.equals(getIntent().getStringExtra(Constant.EXTRA_FLAG), Constant.FLAG_TVSHOW)) {
            tvShow = getIntent().getParcelableExtra(Constant.EXTRA_DATA);
            isTvShow = true;
        } else if (Objects.equals(getIntent().getStringExtra(Constant.EXTRA_FLAG), Constant.FLAG_POPULAR)) {
            trend = getIntent().getParcelableExtra(Constant.EXTRA_DATA);
        }
        detailViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        AppBarLayout appBarLayout = findViewById(R.id.htab_appbar);
        imgPoster = findViewById(R.id.iv_poster_detail);
        imgBackDrop = findViewById(R.id.iv_backdrop_detail);
        imgNotFound = findViewById(R.id.iv_not_found);
        tvTitle = findViewById(R.id.tv_title_detail);
        tvGenres = findViewById(R.id.tv_genre_detail);
        tvRating = findViewById(R.id.tv_rating_detail);
        tvOverview = findViewById(R.id.tv_overview);
        ratingBar = findViewById(R.id.rb_rating_detail);
        recyclerViewCast = findViewById(R.id.rv_caster);
        recyclerViewVideo = findViewById(R.id.rv_videos);
        toolbar = findViewById(R.id.htab_toolbar);
        toolbar.setTitle(isMovie ? movie.getTitle() : isTvShow ? tvShow.getName() : trend.getMedia_type().equals(Constant.KEY_TV_MEDIA_TYPE) ? trend.getName() : trend.getTitle());
        imgNotFound.setVisibility(View.GONE);
        init();
        String state = isMovie ? Constant.FLAG_MOVIE : isTvShow ? Constant.FLAG_TVSHOW : trend.getMedia_type().equals(Constant.KEY_TV_MEDIA_TYPE) ? Constant.FLAG_TVSHOW : Constant.FLAG_MOVIE;
        getDetail(state, isMovie ? movie.getId() : isTvShow ? tvShow.getId() : trend.getId());
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                final String layoutState = state.name();
                Log.d(TAG, "onStateChanged: " + state.name());
                switch (layoutState) {
                    case Constant.STATE_IDLE:
                        toolbar.animate().alpha(0.0f).setDuration(1000);
                    case Constant.STATE_EXPANDED:
                        toolbar.setAlpha(0.0f);
                        break;
                    case Constant.STATE_COLLAPSED:
                        toolbar.animate().alpha(1.0f).setDuration(1000);
                        break;
                }
            }
        });
    }

    private void init() {

        double d = isMovie ? movie.getVote_average() : isTvShow ? tvShow.getVote_average() : trend.getVote_average();
        float rating = (float) (d);

        tvTitle.setText(isMovie ? movie.getTitle() : isTvShow ? tvShow.getName() : trend.getMedia_type().equals(Constant.KEY_TV_MEDIA_TYPE) ? trend.getName() : trend.getTitle());
        tvRating.setText(isMovie ? movie.getVote_average().toString() : isTvShow ? tvShow.getVote_average().toString() : trend.getVote_average().toString());
        ratingBar.setRating(rating / 2);
        tvOverview.setText(isMovie ? movie.getOverview() : isTvShow ? tvShow.getOverview() : trend.getOverview());

        Glide.with(this)
                .load(isMovie ? Constant.POSTER_URL + movie.getPoster_path() :
                        isTvShow ? Constant.POSTER_URL + tvShow.getPoster_path() :
                                Constant.POSTER_URL + trend.getPoster_path())
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
                .load(isMovie ? Constant.POSTER_URL + movie.getBackdrop_path() :
                        isTvShow ? Constant.POSTER_URL + tvShow.getBackdrop_path() :
                                Constant.POSTER_URL + trend.getBackdrop_path())
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

        ArrayList<String> n = new ArrayList<>();
        for (Integer i : isMovie ? movie.getGenre_ids() : isTvShow ? tvShow.getGenre_ids() : trend.getGenre_ids()) {
            n.add(String.valueOf(i));
        }

        Genres genres = new Genres();
        genres.getGenres(n);

        tvGenres.setText(TextUtils.join(", ", n));

    }

    private void getDetail(String state, int id) {
        detailViewModel.getCredits(state, id).observe(this, new Observer<ListCreditResponse>() {
            @Override
            public void onChanged(ListCreditResponse listCreditResponse) {
                showCaster(listCreditResponse);
            }
        });

        detailViewModel.getVideos(state, id).observe(this, new Observer<ListVideoResponse>() {
            @Override
            public void onChanged(ListVideoResponse listVideoResponse) {
                showVideos(listVideoResponse);
            }
        });
    }

    private void showCaster(ListCreditResponse listCreditResponse) {
        recyclerViewCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        CastAdapter castAdapter = new CastAdapter(listCreditResponse.getCast(), listCreditResponse.getCrew(), this);
        recyclerViewCast.setAdapter(castAdapter);
    }

    private void showVideos(ListVideoResponse listVideoResponse) {
        recyclerViewVideo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        VideoAdapter videoAdapter = new VideoAdapter(this, listVideoResponse.getResults());
        recyclerViewVideo.setAdapter(videoAdapter);
    }
}
