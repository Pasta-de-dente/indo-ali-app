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
        Button btnBack = findViewById(R.id.btnBack);
        ObjectViagem objeto = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(carroActivity.this, refeicaoActivity.class);

                EditText totalEstimadoKm = findViewById(R.id.TotalEstimadoQuilometrosTxf);
                EditText mediaQuilometroPorLitro = findViewById(R.id.MediaQuilometrosPorLitroTxf);
                EditText custoMedioPorLitro = findViewById(R.id.CustoMedioPorLitrotxf);
                EditText totalDeVeiculos = findViewById(R.id.totalDeVeiculotxf);

                if (totalEstimadoKm.getText().toString().isEmpty() &&
                        mediaQuilometroPorLitro.getText().toString().isEmpty() &&
                        custoMedioPorLitro.getText().toString().isEmpty() &&
                        totalDeVeiculos.getText().toString().isEmpty()) {
                    objeto.setTotalEstimadoKm(0.0);
                    objeto.setMediaKmLitro(0.0);
                    objeto.setCustoMedioLitro(0.0);
                    objeto.setTotalVeiculo(0);

                    intent.putExtra("Viagem", objeto);
                    startActivity(intent);
                } else {
                    if (totalEstimadoKm.getText().toString().isEmpty()) {
                        totalEstimadoKm.setError("Campo necessário");
                    } else if (mediaQuilometroPorLitro.getText().toString().isEmpty()) {
                        mediaQuilometroPorLitro.setError("Campo necessário");
                    } else if (custoMedioPorLitro.getText().toString().isEmpty()) {
                        custoMedioPorLitro.setError("Campo necessário");
                    } else if (totalDeVeiculos.getText().toString().isEmpty()) {
                        totalDeVeiculos.setError("Campo necessário");
                    } else {
                        objeto.setTotalEstimadoKm(Double.parseDouble(totalEstimadoKm.getText().toString()));
                        objeto.setMediaKmLitro(Double.parseDouble(mediaQuilometroPorLitro.getText().toString()));
                        objeto.setCustoMedioLitro(Double.parseDouble(custoMedioPorLitro.getText().toString()));
                        objeto.setTotalVeiculo(Integer.parseInt(totalDeVeiculos.getText().toString()));

                        intent.putExtra("Viagem", objeto);
                        startActivity(intent);
                    }
                }
            }
        });

        btnBack.setOnClickListener(view -> finish());
    }
}