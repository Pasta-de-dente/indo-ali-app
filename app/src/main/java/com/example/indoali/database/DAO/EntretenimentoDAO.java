package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.entretenimentoModel;

public class EntretenimentoDAO extends AbstrataDAO {
    private final String[] colunas = {
            entretenimentoModel.COLUNA_ID,
            entretenimentoModel.COLUNA_NOME,
            entretenimentoModel.COLUNA_PRECO,
            entretenimentoModel.COLUNA_QTDA_PESSOAS,
            entretenimentoModel.COLUNA_QTDA_VEZES,
    };

    public EntretenimentoDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }

    public long Insert(entretenimentoModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();
        values.put(entretenimentoModel.COLUNA_NOME, model.getNome());
        values.put(entretenimentoModel.COLUNA_PRECO, model.getPreco());
        values.put(entretenimentoModel.COLUNA_QTDA_PESSOAS, model.getQtdaPessoas());
        values.put(entretenimentoModel.COLUNA_QTDA_VEZES, model.getQtdaVezes());
        values.put(entretenimentoModel.COLUNA_ID_VIAGEM, model.getIdViagemToEntretenimento());

        rowAffect = db.insert(entretenimentoModel.TABELA_NOME, null, values);

        Close();

        return rowAffect;
    }
}
