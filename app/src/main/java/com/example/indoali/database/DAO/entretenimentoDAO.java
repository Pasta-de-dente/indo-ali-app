package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.database.model.entretenimentoModel;

public class entretenimentoDAO extends AbstrataDAO{
    private final String[] colunas={
        entretenimentoModel.COLUNA_ID,
        entretenimentoModel.COLUNA_NOME,
        entretenimentoModel.COLUNA_CUSTO_TOTAL};

    public entretenimentoDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void AbreBanco() {
        Open();
    }

    public long Insert(entretenimentoModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();
        values.put(entretenimentoModel.COLUNA_ID, model.getID()); // Não precisa pois é autoincrement
        values.put(entretenimentoModel.COLUNA_NOME, model.getNomeEntretenimento());
        values.put(entretenimentoModel.COLUNA_CUSTO_TOTAL, model.getCustoTotal());
        rowAffect = db.insert(entretenimentoModel.TABELA_NOME, null, values);

        Close();

        return rowAffect;
    }
}
