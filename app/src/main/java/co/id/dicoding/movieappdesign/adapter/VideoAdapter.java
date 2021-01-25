package co.id.dicoding.movieappdesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
import co.id.dicoding.movieappdesign.model.Video;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {

    private Context mContext;
    private ArrayList<Video> videos;

    public VideoAdapter(Context mContext, ArrayList<Video> videos) {
        this.mContext = mContext;
        this.videos = videos;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoAdapter.VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        final Video video = videos.get(position);

        if (video != null) {
            Glide.with(holder.itemView.getContext())
                    .load(Constant.YOUTUBE_THUMBNAIL_URL + video.getKey() + Constant.DEFAULT_THUMBNAIL)
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
                    .into(holder.imageView);
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constant.YOUTUBE_VIEW + (video != null ? video.getKey() : null))));
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class VideoHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        VideoHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_video);
        }
    }
}
