package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.refeicaoModel;
import com.example.indoali.database.model.*;
import com.example.indoali.javaScreens.objects.Entretenimento;
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
        values.put(viagemModel.COLUNA_DURACAO,model.getDuracao());
        values.put(viagemModel.COLUNA_QTDA_VIAJANTES,model.getQtdaViajante());
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

        String queryEntretenimento = "SELECT entretenimento.* FROM viagem LEFT JOIN entretenimento ON viagem._idTabelaViagemToEntretenimento = entretenimento._id WHERE viagem._idProfile =" + profileId;

        //Execute a consulta SQL para buscar os resultados pelo id do usuario
        Cursor cursor = db.rawQuery(query, null);

        // Verifica se há resultados
        if (cursor.moveToFirst()) {
            do {
                String data = "erro";
                String destino = "erro";

                // Recupera os dados das colunas de todas as tabelas
                // Viagem info
                // Recupera os dados das colunas de todas as tabelas

                // ID to entretenimento info
                int columnIndexIDViagem = cursor.getColumnIndex(viagemModel.COLUNA_ID_VIAGEM_ENTRETENIMENTO);
                int idViagemToEntretenimento = columnIndexIDViagem >= 0 ? cursor.getInt(columnIndexIDViagem) : 0;


// Viagem info
                int columnIndexData = cursor.getColumnIndex(viagemModel.COLUNA_DATA);
                data = columnIndexData >= 0 ? cursor.getString(columnIndexData) : "Valor Padrão ou Lidar com Ausência";

                int columnIndexDestino = cursor.getColumnIndex(viagemModel.COLUNA_DESTINO);
                destino = columnIndexDestino >= 0 ? cursor.getString(columnIndexDestino) : "Valor Padrão ou Lidar com Ausência";

                int columnIndexDuracao = cursor.getColumnIndex(viagemModel.COLUNA_DURACAO);
                int duracaoViajem = columnIndexDuracao >= 0 ? cursor.getInt(columnIndexDuracao) : 0;

                int columnIndexQTDA_VIAJANTES = cursor.getColumnIndex(viagemModel.COLUNA_QTDA_VIAJANTES);
                int totalDeViajante = columnIndexQTDA_VIAJANTES >= 0 ? cursor.getInt(columnIndexQTDA_VIAJANTES) : 0;
// Carro
                int columnIndexCustoMedioLitro = cursor.getColumnIndex(carroModel.COLUNA_CUSTO_MEDIO_LITRO);
                double custoMedioLitro = columnIndexCustoMedioLitro >= 0 ? cursor.getDouble(columnIndexCustoMedioLitro) : 0.0;

                int columnIndexTotalEstimadoKm = cursor.getColumnIndex(carroModel.COLUNA_TOTAL_ESTIMADO_KM);
                double totalEstimadoKm = columnIndexTotalEstimadoKm >= 0 ? cursor.getDouble(columnIndexTotalEstimadoKm) : 0.0;

                int columnIndexMediaKmLitro = cursor.getColumnIndex(carroModel.COLUNA_MEDIA_KM_LITRO);
                double mediaKmLitro = columnIndexMediaKmLitro >= 0 ? cursor.getDouble(columnIndexMediaKmLitro) : 0.0;

                int columnIndexTotalVeiculo = cursor.getColumnIndex(carroModel.COLUNA_TOTAL_VEICULO);
                int totalVeiculo = columnIndexTotalVeiculo >= 0 ? cursor.getInt(columnIndexTotalVeiculo) : 0;

// Avião
                int columnIndexAluguelVeiculo = cursor.getColumnIndex(aviaoModel.COLUNA_ALUGUEL_VEICULO);
                double aluguelVeiculo = columnIndexAluguelVeiculo >= 0 ? cursor.getDouble(columnIndexAluguelVeiculo) : 0.0;

                int columnIndexCustoPorPessoa = cursor.getColumnIndex(aviaoModel.COLUNA_CUSTO_POR_PESSOA);
                double custoPorPessoa = columnIndexCustoPorPessoa >= 0 ? cursor.getDouble(columnIndexCustoPorPessoa) : 0.0;



// Refeição
                int columnIndexCustoEstimadoPorRefeicao = cursor.getColumnIndex(refeicaoModel.COLUNA_CUSTO_ESTIMADO_POR_REFEICAO);
                double custoEstimadoPorRefeicao = columnIndexCustoEstimadoPorRefeicao >= 0 ? cursor.getDouble(columnIndexCustoEstimadoPorRefeicao) : 0.0;

                int columnIndexQtdaRefeicaoPorDia = cursor.getColumnIndex(refeicaoModel.COLUNA_QTDA_REFEICAO_POR_DIA);
                int qtdaRefeicaoPorDia = columnIndexQtdaRefeicaoPorDia >= 0 ? cursor.getInt(columnIndexQtdaRefeicaoPorDia) : 0;


// Hospedagem
                int columnIndexTotalQuartos = cursor.getColumnIndex(hospedagemModel.COLUNA_TOTAL_QUARTOS);
                int totalQuartos = columnIndexTotalQuartos >= 0 ? cursor.getInt(columnIndexTotalQuartos) : 0;

                int columnIndexCustoMedioPorNoite = cursor.getColumnIndex(hospedagemModel.COLUNA_CUSTO_MEDIO_POR_NOITE);
                double custoMedioPorNoite = columnIndexCustoMedioPorNoite >= 0 ? cursor.getDouble(columnIndexCustoMedioPorNoite) : 0.0;

                int columnIndexTotalNoite = cursor.getColumnIndex(hospedagemModel.COLUNA_TOTAL_DE_NOITE);
                int totalNoite = columnIndexTotalNoite >= 0 ? cursor.getInt(columnIndexTotalNoite) : 0;


                ObjectViagem viagem = new ObjectViagem();

                //ID
                viagem.setIdEntretenimento(idViagemToEntretenimento);

                //viagem
                viagem.setData(data);
                viagem.setDestino(destino);
                viagem.setDuracaoDaViagem(duracaoViajem);
                viagem.setTotalViajante(totalDeViajante);

                //aviao
                viagem.setAluguelVeiculo(aluguelVeiculo);
                viagem.setCustoPorPessoa(custoPorPessoa);


                //Carro
                viagem.setCustoMedioLitro(custoMedioLitro);
                viagem.setTotalEstimadoKm(totalEstimadoKm);
                viagem.setMediaKmLitro(mediaKmLitro);
                viagem.setTotalVeiculo(totalVeiculo);

                //Refeicao
                viagem.setCustoEstimadoPorRefeicao(custoEstimadoPorRefeicao);
                viagem.setQtdaRefeicaoPorDia(qtdaRefeicaoPorDia);


                //hospedagem
                viagem.setTotalQuartos(totalQuartos);
                viagem.setCustoMedioPorNoite(custoMedioPorNoite);
                viagem.setTotalNoite(totalNoite);

                // Envia pra lista pra depois puxar na main
                viagemList.add(viagem);

            } while (cursor.moveToNext());
        }

        Cursor cursorEntretenimento = db.rawQuery(queryEntretenimento, null);
        List<Entretenimento> EntretenimentoList = new ArrayList<>();
        // Verifica se há resultados
        if (cursorEntretenimento.moveToFirst()) {
            do {
                Entretenimento entre = new Entretenimento();
                int columnIndexNome = cursorEntretenimento.getColumnIndex(entretenimentoModel.COLUNA_NOME);
                String nome = columnIndexNome >= 0 ? cursorEntretenimento.getString(columnIndexNome) : "Valor Padrão ou Lidar com Ausência";

                int columnIndexPreco = cursorEntretenimento.getColumnIndex(entretenimentoModel.COLUNA_PRECO);
                double preco = columnIndexPreco >= 0 ? cursorEntretenimento.getDouble(columnIndexPreco) : 0.0;

                int columnIndexQtdaPessoas = cursorEntretenimento.getColumnIndex(entretenimentoModel.COLUNA_QTDA_PESSOAS);
                int qtdaPessoa = columnIndexQtdaPessoas >= 0 ? cursorEntretenimento.getInt(columnIndexQtdaPessoas) : 0;

                int columnIndexQtdaVezes = cursorEntretenimento.getColumnIndex(entretenimentoModel.COLUNA_QTDA_VEZES);
                int qtdaVezes = columnIndexQtdaVezes >= 0 ? cursorEntretenimento.getInt(columnIndexQtdaVezes) : 0;

                int columnIndexIDViagemToEntretenimento = cursorEntretenimento.getColumnIndex(entretenimentoModel.COLUNA_ID_VIAGEM);
                int idViagem = columnIndexIDViagemToEntretenimento >= 0 ? cursorEntretenimento.getInt(columnIndexIDViagemToEntretenimento) : 0;

                entre.setNome(nome);
                entre.setPreco(preco);
                entre.setQtdaPessoas(qtdaPessoa);
                entre.setQtdaVezes(qtdaVezes);
                entre.setIdViagemToEntretenimento(idViagem);
                EntretenimentoList.add(entre);

                // Envia pra lista pra depois puxar na main

            } while (cursorEntretenimento.moveToNext());
        }
        for(int i=0;i<viagemList.size();i++){
            for(int j=0;j<EntretenimentoList.size();j++){
                if(EntretenimentoList.get(j).getIdViagemToEntretenimento()==viagemList.get(i).getIdEntretenimento()){
                    viagemList.get(i).listEntretenimento.add(EntretenimentoList.get(j));
                }
            }
        }
        cursorEntretenimento.close();
        // Não se esqueça de fechar o cursor quando terminar
        cursor.close();

        return viagemList;
    }

}
