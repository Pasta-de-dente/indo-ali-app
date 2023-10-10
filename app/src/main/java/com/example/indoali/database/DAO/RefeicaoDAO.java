package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.refeicaoModel;


public class RefeicaoDAO extends AbstrataDAO{

    private final String[] colunas={

            refeicaoModel.COLUNA_ID,
            refeicaoModel.COLUNA_CUSTO_ESTIMADO_POR_REFEICAO,
            refeicaoModel. COLUNA_QTDA_REFEICAO_POR_DIA
    };
    public RefeicaoDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void AbreBanco() {
        Open();
    }

    public long Insert(refeicaoModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();
        values.put(  refeicaoModel.COLUNA_ID, model.get_ID()); // Não precisa pois é autoincrement
        values.put(  refeicaoModel.COLUNA_QTDA_REFEICAO_POR_DIA, model.getQtdaRefeicaoPorDia());
        values.put(  refeicaoModel.COLUNA_CUSTO_ESTIMADO_POR_REFEICAO, model.getCustoEstimadoPorRefeicao());
        rowAffect = db.insert(refeicaoModel.TABELA_NOME, null, values);
        Close();

        return rowAffect;
    }
}
