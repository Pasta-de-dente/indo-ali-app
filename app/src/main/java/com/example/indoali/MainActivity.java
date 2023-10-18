package com.example.indoali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.indoali.List.entretenimentoAdapter;
import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.javaScreens.aviaoActivity;
import com.example.indoali.javaScreens.entretenimentoActivity;
import com.example.indoali.javaScreens.objects.entretenimento;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView productList;

    private entretenimentoAdapter adapter;
    ArrayList<entretenimento> arl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = findViewById(R.id.list_viajens);
        adapter = new entretenimentoAdapter(MainActivity.this);


        arl = new ArrayList<entretenimento>();
        adapter.setProductList(arl);
        productList.setAdapter(adapter);
//Colocar para renderizar por viajem e fazer join entre todas as informações
//        for{
//
//        }
//        arl.add(ent);
//        adapter.notifyDataSetChanged();
//

        Button btnAnalise=findViewById(R.id.btnAnalisar);
        TextView txt=findViewById(R.id.editText);
        btnAnalise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this, aviaoActivity.class);

                intent.putExtra("Viajem", "Oi teste");
                startActivity(intent);

            }
        });

    }
}