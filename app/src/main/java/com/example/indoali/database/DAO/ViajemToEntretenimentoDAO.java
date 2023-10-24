package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.viajemToEntretenimentoModel;

import java.util.ArrayList;
import java.util.List;

public class ViajemToEntretenimentoDAO extends  AbstrataDAO{
    private final String[] colunas={
            viajemToEntretenimentoModel.COLUNA_ID,
            viajemToEntretenimentoModel.COLUNA_DATA_VIAJEM

    };
    public ViajemToEntretenimentoDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void AbreBanco() {
        Open();
    }

    public long Insert(viajemToEntretenimentoModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;
        Open();

            ContentValues values = new ContentValues();

        values.put("idDataViajem", model.getDataViajem());

        rowAffect = db.insert(viajemToEntretenimentoModel.TABELA_NOME, null, values);

           //Close();
        return rowAffect;
    }

}
