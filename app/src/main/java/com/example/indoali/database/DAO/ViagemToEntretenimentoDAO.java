package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.viagemToEntretenimentoModel;

public class ViagemToEntretenimentoDAO extends AbstrataDAO {
    private final String[] colunas = {
            viagemToEntretenimentoModel.COLUNA_ID,
            viagemToEntretenimentoModel.COLUNA_DATA_VIAGEM
    };

    public ViagemToEntretenimentoDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }

    public long Insert(viagemToEntretenimentoModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();

        values.put("idDataViagem", model.getDataViagem());

        rowAffect = db.insert(viagemToEntretenimentoModel.TABELA_NOME, null, values);

        Close();

        return rowAffect;
    }

}
