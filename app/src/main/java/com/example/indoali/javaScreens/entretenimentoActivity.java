package com.example.indoali.javaScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoali.MainActivity;
import com.example.indoali.R;

public class entretenimentoActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasporte_entretenimento);

        Button btnNext=findViewById(R.id.nextBtn);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entretenimentoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
