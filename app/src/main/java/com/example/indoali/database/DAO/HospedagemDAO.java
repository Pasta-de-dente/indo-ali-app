package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.database.model.carroModel;
import com.example.indoali.database.model.hospedagemModel;

import java.util.ArrayList;
import java.util.List;

public class HospedagemDAO extends AbstrataDAO {

    private final String[] colunas={

            hospedagemModel.COLUNA_ID,
            hospedagemModel.COLUNA_CUSTO_MEDIO_POR_NOITE,
            hospedagemModel.COLUNA_TOTAL_DE_NOITE,
            hospedagemModel.COLUNA_TOTAL_QUARTOS
    };
    public HospedagemDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void AbreBanco() {
        Open();
    }

    public long Insert(hospedagemModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();

        values.put(hospedagemModel.COLUNA_CUSTO_MEDIO_POR_NOITE, model.getCustoMedioPorNoite());
        values.put(hospedagemModel.COLUNA_TOTAL_DE_NOITE, model.getTotalNoite());
        values.put(hospedagemModel.COLUNA_TOTAL_QUARTOS, model.getTotalQuartos());


        rowAffect = db.insert(hospedagemModel.TABELA_NOME, null, values);

      //  Close();

        return rowAffect;
    }

    public List<hospedagemModel> Select(){
        List<hospedagemModel> aviaoList = new ArrayList<>();

        Open();

        Cursor cursor = db.query(
                hospedagemModel.TABELA_NOME, // Tabe name
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
                double CustoMedioPorNoite = cursor.getColumnIndex(hospedagemModel.COLUNA_CUSTO_MEDIO_POR_NOITE);
                int totalQuartos = cursor.getColumnIndex(hospedagemModel.COLUNA_TOTAL_QUARTOS);
                int totalNoite = cursor.getColumnIndex(hospedagemModel.COLUNA_TOTAL_DE_NOITE);

                do {
                    hospedagemModel model = new hospedagemModel();

                    if (idIndex >= 0) {
                        model.set_ID(cursor.getInt(idIndex));
                    }

                    if (CustoMedioPorNoite >= 0) {
                        model.setCustoMedioPorNoite(cursor.getDouble((int) CustoMedioPorNoite));
                    }

                    if (totalNoite >= 0) {
                        model.setTotalNoite(cursor.getInt(totalNoite));
                    }
                    if (totalQuartos >= 0) {
                        model.setTotalQuartos(cursor.getInt( totalQuartos));
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
