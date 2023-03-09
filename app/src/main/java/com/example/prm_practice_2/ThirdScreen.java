package com.example.prm_practice_2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prm_practice_2.databinding.FragmentThirdScreenBinding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdScreen extends Fragment {

    FragmentThirdScreenBinding binding;
    MainActivity mainActivity;
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
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mi\\Desktop\\Cinemas.txt"))){
            String line;
            while ((line = br.readLine()) != null)
                listOfCinemas.add(line);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainActivity, RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        ThirdScreenAdapter adapter = new ThirdScreenAdapter(mainActivity, listOfCinemas);
        binding.recyclerView.setAdapter(adapter);
        return binding.getRoot();
    }
}