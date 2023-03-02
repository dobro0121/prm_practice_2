package com.example.prm_practice_2;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prm_practice_2.databinding.FragmentButtomBinding;


public class FragmentButtom extends Fragment {

    private static final int REQUEST_CODE = 123;
    private final String TAG = this.getClass().getSimpleName();
    private FragmentButtomBinding binding;

    public FragmentButtom(){
        super(R.layout.fragment_buttom);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentButtomBinding.inflate(inflater, container, false);

        //Инициализация ImageView картинкой с помощью ViewBinding
        ImageView imageView = binding.stars;
        Drawable drawable = getResources().getDrawable(R.drawable.free_icon_font_sparkles_6854012);
        imageView.setImageDrawable(drawable);

        return binding.getRoot();
    }

}