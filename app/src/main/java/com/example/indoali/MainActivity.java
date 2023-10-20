package com.example.indoali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.javaScreens.aviaoActivity;
import com.example.indoali.javaScreens.entretenimentoActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnalise = findViewById(R.id.btnAnalisar);
        ImageButton btnLogout = findViewById(R.id.btnLogout);
        TextView txt = findViewById(R.id.editText);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor edit = pref.edit();

        btnAnalise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, aviaoActivity.class);
                intent.putExtra("Viagem", "Oi teste");
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.remove("KEY_EMAIL").apply();
                edit.remove("KEY_PASSWORD").apply();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}