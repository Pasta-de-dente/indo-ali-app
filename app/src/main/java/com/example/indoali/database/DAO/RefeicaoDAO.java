package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.carroModel;
import com.example.indoali.database.model.refeicaoModel;

import java.util.ArrayList;
import java.util.List;

public class RefeicaoDAO extends AbstrataDAO {
    private final String[] colunas = {
            refeicaoModel.COLUNA_ID,
            refeicaoModel.COLUNA_CUSTO_ESTIMADO_POR_REFEICAO,
            refeicaoModel.COLUNA_QTDA_REFEICAO_POR_DIA,
            refeicaoModel.COLUNA_DURACAO_VIAGEM,
            refeicaoModel.COLUNA_VIAJANTE_POR_REFEICAO

    };

    public RefeicaoDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }

    public long Insert(refeicaoModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();
        values.put(refeicaoModel.COLUNA_QTDA_REFEICAO_POR_DIA, model.getQtdaRefeicaoPorDia());
        values.put(refeicaoModel.COLUNA_CUSTO_ESTIMADO_POR_REFEICAO, model.getCustoEstimadoPorRefeicao());
        values.put(refeicaoModel.COLUNA_DURACAO_VIAGEM, model.getDuracaoViagem());
        values.put(refeicaoModel.COLUNA_VIAJANTE_POR_REFEICAO, model.getViajantePorRefeicao());
        rowAffect = db.insert(refeicaoModel.TABELA_NOME, null, values);

        Close();

        return rowAffect;
    }

    public List<refeicaoModel> Select() {
        List<refeicaoModel> aviaoList = new ArrayList<>();

        Open();

        Cursor cursor = db.query(
                refeicaoModel.TABELA_NOME, // Tabe name
                colunas,                 // Columns to retrieve
                null,                    // Selection (WHERE clause)
                null,                    // Selection arguments
                null,                    // Group by
                null,                    // Having
                null                     // Order by
        );

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(carroModel.COLUNA_ID);
                double CustoEstimadoPorRefeicao = cursor.getColumnIndex(refeicaoModel.COLUNA_CUSTO_ESTIMADO_POR_REFEICAO);
                int qtdaRefeicaoPorDia = cursor.getColumnIndex(refeicaoModel.COLUNA_QTDA_REFEICAO_POR_DIA);
                int duracaoViagem = cursor.getColumnIndex(refeicaoModel.COLUNA_DURACAO_VIAGEM);
                do {
                    refeicaoModel model = new refeicaoModel();

                    if (idIndex >= 0) {
                        model.set_ID(cursor.getInt(idIndex));
                    }

                    if (CustoEstimadoPorRefeicao >= 0) {
                        model.setCustoEstimadoPorRefeicao(cursor.getDouble((int) CustoEstimadoPorRefeicao));
                    }

                    if (qtdaRefeicaoPorDia >= 0) {
                        model.setQtdaRefeicaoPorDia(cursor.getInt(qtdaRefeicaoPorDia));
                    }
                    if (duracaoViagem >= 0) {
                        model.setDuracaoViagem(cursor.getInt(duracaoViagem));
                    }


                    aviaoList.add(model);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        Close();

        return aviaoList;
    }
}
