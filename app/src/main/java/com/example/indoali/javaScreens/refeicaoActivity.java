package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViajem;

public class refeicaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasporte_refeicao);
        Button btnNext = findViewById(R.id.nextBtn);

        ObjectViajem viajem = (ObjectViajem) getIntent().getSerializableExtra("Viajem");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(refeicaoActivity.this, hospedagemActivity.class);
                EditText CustoEstimadoPorRefeicao = findViewById(R.id.custoEstimadoPorRefeicao);
                EditText RefeicaoPorDia = findViewById(R.id.refeicaoPorDia);
                EditText duracaoViajemTxf = findViewById(R.id.duracaoViajemTxf);
                EditText ViajantesTxt = findViewById(R.id.totalDeViajanteRefeicaoTxf);
                viajem.setCustoEstimadoPorRefeicao(Integer.parseInt(CustoEstimadoPorRefeicao.getText().toString()));
                viajem.setQtdaRefeicaoPorDia(Integer.parseInt(RefeicaoPorDia.getText().toString()));
                viajem.setDuraçãodaViagem(Integer.parseInt(duracaoViajemTxf.getText().toString()));
                viajem.setTotalViajanteRefeicao(Integer.parseInt(ViajantesTxt.getText().toString()));
                intent.putExtra("Viajem", viajem);
                startActivity(intent);
            }
        });
    }
}