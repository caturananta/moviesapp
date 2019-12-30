package co.id.dicoding.movieappdesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
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
import co.id.dicoding.movieappdesign.model.TvShow;
import co.id.dicoding.movieappdesign.ui.detail.DetailActivity;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewsHolder> {

    private ArrayList<TvShow> listTvShow;
    private Context mContext;

    public TvShowAdapter(ArrayList<TvShow> list, Context context) {
        this.listTvShow = list;
        this.mContext = context;
        Log.e("ASD", "TvShowAdapter: " + list.get(0).getName());
    }

    @NonNull
    @Override
    public TvShowViewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_show, viewGroup, false);
        return new TvShowAdapter.TvShowViewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewsHolder tvShowViewsHolder, int i) {
        final TvShow tvShow = listTvShow.get(i);
        double d = tvShow.getVote_average();
        float onerm = (float) (d);

        tvShowViewsHolder.tvTitle.setText(tvShow.getName());
        tvShowViewsHolder.rating.setRating(onerm / 2);
        Glide.with(tvShowViewsHolder.itemView.getContext())
                .load(Constant.POSTER_URL + tvShow.getPoster_path())
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
                .into(tvShowViewsHolder.tvPoster);

        tvShowViewsHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailMovie = new Intent(mContext, DetailActivity.class);
                detailMovie.putExtra(Constant.EXTRA_DATA, tvShow);
                detailMovie.putExtra(Constant.EXTRA_FLAG, Constant.FLAG_TVSHOW);
                mContext.startActivity(detailMovie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class TvShowViewsHolder extends RecyclerView.ViewHolder {
        ImageView tvPoster;
        TextView tvTitle;
        RatingBar rating;

        public TvShowViewsHolder(@NonNull View itemView) {
            super(itemView);
            tvPoster = itemView.findViewById(R.id.iv_tvshow);
            tvTitle = itemView.findViewById(R.id.tv_tvshow);
            rating = itemView.findViewById(R.id.rb_tvshow);
        }
    }
}
