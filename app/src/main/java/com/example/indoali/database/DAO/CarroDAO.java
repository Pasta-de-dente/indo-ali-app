package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.database.model.carroModel;

public class CarroDAO extends AbstrataDAO{


        private final String[] colunas={

                carroModel.COLUNA_ID,
                carroModel.COLUNA_CUSTO_MEDIO_LITRO,
                carroModel.COLUNA_MEDIA_KM_LITRO,
                carroModel.COLUNA_TOTAL_VEICULO,
                carroModel.COLUNA_TOTAL_ESTIMADO_KM,
        };
        public CarroDAO(Context context){
                db_helper = new DBOpenHelper(context);
        }

        public void AbreBanco() {
                Open();
        }

        public long Insert(carroModel model) {
                long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

                Open();

                ContentValues values = new ContentValues();
                values.put(carroModel.COLUNA_ID, model.get_id()); // Não precisa pois é autoincrement
                values.put(carroModel.COLUNA_CUSTO_MEDIO_LITRO, model.getCustoMedioLitro());
                values.put(carroModel.COLUNA_MEDIA_KM_LITRO, model.getMediaKmLitro());
                values.put(carroModel.COLUNA_TOTAL_VEICULO, model.getTotalVeiculo());
                values.put(carroModel.COLUNA_TOTAL_ESTIMADO_KM, model.getTotalEstimadoKm());

                rowAffect = db.insert(aviaoModel.TABELA_NOME, null, values);

                Close();

                return rowAffect;
        }
}
