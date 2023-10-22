package com.example.indoali;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.indoali.database.model.profileModel;
import com.example.indoali.database.DAO.ProfileDAO;
import com.example.indoali.javaScreens.entretenimentoActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        Switch switchLembrar = findViewById(R.id.switchLembrar);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        SharedPreferences.Editor edit = pref.edit();

        if (pref.getString("KEY_EMAIL", "").equals("admin") && pref.getString("KEY_PASSWORD", "").equals("admin")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtEmail.getText().toString().isEmpty()) {
                    edtEmail.setError("Campo de e-mail obrigatório");
                } else if (edtPassword.getText().toString().isEmpty()) {
                    edtPassword.setError("Campo de senha obrigatório");
                } else {
                    ProfileDAO profile = new ProfileDAO(LoginActivity.this);
                    profileModel profileModel = profile.login(edtEmail.getText().toString(), edtPassword.getText().toString());

                    if (profileModel != null) {
                        // Login bem-sucedido
                        if (switchLembrar.isChecked()) {
                            edit.putString("KEY_EMAIL", edtEmail.getText().toString()).apply();
                            edit.putString("KEY_PASSWORD", edtPassword.getText().toString()).apply();

                        } else {
                            edit.remove("KEY_EMAIL").apply();
                            edit.remove("KEY_PASSWORD").apply();
                        }
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    } else {
                        // Login falhou

                        Toast.makeText(LoginActivity.this, "Login falhou. Verifique suas credenciais.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
