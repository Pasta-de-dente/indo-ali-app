package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViajem;

public class carroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasporte_car);

        Button btnNext = findViewById(R.id.nextBtn);
        ObjectViajem objeto = (ObjectViajem) getIntent().getSerializableExtra("Viajem");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(carroActivity.this, refeicaoActivity.class);
                EditText totalEstimadoKm = findViewById(R.id.TotalEstimadoQuiilometroTxf);
                EditText mediQuilometroPorLitro = findViewById(R.id.MediaQuilometroPorlitroTxf);
                EditText custoMedioPorLitro = findViewById(R.id.CustoMedioPorLitrotxf);
                EditText totalDeVeiculos = findViewById(R.id.totalDeVeiculotxf);

                if ((totalEstimadoKm.getText().toString() != null
                        && mediQuilometroPorLitro.getText().toString() != null)
                        && (custoMedioPorLitro.getText().toString() != null && totalDeVeiculos.getText() != null) ||
                        (totalEstimadoKm.getText().toString() == null
                                && mediQuilometroPorLitro.getText().toString() == null)
                                && (custoMedioPorLitro.getText().toString() == null
                                        && totalDeVeiculos.getText() == null)) {
                    objeto.setTotalEstimadoKm(Double.parseDouble(totalEstimadoKm.getText().toString()));
                    objeto.setMediaKmLitro(Double.parseDouble(mediQuilometroPorLitro.getText().toString()));
                    objeto.setCustoMedioLitro(Double.parseDouble(custoMedioPorLitro.getText().toString()));
                    objeto.setTotalVeiculo(Integer.parseInt(totalDeVeiculos.getText().toString()));
                    intent.putExtra("Viajem", objeto);
                    startActivity(intent);
                } else {
                    if (totalDeVeiculos.getText() == null) {
                        totalDeVeiculos.setError("Preencha total de veiculos tambem");
                    }
                    if (totalEstimadoKm.getText() == null) {
                        totalEstimadoKm.setError("Preencha KM total estimado tambem");
                    }
                    if (custoMedioPorLitro.getText() == null) {
                        custoMedioPorLitro.setError("Preencha custo medio litro tambem");
                    }
                    if (mediQuilometroPorLitro.getText() == null) {
                        mediQuilometroPorLitro.setError("Preencha media quilometro por litro tambem");
                    }

                }
            }
        });
    }
}