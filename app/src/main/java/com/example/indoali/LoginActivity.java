package com.example.indoali;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public EditText edtEmail;
    public EditText edtPassword;
    public Button btnLogin;
    public Button btnRegister;

    public Switch switchLembrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        edtEmail.findViewById(R.id.edtEmail);
//        edtPassword.findViewById(R.id.edtPassword);
//        btnLogin.findViewById(R.id.btnLogin);
//        btnRegister.findViewById(R.id.btnRegister);

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}
