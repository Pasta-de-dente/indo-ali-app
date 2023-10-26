package com.example.indoali.javaScreens;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;
import java.text.DecimalFormat;

public class viewViagemActivity extends AppCompatActivity {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_viagem);

        ObjectViagem viagem = (ObjectViagem) getIntent().getSerializableExtra("Viagem");
        ImageButton backBtn = findViewById(R.id.btnBack);
        LinearLayout cardParent = findViewById(R.id.cardParent);

        //Card view
        CardView cardViewAviao = findViewById(R.id.cardViewAviao);
        CardView cardViewCarro = findViewById(R.id.cardViewCarro);
        CardView cardViewHospedagem = findViewById(R.id.cardViewHospedagem);
        CardView cardViewRefeicao = findViewById(R.id.cardViewRefeicao);
        CardView cardViewEntertainment = findViewById(R.id.cardViewEntertainment);

        //Textview
        //Viagem
        TextView viewDURACAO_VIAGEM = findViewById(R.id.viewDURACAO_VIAGEM);
        TextView viewQTDA_DE_VIAJANTES = findViewById(R.id.viewQTDA_DE_VIAJANTES);
        TextView viewDATA_VIAGEM = findViewById(R.id.viewDATA_VIAGEM);
        TextView viewDESTINO = findViewById(R.id.viewDESTINO);
        TextView viewTOTAL_VIAGEM = findViewById(R.id.viewTOTAL_VIAGEM);

        viewDURACAO_VIAGEM.setText(String.format(getString(R.string.cardTravelDuration), viagem.getDuracaoDaViagem()));
        viewDESTINO.setText(String.format(getString(R.string.cardTravelDestination), viagem.getDestino()));
        viewDATA_VIAGEM.setText(String.format(getString(R.string.cardTravelDate), viagem.getData()));
        viewQTDA_DE_VIAJANTES.setText(String.format(getString(R.string.cardTravelTotalPeople), viagem.getTotalViajante()));

        //Aviao
        TextView viewCUSTO_POR_PESSOA = findViewById(R.id.viewCUSTO_POR_PESSOA);
        TextView viewALUGUEL_VEICULO = findViewById(R.id.viewALUGUEL_VEICULO);
        TextView viewAviaoTotal = findViewById(R.id.viewAviaoTotal);

        viewCUSTO_POR_PESSOA.setText(String.format(getString(R.string.cardPlaneCostPerPerson), decimalFormat.format(viagem.getCustoPorPessoa())));
        viewALUGUEL_VEICULO.setText(String.format(getString(R.string.cardPlaneVehicleRental), decimalFormat.format(viagem.getAluguelVeiculo())));

        double totalAviaoCalc = (viagem.getCustoPorPessoa() * viagem.getTotalViajante()) + viagem.getAluguelVeiculo();

        if (totalAviaoCalc == 0.0) {
            cardParent.removeView(cardViewAviao);
        } else {
            viewAviaoTotal.setText(String.format(getString(R.string.totalReal), decimalFormat.format(totalAviaoCalc)));
        }

        //Carro
        TextView viewCUSTO_MEDIO_LITRO = findViewById(R.id.viewCUSTO_MEDIO_LITRO);
        TextView viewMEDIA_KM_LITRO = findViewById(R.id.viewMEDIA_KM_LITRO);
        TextView viewTOTAL_VEICULO = findViewById(R.id.viewTOTAL_VEICULO);
        TextView viewTOTAL_ESTIMADO_KM = findViewById(R.id.viewTOTAL_ESTIMADO_KM);
        TextView viewCarroTotal = findViewById(R.id.viewCarroTotal);

        viewCUSTO_MEDIO_LITRO.setText(String.format(getString(R.string.cardCarAverageCostPerLiter), decimalFormat.format(viagem.getCustoMedioLitro())));
        viewMEDIA_KM_LITRO.setText(String.format(getString(R.string.cardCarAverageKmPerLiter), viagem.getMediaKmLitro()));
        viewTOTAL_VEICULO.setText(String.format(getString(R.string.cardCarNumberOfVehicles), viagem.getTotalVeiculo()));
        viewTOTAL_ESTIMADO_KM.setText(String.format(getString(R.string.cardCarTotalEstimatedKm), viagem.getTotalEstimadoKm()));

        double totalCarCalc = ((viagem.getTotalEstimadoKm() / viagem.getMediaKmLitro()) * viagem.getCustoMedioLitro()) / viagem.getTotalVeiculo();

        if (Double.isNaN(totalCarCalc)) {
            totalCarCalc = 0.0;
        }

        if (totalCarCalc == 0.0) {
            cardParent.removeView(cardViewCarro);
        } else {
            viewCarroTotal.setText(String.format(getString(R.string.totalReal), decimalFormat.format(totalCarCalc)));
        }

        //Refeição
        TextView viewCUSTO_ESTIMADO_POR_REFEICAO = findViewById(R.id.viewCUSTO_ESTIMADO_POR_REFEICAO);
        TextView viewQTDA_REFEICAO_POR_DIA = findViewById(R.id.viewQTDA_REFEICAO_POR_DIA);
        TextView viewRefeicaoTotal = findViewById(R.id.viewRefeicaoTotal);

        viewCUSTO_ESTIMADO_POR_REFEICAO.setText(String.format(getString(R.string.cardMealAverageCostPerMeal), decimalFormat.format(viagem.getCustoEstimadoPorRefeicao())));
        viewQTDA_REFEICAO_POR_DIA.setText(String.format(getString(R.string.cardMealMealsPerDay), viagem.getQtdaRefeicaoPorDia()));

        double totalRefeicaoCalc = (viagem.getQtdaRefeicaoPorDia() * viagem.getTotalViajante() * viagem.getCustoEstimadoPorRefeicao() * viagem.getDuracaoDaViagem());

        if (totalRefeicaoCalc == 0.0) {
            cardParent.removeView(cardViewRefeicao);
        } else {
            viewRefeicaoTotal.setText(String.format(getString(R.string.totalReal), decimalFormat.format(totalRefeicaoCalc)));
        }

        //Hospedagem
        TextView viewCUSTO_MEDIO_POR_NOITE = findViewById(R.id.viewCUSTO_MEDIO_POR_NOITE);
        TextView viewTOTAL_DE_NOITE = findViewById(R.id.viewTOTAL_DE_NOITE);
        TextView viewTOTAL_QUARTOS = findViewById(R.id.viewTOTAL_QUARTOS);
        TextView viewHospedagemTotal = findViewById(R.id.viewHospedagemTotal);

        viewCUSTO_MEDIO_POR_NOITE.setText(String.format(getString(R.string.cardAccommodationAverageCostPerNight), decimalFormat.format(viagem.getCustoMedioPorNoite())));
        viewTOTAL_DE_NOITE.setText(String.format(getString(R.string.cardAccommodationTotalNights), viagem.getTotalNoite()));
        viewTOTAL_QUARTOS.setText(String.format(getString(R.string.cardAccommodationTotalRooms), viagem.getTotalQuartos()));

        double totalHospedagemCalc = (viagem.getCustoMedioPorNoite() * viagem.getTotalNoite()) * viagem.getTotalQuartos();

        if (totalHospedagemCalc == 0.0) {
            cardParent.removeView(cardViewHospedagem);
        } else {
            viewHospedagemTotal.setText(String.format(getString(R.string.totalReal), decimalFormat.format(totalHospedagemCalc)));
        }

        //Entretenimento
        TextView viewENTRETENIMENTO_TOTAL = findViewById(R.id.viewENTRETENIMENTO_TOTAL);

        if (viagem.getTotalEntretenimento() == 0.0) {
            cardParent.removeView(cardViewEntertainment);
        } else {
            viewENTRETENIMENTO_TOTAL.setText(String.format(getString(R.string.totalReal), decimalFormat.format(viagem.getTotalEntretenimento())));
        }

        double totalViagem = totalAviaoCalc + totalCarCalc + totalRefeicaoCalc + totalHospedagemCalc + viagem.getTotalEntretenimento();

        viewTOTAL_VIAGEM.setText(String.format(getString(R.string.totalReal), decimalFormat.format(totalViagem)));

        backBtn.setOnClickListener(view -> finish());
    }
}
