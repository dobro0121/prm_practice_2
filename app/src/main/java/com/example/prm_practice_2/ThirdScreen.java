package com.example.prm_practice_2;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.prm_practice_2.databinding.FragmentThirdScreenBinding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdScreen extends Fragment {

    FragmentThirdScreenBinding binding;
    MainActivity mainActivity;
    RecyclerView recyclerView;
    public ThirdScreen() {
        super(R.layout.fragment_third_screen);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdScreenBinding.inflate(inflater, container, false);

        List<String> listOfCinemas = new ArrayList<String>();
        try {
            AssetManager assetManager = getActivity().getApplicationContext().getAssets();
            InputStream stream = assetManager.open("Cinemas.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(inputStreamReader);

            String line;
            while ((line = br.readLine()) != null)
                listOfCinemas.add(line);
            br.close();
            inputStreamReader.close();
            stream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));

        ThirdScreenAdapter adapter = new ThirdScreenAdapter(mainActivity, listOfCinemas);
        recyclerView.setAdapter(adapter);

        // Отображение Toast и сообщения в Log при нажатии на элемент списка
        adapter.setOnItemClickListener(new ThirdScreenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), "Clicking on a list item", Toast.LENGTH_SHORT).show();
                Log.i("tag","Clicking on a list item");
            }
        });

        return binding.getRoot();
    }
}