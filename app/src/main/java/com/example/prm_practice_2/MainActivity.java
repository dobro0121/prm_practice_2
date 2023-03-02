package com.example.prm_practice_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            // Создаем первый фрагмент и загружаем его в контейнер
            BlankFragmentFirst fragmentFirst = new BlankFragmentFirst();
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.main_fragment, BlankFragmentFirst.class, null)
                    .commit();

            // Создаем второй фрагмент и загружаем его в контейнер
            FragmentButtom fragmentButtom = new FragmentButtom();
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.menu_fragment, FragmentButtom.class, null)
                    .commit();
        }
    }
}