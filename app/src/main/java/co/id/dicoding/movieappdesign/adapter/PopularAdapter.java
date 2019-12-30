package co.id.dicoding.movieappdesign.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import co.id.dicoding.movieappdesign.model.Trend;
import co.id.dicoding.movieappdesign.utils.Genres;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularHolder> {
    private ArrayList<Trend> trends;
    private Context context;

    public PopularAdapter(ArrayList<Trend> trends, Context context) {
        this.context = context;
        this.trends = trends;
    }

    @NonNull
    @Override
    public PopularHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular, parent, false);
        return new PopularAdapter.PopularHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularHolder holder, int position) {
        final Trend trend = trends.get(position);
        double d = trend.getVote_average();
        float onerm = (float) (d);
        String s = "";

        ArrayList<String> n = new ArrayList<String>();
        for (Integer i : trend.getGenre_ids()) {
            n.add(String.valueOf(i));
        }

        Genres genres = new Genres();

        n = genres.getGenres(n);

        holder.title.setText(trend.getMedia_type().equals(Constant.KEY_TV_MEDIA_TYPE) ? trend.getName() : trend.getTitle());
        holder.rating.setRating(onerm / 2);
        holder.ratingText.setText(trend.getVote_average().toString());
        holder.mediaType.setText("type : " + trend.getMedia_type());
        holder.genre.setText("genre : " + TextUtils.join(", ", n));
        Glide.with(holder.itemView.getContext())
                .load(Constant.POSTER_URL + trend.getPoster_path())
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
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return trends.size();
    }

    public class PopularHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title, ratingText, mediaType, genre;
        RatingBar rating;

        public PopularHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.iv_popular);
            title = itemView.findViewById(R.id.tv_title_popular);
            rating = itemView.findViewById(R.id.rb_popular);
            ratingText = itemView.findViewById(R.id.tv_rating_crown);
            mediaType = itemView.findViewById(R.id.tv_type_popular);
            genre = itemView.findViewById(R.id.tv_genre_popular);
        }
    }
}
