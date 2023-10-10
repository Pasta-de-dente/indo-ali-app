package com.example.indoali.database.DAO;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.aviaoModel;

import java.util.ArrayList;
import java.util.List;

public class AviaoDAO extends AbstrataDAO{

    private final String[] colunas = {
            aviaoModel.COLUNA_ID,
            aviaoModel.COLUNA_CUSTO_POR_PESSOA,
            aviaoModel.COLUNA_ALUGUEL_VEICULO
    };

    public AviaoDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void AbreBanco() {
        Open();
    }

    public long Insert(aviaoModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();
        values.put(aviaoModel.COLUNA_ID, model.get_id()); // Não precisa pois é autoincrement
        values.put(aviaoModel.COLUNA_CUSTO_POR_PESSOA, model.getCustoPorPessoa());
        values.put(aviaoModel.COLUNA_ALUGUEL_VEICULO, model.getAluguelVeiculo());
        rowAffect = db.insert(aviaoModel.TABELA_NOME, null, values);

        Close();

        return rowAffect;
    }
    public List<aviaoModel> Select() {
        List<aviaoModel> aviaoList = new ArrayList<>();

        Open();

        Cursor cursor = db.query(
                aviaoModel.TABELA_NOME,  // Table name
                colunas,                 // Columns to retrieve
                null,                    // Selection (WHERE clause)
                null,                    // Selection arguments
                null,                    // Group by
                null,                    // Having
                null                     // Order by
        );

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(aviaoModel.COLUNA_ID);
                int custoPorPessoaIndex = cursor.getColumnIndex(aviaoModel.COLUNA_CUSTO_POR_PESSOA);
                int aluguelVeiculoIndex = cursor.getColumnIndex(aviaoModel.COLUNA_ALUGUEL_VEICULO);


                do {
                    aviaoModel model = new aviaoModel();

                    if (idIndex >= 0) {
                        model.set_id(cursor.getInt(idIndex));
                    }

                    if (custoPorPessoaIndex >= 0) {
                        model.setCustoPorPessoa(cursor.getDouble(custoPorPessoaIndex));
                    }

                    if (aluguelVeiculoIndex >= 0) {
                        model.setAluguelVeiculo(cursor.getDouble(aluguelVeiculoIndex));
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
