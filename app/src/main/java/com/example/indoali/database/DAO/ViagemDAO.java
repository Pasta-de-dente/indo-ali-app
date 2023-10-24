package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.refeicaoModel;
import com.example.indoali.database.model.*;
import com.example.indoali.javaScreens.objects.ObjectViagem;

import java.util.ArrayList;
import java.util.List;

public class ViagemDAO extends AbstrataDAO {
    private final String[] colunas = {
            viagemModel.COLUNA_ID,
            viagemModel.COLUNA_DATA,
            viagemModel.COLUNA_DESTINO,
            viagemModel.COLUNA_ID_PROFILE,
            viagemModel.COLUNA_ID_AVIAO,
            viagemModel.COLUNA_ID_CARRO,
            viagemModel.COLUNA_ID_HOSPEDAGEM,
            viagemModel.COLUNA_ID_VIAGEM_ENTRETENIMENTO,
    };

    public ViagemDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }

    public long Insert(viagemModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();

        ContentValues values = new ContentValues();
        values.put(viagemModel.COLUNA_DATA, model.getData());
        values.put(viagemModel.COLUNA_ID_PROFILE, model.getIdProfile());
        values.put(viagemModel.COLUNA_DESTINO, model.getDestino());
        values.put(viagemModel.COLUNA_ID_REFEICAO, model.getIdRefeicao());
        values.put(viagemModel.COLUNA_ID_CARRO, model.getIdCarro());
        values.put(viagemModel.COLUNA_ID_HOSPEDAGEM, model.getIdHospedagem());
        values.put(viagemModel.COLUNA_ID_VIAGEM_ENTRETENIMENTO, model.getIdViagemToEntretenimento());
        values.put(viagemModel.COLUNA_ID_AVIAO, model.getIdAviao());
        rowAffect = db.insert(viagemModel.TABELA_NOME, null, values);

        Close();

        return rowAffect;
    }

    public List<ObjectViagem> QueryWithJoin(int profileId) {
        SQLiteDatabase db = db_helper.getReadableDatabase();
        List<ObjectViagem> viagemList = new ArrayList<>();

        // Substitua isso pelo ID do perfil desejado

        String query = "SELECT * FROM " + "viagem" +
                " LEFT JOIN " + "aviao" + " ON " + "viagem" + "." + "_idTabelaAviao" + " = " + "aviao" + "." + "_id" +
                " LEFT JOIN " + "carro" + " ON " + "viagem" + "." + "_idTabelaCarro" + " = " + "carro" + "." + "_id" +
                " LEFT JOIN " + "refeicao" + " ON " + "viagem" + "." + "_idTabelaRefeicao" + " = " + "refeicao" + "." + "_id" +
                " LEFT JOIN " + "viagemEntretenimento" + " ON " + "viagem" + "." + "_idTabelaViagemToEntretenimento" + " = " + "viagemEntretenimento" + "." + "_id" +
                " LEFT JOIN " + "hospedagem" + " ON " + "viagem" + "." + "_idTabelaHospedagem" + " = " + "hospedagem" + "." + "_id" +
                " WHERE " + "viagem" + "." + "_idProfile" + " = " + profileId;

        //Execute a consulta SQL para buscar os resultados pelo id do usuario
        Cursor cursor = db.rawQuery(query, null);

        // Verifica se há resultados

        if (cursor.moveToFirst()) {
            do {
                String data = "erro";
                String destino = "erro";

                // Recupera os dados das colunas de todas as tabelas
                // Viagem info
                int columnIndexData = cursor.getColumnIndex(viagemModel.COLUNA_DATA);
                int columnIndexDestino = cursor.getColumnIndex(viagemModel.COLUNA_DESTINO);

                // Verifica se o índice é válido
                if (columnIndexData != -1 && columnIndexDestino != -1) {
                    // Acesse os valores das colunas "data" e "destino
                    data = cursor.getString(columnIndexData);
                    destino = cursor.getString(columnIndexDestino);

                    // Agora você pode usar as variáveis 'data' e 'destino' para seus fins.
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

                ObjectViagem viagem = new ObjectViagem();

                viagem.setData(data);
                viagem.setDestino(destino);
                viagem.setCustoMedioLitro(idIndexCustoMedioLitro);
                viagem.setTotalEstimadoKm(idIndexTotalEstimadoKm);
                viagem.setMediaKmLitro(idIndexMediaKmLitro);
                viagem.setTotalVeiculo(idIndexColunaTotalVeiculo);

                viagem.setCustoEstimadoPorRefeicao(idIndexEstimadoPorRefeicao);
                viagem.setQtdaRefeicaoPorDia(idIndexQtdaRefeicaoPorDia);

                viagem.setCustoEstimadoPorRefeicao(idIndexEstimadoPorRefeicao);
                viagem.setQtdaRefeicaoPorDia(idIndexQtdaRefeicaoPorDia);

                viagem.setTotalQuartos(idIndexTotalQuartos);
                viagem.setCustoMedioPorNoite(idIndexCustoMedioPorNoite);
                viagem.setTotalNoite(idIndexTotalNoite);

                // Envia pra lista pra depois puxar na main
                viagemList.add(viagem);

            } while (cursor.moveToNext());
        }

        // Não se esqueça de fechar o cursor quando terminar
        cursor.close();

        return viagemList;
    }

}
