package com.example.prm_practice_2;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prm_practice_2.databinding.FragmentButtomBinding;
import com.example.prm_practice_2.databinding.FragmentProfileNameBinding;

public class FragmentProfileName extends Fragment {
    private FragmentProfileNameBinding binding;
    private FragmentButtomBinding bindingbuttom;
    FragmentManager fragmentManager;
    MainActivity mainActivity;
    public FragmentProfileName() {
        super(R.layout.fragment_profile_name);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getParentFragmentManager();
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
        }));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileNameBinding.inflate(inflater, container, false);
        bindingbuttom = FragmentButtomBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindingbuttom.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textviewName = binding.NameOfAccount;
                EditText edittextEmail = binding.EmailOfAccount;
                EditText edittextpassword = binding.PasswordOfAccount;

                Bundle bundle = new Bundle();
                String name_ = textviewName.getText().toString();
                String email_ = edittextEmail.getText().toString();
                String password_ = edittextpassword.getText().toString();

                // Переход со второго в первый фрагмент
                bundle.putString("name_", name_);
                bundle.putString("email_", email_);
                bundle.putString("password_", password_);

                fragmentManager.setFragmentResult("written data", bundle);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.constraint_layout_main, new BlankFragmentFirst());
                fragmentTransaction.addToBackStack(null).commit();
            }

        });
    }
}