package com.example.indoali;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.indoali.API.Api;
import com.example.indoali.API.model.Aereo;
import com.example.indoali.API.model.EntretenimentoAPI;
import com.example.indoali.API.model.Gasolina;
import com.example.indoali.API.model.Hospedagem;
import com.example.indoali.API.model.Refeicao;
import com.example.indoali.API.model.ViagemModel;
import com.example.indoali.List.viagemAdapter;
import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.DAO.CarroDAO;
import com.example.indoali.database.DAO.EntretenimentoDAO;
import com.example.indoali.database.DAO.HospedagemDAO;
import com.example.indoali.database.DAO.RefeicaoDAO;
import com.example.indoali.database.DAO.ViagemDAO;
import com.example.indoali.database.DAO.ViagemToEntretenimentoDAO;
import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.database.model.carroModel;
import com.example.indoali.database.model.entretenimentoModel;
import com.example.indoali.database.model.hospedagemModel;
import com.example.indoali.database.model.refeicaoModel;
import com.example.indoali.database.model.viagemModel;
import com.example.indoali.database.model.viagemToEntretenimentoModel;
import com.example.indoali.javaScreens.aviaoActivity;
import com.example.indoali.javaScreens.objects.Entretenimento;
import com.example.indoali.javaScreens.objects.ObjectViagem;
import com.example.indoali.javaScreens.resumeActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

            finish();
        });

        txtData.getText();

        Button btnSincronizar = findViewById(R.id.btnSincronizarTudo);

        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBOpenHelper dbOpenHelper = new DBOpenHelper(MainActivity.this);
                dbOpenHelper.dropToSync();

                Api.getViagem(121753, new Callback<ArrayList<ViagemModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ViagemModel>> call, Response<ArrayList<ViagemModel>> response) {
                        if (response != null && response.isSuccessful()) {
                            ArrayList<ViagemModel> viagemList = response.body();

                            if (viagemList != null) {
                                arl.clear();
                                arl.addAll(convertToObjects(viagemList));

                                adapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "Viagens sincronizadas com sucesso!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ViagemModel>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Erro ao sincronizar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

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

    private ArrayList<ObjectViagem> convertToObjects(ArrayList<ViagemModel> viagemList) {
        ArrayList<ObjectViagem> objectViagemList = new ArrayList<>();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        for (ViagemModel viagemModel : viagemList) {
            ObjectViagem objectViagem = new ObjectViagem();

            Aereo aereo = viagemModel.getAereo();
            Gasolina gasolina = viagemModel.getGasolina();
            Refeicao refeicao = viagemModel.getRefeicao();
            Hospedagem hospedagem = viagemModel.getHospedagem();
            ArrayList<EntretenimentoAPI> entretenimento = viagemModel.getListaEntretenimento();

            AviaoDAO aviaoDAO = new AviaoDAO(MainActivity.this);
            aviaoModel aviaoModel = new aviaoModel();

            objectViagem.setAluguelVeiculo(aereo.getCustoAluguelVeiculo());
            objectViagem.setCustoPorPessoa(aereo.getCustoPessoa());

            aviaoModel.setAluguelVeiculo(aereo.getCustoAluguelVeiculo());
            aviaoModel.setCustoPorPessoa(aereo.getCustoPessoa());
            long rowAffectAviao = aviaoDAO.Insert(aviaoModel);

            CarroDAO carroDAO = new CarroDAO(MainActivity.this);
            carroModel carroModel = new carroModel();

            objectViagem.setTotalEstimadoKm(gasolina.getTotalEstimadoKM());
            objectViagem.setMediaKmLitro(gasolina.getMediaKMLitro());
            objectViagem.setCustoMedioLitro(gasolina.getCustoMedioLitro());
            objectViagem.setTotalVeiculo(gasolina.getTotalVeiculos());

            carroModel.setTotalEstimadoKm(gasolina.getTotalEstimadoKM());
            carroModel.setMediaKmLitro(gasolina.getMediaKMLitro());
            carroModel.setCustoMedioLitro(gasolina.getCustoMedioLitro());
            carroModel.setTotalVeiculo(gasolina.getTotalVeiculos());
            long rowAffectCarro = carroDAO.Insert(carroModel);

            RefeicaoDAO refeicaoDAO = new RefeicaoDAO(MainActivity.this);
            refeicaoModel RefeicaoModel = new refeicaoModel();

            objectViagem.setCustoEstimadoPorRefeicao(refeicao.getCustoRefeicao());
            objectViagem.setQtdaRefeicaoPorDia(refeicao.getRefeicoesDia());

            RefeicaoModel.setCustoEstimadoPorRefeicao(refeicao.getCustoRefeicao());
            RefeicaoModel.setQtdaRefeicaoPorDia(refeicao.getRefeicoesDia());
            long rowAffectRefeicao = refeicaoDAO.Insert(RefeicaoModel);

            HospedagemDAO hospedagemDAO = new HospedagemDAO(MainActivity.this);
            hospedagemModel HospedagemModel = new hospedagemModel();
            objectViagem.setTotalNoite(hospedagem.getTotalNoite());
            objectViagem.setTotalQuartos(hospedagem.getTotalQuartos());
            objectViagem.setCustoMedioPorNoite(hospedagem.getCustoMedioNoite());

            HospedagemModel.setTotalNoite(hospedagem.getTotalNoite());
            HospedagemModel.setTotalQuartos(hospedagem.getTotalQuartos());
            HospedagemModel.setCustoMedioPorNoite(hospedagem.getCustoMedioNoite());
            long rowAffectHospedagem = hospedagemDAO.Insert(HospedagemModel);

            ViagemDAO viagemDAO = new ViagemDAO(MainActivity.this);
            viagemModel viagemModel2 = new viagemModel();

            objectViagem.listEntretenimento = new ArrayList<>();

            if (entretenimento.size() > 0) {
                ViagemToEntretenimentoDAO viagemToEntretenimento = new ViagemToEntretenimentoDAO(MainActivity.this);
                viagemToEntretenimentoModel viagemToEntretenimentoModel = new viagemToEntretenimentoModel();
                viagemToEntretenimentoModel.setDataViagem(viagemModel.getDt_inc());

                viagemToEntretenimento.Insert(viagemToEntretenimentoModel);

                EntretenimentoDAO entret = new EntretenimentoDAO(MainActivity.this);

                for (int i = 0; i < entretenimento.size(); i++) {
                    Entretenimento ent1 = new Entretenimento();
                    entretenimentoModel entModel = new entretenimentoModel();

                    ent1.setNome(entretenimento.get(i).getEntretenimento());
                    ent1.setPreco(entretenimento.get(i).getValor());
                    ent1.setQtdaPessoas(1);
                    ent1.setQtdaVezes(1);

                    entModel.setNome(entretenimento.get(i).getEntretenimento());
                    entModel.setPreco(entretenimento.get(i).getValor());
                    entModel.setQtdaPessoas(1);
                    entModel.setQtdaVezes(1);

                    objectViagem.listEntretenimento.add(ent1);
                    entret.Insert(entModel);
                }
            }

            objectViagem.setTotalViajante(viagemModel.getTotalViajantes());
            objectViagem.setDuracaoDaViagem(viagemModel.getDuracaoViagem());
            objectViagem.setDestino(viagemModel.getLocal());

            String data = viagemModel.getDt_inc();
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(data, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String outputDateString = dateTime.format(outputFormatter);

            objectViagem.setData(outputDateString);

            viagemModel2.setQtdaViajante(viagemModel.getTotalViajantes());
            viagemModel2.setDuracao(viagemModel.getDuracaoViagem());
            viagemModel2.setData(outputDateString);
            viagemModel2.setDestino(viagemModel.getLocal());
            viagemModel2.setIdAviao((int) rowAffectAviao);
            viagemModel2.setIdHospedagem((int) rowAffectHospedagem);
            viagemModel2.setIdCarro((int) rowAffectCarro);
            viagemModel2.setIdRefeicao((int) rowAffectRefeicao);
            viagemModel2.setIdProfile(pref.getInt("KEY_ID", 0));
            viagemDAO.Insert(viagemModel2);

            objectViagemList.add(objectViagem);
        }

        return objectViagemList;
    }
}
