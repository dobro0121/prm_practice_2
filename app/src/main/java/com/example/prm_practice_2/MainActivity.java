package com.example.prm_practice_2;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @SuppressLint("WrongViewCast") TextView textView = findViewById(R.id.Consent_);
        ImageView imageView = findViewById(R.id.stars);
        String text = getString(R.string.Consent);
        Drawable drawable = getResources().getDrawable(R.drawable.free_icon_font_sparkles_6854012);
        textView.setText(text);
        imageView.setImageDrawable(drawable);
    }
}