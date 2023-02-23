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

import com.example.prm_practice_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Инициализация TextView и ImageView строковым и картинкой с помощью ViewBinding
        TextView textView = binding.Consent;
        ImageView imageView = binding.stars;
        String text = getString(R.string.Consent);
        Drawable drawable = getResources().getDrawable(R.drawable.free_icon_font_sparkles_6854012);
        textView.setText(text);
        imageView.setImageDrawable(drawable);

        //Программное задание метода обработчика событий с помощью ViewBinding
        binding.ConsentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonConsentClickHandler(view);
            }
        });

    }

    //Декларативное задание метода обработчика событий с помощью ViewBinding
    public void ButtonConsentClickHandler (View view){
        Log.d(TAG, "Click is saved");
    }
}