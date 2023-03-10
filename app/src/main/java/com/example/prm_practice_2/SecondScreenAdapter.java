package com.example.prm_practice_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class SecondScreenAdapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;
    private int layout;
    private List<String> Films;

    public SecondScreenAdapter(@NonNull Context context, int resource, List<String> Films) {
        super(context, resource, Films);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.Films = Films;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(this.layout, parent, false);

        ImageView imageView = view.findViewById(R.id.imageViewPoints);
        imageView.setImageResource(R.drawable.free_icon_font_menu_dots_3917763);

        TextView textView = view.findViewById(R.id.nameOfFilm);
        String film = Films.get(position);
        textView.setText(film);

        return view;
    }
}
