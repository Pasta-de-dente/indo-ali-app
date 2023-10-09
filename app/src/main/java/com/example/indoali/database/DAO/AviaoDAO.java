package com.example.indoali.database.DAO;
import android.content.ContentValues;
import android.content.Context;
import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.aviaoModel;

public class AviaoDAO extends AbstrataDAO{

    private final String[] colunas = {
            aviaoModel.COLUNA_ID,
            aviaoModel.COLUNA_CUSTO_POR_PESSOA,
            aviaoModel.COLUNA_ALUGUEL_VEICULO,
            aviaoModel.COLUNA_TOTAL_GASTO
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
        values.put(aviaoModel.COLUNA_TOTAL_GASTO, model.getTotalGasto());
        rowAffect = db.insert(aviaoModel.TABELA_NOME, null, values);

        Close();

        return rowAffect;
    }

}
