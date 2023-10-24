package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;

public class hospedagemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_hospedagem);

        Button btnNext = findViewById(R.id.nextBtn);
        Button btnBack = findViewById(R.id.btnBack);
        ObjectViagem viagem = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospedagemActivity.this, entretenimentoActivity.class);

                EditText custoPorNoite = findViewById(R.id.custoMedioPorNoiteTxf);
                EditText totalDeNoite = findViewById(R.id.totalDeNoitesTxf);
                EditText totalDeQuarto = findViewById(R.id.totalDeQuartosTxf);

                if (custoPorNoite.getText().toString().isEmpty() &&
                        totalDeNoite.getText().toString().isEmpty() &&
                        totalDeQuarto.getText().toString().isEmpty()
                ) {
                    viagem.setCustoMedioPorNoite(0.0);
                    viagem.setTotalNoite(0);
                    viagem.setTotalQuartos(0);

                    intent.putExtra("Viagem", viagem);
                    startActivity(intent);
                } else {
                    if (custoPorNoite.getText().toString().isEmpty()) {
                        custoPorNoite.setError("Campo necessário");
                    } else if (totalDeNoite.getText().toString().isEmpty()) {
                        totalDeNoite.setError("Campo necessário");
                    } else if (totalDeQuarto.getText().toString().isEmpty()) {
                        totalDeQuarto.setError("Campo necessário");
                    } else {
                        viagem.setCustoMedioPorNoite(Double.parseDouble(custoPorNoite.getText().toString()));
                        viagem.setTotalNoite(Integer.parseInt(totalDeNoite.getText().toString()));
                        viagem.setTotalQuartos(Integer.parseInt(totalDeQuarto.getText().toString()));

                        intent.putExtra("Viagem", viagem);
                        startActivity(intent);
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hospedagemActivity.this, refeicaoActivity.class);
                intent.putExtra("Viagem", viagem);
                startActivity(intent);
            }
        });
    }
}