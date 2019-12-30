package co.id.dicoding.movieappdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import co.id.dicoding.movieappdesign.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.CardHolder> {
    private ArrayList<String> movie;
    private Context context;

    public HomeAdapter(ArrayList<String> movie, Context mContext) {
        this.movie = movie;
        this.context = mContext;
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new HomeAdapter.CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        String s = movie.get(position);
        Glide.with(holder.itemView.getContext())
                .load(s.equals("1") ? R.drawable.banner1 :
                        s.equals("2") ? R.drawable.banner2 :
                                s.equals("3") ? R.drawable.banner3 : R.drawable.banner4)
                .into(holder.cardView);
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class CardHolder extends RecyclerView.ViewHolder {
        ImageView cardView;

        public CardHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.bg_cardview);
        }
    }
}
