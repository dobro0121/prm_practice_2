package com.example.prm_practice_2;

import static com.example.prm_practice_2.R.id.listViewFilms;
import static com.example.prm_practice_2.R.layout.activity_main;
import static com.example.prm_practice_2.R.layout.first_screen;
import static com.example.prm_practice_2.R.layout.second_screen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prm_practice_2.databinding.SecondScreenBinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        try {
            AssetManager assetManager = getActivity().getApplicationContext().getAssets();
            InputStream stream = assetManager.open("Films.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(inputStreamReader);

            String line;
            while ((line = br.readLine()) != null)
                listOfFilms.add(line);
            br.close();
            inputStreamReader.close();
            stream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        SecondScreenAdapter adapter = new SecondScreenAdapter(getActivity(), R.layout.list_item, listOfFilms);
        binding.listViewFilms.setAdapter(adapter);

        // Отображение Toast и сообщения в Log при нажатии на элемент списка
        binding.listViewFilms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Clicking on a list item", Toast.LENGTH_SHORT).show();
                Log.i("tag","Clicking on a list item");
            }
        });

        return binding.getRoot();
    }
}