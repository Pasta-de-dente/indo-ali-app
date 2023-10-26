package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.List.entretenimentoAdapter;
import com.example.indoali.LoginActivity;
import com.example.indoali.MainActivity;
import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.DAO.CarroDAO;
import com.example.indoali.database.DAO.HospedagemDAO;
import com.example.indoali.database.DAO.RefeicaoDAO;
import com.example.indoali.database.DAO.ViagemDAO;
import com.example.indoali.database.DAO.ViagemToEntretenimentoDAO;
import com.example.indoali.database.DAO.EntretenimentoDAO;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.R;
import com.example.indoali.database.model.carroModel;
import com.example.indoali.database.model.entretenimentoModel;
import com.example.indoali.database.model.hospedagemModel;
import com.example.indoali.database.model.refeicaoModel;
import com.example.indoali.database.model.viagemModel;
import com.example.indoali.database.model.viagemToEntretenimentoModel;
import com.example.indoali.javaScreens.objects.ObjectViagem;
import com.example.indoali.javaScreens.objects.Entretenimento;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class resumeActivity extends AppCompatActivity {
    ArrayList<Entretenimento> arl;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        ObjectViagem objeto = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        LinearLayout parentLayout = findViewById(R.id.parentLayout);
        LinearLayout planeSection = findViewById(R.id.planeSection);
        LinearLayout carSection = findViewById(R.id.carSection);
        LinearLayout mealSection = findViewById(R.id.mealSection);
        LinearLayout accommodationSection = findViewById(R.id.accommodationSection);
        LinearLayout entertainmentSection = findViewById(R.id.entertainmentSection);

        Button btnNext = findViewById(R.id.btnNext);
        ImageButton btnBack = findViewById(R.id.btnBack);
        ListView productList = findViewById(R.id.listEntretenimentos);

        TextView destino = findViewById(R.id.ResumeDestino);
        TextView data = findViewById(R.id.ResumeData);
        TextView duracao = findViewById(R.id.ResumeDuracao);
        TextView viajantes = findViewById(R.id.resumeViajantes);
        TextView totalViagem = findViewById(R.id.resumeTotalViagem);

        duracao.setText(String.format(getString(R.string.cardTravelDuration), objeto.getDuracaoDaViagem()));
        viajantes.setText(String.format(getString(R.string.cardTravelTotalPeople), objeto.getTotalViajante()));
        destino.setText(String.format(getString(R.string.cardTravelDestination), objeto.getDestino()));
        data.setText(String.format(getString(R.string.cardTravelDate), objeto.getData()));

        //TextView aviao
        TextView TotalAviao = findViewById(R.id.txtcustoTotalTarifaArea);
        TextView estimadoPessoa = findViewById(R.id.txtEstimadoPessoa);
        TextView aluguelVeiculo = findViewById(R.id.txtAluguelVeiculo);

        double totalAviaoCalc = (objeto.getCustoPorPessoa() * objeto.getTotalViajante()) + objeto.getAluguelVeiculo();

        if (totalAviaoCalc == 0.00) {
            parentLayout.removeView(planeSection);
        } else {
            TotalAviao.setText(String.format(getString(R.string.totalAirfareCost), decimalFormat.format(totalAviaoCalc)));
        }

        //TextView Carro
        TextView TotalCarro = findViewById(R.id.custoTotalDaGasolina);
        TextView TotalEstimadoKM = findViewById(R.id.txtTotalEstimadoKM);
        TextView MediaKMLitro = findViewById(R.id.txtMediaKMLitro);
        TextView CustoMedioLitro = findViewById(R.id.txtCustoMedioLitro);
        TextView TotalVeiculos = findViewById(R.id.txtTotalVeiculos);

        double totalCarCalc = ((objeto.getTotalEstimadoKm() / objeto.getMediaKmLitro()) * objeto.getCustoMedioLitro()) / objeto.getTotalVeiculo();

        if (Double.isNaN(totalCarCalc)) {
            totalCarCalc = 0.0;
            parentLayout.removeView(carSection);
        } else {
            TotalCarro.setText(String.format(getString(R.string.totalCostOfGasoline), decimalFormat.format(totalCarCalc)));
        }

        //TextView Refeição
        TextView CustoEstimadoPorRefeicao = findViewById(R.id.txtCustoEstimadoPorRefeicao);
        TextView QtdaRefeicaoPorDia = findViewById(R.id.txtQtdaRefeicaoPorDia);
        TextView txtCustoTotalRefeicao = findViewById(R.id.txtCustoTotalRefeicao);

        double totalRefeicaoCalc = (objeto.getQtdaRefeicaoPorDia() * objeto.getTotalViajante() * objeto.getCustoEstimadoPorRefeicao() * objeto.getDuracaoDaViagem());

        if (totalRefeicaoCalc == 0.00) {
            parentLayout.removeView(mealSection);
        } else {
            txtCustoTotalRefeicao.setText(String.format(getString(R.string.totalMealCost), decimalFormat.format(totalRefeicaoCalc)));
        }

        //TextView Hospedagem
        TextView custoMedioPorNoite = findViewById(R.id.txtCustoMedioPorNoite);
        TextView totalNoite = findViewById(R.id.txtTotalNoite);
        TextView TotalQuartos = findViewById(R.id.txtTotalQuartos);
        TextView totalHospedagem = findViewById(R.id.txtCustoTotalHospedagem);

        double totalHospedagemCalc = (objeto.getCustoMedioPorNoite() * objeto.getTotalNoite()) * objeto.getTotalQuartos();

        if (totalHospedagemCalc == 0.00) {
            parentLayout.removeView(accommodationSection);
        } else {
            totalHospedagem.setText(String.format(getString(R.string.totalAccommodationCost), decimalFormat.format(totalHospedagemCalc)));
        }

        //SET TEXT VIEW
        estimadoPessoa.setText(String.format(String.valueOf(objeto.getCustoPorPessoa())));
        aluguelVeiculo.setText(String.format(String.valueOf(objeto.getAluguelVeiculo())));

        TotalEstimadoKM.setText(String.format(String.valueOf(objeto.getTotalEstimadoKm())));
        MediaKMLitro.setText(String.format(String.valueOf(objeto.getMediaKmLitro())));
        CustoMedioLitro.setText(String.format(String.valueOf(objeto.getCustoMedioLitro())));
        TotalVeiculos.setText(String.format(String.valueOf(objeto.getTotalVeiculo())));

        CustoEstimadoPorRefeicao.setText(String.format(String.valueOf(objeto.getCustoEstimadoPorRefeicao())));
        QtdaRefeicaoPorDia.setText(String.format(String.valueOf(objeto.getQtdaRefeicaoPorDia())));

        custoMedioPorNoite.setText(String.format(String.valueOf(objeto.getCustoMedioPorNoite())));
        totalNoite.setText(String.format(String.valueOf(objeto.getTotalNoite())));
        TotalQuartos.setText(String.format(String.valueOf(objeto.getTotalQuartos())));

        TextView txtCustoTotalEntretenimento = findViewById(R.id.txtCustoTotalEntretenimento);

        double totalEntCalc = 0;

        if (objeto.listEntretenimento.size() > 0) {
            entretenimentoAdapter adapter = new entretenimentoAdapter(resumeActivity.this);

            arl = new ArrayList<>();
            adapter.setProductList(arl);
            productList.setAdapter(adapter);

            for (int i = 0; i < objeto.listEntretenimento.size(); i++) {
                Entretenimento ent = new Entretenimento();

                totalEntCalc = totalEntCalc + ((objeto.listEntretenimento.get(i).getPreco() * objeto.listEntretenimento.get(i).getQtdaVezes()) * objeto.listEntretenimento.get(i).getQtdaPessoas());
                ent.setNome(objeto.listEntretenimento.get(i).getNome());
                ent.setPreco(objeto.listEntretenimento.get(i).getPreco());
                ent.setQtdaVezes(objeto.listEntretenimento.get(i).getQtdaVezes());
                ent.setQtdaPessoas(objeto.listEntretenimento.get(i).getQtdaPessoas());

                arl.add(ent);
                adapter.notifyDataSetChanged();
            }
            txtCustoTotalEntretenimento.setText(String.format(getString(R.string.totalEntertainmentCost), decimalFormat.format(totalEntCalc)));
        } else {
            parentLayout.removeView(entertainmentSection);
        }

        double totalViagemCalc = totalAviaoCalc + totalCarCalc + totalRefeicaoCalc + totalHospedagemCalc + totalEntCalc;
        totalViagem.setText(String.format(getString(R.string.totalReal), decimalFormat.format(totalViagemCalc)));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AviaoDAO dao = new AviaoDAO(resumeActivity.this);
                aviaoModel pessoaModel = new aviaoModel();

                pessoaModel.setAluguelVeiculo(objeto.getAluguelVeiculo());
                pessoaModel.setCustoPorPessoa(objeto.getCustoPorPessoa());
                long rowAffectAviao = dao.Insert(pessoaModel);

                CarroDAO carro = new CarroDAO(resumeActivity.this);
                carroModel carroModel = new carroModel();
                carroModel.setTotalEstimadoKm(objeto.getTotalEstimadoKm());
                carroModel.setMediaKmLitro(objeto.getMediaKmLitro());
                carroModel.setCustoMedioLitro(objeto.getCustoMedioLitro());
                carroModel.setTotalVeiculo(objeto.getTotalVeiculo());
                long rowAffectCarro = carro.Insert(carroModel);

                RefeicaoDAO refeicao = new RefeicaoDAO(resumeActivity.this);
                refeicaoModel RefeicaoModel = new refeicaoModel();
                RefeicaoModel.setCustoEstimadoPorRefeicao(objeto.getCustoEstimadoPorRefeicao());
                RefeicaoModel.setQtdaRefeicaoPorDia(objeto.getQtdaRefeicaoPorDia());
                long rowAffectRefeicao = refeicao.Insert(RefeicaoModel);

                HospedagemDAO hospedagemDAO = new HospedagemDAO(resumeActivity.this);
                hospedagemModel HospedagemModel = new hospedagemModel();
                HospedagemModel.setTotalNoite(objeto.getTotalNoite());
                HospedagemModel.setTotalQuartos(objeto.getTotalQuartos());
                HospedagemModel.setCustoMedioPorNoite(objeto.getCustoMedioPorNoite());
                long rowAffectHospedagem = hospedagemDAO.Insert(HospedagemModel);

                ViagemDAO viagemDAO = new ViagemDAO(resumeActivity.this);
                viagemModel viagemModel = new viagemModel();

                if (objeto.listEntretenimento.size() > 0) {
                    // Inserção do entretenimento bem-sucedida.
                    ViagemToEntretenimentoDAO viagemToEntretenimento = new ViagemToEntretenimentoDAO(resumeActivity.this);
                    viagemToEntretenimentoModel viagemToEntretenimentoModel = new viagemToEntretenimentoModel();
                    viagemToEntretenimentoModel.setDataViagem(objeto.getData());

                    long rowViagemToEntretenimento = viagemToEntretenimento.Insert(viagemToEntretenimentoModel);

                    viagemModel.setIdViagemToEntretenimento((int) rowViagemToEntretenimento);

                    for (int i = 0; i < arl.size(); i++) {
                        entretenimentoModel ent1 = new entretenimentoModel();

                        ent1.setNome(arl.get(i).getNome());
                        ent1.setPreco(arl.get(i).getPreco());
                        ent1.setQtdaPessoas(arl.get(i).getQtdaPessoas());
                        ent1.setQtdaVezes(arl.get(i).getQtdaVezes());
                        ent1.setIdViagemToEntretenimento((int) rowViagemToEntretenimento);
                        EntretenimentoDAO entret = new EntretenimentoDAO(resumeActivity.this);

                        entret.Insert(ent1);
                    }
                }
                viagemModel.setQtdaViajante(objeto.getTotalViajante());
                viagemModel.setDuracao(objeto.getDuracaoDaViagem());
                viagemModel.setData(objeto.getData());
                viagemModel.setDestino(objeto.getDestino());
                viagemModel.setIdAviao((int) rowAffectAviao);
                viagemModel.setIdHospedagem((int) rowAffectHospedagem);
                viagemModel.setIdCarro((int) rowAffectCarro);
                viagemModel.setIdRefeicao((int) rowAffectRefeicao);

                if (objeto.getKEY_ID_PROFILE() != 0) {
                    viagemModel.setIdProfile(objeto.getKEY_ID_PROFILE());
                    long rowAffectViagem = viagemDAO.Insert(viagemModel);

                    if (rowAffectViagem > 0) {
                        Toast.makeText(resumeActivity.this, "Salvo com Sucesso.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(resumeActivity.this, MainActivity.class);
                        intent.putExtra("Viagem", objeto);
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(resumeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
