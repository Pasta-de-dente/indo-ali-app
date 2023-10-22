package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.List.entretenimentoAdapter;
import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.DAO.CarroDAO;
import com.example.indoali.database.DAO.HospedagemDAO;
import com.example.indoali.database.DAO.RefeicaoDAO;
import com.example.indoali.database.DAO.ViajemDAO;
import com.example.indoali.database.DAO.ViajemToEntretenimentoDAO;
import com.example.indoali.database.DAO.entretenimentoDAO;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.R;
import com.example.indoali.database.model.carroModel;
import com.example.indoali.database.model.entretenimentoModel;
import com.example.indoali.database.model.hospedagemModel;
import com.example.indoali.database.model.refeicaoModel;
import com.example.indoali.database.model.viajemModel;
import com.example.indoali.database.model.viajemToEntretenimentoModel;
import com.example.indoali.javaScreens.objects.ObjectViajem;
import com.example.indoali.javaScreens.objects.entretenimento;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class resumeActivity extends AppCompatActivity {
    private ListView productList;

    private entretenimentoAdapter adapter;

    private Button btnAdd;

    ArrayList<entretenimento> arl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        ObjectViajem objeto = (ObjectViajem) getIntent().getSerializableExtra("Viajem");

        Button btnNext = findViewById(R.id.btnNext);

        productList = findViewById(R.id.listEntretenimentos);


        TextView destino = findViewById(R.id.ResumeDestino);
        TextView data = findViewById(R.id.ResumeData);
        destino.setText("Destino: " + objeto.getDestinario());
        data.setText("Data: " + objeto.getData());

        //  TextView aviao
        TextView estimadoPessoa = findViewById(R.id.txtEstimadoPessoa);
        TextView aluguelVeiculo = findViewById(R.id.txtAlguelVeiculo);

        //TextView Carro
        TextView TotalEstimadoKM = findViewById(R.id.txtTotalEstimadoKM);
        TextView MediaKMLitro = findViewById(R.id.txtMediaKMLitro);
        TextView CustoMedioLitro = findViewById(R.id.txtCustoMedioLitro);
        TextView TotalVeiculos = findViewById(R.id.txtTotalVeiculos);
        TextView EstimadoPessoa = findViewById(R.id.txtEstimadoPessoa);

        //TextView Refeição
        TextView CustoEstimadoPorRefeicao = findViewById(R.id.txtCustoEstimadoPorRefeicao);
        TextView QtdaRefeicaoPorDia = findViewById(R.id.txtQtdaRefeicaoPorDia);

        //TextView Hospedagem
        TextView custoMedioPorNoite = findViewById(R.id.txtCustoMedioPorNoite);
        TextView totalNoite = findViewById(R.id.txtTotalNoite);
        TextView TotalQuartos = findViewById(R.id.txtTotalQuartos);

        //SET TEXT VIEW
        estimadoPessoa.setText(objeto.getCustoPorPessoa().toString());
        aluguelVeiculo.setText(objeto.getAluguelVeiculo().toString());

        TotalEstimadoKM.setText(objeto.getTotalEstimadoKm() + "");
        MediaKMLitro.setText(objeto.getMediaKmLitro() + "");
        CustoMedioLitro.setText(objeto.getCustoMedioLitro() + "");
        TotalVeiculos.setText(objeto.getTotalVeiculo() + "");

        CustoEstimadoPorRefeicao.setText(objeto.getCustoEstimadoPorRefeicao() + "");
        QtdaRefeicaoPorDia.setText(objeto.getQtdaRefeicaoPorDia() + "");

        custoMedioPorNoite.setText(objeto.getCustoMedioPorNoite() + "");
        totalNoite.setText(objeto.getTotalNoite() + "");
        TotalQuartos.setText(objeto.getTotalQuartos() + "");

        if (objeto.listEntretenimento.size() > 0) {
            adapter = new entretenimentoAdapter(resumeActivity.this);
            arl = new ArrayList<entretenimento>();
            adapter.setProductList(arl);
            productList.setAdapter(adapter);
            entretenimento ent = new entretenimento();

            for (int i = 0; i < objeto.listEntretenimento.size(); i++) {
                ent.setNome(objeto.listEntretenimento.get(i).getNome());
                    ent.setPreco(objeto.listEntretenimento.get(i).getPreco());
                    ent.setQtdaVezes(objeto.listEntretenimento.get(i).getQtdaVezes());
                    ent.setQtdaPessoas(objeto.listEntretenimento.get(i).getQtdaPessoas());
                arl.add(ent);
                adapter.notifyDataSetChanged();
            }
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


                ViajemDAO viajemDAO = new ViajemDAO(resumeActivity.this);
                viajemModel viajemModel = new viajemModel();

                if (objeto.listEntretenimento.size() > 0) {
                    // Inserção do entretenimento bem-sucedida.


                    ViajemToEntretenimentoDAO   viajemToEntretenimento = new ViajemToEntretenimentoDAO(resumeActivity.this);
                    viajemToEntretenimentoModel viajemToEntretenimentoModel=new viajemToEntretenimentoModel();
                    viajemToEntretenimentoModel.setDataViajem(objeto.getData());

                   long rowViajemToEntretenimento = viajemToEntretenimento.Insert(viajemToEntretenimentoModel);

                    viajemModel.setIdViajemToEntretenimento((int) rowViajemToEntretenimento);

                    for (int i = 0; i < arl.size(); i++) {
                        entretenimentoModel ent1 = new entretenimentoModel();

                        ent1.setNome(arl.get(i).getNome());
                        ent1.setPreco(arl.get(i).getPreco());
                        ent1.setQtdaPessoas(arl.get(i).getQtdaPessoas());
                        ent1.setQtdaVezes(arl.get(i).getQtdaVezes());
                        ent1.setIdViajemToEntretenimento((int) rowViajemToEntretenimento);
                        entretenimentoDAO entret = new entretenimentoDAO(resumeActivity.this);

                        entret.Insert(ent1);
                    }

                } else {
                    // Ocorreu um erro durante a inserção do entretenimento.
                }

                viajemModel.setData(objeto.getData());
                viajemModel.setDestinario(objeto.getDestinario());
                viajemModel.setIdAviao((int) rowAffectAviao);
                viajemModel.setIdHospedagem((int) rowAffectHospedagem);
                viajemModel.setIdCarro((int) rowAffectCarro);
                viajemModel.setIdRefeicao((int) rowAffectRefeicao);
                viajemModel.setIdProfile(1);






                viajemDAO.Insert(viajemModel);
            }
        });

    }
}
