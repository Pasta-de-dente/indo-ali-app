package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.aviaoModel;
import com.example.indoali.database.model.carroModel;

import java.util.ArrayList;
import java.util.List;

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
                values.put(carroModel.COLUNA_CUSTO_MEDIO_LITRO, model.getCustoMedioLitro());
                values.put(carroModel.COLUNA_MEDIA_KM_LITRO, model.getMediaKmLitro());
                values.put(carroModel.COLUNA_TOTAL_VEICULO, model.getTotalVeiculo());
                values.put(carroModel.COLUNA_TOTAL_ESTIMADO_KM, model.getTotalEstimadoKm());

                rowAffect = db.insert(carroModel.TABELA_NOME, null, values);

//              Close();

                return rowAffect;
        }
        public List<carroModel> Select(){
                List<carroModel> aviaoList = new ArrayList<>();

                Open();

                Cursor cursor = db.query(
                        carroModel.TABELA_NOME, // Tabe name
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
                                double custoMedioLitro = cursor.getColumnIndex(carroModel.COLUNA_CUSTO_MEDIO_LITRO);
                                int totalVeiculo = cursor.getColumnIndex(carroModel.COLUNA_TOTAL_VEICULO);
                                double mediaKmLitro = cursor.getColumnIndex(carroModel.COLUNA_MEDIA_KM_LITRO);
                                double totalEstimadoKm = cursor.getColumnIndex(carroModel.COLUNA_TOTAL_ESTIMADO_KM);
                                do {
                                        carroModel model = new carroModel();

                                        if (idIndex >= 0) {
                                                model.set_id(cursor.getInt(idIndex));
                                        }

                                        if (custoMedioLitro >= 0) {
                                                model.setCustoMedioLitro(cursor.getDouble((int) custoMedioLitro));
                                        }

                                        if (totalVeiculo >= 0) {
                                                model.setTotalVeiculo(cursor.getInt(totalVeiculo));
                                        }
                                        if (mediaKmLitro >= 0) {
                                                model.setMediaKmLitro(cursor.getDouble((int) mediaKmLitro));
                                        }
                                        if (totalEstimadoKm >= 0) {
                                                model.setTotalEstimadoKm(cursor.getDouble((int) totalEstimadoKm));
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
