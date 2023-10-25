package com.example.indoali.javaScreens;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.Toast;

import com.example.indoali.List.entretenimentoAdapter;
import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;
import com.example.indoali.javaScreens.objects.Entretenimento;

import java.util.ArrayList;

public class entretenimentoActivity extends AppCompatActivity {
    private ListView productList;

    private entretenimentoAdapter adapter;

    ArrayList<Entretenimento> arl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_entretenimento);

        Button btnNext = findViewById(R.id.nextBtn);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnAddNewEntretenimento = findViewById(R.id.addNewEntretenimento);
        productList = findViewById(R.id.listLugares);
        ObjectViagem objeto = (ObjectViagem) getIntent().getSerializableExtra("Viagem");

        adapter = new entretenimentoAdapter(entretenimentoActivity.this);
        arl = new ArrayList<Entretenimento>();
        adapter.setProductList(arl);
        productList.setAdapter(adapter);

        btnAddNewEntretenimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Crie um AlertDialog com layout personalizado
                AlertDialog.Builder builder = new AlertDialog.Builder(entretenimentoActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_signin, null);

                final EditText precoTxf = dialogView.findViewById(R.id.precoTxf);
                final EditText qtdaVezesTxf = dialogView.findViewById(R.id.qtdaVezesTxf);
                final EditText qtdaPessoaTxf = dialogView.findViewById(R.id.qtdaPessoasTxf);
                final EditText nomeTxf = dialogView.findViewById(R.id.nomeTxf);
                builder.setView(dialogView);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Obtenha o texto dos EditText
                        String nome = nomeTxf.getText().toString();
                        String qtdaVezes = qtdaVezesTxf.getText().toString();
                        String preco = precoTxf.getText().toString();
                        String qtdaPessoas = qtdaPessoaTxf.getText().toString();
                        Entretenimento ent = new Entretenimento();

                        ent.setNome(nome);
                        ent.setPreco(Double.parseDouble(preco));
                        ent.setQtdaVezes(Integer.parseInt(qtdaVezes));
                        ent.setQtdaPessoas(Integer.parseInt(qtdaPessoas));
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

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entretenimentoActivity.this, resumeActivity.class);
                objeto.listEntretenimento = arl;

                if (objeto.verificaVazio()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(entretenimentoActivity.this);

                    builder.setTitle("Aviso");
                    builder.setMessage("Você não adicionou nenhum dado a sua viagem, por favor retorne e adicione os dados corretamente!");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

//                    Toast.makeText(entretenimentoActivity.this, "Você não adicionou nenhum dado a sua viagem!", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("Viagem", objeto);
                    startActivity(intent);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(entretenimentoActivity.this, hospedagemActivity.class);
                intent.putExtra("Viagem", objeto);
                startActivity(intent);
            }
        });

    }

}