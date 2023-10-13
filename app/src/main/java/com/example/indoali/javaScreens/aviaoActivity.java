package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.MainActivity;
import com.example.indoali.R;
import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.javaScreens.objects.ObjectViajem;

import java.util.List;

public class aviaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasporte_aviao);

        Button btnNext=findViewById(R.id.nextBtn);
        Button btnSave=findViewById(R.id.save);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AviaoDAO dao= new AviaoDAO(aviaoActivity.this);
                 //INSERT
                aviaoModel pessoaModel = new aviaoModel();
                pessoaModel.setCustoPorPessoa(12.3);

                pessoaModel.setAluguelVeiculo(12.0);
                dao.Insert(pessoaModel);

            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aviaoActivity.this, carroActivity.class);
                ObjectViajem viajem=new ObjectViajem();
                EditText txfCustoEstimado=findViewById(R.id.custoEstimadoTxf);
                EditText txfAlguelVeiculo=findViewById(R.id.alguelVeiculoTxf);
                viajem.setAluguelVeiculo(Double.parseDouble (txfCustoEstimado.getText().toString()));
                viajem.setAluguelVeiculo(Double.parseDouble(txfAlguelVeiculo.getText().toString()));
                intent.putExtra("Viajem",viajem);
                startActivity(intent);


            }
        });

    }
}
