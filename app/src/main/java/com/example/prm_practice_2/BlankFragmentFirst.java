package com.example.prm_practice_2;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.prm_practice_2.databinding.FragmentBlankFirstBinding;
public class BlankFragmentFirst extends Fragment {

    private FragmentBlankFirstBinding binding;
    private static final int REQUEST_CODE = 123;
    private final String TAG = this.getClass().getSimpleName();

    public BlankFragmentFirst(){
        super(R.layout.fragment_blank_first);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankFirstBinding.inflate(inflater, container, false);
        //Инициализация TextView строковым с помощью ViewBinding
        TextView textView = binding.Consent;
        String text = getString(R.string.Consent);
        textView.setText(text);

        // Инициализация EditText для имени, емэйла и пароля
        EditText NameEditText, PasswordEditText, EmailEditText;

        NameEditText = binding.NameWrite;
        PasswordEditText = (EditText) binding.PasswordWrite;
        EmailEditText = binding.EmailAddressWrite;

        //Программное задание метода обработчика событий с помощью ViewBinding
        binding.ConsentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Получение и сохранение данных из EditText
                String Name, Password, Email;
                Name = NameEditText.getText().toString();
                Password = PasswordEditText.getText().toString();
                Email = EmailEditText.getText().toString();
                ButtonConsentClickHandler(view, Name, Password, Email);
            }
        });

        return binding.getRoot();
    }

    //Декларативное задание метода обработчика событий с помощью ViewBinding
    public void ButtonConsentClickHandler (View view, String Name, String Password, String Email){
        Log.d(TAG, "Click is saved");
        //Переход на новую активность
        Intent intent = new Intent(getActivity() , SecondActivity.class);
        intent.putExtra("name", Name);
        intent.putExtra("email", Email);
        intent.putExtra("password", Password);
        startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            EditText editname = binding.NameWrite;
            EditText editemail = binding.EmailAddressWrite;
            EditText editpass = (EditText) binding.PasswordWrite;

            if(resultCode  == RESULT_OK){
                String nameresult = data.getStringExtra("name2");
                editname.setText(nameresult);
                String emailresult = data.getStringExtra("email2");
                editemail.setText(emailresult);
                String passresult = data.getStringExtra("password2");
                editpass.setText(passresult);
            }
            else{
                editemail.setText("Error");
                editpass.setText("Error");
            }
        }
    }






}