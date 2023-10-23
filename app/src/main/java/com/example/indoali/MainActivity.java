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
import android.widget.ListView;
import android.widget.TextView;

import com.example.indoali.List.entretenimentoAdapter;
import com.example.indoali.List.viajemAdapter;
import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.DAO.ViajemDAO;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.javaScreens.aviaoActivity;
import com.example.indoali.javaScreens.entretenimentoActivity;
import com.example.indoali.javaScreens.objects.ObjectViajem;
import com.example.indoali.javaScreens.objects.entretenimento;
import com.example.indoali.javaScreens.resumeActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView productList;
    private EditText txtData;
    private viajemAdapter adapter;
    ArrayList<ObjectViajem> arl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObjectViajem viajem = (ObjectViajem) getIntent().getSerializableExtra("Viajem");
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor edit = pref.edit();
        ViajemDAO viajemDAO=new ViajemDAO(MainActivity.this);
        List<ObjectViajem> teste= viajemDAO.QueryWithJoin(viajem.getKEY_ID_PROFILE());

        productList = findViewById(R.id.list_viajens);
        adapter = new viajemAdapter(MainActivity.this);

        arl = new ArrayList<ObjectViajem>();
        adapter.setProductList(arl);
        productList.setAdapter(adapter);

        if(teste.size()>0){
        for(int i=0;i<teste.size();i++){
            arl.add(teste.get(i));
            adapter.notifyDataSetChanged();
        }}



        Button btnAnalise = findViewById(R.id.btnAnalisar);
        txtData = findViewById(R.id.txtDataViajem);
        EditText txtDestino = findViewById(R.id.lugarViajem);
        Button btnLogout = findViewById(R.id.btnLogout);
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
                viajem.setData(txtData.getText().toString());
                viajem.setDestinario(txtDestino.getText().toString());
                intent.putExtra("Viajem", viajem);
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
}