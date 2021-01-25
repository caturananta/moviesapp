package co.id.dicoding.movieappdesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import co.id.dicoding.movieappdesign.R;
import co.id.dicoding.movieappdesign.constant.Constant;
import co.id.dicoding.movieappdesign.model.Movie;
import co.id.dicoding.movieappdesign.ui.detail.DetailActivity;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviesViewHolder> {

    private ArrayList<Movie> listMovie;
    private Context mContext;

    public MovieAdapter(ArrayList<Movie> list, Context context) {
        this.listMovie = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MoviesViewHolder movieViewHolder, int i) {
        final Movie movie = listMovie.get(i);
        double d = movie.getVote_average();
        float onerm = (float) (d);
        movieViewHolder.movieTitle.setText(movie.getTitle());
        movieViewHolder.rating.setRating(onerm / 2);
        Glide.with(movieViewHolder.itemView.getContext())
                .load(Constant.POSTER_URL + movie.getPoster_path())
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
                .into(movieViewHolder.moviePoster);

        movieViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailMovie = new Intent(mContext, DetailActivity.class);
                detailMovie.putExtra(Constant.EXTRA_DATA, movie);
                detailMovie.putExtra(Constant.EXTRA_FLAG, Constant.FLAG_MOVIE);
                mContext.startActivity(detailMovie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;
        TextView movieTitle;
        RatingBar rating;

        MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.iv);
            movieTitle = itemView.findViewById(R.id.tv);
            rating = itemView.findViewById(R.id.rb_movie);
        }
    }
}
