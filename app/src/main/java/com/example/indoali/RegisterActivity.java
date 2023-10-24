package com.example.indoali;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.indoali.database.DAO.ProfileDAO;
import com.example.indoali.database.model.profileModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageButton btnBack = findViewById(R.id.btnBack);
        EditText edtRegisterName = findViewById(R.id.edtRegisterName);
        EditText edtRegisterEmail = findViewById(R.id.edtRegisterEmail);
        EditText edtRegisterPassword = findViewById(R.id.edtRegisterPassword);
        EditText edtRegisterPasswordConfirm = findViewById(R.id.edtRegisterPasswordConfirm);
        Button btnRegisterConfirm = findViewById(R.id.btnRegisterConfirm);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegisterConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implementar registro no SQLite
                ProfileDAO profile = new ProfileDAO(RegisterActivity.this);
                profileModel proModel = new profileModel();

                if (edtRegisterPassword.getText().toString().equals(edtRegisterPasswordConfirm.getText().toString())) {
                    proModel.setEmail(edtRegisterEmail.getText().toString());
                    proModel.setNome(edtRegisterName.getText().toString());
                    proModel.setSenha(edtRegisterPassword.getText().toString());

                    long result = profile.Insert(proModel);

                    if (result != -1) {
                        Toast.makeText(RegisterActivity.this, "Registro bem-sucedido.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Erro ao registrar. Verifique os detalhes.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "As senhas não coincidem.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

