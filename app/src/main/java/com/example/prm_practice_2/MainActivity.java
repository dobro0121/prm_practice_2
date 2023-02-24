package com.example.prm_practice_2;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prm_practice_2.databinding.ActivityMainBinding;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 123;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Инициализация TextView и ImageView строковым и картинкой с помощью ViewBinding
        TextView textView = binding.Consent;
        ImageView imageView = binding.stars;
        String text = getString(R.string.Consent);
        Drawable drawable = getResources().getDrawable(R.drawable.free_icon_font_sparkles_6854012);
        textView.setText(text);
        imageView.setImageDrawable(drawable);

        // Инициализация EditText для имени, емэйла и пароля
        EditText NameEditText, PasswordEditText, EmailEditText;

        NameEditText = findViewById(R.id.Name_);
        PasswordEditText= findViewById(R.id.Password_);
        EmailEditText = findViewById(R.id.Email_Address_);

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



    }

    //Декларативное задание метода обработчика событий с помощью ViewBinding
    public void ButtonConsentClickHandler (View view, String Name, String Password, String Email){
        Log.d(TAG, "Click is saved");
        //Переход на новую активность
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", Name);
        intent.putExtra("email", Email);
        intent.putExtra("password", Password);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            EditText editname = findViewById(R.id.Name_);
            EditText editemail = findViewById(R.id.Email_Address_);
            EditText editpass = findViewById(R.id.Password_);

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