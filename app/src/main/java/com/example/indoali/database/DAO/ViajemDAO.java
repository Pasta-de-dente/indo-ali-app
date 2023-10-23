package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.indoali.LoginActivity;
import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.profileModel;
import com.example.indoali.database.model.refeicaoModel;
import com.example.indoali.database.model.*;
import com.example.indoali.javaScreens.objects.ObjectViajem;

import java.util.ArrayList;
import java.util.List;

public class ViajemDAO extends AbstrataDAO {
    private final String[] colunas = {

            viajemModel.COLUNA_ID,
            viajemModel.COLUNA_DATA,
            viajemModel.COLUNA_DESTINO,
            viajemModel.COLUNA_ID_PROFILE,
            viajemModel.COLUNA_ID_AVIAO,
            viajemModel.COLUNA_ID_CARRO,
            viajemModel.COLUNA_ID_HOSPEDAGEM,
            viajemModel.COLUNA_ID_VIAJEM_ENTRETENIMENTO,
    };

    public ViajemDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }

    public void AbreBanco() {
        Open();
    }

    public long Insert(viajemModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();
        values.put(viajemModel.COLUNA_DATA, model.getData());
        values.put(viajemModel.COLUNA_ID_PROFILE, model.getIdProfile());
        values.put(viajemModel.COLUNA_DESTINO, model.getDestinario());
        values.put(viajemModel.COLUNA_ID_REFEICAO, model.getIdRefeicao());
        values.put(viajemModel.COLUNA_ID_CARRO, model.getIdCarro());
        values.put(viajemModel.COLUNA_ID_HOSPEDAGEM, model.getIdHospedagem());
        values.put(viajemModel.COLUNA_ID_VIAJEM_ENTRETENIMENTO, model.getIdViajemToEntretenimento());
        values.put(viajemModel.COLUNA_ID_AVIAO, model.getIdAviao());
        rowAffect = db.insert(viajemModel.TABELA_NOME, null, values);
        // Close();

        return rowAffect;
    }

    public List<ObjectViajem> QueryWithJoin(int profileId) {
        SQLiteDatabase db = db_helper.getReadableDatabase();
        List<ObjectViajem> viagemList = new ArrayList<>();

        // Substitua isso pelo ID do perfil desejado

        String query = "SELECT * FROM " + "viajem" +
                " LEFT JOIN " + "aviao" + " ON " + "viajem" + "." + "_idTabelaAviao" + " = " + "aviao" + "." + "_id" +
                " LEFT JOIN " + "carro" + " ON " + "viajem" + "." + "_idTabelaCarro" + " = " + "carro" + "." + "_id" +
                " LEFT JOIN " + "refeicao" + " ON " + "viajem" + "." + "_idTabelaRefeicao" + " = " + "refeicao" + "." + "_id" +
                " LEFT JOIN " + "viajemEntretenimento" + " ON " + "viajem" + "." + "_idTabelaViajemToEntretenimento" + " = " + "viajemEntretenimento" + "." + "_id" +
                " LEFT JOIN " + "hospedagem" + " ON " + "viajem" + "." + "_idTabelaHospedagem" + " = " + "hospedagem" + "." + "_id" +
                " WHERE " + "viajem" + "." + "_idProfile" + " = " + profileId;

//Execute a consulta SQL para buscar os resultados pelo id do usuario
        Cursor cursor = db.rawQuery(query, null);

//vrifique se há resultados
        if (cursor.moveToFirst()) {
            do {
                String data = "erro";
                String destino = "erro";
                // recupere os dados das colunas de todas as tabelas
                //Viajem info
                int columnIndexData = cursor.getColumnIndex(viajemModel.COLUNA_DATA);
                int columnIndexDestino = cursor.getColumnIndex(viajemModel.COLUNA_DESTINO);
// Verifica se o índice é válido
                if (columnIndexData != -1 && columnIndexDestino != -1) {
                    // Acesse os valores das colunas "data" e "destino
                    data = cursor.getString(columnIndexData);
                    destino = cursor.getString(columnIndexDestino);

                    // Agora você pode usar as variáveis 'data' e 'destino' para seus fins.
                } else {
                    // Os índices de coluna não foram encontrados, o que pode indicar que as colunas não existem na tabela ou estão nomeadas de forma diferente.
                    // Trate esse caso adequadamente.
                }
                ///CARRO
                double idIndexCustoMedioLitro = cursor.getColumnIndex(carroModel.COLUNA_CUSTO_MEDIO_LITRO);
                double idIndexTotalEstimadoKm = cursor.getColumnIndex(carroModel.COLUNA_TOTAL_ESTIMADO_KM);
                double idIndexMediaKmLitro = cursor.getColumnIndex(carroModel.COLUNA_MEDIA_KM_LITRO);
                int idIndexColunaTotalVeiculo = cursor.getColumnIndex(carroModel.COLUNA_TOTAL_VEICULO);

                //AVIAO
                double idIndexAluguelVeiculo = cursor.getColumnIndex(aviaoModel.COLUNA_ALUGUEL_VEICULO);
                double idIndexCustoPorPessoa = cursor.getColumnIndex(aviaoModel.COLUNA_CUSTO_POR_PESSOA);

                //REFEICAO
                double idIndexEstimadoPorRefeicao = cursor.getColumnIndex(refeicaoModel.COLUNA_CUSTO_ESTIMADO_POR_REFEICAO);
                int idIndexQtdaRefeicaoPorDia = cursor.getColumnIndex(refeicaoModel.COLUNA_QTDA_REFEICAO_POR_DIA);

                //HOSPEDAGEM
                int idIndexTotalQuartos = cursor.getColumnIndex(hospedagemModel.COLUNA_TOTAL_QUARTOS);
                double idIndexCustoMedioPorNoite = cursor.getColumnIndex(hospedagemModel.COLUNA_CUSTO_MEDIO_POR_NOITE);
                int idIndexTotalNoite = cursor.getColumnIndex(hospedagemModel.COLUNA_TOTAL_DE_NOITE);

                ObjectViajem viajem = new ObjectViajem();

                viajem.setData(data);
                viajem.setDestinario(destino);
                viajem.setCustoMedioLitro(idIndexCustoMedioLitro);
                viajem.setTotalEstimadoKm(idIndexTotalEstimadoKm);
                viajem.setMediaKmLitro(idIndexMediaKmLitro);
                viajem.setTotalVeiculo(idIndexColunaTotalVeiculo);

                viajem.setCustoEstimadoPorRefeicao(idIndexEstimadoPorRefeicao);
                viajem.setQtdaRefeicaoPorDia(idIndexQtdaRefeicaoPorDia);

                viajem.setCustoEstimadoPorRefeicao(idIndexEstimadoPorRefeicao);
                viajem.setQtdaRefeicaoPorDia(idIndexQtdaRefeicaoPorDia);

                viajem.setTotalQuartos(idIndexTotalQuartos);
                viajem.setCustoMedioPorNoite(idIndexCustoMedioPorNoite);
                viajem.setTotalNoite(idIndexTotalNoite);

                // Envia pra lista pra depois puxar na main
                viagemList.add(viajem);

            } while (cursor.moveToNext());
        }

// Não se esqueça de fechar o cursor quando terminar
        cursor.close();


        return viagemList;
    }

}
