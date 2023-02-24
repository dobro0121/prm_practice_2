package com.example.prm_practice_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prm_practice_2.databinding.ActivityMainBinding;
import com.example.prm_practice_2.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding_ = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding_.getRoot());
        //setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("password");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView NameTextView = findViewById(R.id.NameOfAccount);
        NameTextView.setText(name);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView EmailTextView = findViewById(R.id.EmailOffAccount);
        EmailTextView.setText(email);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView PasswordTextView = findViewById(R.id.PasswordOfAccount);
        PasswordTextView.setText(pass);

        binding_.textView2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                TextView textviewName = binding_.NameOfAccount;
                EditText edittextEmail = binding_.EmailOffAccount;
                EditText edittextpassword = binding_.PasswordOfAccount;

                String name_ = textviewName.getText().toString();
                String email_ = edittextEmail.getText().toString();
                String password_ = edittextpassword.getText().toString();

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("name2", name_);
                intent.putExtra("email2", email_);
                intent.putExtra("password2", password_);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}