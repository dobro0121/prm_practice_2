package com.example.prm_practice_2;

import android.annotation.SuppressLint;
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
    private OnItemClickListener listener;

    public ThirdScreenAdapter(Context context, List<String> Cinemas) {
        this.context = context;
        this.Cinemas = Cinemas;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ThirdScreenAdapter.CinemasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cinemaItems = LayoutInflater.from(context).inflate(R.layout.cinema_item, parent, false);
        return new CinemasViewHolder(cinemaItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemasViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String cinema_ = Cinemas.get(position);
        holder.cinema.setText(cinema_);
        holder.dots.setImageResource(R.drawable.free_icon_font_menu_dots_3917763);

        // Обработчик нажатия на элемент
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Cinemas.size();
    }

    public static class CinemasViewHolder extends RecyclerView.ViewHolder {

        TextView cinema;
        ImageView dots;
        public CinemasViewHolder(@NonNull View itemView) {
            super(itemView);
            cinema = itemView.findViewById(R.id.nameOfCinema);
            dots = itemView.findViewById(R.id.dots);
        }
    }
}
