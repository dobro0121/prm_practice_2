package com.example.prm_practice_2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.prm_practice_2.databinding.FirstScreenBinding;
public class FirstScreen extends Fragment {

    private FragmentManager fragmentManager;
    private FirstScreenBinding binding;

    public FirstScreen(){
        super(R.layout.first_screen);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //Toast.makeText(getActivity(), "Fragment attached", Toast.LENGTH_SHORT).show();
        //Log.d("MyFragment", "Fragment attached");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toast.makeText(getActivity(), "Fragment created", Toast.LENGTH_SHORT).show();
        //Log.d("MyFragment", "Fragment created");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FirstScreenBinding.inflate(inflater, container, false);

        binding.FilmButtonChoice.setOnClickListener(v -> {
            fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.constraint_layout_main, new SecondScreen());
            fragmentTransaction.addToBackStack(null).commit();
        });

        binding.CinemaButtonChoice.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.constraint_layout_main, new ThirdScreen());
            fragmentTransaction.addToBackStack(null).commit();
        });
        //Toast.makeText(getActivity(), "Fragment createdView", Toast.LENGTH_SHORT).show();
        //Log.d("MyFragment", "Fragment createdView");
        return binding.getRoot();
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "Fragment activityCreated", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment activityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "Fragment started", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment started");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "Fragment resumed", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment resumed");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "Fragment stopped", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment stopped");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getActivity(), "Fragment savedInstanceState", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment savedInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "Fragment stopped", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment stopped");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "Fragment destroyedView", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment destroyedView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "Fragment destroyed", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment destroyed");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "Fragment detached", Toast.LENGTH_SHORT).show();
        Log.d("MyFragment", "Fragment detached");
    }*/
}