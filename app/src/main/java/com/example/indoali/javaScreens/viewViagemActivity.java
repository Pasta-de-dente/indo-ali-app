package com.example.indoali.javaScreens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.indoali.List.entretenimentoAdapter;
import com.example.indoali.List.viagemAdapter;
import com.example.indoali.MainActivity;
import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.Entretenimento;
import com.example.indoali.javaScreens.objects.ObjectViagem;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class viewViagemActivity extends AppCompatActivity {

    private ListView productList;

    private entretenimentoAdapter adapter;

    ArrayList<Entretenimento> arl;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_viagem);

        ObjectViagem viagem = (ObjectViagem) getIntent().getSerializableExtra("Viagem");
        Button backBtn = findViewById(R.id.resumeBackTop);

        productList = findViewById(R.id.viewListEntretenimento);
        adapter = new entretenimentoAdapter(viewViagemActivity.this);

        //Card view
        CardView cardViewAviao =findViewById(R.id.cardViewAviao);
        CardView cardViewCarro=findViewById(R.id.cardViewCarro);
        CardView cardViewHospedagem=findViewById(R.id.cardViewHospedagem);
        CardView cardViewRefeicao=findViewById(R.id.cardViewRefeicao);

        //Textview

        //Aviao
        TextView viewCUSTO_POR_PESSOA=findViewById(R.id.viewCUSTO_POR_PESSOA);
        TextView viewALUGUEL_VEICULO=findViewById(R.id.viewALUGUEL_VEICULO);
        TextView viewAviaoTotal=findViewById(R.id.viewAviaoTotal);

        viewCUSTO_POR_PESSOA.setText(String.valueOf(viagem.getCustoPorPessoa()));
        viewALUGUEL_VEICULO.setText(String.valueOf(viagem.getAluguelVeiculo()));
        viewAviaoTotal.setText("Total");

        //Carro
        TextView viewCUSTO_MEDIO_LITRO= findViewById(R.id.viewCUSTO_MEDIO_LITRO);
        TextView viewMEDIA_KM_LITRO=findViewById(R.id.viewMEDIA_KM_LITRO);
        TextView viewTOTAL_VEICULO=findViewById(R.id.viewTOTAL_VEICULO);
        TextView viewTOTAL_ESTIMADO_KM=findViewById(R.id.viewTOTAL_ESTIMADO_KM);
        TextView viewCarroTotal=findViewById(R.id.viewCarroTotal);

        viewCUSTO_MEDIO_LITRO.setText(String.valueOf( viagem.getCustoMedioLitro()));
        viewMEDIA_KM_LITRO.setText(String.valueOf(viagem.getMediaKmLitro()));
        viewTOTAL_VEICULO.setText(String.valueOf(viagem.getTotalVeiculo()));
        viewTOTAL_ESTIMADO_KM.setText(String.valueOf(viagem.getTotalEstimadoKm()));
        viewCarroTotal.setText("");

        //Refeição
        TextView viewCUSTO_ESTIMADO_POR_REFEICAO=findViewById(R.id.viewCUSTO_ESTIMADO_POR_REFEICAO);
        TextView viewQTDA_REFEICAO_POR_DIA=findViewById(R.id.viewQTDA_REFEICAO_POR_DIA);
        TextView viewRefeicaoTotal=findViewById(R.id.viewRefeicaoTotal);

        viewCUSTO_ESTIMADO_POR_REFEICAO.setText(String.valueOf(viagem.getCustoEstimadoPorRefeicao()));
        viewQTDA_REFEICAO_POR_DIA.setText(String.valueOf(viagem.getQtdaRefeicaoPorDia()));
        viewRefeicaoTotal.setText("");

        //Hospedagem
        TextView viewCUSTO_MEDIO_POR_NOITE=findViewById(R.id.viewCUSTO_MEDIO_POR_NOITE);
        TextView viewTOTAL_DE_NOITE=findViewById(R.id.viewTOTAL_DE_NOITE);
        TextView viewTOTAL_QUARTOS=findViewById(R.id.viewTOTAL_QUARTOS);
        TextView viewHospedagemTotal=findViewById(R.id.viewHospedagemTotal);

        viewCUSTO_MEDIO_POR_NOITE.setText(String.valueOf(viagem.getCustoMedioPorNoite()));
        viewTOTAL_DE_NOITE.setText(String.valueOf(viagem.getTotalNoite()));
        viewTOTAL_QUARTOS.setText(String.valueOf(viagem.getTotalQuartos()));
        viewHospedagemTotal.setText("");

        arl = new ArrayList<>(viagem.listEntretenimento);
        adapter.setProductList(arl);
        productList.setAdapter(adapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
