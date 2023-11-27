package com.example.indoali;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.indoali.List.viagemAdapter;
import com.example.indoali.database.DAO.ViagemDAO;
import com.example.indoali.javaScreens.aviaoActivity;
import com.example.indoali.javaScreens.objects.ObjectViagem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtData;
    ArrayList<ObjectViagem> arl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObjectViagem viagem = (ObjectViagem) getIntent().getSerializableExtra("Viagem");
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor edit = pref.edit();
        ViagemDAO viagemDAO = new ViagemDAO(MainActivity.this);
        List<ObjectViagem> teste = viagemDAO.QueryWithJoin(viagem.getKEY_ID_PROFILE());

        ListView productList = findViewById(R.id.list_viagens);
        viagemAdapter adapter = new viagemAdapter(MainActivity.this);

        arl = new ArrayList<>(teste);
        adapter.setProductList(arl);
        productList.setAdapter(adapter);

        Button btnAnalise = findViewById(R.id.btnAnalisar);
        txtData = findViewById(R.id.txtDataViagem);
        EditText txtDestino = findViewById(R.id.lugarViagem);
        EditText totalDeViajante = findViewById(R.id.txtQuantidadeViajantes);
        EditText txtDuracaoViagem = findViewById(R.id.txtDuracaoViajem);
        ImageButton btnLogout = findViewById(R.id.btnLogout);

        txtData.setOnClickListener(v -> showDatePickerDialog());

        btnLogout.setOnClickListener(view -> {
            edit.remove("KEY_ID").apply();
            edit.remove("KEY_EMAIL").apply();
            edit.remove("KEY_NOME").apply();

//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
            finish();
        });

        txtData.getText();

//        Button btnSincronizar = findViewById(R.id.btnSincronizar);

//        btnSincronizar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ViagemModel viagemModel = new ViagemModel();

//                viagemModel.setIdConta(121753);
//                viagemModel.setTotalViajantes(0);
//                viagemModel.setDuracaoViagem(0);
//                viagemModel.setCustoTotalViagem(0);
//                viagemModel.setCustoPorPessoa(0);
//                viagemModel.setLocal("Testando");
//
//                Refeicao refeicao = new Refeicao();
//                refeicao.setCustoRefeicao(0);
//                refeicao.setRefeicoesDia(0);
//                viagemModel.setRefeicao(refeicao);
//
//                Aereo aereo = new Aereo();
//                aereo.setCustoPessoa(0);
//                aereo.setCustoAluguelVeiculo(0);
//                viagemModel.setAereo(aereo);
//
//                Hospedagem hospedagem = new Hospedagem();
//                hospedagem.setCustoMedioNoite(0);
//                hospedagem.setTotalNoite(0);
//                hospedagem.setTotalQuartos(0);
//                viagemModel.setHospedagem(hospedagem);
//
//                Gasolina gasolina = new Gasolina();
//                gasolina.setTotalEstimadoKM(0);
//                gasolina.setMediaKMLitro(0);
//                gasolina.setCustoMedioLitro(0);
//                gasolina.setTotalVeiculos(0);
//                viagemModel.setGasolina(gasolina);
//
//                EntretenimentoModel e1 = new EntretenimentoModel();
//                e1.setValor(0);
//                e1.setEntretenimento("Parque");
//
//                EntretenimentoModel e2 = new EntretenimentoModel();
//                e2.setValor(1);
//                e2.setEntretenimento("Praça");
//
//                ArrayList<EntretenimentoModel> listaEntretenimento = new ArrayList<EntretenimentoModel>();
//                listaEntretenimento.add(e1);
//                listaEntretenimento.add(e2);
//
//                viagemModel.setListaEntretenimento(listaEntretenimento);
//
//                Api.postViagem(viagemModel, new Callback<Resposta>() {
//                    @Override
//                    public void onResponse(Call<Resposta> call, Response<Resposta> response) {
//                        if (response != null && response.isSuccessful()) {
//                            Resposta resposta = response.body();
//
//                            System.out.println(resposta.getDados());
//                            System.out.println(resposta.getMensagem());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Resposta> call, Throwable t) {
//                        Toast.makeText(MainActivity.this, "Erro no envio", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });

        btnAnalise.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, aviaoActivity.class);

            if (txtData.getText().toString().isEmpty()) {
                txtData.setError("Campo necessário!");
            }

            if (txtDestino.getText().toString().isEmpty()) {
                txtDestino.setError("Campo necessário!");
            }

            if (txtDuracaoViagem.getText().toString().isEmpty()) {
                txtDuracaoViagem.setError("Campo necessário!");
            }

            if (txtDuracaoViagem.getText().toString().equals("0")) {
                txtDuracaoViagem.setError("Valor inválido!");
            }

            if (totalDeViajante.getText().toString().isEmpty()) {
                totalDeViajante.setError("Campo necessário!");
            }

            if (totalDeViajante.getText().toString().equals("0")) {
                totalDeViajante.setError("Valor inválido!");
            }

            if (!txtData.getText().toString().isEmpty() && !txtDestino.getText().toString().isEmpty()) {
                viagem.setData(txtData.getText().toString());
                viagem.setDestino(txtDestino.getText().toString());
                viagem.setTotalViajante(Integer.parseInt(totalDeViajante.getText().toString()));
                viagem.setDuracaoDaViagem(Integer.parseInt(txtDuracaoViagem.getText().toString()));

                intent.putExtra("Viagem", viagem);
                startActivity(intent);
            }
        });
    }

    private void showDatePickerDialog() {
        // Obter a data atual
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Criar um DatePickerDialog e configurá-lo
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
            // A data selecionada pelo usuário
            String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
            txtData.setText(selectedDate);
        }, year, month, day);

        // Mostrar o seletor de data
        datePickerDialog.show();
    }
}