package com.example.prm_practice_2;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @SuppressLint("WrongViewCast") TextView textView = findViewById(R.id.Consent);
        ImageView imageView = findViewById(R.id.stars);
        String text = getString(R.string.Consent);
        Drawable drawable = getResources().getDrawable(R.drawable.free_icon_font_sparkles_6854012);
        textView.setText(text);
        imageView.setImageDrawable(drawable);

        // Программное задание метода обработчика событий
        @SuppressLint("WrongViewCast") Button button = findViewById(R.id.Consent_);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonConsentClickHandler(view);
            }
        });
    }

    //Декларативное задание метода обработчика событий
    public void ButtonConsentClickHandler (View view){
        Log.d(TAG, "Click is saved");
    }
}