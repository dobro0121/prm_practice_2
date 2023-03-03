package com.example.prm_practice_2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.prm_practice_2.databinding.FragmentBlankFirstBinding;
public class BlankFragmentFirst extends Fragment {

    private FragmentManager fragmentManager;
    private FragmentBlankFirstBinding binding;
    private MainActivity mainActivity;
    private static final int REQUEST_CODE = 123;
    private final String TAG = this.getClass().getSimpleName();

    public BlankFragmentFirst(){
        super(R.layout.fragment_blank_first);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) mainActivity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getParentFragmentManager();

        fragmentManager.setFragmentResultListener("written data", this, ((requestKey, result) ->{
            EditText editname = binding.NameWrite;
            EditText editemail = binding.EmailAddressWrite;
            EditText editpass = (EditText) binding.PasswordWrite;
            String name_ = result.getString("name_");
            String email_ = result.getString("email_");
            String password_ = result.getString("password_");
            editname.setText(name_);
            editemail.setText(email_);
            editpass.setText(password_);
        }));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Программное задание метода обработчика событий с помощью ViewBinding
        binding.ConsentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", binding.NameWrite.getText().toString());
                bundle.putString("email", binding.EmailAddressWrite.getText().toString());
                bundle.putString("password", binding.PasswordWrite.getText().toString());

                fragmentManager.setFragmentResult("go to personal data", bundle);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.constraint_layout_main, new FragmentProfileName());
                fragmentTransaction.addToBackStack(null).commit();
            }
        });

    }

    // Метод получения данных из второго фрагмента
    public void addNewData(){
        EditText editname = binding.NameWrite;
        EditText editemail = binding.EmailAddressWrite;
        EditText editpass = (EditText) binding.PasswordWrite;
        Bundle bundle_= getArguments();
        String name = null, email = null, password = null;
        if(bundle_ != null){
            name = bundle_.getString("name_");
            editname.setText(name);
            email = bundle_.getString("email_");
            editemail.setText(email);
            password = bundle_.getString("password_");
            editpass.setText(password);
        }
        else
        {
            editemail.setText("Error");
            editpass.setText("Error");
        }
    }
}