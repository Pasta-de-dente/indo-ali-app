package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.database.model.hospedagemModel;

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
        values.put(hospedagemModel.COLUNA_ID, model.get_ID()); // Não precisa pois é autoincrement
        values.put(hospedagemModel.COLUNA_CUSTO_MEDIO_POR_NOITE, model.getCustoMedioPorNoite());
        values.put(hospedagemModel.COLUNA_TOTAL_DE_NOITE, model.getTotalNoite());
        values.put(hospedagemModel.COLUNA_TOTAL_QUARTOS, model.getTotalQuartos());


        rowAffect = db.insert(aviaoModel.TABELA_NOME, null, values);

        Close();

        return rowAffect;
    }
}
