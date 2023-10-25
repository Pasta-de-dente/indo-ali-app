package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private ListView productList;

    private entretenimentoAdapter adapter;

    ArrayList<Entretenimento> arl;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        Button btnBackTop=findViewById(R.id.resumeBackTop);

        btnBackTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ObjectViagem objeto = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        Button btnNext = findViewById(R.id.btnNext);
        productList = findViewById(R.id.listEntretenimentos);

        TextView destino = findViewById(R.id.ResumeDestino);
        TextView data = findViewById(R.id.ResumeData);
        destino.setText("Destino: " + objeto.getDestino());
        data.setText("Data: " + objeto.getData());

        //TextView aviao
        TextView TotalAviao = findViewById(R.id.txtcustoTotalTarifaArea);
        TextView estimadoPessoa = findViewById(R.id.txtEstimadoPessoa);
        TextView aluguelVeiculo = findViewById(R.id.txtAluguelVeiculo);
        TextView totalViajanteAviao = findViewById(R.id.txtTotalViajante);

        TotalAviao.setText("Total: " + decimalFormat.format((objeto.getCustoPorPessoa() * objeto.getTotalViajante()) + objeto.getAluguelVeiculo()));

        //TextView Carro
        TextView TotalCarro = findViewById(R.id.custoTotalDaGasolina);
        TextView TotalEstimadoKM = findViewById(R.id.txtTotalEstimadoKM);
        TextView MediaKMLitro = findViewById(R.id.txtMediaKMLitro);
        TextView CustoMedioLitro = findViewById(R.id.txtCustoMedioLitro);
        TextView TotalVeiculos = findViewById(R.id.txtTotalVeiculos);
        TotalCarro.setText("Total: " + decimalFormat.format(((objeto.getTotalEstimadoKm() / objeto.getMediaKmLitro()) * objeto.getCustoMedioLitro()) / objeto.getTotalVeiculo()));

        //TextView Refeição
        TextView CustoEstimadoPorRefeicao = findViewById(R.id.txtCustoEstimadoPorRefeicao);
        TextView QtdaRefeicaoPorDia = findViewById(R.id.txtQtdaRefeicaoPorDia);
        TextView DuracaoViagem = findViewById(R.id.txtDuracaoViagemResume);
        TextView qtdaViajante = findViewById(R.id.txtQtdaViajanteResume);
        TextView txtCustoTotalRefeicao = findViewById(R.id.txtCustoTotalRefeicao);
        txtCustoTotalRefeicao.setText("Total: " + decimalFormat.format((objeto.getQtdaRefeicaoPorDia() * objeto.getTotalViajante() * objeto.getCustoEstimadoPorRefeicao() * objeto.getDuracaoDaViagem())));

        //TextView Hospedagem
        TextView custoMedioPorNoite = findViewById(R.id.txtCustoMedioPorNoite);
        TextView totalNoite = findViewById(R.id.txtTotalNoite);
        TextView TotalQuartos = findViewById(R.id.txtTotalQuartos);
        TextView totalHospedagem = findViewById(R.id.txtCustoTotalHospedagem);
        totalHospedagem.setText("Total: " + decimalFormat.format((objeto.getCustoMedioPorNoite() * objeto.getTotalNoite()) * objeto.getTotalQuartos()));

        //SET TEXT VIEW
        estimadoPessoa.setText(objeto.getCustoPorPessoa().toString());
        aluguelVeiculo.setText(objeto.getAluguelVeiculo().toString());


        TotalEstimadoKM.setText(objeto.getTotalEstimadoKm() + "");
        MediaKMLitro.setText(objeto.getMediaKmLitro() + "");
        CustoMedioLitro.setText(objeto.getCustoMedioLitro() + "");
        TotalVeiculos.setText(objeto.getTotalVeiculo() + "");

        CustoEstimadoPorRefeicao.setText(objeto.getCustoEstimadoPorRefeicao() + "");
        QtdaRefeicaoPorDia.setText(objeto.getQtdaRefeicaoPorDia() + "");
        DuracaoViagem.setText(objeto.getDuracaoDaViagem() + "");

        custoMedioPorNoite.setText(objeto.getCustoMedioPorNoite() + "");
        totalNoite.setText(objeto.getTotalNoite() + "");
        TotalQuartos.setText(objeto.getTotalQuartos() + "");

        TextView txtCustoTotalEntretenimento = findViewById(R.id.txtCustoTotalEntretenimento);
        if (objeto.listEntretenimento.size() > 0) {
            double total = 0;
            adapter = new entretenimentoAdapter(resumeActivity.this);

            arl = new ArrayList<Entretenimento>();
            adapter.setProductList(arl);
            productList.setAdapter(adapter);
            Entretenimento ent = new Entretenimento();

            for (int i = 0; i < objeto.listEntretenimento.size(); i++) {

                total = total + ((objeto.listEntretenimento.get(i).getPreco() * objeto.listEntretenimento.get(i).getQtdaVezes()) * objeto.listEntretenimento.get(i).getQtdaPessoas());
                ent.setNome(objeto.listEntretenimento.get(i).getNome());
                ent.setPreco(objeto.listEntretenimento.get(i).getPreco());
                ent.setQtdaVezes(objeto.listEntretenimento.get(i).getQtdaVezes());
                ent.setQtdaPessoas(objeto.listEntretenimento.get(i).getQtdaPessoas());
                arl.add(ent);
                adapter.notifyDataSetChanged();
            }
            txtCustoTotalEntretenimento.setText("Total: " + decimalFormat.format(total));
        }
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

    }
}
