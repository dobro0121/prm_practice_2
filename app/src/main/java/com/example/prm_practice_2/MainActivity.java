package com.example.prm_practice_2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment fragmentFirst, fragmentButtom, fragmentProfileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentFirst = new FirstScreen();
        fragmentButtom = new FragmentButtom();
        fragmentProfileName = new SecondScreen();

        if(savedInstanceState == null){

            // Создаем первый фрагмент и загружаем его в контейнер
            fragmentManager = getSupportFragmentManager(); // добро пожаловать который
            fragmentManager.beginTransaction()
                    .replace(R.id.constraint_layout_main, new FirstScreen())
                    .addToBackStack(null)
                    .commit();
        }
    }
}