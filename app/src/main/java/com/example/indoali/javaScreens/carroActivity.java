package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;

public class carroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_car);

        Button btnNext = findViewById(R.id.nextBtn);
        ObjectViagem objeto = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(carroActivity.this, refeicaoActivity.class);
                EditText totalEstimadoKm = findViewById(R.id.TotalEstimadoQuilometrosTxf);
                EditText mediaQuilometroPorLitro = findViewById(R.id.MediaQuilometrosPorLitroTxf);
                EditText custoMedioPorLitro = findViewById(R.id.CustoMedioPorLitrotxf);
                EditText totalDeVeiculos = findViewById(R.id.totalDeVeiculotxf);

                if ((!totalEstimadoKm.getText().toString().isEmpty() && !mediaQuilometroPorLitro.getText().toString().isEmpty())
                        && (!custoMedioPorLitro.getText().toString().isEmpty() && !totalDeVeiculos.getText().toString().isEmpty())
                ) {
                    objeto.setTotalEstimadoKm(Double.parseDouble(totalEstimadoKm.getText().toString()));
                    objeto.setMediaKmLitro(Double.parseDouble(mediaQuilometroPorLitro.getText().toString()));
                    objeto.setCustoMedioLitro(Double.parseDouble(custoMedioPorLitro.getText().toString()));
                    objeto.setTotalVeiculo(Integer.parseInt(totalDeVeiculos.getText().toString()));
                    intent.putExtra("Viagem", objeto);
                    startActivity(intent);
                } else {
                    if ((totalEstimadoKm.getText().toString().isEmpty() && mediaQuilometroPorLitro.getText().toString().isEmpty())) {
                        if (custoMedioPorLitro.getText().toString().isEmpty()) {
                            totalDeVeiculos.getText();
                        }
                    }

                    if (totalDeVeiculos.getText() == null) {
                        totalDeVeiculos.setError("Preencha total de veículos");
                    }

                    if (totalEstimadoKm.getText() == null) {
                        totalEstimadoKm.setError("Preencha KM total estimado");
                    }

                    if (custoMedioPorLitro.getText() == null) {
                        custoMedioPorLitro.setError("Preencha custo médio litro");
                    }

                    if (mediaQuilometroPorLitro.getText() == null) {
                        mediaQuilometroPorLitro.setError("Preencha media quilômetro por litro");
                    }
                }
            }
        });
    }
}
