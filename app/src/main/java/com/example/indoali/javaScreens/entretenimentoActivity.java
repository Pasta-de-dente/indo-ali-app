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

public class entretenimentoActivity extends AppCompatActivity {
    private ListView productList;

    private entretenimentoAdapter adapter;

    private Button btnAdd;

    ArrayList<entretenimento> arl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasporte_entretenimento);

        Button btnNext = findViewById(R.id.nextBtn);
        Button btnAddNewEntretenimento = findViewById(R.id.addNewEntretenimento);
        productList = findViewById(R.id.listLugares);
        ObjectViajem objeto = (ObjectViajem) getIntent().getSerializableExtra("Viajem");

        adapter = new entretenimentoAdapter(entretenimentoActivity.this);
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
                        entretenimento ent = new entretenimento();

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
        Button saveBtn = findViewById(R.id.save);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entretenimentoActivity.this, resumeActivity.class);
                objeto.listEntretenimento = arl;
                intent.putExtra("Viajem", objeto);
                startActivity(intent);
            }
        });

    }

}