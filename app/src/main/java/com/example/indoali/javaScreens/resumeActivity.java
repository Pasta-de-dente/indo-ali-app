package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.indoali.database.DAO.AviaoDAO;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.R;

import org.w3c.dom.Text;

import java.util.List;

public class resumeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        TextView txtCustoAviao=findViewById(R.id.txtCustoAviao);
        TextView txtCustoCarro=findViewById(R.id.txtCustoCarro);
        TextView txtCustoEntretenimento=findViewById(R.id.txtCustoEntretenimento);
        TextView txtCustoHospedagem=findViewById(R.id.txtCustoHospedagem);
        TextView txtCustoRefeicao=findViewById(R.id.txtCustoRefeição);

       // AviaoDAO aviaoDAO=new AviaoDAO(this.resumeActivity);
        //List<aviaoModel>    listaAviao=aviaoDAO.Select();

    }
}
