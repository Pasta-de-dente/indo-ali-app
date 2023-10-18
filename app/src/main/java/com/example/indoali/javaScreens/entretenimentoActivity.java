package com.example.indoali.javaScreens;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

import com.example.indoali.List.entretenimentoAdapter;
import com.example.indoali.MainActivity;
import com.example.indoali.R;
import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.DAO.CarroDAO;
import com.example.indoali.database.DAO.HospedagemDAO;
import com.example.indoali.database.DAO.RefeicaoDAO;
import com.example.indoali.database.DAO.ViajemToEntretenimentoDAO;
import com.example.indoali.database.DAO.entretenimentoDAO;
import com.example.indoali.javaScreens.objects.ObjectViajem;
import com.example.indoali.javaScreens.objects.entretenimento;
import com.example.indoali.database.model.*;
import java.util.ArrayList;
import java.util.List;

public class entretenimentoActivity  extends AppCompatActivity {
    private ListView productList;

    private entretenimentoAdapter adapter;

    private Button btnAdd;

    ArrayList<entretenimento> arl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasporte_entretenimento);

        Button btnNext = findViewById(R.id.nextBtn);
        Button btnAddNewEntretenimento= findViewById(R.id.addNewEntretenimento);
        ObjectViajem objeto = (ObjectViajem) getIntent().getSerializableExtra("Viajem");
        productList = findViewById(R.id.listLugares);
        adapter = new entretenimentoAdapter(entretenimentoActivity.this);
        TextView a =findViewById(R.id.ttvtotalGasto);

        arl = new ArrayList<entretenimento>();
        adapter.setProductList(arl);
        productList.setAdapter(adapter);
        btnAddNewEntretenimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Crie um AlertDialog com layout personalizado
                AlertDialog.Builder builder = new AlertDialog.Builder(entretenimentoActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_signin, null);

                final EditText precoTxf  = dialogView.findViewById(R.id.precoTxf);
                final EditText qtdaVezesTxf = dialogView.findViewById(R.id.qtdaVezesTxf);
                final EditText qtdaPessoaTxf = dialogView.findViewById(R.id.qtdaPessoasTxf);
                final EditText nomeTxf =dialogView.findViewById(R.id.nomeTxf);
                builder.setView(dialogView);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Obtenha o texto dos EditText


                        String nome=  nomeTxf.getText().toString();
                     //   String qtdaVezes=qtdaVezesTxf.getText().toString();
                        String preco=precoTxf.getText().toString();
                   //     String qtdaPessoas=qtdaPessoaTxf.getText().toString();
                        entretenimento ent=new entretenimento();

                        ent.setNome(nome);
                        ent.setPreco(Double.parseDouble(preco));
//                        ent.setQtdaVezes(Integer.parseInt(qtdaVezes));
//                        ent.setQtdaPessoas(Integer.parseInt(qtdaPessoas));
                        arl.add(ent);
                        adapter.notifyDataSetChanged();

                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        Button saveBtn=findViewById(R.id.save);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AviaoDAO dao = new  AviaoDAO(entretenimentoActivity.this);

                List<aviaoModel> aviaolist= dao.Select();

                for(int i=0;i<aviaolist.size();i++){

                   if(aviaolist.get(i).getAluguelVeiculo() !=null){
                       a.setText(aviaolist.get(i).getAluguelVeiculo()+"");
                   }
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AviaoDAO dao = new  AviaoDAO(entretenimentoActivity.this);
                aviaoModel pessoaModel = new aviaoModel();

                pessoaModel.setAluguelVeiculo(objeto.getAluguelVeiculo());
                pessoaModel.setCustoPorPessoa(objeto.getCustoPorPessoa());
                dao.Insert(pessoaModel);

                CarroDAO carro = new  CarroDAO(entretenimentoActivity.this);
                carroModel carroModel = new carroModel();
                carroModel.setTotalEstimadoKm(objeto.getTotalEstimadoKm());
                carroModel.setMediaKmLitro(objeto.getMediaKmLitro());
                carroModel.setCustoMedioLitro(objeto.getCustoMedioLitro());
                carroModel.setTotalVeiculo(objeto.getTotalVeiculo());
                carro.Insert(carroModel);

                RefeicaoDAO refeicao = new  RefeicaoDAO(entretenimentoActivity.this);
                refeicaoModel RefeicaoModel = new refeicaoModel();
                RefeicaoModel .setCustoEstimadoPorRefeicao(objeto.getCustoEstimadoPorRefeicao());
                RefeicaoModel .setQtdaRefeicaoPorDia(objeto.getQtdaRefeicaoPorDia());
                refeicao.Insert(RefeicaoModel);

                HospedagemDAO hospedagemDAO = new  HospedagemDAO(entretenimentoActivity.this);
                hospedagemModel HospedagemModel = new hospedagemModel();
                HospedagemModel .setTotalNoite(objeto.getTotalNoite());
                HospedagemModel .setTotalQuartos(objeto.getTotalQuartos());
                HospedagemModel .setCustoMedioPorNoite(objeto.getCustoMedioPorNoite());
               long rowAffect= hospedagemDAO.Insert(HospedagemModel);

               if (rowAffect > 0) {
                    // Inserção do entretenimento bem-sucedida.


                    ViajemToEntretenimentoDAO viajemDAO=new ViajemToEntretenimentoDAO(entretenimentoActivity.this);

                    viajemDAO.Insert(rowAffect);
                    for(int i =0;i<arl.size();i++){
                        entretenimentoModel ent1 = new entretenimentoModel();

                        ent1.setNome(arl.get(i).getNome());
                        ent1.setPreco(arl.get(i).getPreco());
                        ent1.setQtdaPessoas(arl.get(i).getQtdaPessoas());
                        ent1.setQtdaVezes(arl.get(i).getQtdaVezes());
                        entretenimentoDAO entret=new entretenimentoDAO(entretenimentoActivity.this);

                        entret.Insert(ent1, rowAffect);
                    }



                } else {
                    // Ocorreu um erro durante a inserção do entretenimento.
                }
            }
        });

    }

}
