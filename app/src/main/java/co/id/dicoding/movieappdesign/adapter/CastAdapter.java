package co.id.dicoding.movieappdesign.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import co.id.dicoding.movieappdesign.model.Cast;
import co.id.dicoding.movieappdesign.model.Crew;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CasterViewHolder> {

    private ArrayList<Cast> listCast;
    private ArrayList<Crew> listCrew;
    private Context mContext;

    public CastAdapter(ArrayList<Cast> casts, ArrayList<Crew> crews, Context context) {
        this.listCast = casts;
        this.listCrew = crews;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cast, parent, false);
        return new CastAdapter.CasterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CasterViewHolder holder, int position) {
        Cast cast = listCast.get(position);
//        Crew crew = listCrew.get(position);

        holder.castJob.setText(cast.getCharacter());
        holder.castName.setText(cast.getName());
        if (cast != null) {
            Glide.with(holder.itemView.getContext())
                    .load(Constant.POSTER_URL + cast.getProfile_path())
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
                    .into(holder.castPoster);
        }

//        if (crew != null) {
//            Glide.with(holder.itemView.getContext())
//                    .load(Constant.POSTER_URL + crew.getProfile_path())
//                    .listener(new RequestListener<Drawable>() {
//                        @Override
//                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                            return false;
//                        }
//
//                        @Override
//                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                            return false;
//                        }
//                    })
//                    .into(holder.castPoster);
//        }
    }

    @Override
    public int getItemCount() {
//        return listCast.size() + listCrew.size();
        return listCast.size();
    }

    public class CasterViewHolder extends RecyclerView.ViewHolder {
        ImageView castPoster;
        TextView castName, castJob;

        public CasterViewHolder(@NonNull View itemView) {
            super(itemView);
            castPoster = itemView.findViewById(R.id.iv_cast_poster);
            castName = itemView.findViewById(R.id.tv_cast_name);
            castJob = itemView.findViewById(R.id.tv_cast_job);
        }
    }
}
