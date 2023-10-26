package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;

public class refeicaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_refeicao);

        Button btnNext = findViewById(R.id.nextBtn);
        Button btnBack = findViewById(R.id.btnBack);

        ObjectViagem viagem = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(refeicaoActivity.this, hospedagemActivity.class);

                EditText CustoEstimadoPorRefeicao = findViewById(R.id.custoEstimadoPorRefeicao);
                EditText RefeicaoPorDia = findViewById(R.id.refeicaoPorDia);

                if (CustoEstimadoPorRefeicao.getText().toString().isEmpty() &&
                        RefeicaoPorDia.getText().toString().isEmpty()) {
                    viagem.setCustoEstimadoPorRefeicao(0);
                    viagem.setQtdaRefeicaoPorDia(0);

                    intent.putExtra("Viagem", viagem);
                    startActivity(intent);
                } else {
                    if (CustoEstimadoPorRefeicao.getText().toString().isEmpty()) {
                        CustoEstimadoPorRefeicao.setError("Campo necessário");
                    } else if (RefeicaoPorDia.getText().toString().isEmpty()) {
                        RefeicaoPorDia.setError("Campo necessário");
                    } else {
                        viagem.setCustoEstimadoPorRefeicao(Integer.parseInt(CustoEstimadoPorRefeicao.getText().toString()));
                        viagem.setQtdaRefeicaoPorDia(Integer.parseInt(RefeicaoPorDia.getText().toString()));

                        intent.putExtra("Viagem", viagem);
                        startActivity(intent);
                    }
                }
            }
        });

        btnBack.setOnClickListener(view -> finish());
    }
}