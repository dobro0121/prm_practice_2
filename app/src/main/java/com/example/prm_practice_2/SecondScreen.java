package com.example.prm_practice_2;

import static com.example.prm_practice_2.R.id.listViewFilms;
import static com.example.prm_practice_2.R.layout.activity_main;
import static com.example.prm_practice_2.R.layout.first_screen;
import static com.example.prm_practice_2.R.layout.second_screen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.prm_practice_2.databinding.SecondScreenBinding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondScreen extends Fragment {
    SecondScreenBinding binding;
    FragmentManager fragmentManager;
    MainActivity mainActivity;
    public SecondScreen() {
        super(R.layout.second_screen);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*fragmentManager = getParentFragmentManager();
        fragmentManager.setFragmentResultListener("go to personal data", this, ((requestKey, result) -> {
            String name = result.getString("name");
            TextView NameTextView = binding.NameOfAccount;
            NameTextView.setText(name);
            String email = result.getString("email");
            TextView EmailTextView = binding.EmailOfAccount;
            EmailTextView.setText(email);
            String password = result.getString("password");
            TextView PasswordTextView = binding.PasswordOfAccount;
            PasswordTextView.setText(password);
        }));*/
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = SecondScreenBinding.inflate(inflater, container, false);

        List<String> listOfFilms = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mi\\Desktop\\Films.txt"))){
            String line;
            while ((line = br.readLine()) != null)
                listOfFilms.add(line);
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        SecondScreenAdapter adapter = new SecondScreenAdapter(getActivity(), R.layout.list_item, listOfFilms);
        binding.listViewFilms.setAdapter(adapter);
        return binding.getRoot();
    }
}