package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.MainActivity;
import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViajem;

public class hospedagemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasporte_hospedagem);

        Button btnNext = findViewById(R.id.nextBtn);
        ObjectViajem viagem = (ObjectViajem) getIntent().getSerializableExtra("Viajem");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospedagemActivity.this, entretenimentoActivity.class);
                EditText custoPorNoite = findViewById(R.id.custoMedioPorNoiteTxf);
                EditText totalDeNoite = findViewById(R.id.totalDeNoitesTxf);
                EditText totalDeQuarto = findViewById(R.id.totalDeQuartosTxf);
                viagem.setCustoMedioPorNoite(Double.parseDouble(custoPorNoite.getText().toString()));
                viagem.setTotalNoite(Integer.parseInt(totalDeNoite.getText().toString()));
                viagem.setTotalQuartos(Integer.parseInt(totalDeQuarto.getText().toString()));

                intent.putExtra("Viajem", viagem);
                startActivity(intent);
            }
        });
    }
}
