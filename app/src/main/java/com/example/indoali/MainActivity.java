package com.example.indoali;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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

        txtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.remove("KEY_ID").apply();
                edit.remove("KEY_EMAIL").apply();
                edit.remove("KEY_NOME").apply();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        txtData.getText();

        btnAnalise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, aviaoActivity.class);

                if (txtData.getText().toString().isEmpty()) {
                    txtData.setError("Campo necessário!");
                }

                if (txtDestino.getText().toString().isEmpty()) {
                    txtDestino.setError("Campo necessário!");
                }

                if (!txtData.getText().toString().isEmpty() && !txtDestino.getText().toString().isEmpty()) {
                    viagem.setData(txtData.getText().toString());
                    viagem.setDestino(txtDestino.getText().toString());
                    viagem.setTotalViajante(Integer.parseInt(totalDeViajante.getText().toString()));
                    viagem.setDuracaoDaViagem(Integer.parseInt(txtDuracaoViagem.getText().toString()));

                    intent.putExtra("Viagem", viagem);
                    startActivity(intent);
                }
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
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                // A data selecionada pelo usuário
                String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                txtData.setText(selectedDate);
            }
        }, year, month, day);

        // Mostrar o seletor de data
        datePickerDialog.show();
    }
//    private void showDatePickerDialog() {
//        // Obter a data atual (data final)
//        Calendar currentCalendar = Calendar.getInstance();
//        int currentYear = currentCalendar.get(Calendar.YEAR);
//        int currentMonth = currentCalendar.get(Calendar.MONTH);
//        int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
//
//        // Criar um DatePickerDialog e configurá-lo
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
//                // A data selecionada pelo usuário (data inicial)
//                String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
//                txtData.setText(selectedDate);
//
//                // Você pode usar currentCalendar para obter a data final se necessário
//                String currentDate = currentYear + "-" + (currentMonth + 1) + "-" + currentDay;
//                // Faça o que desejar com a data final (currentDate)
//            }
//        }, currentYear, currentMonth, currentDay);
//
//        // Mostrar o seletor de data
//        datePickerDialog.show();
//    }
}