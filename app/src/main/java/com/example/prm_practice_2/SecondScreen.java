package com.example.prm_practice_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prm_practice_2.databinding.SecondScreenBinding;

public class SecondScreen extends Fragment {
    SecondScreenBinding binding;
    FragmentManager fragmentManager;
    public SecondScreen() {
        super(R.layout.second_screen);
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
        binding.Person.setOnClickListener(v -> {
            /*Bundle bundle = new Bundle();
            // Переход со второго в первый фрагмент
            bundle.putString("name_", binding.NameOfAccount.getText().toString());
            bundle.putString("email_", binding.EmailOfAccount.getText().toString());
            bundle.putString("password_", binding.PasswordOfAccount.getText().toString());

            fragmentManager.setFragmentResult("written data", bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.constraint_layout_main, new FirstScreen());
            fragmentTransaction.addToBackStack(null).commit();*/
        });
        return binding.getRoot();
    }
}