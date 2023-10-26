package com.example.indoali.javaScreens;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;

public class aviaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_aviao);

        Button btnNext = findViewById(R.id.nextBtn);
        Button btnBack = findViewById(R.id.btnBack);
        ObjectViagem viagem = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aviaoActivity.this, carroActivity.class);

                EditText txfCustoEstimado = findViewById(R.id.custoEstimadoTxf);
                EditText txfAluguelVeiculo = findViewById(R.id.aluguelVeiculoTxf);

                if (txfCustoEstimado.getText().toString().isEmpty() && txfAluguelVeiculo.getText().toString().isEmpty()) {
                    viagem.setCustoPorPessoa(0.0);
                    viagem.setAluguelVeiculo(0.0);

                    intent.putExtra("Viagem", viagem);
                    startActivity(intent);
                } else {
                    if (txfCustoEstimado.getText().toString().isEmpty()) {
                        txfCustoEstimado.setError("Campo necessário");
                    } else if (txfAluguelVeiculo.getText().toString().isEmpty()) {
                        txfAluguelVeiculo.setError("Campo necessário");
                    } else {
                        viagem.setCustoPorPessoa(Double.parseDouble(txfCustoEstimado.getText().toString()));
                        viagem.setAluguelVeiculo(Double.parseDouble(txfAluguelVeiculo.getText().toString()));

                        intent.putExtra("Viagem", viagem);
                        startActivity(intent);
                    }

                }
            }
        });

        btnBack.setOnClickListener(view -> finish());
    }
}