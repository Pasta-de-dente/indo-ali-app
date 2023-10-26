package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.MainActivity;
import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;

public class aviaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_aviao);

        Button btnBack=findViewById(R.id.backBtnAviao);
        Button btnNext = findViewById(R.id.nextBtn);
        ObjectViagem viagem = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aviaoActivity.this, carroActivity.class);

                EditText txfCustoEstimado = findViewById(R.id.custoEstimadoTxf);
                EditText txfAluguelVeiculo = findViewById(R.id.aluguelVeiculoTxf);


                viagem.setCustoPorPessoa(Double.parseDouble(txfCustoEstimado.getText().toString()));
                viagem.setAluguelVeiculo(Double.parseDouble(txfAluguelVeiculo.getText().toString()));

                intent.putExtra("Viagem", viagem);
                startActivity(intent);
            }
        });

    }
}