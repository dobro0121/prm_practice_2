package com.example.prm_practice_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ThirdScreenAdapter extends RecyclerView.Adapter<ThirdScreenAdapter.CinemasViewHolder> {
    Context context;
    private List<String> Cinemas;

    public ThirdScreenAdapter(Context context, List<String> Cinemas) {
        this.context = context;
        this.Cinemas = Cinemas;
    }


    public final static class CinemasViewHolder extends RecyclerView.ViewHolder {

        TextView cinema;
        ImageView dots;
        public CinemasViewHolder(@NonNull View itemView) {
            super(itemView);
            cinema = itemView.findViewById(R.id.nameOfCinema);
            dots = itemView.findViewById(R.id.dots);
        }
    }
    @NonNull
    @Override
    public ThirdScreenAdapter.CinemasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cinemaItems = LayoutInflater.from(context).inflate(R.layout.cinema_item, parent, false);
        return new CinemasViewHolder(cinemaItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemasViewHolder holder, int position) {
        holder.cinema.setText(Cinemas.get(position));
    }

    @Override
    public int getItemCount() {
        return Cinemas.size();
    }
}
