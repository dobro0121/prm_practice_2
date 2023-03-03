package com.example.prm_practice_2;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prm_practice_2.databinding.FragmentButtomBinding;
import com.example.prm_practice_2.databinding.FragmentProfileNameBinding;


public class FragmentButtom extends Fragment {

    private FragmentManager fragmentManager;
    private FragmentButtomBinding bindinghere;
    private MainActivity mainActivity;

    public FragmentButtom(){
        super(R.layout.fragment_buttom);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindinghere = FragmentButtomBinding.inflate(inflater, container, false);

        return bindinghere.getRoot();
    }

}