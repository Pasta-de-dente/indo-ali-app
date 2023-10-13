package com.example.indoali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button btnAnalise=findViewById(R.id.btnAnalisar);
        TextView txt=findViewById(R.id.editText);
        btnAnalise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this, entretenimentoActivity.class);

                intent.putExtra("Viajem", "Oi teste");
                startActivity(intent);

            }
        });

    }
}