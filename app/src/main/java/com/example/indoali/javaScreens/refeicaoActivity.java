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
        Button btnBack = findViewById(R.id.backBtnRefeicao);
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
                Intent intent = new Intent(refeicaoActivity.this, hospedagemActivity.class);
                EditText CustoEstimadoPorRefeicao = findViewById(R.id.custoEstimadoPorRefeicao);
                EditText RefeicaoPorDia = findViewById(R.id.refeicaoPorDia);
                EditText duracaoViagemTxf = findViewById(R.id.duracaoViagemTxf);
                EditText ViajantesTxt = findViewById(R.id.totalDeViajanteRefeicaoTxf);

                viagem.setCustoEstimadoPorRefeicao(Integer.parseInt(CustoEstimadoPorRefeicao.getText().toString()));
                viagem.setQtdaRefeicaoPorDia(Integer.parseInt(RefeicaoPorDia.getText().toString()));
                viagem.setDuracaoDaViagem(Integer.parseInt(duracaoViagemTxf.getText().toString()));
                intent.putExtra("Viagem", viagem);
                startActivity(intent);
            }
        });
    }
}