package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.profileModel;
import com.example.indoali.database.model.refeicaoModel;
import com.example.indoali.database.model.*;
public class ViajemDAO extends AbstrataDAO{
 private final String[] colunas={

         viajemModel.COLUNA_ID,
         viajemModel.COLUNA_DATA,
         viajemModel.COLUNA_DESTINO,
         viajemModel.COLUNA_ID_PROFILE,
         viajemModel.COLUNA_ID_AVIAO,
         viajemModel.COLUNA_ID_CARRO,
         viajemModel.COLUNA_ID_HOSPEDAGEM,
         viajemModel.COLUNA_ID_VIAJEM_ENTRETENIMENTO,
 };
 public ViajemDAO(Context context){
  db_helper = new DBOpenHelper(context);
 }

 public void AbreBanco() {
  Open();
 }

 public long Insert(viajemModel model) {
  long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

  Open();

  ContentValues values = new ContentValues();
  values.put(  viajemModel.COLUNA_DATA, model.getData());
  values.put(  viajemModel.COLUNA_ID_PROFILE, model.getIdProfile());
  values.put(  viajemModel.COLUNA_DESTINO, model.getDestinario());
  values.put(  viajemModel.COLUNA_ID_REFEICAO, model.getIdRefeicao());
  values.put(  viajemModel.COLUNA_ID_CARRO, model.getIdCarro());
  values.put(  viajemModel.COLUNA_ID_HOSPEDAGEM,  model.getIdHospedagem());
  values.put(  viajemModel.COLUNA_ID_VIAJEM_ENTRETENIMENTO,  model.getIdViajemToEntretenimento());
  values.put(  viajemModel.COLUNA_ID_AVIAO, model.getIdAviao());
  rowAffect = db.insert(refeicaoModel.TABELA_NOME, null, values);
  // Close();

  return rowAffect;
 }
 public Cursor QueryWithJoin(long id) {
  SQLiteDatabase db = db_helper.getReadableDatabase();

  String query = "SELECT " +
          "v." + viajemModel.COLUNA_ID + ", " +
          "v." + viajemModel.COLUNA_ID_PROFILE + ", " +
          "v." + viajemModel.COLUNA_ID_AVIAO + ", " +
          "v." + viajemModel.COLUNA_ID_CARRO + ", " +
          "v." + viajemModel.COLUNA_ID_HOSPEDAGEM + ", " +
          "v." + viajemModel.COLUNA_ID_VIAJEM_ENTRETENIMENTO +
          " FROM " + viajemModel.TABELA_NOME + " v " +
          "JOIN profile p ON v." + viajemModel.COLUNA_ID_PROFILE + " = p." + profileModel.COLUNA_ID + " " +
          "JOIN aviao a ON v." + viajemModel.COLUNA_ID_AVIAO + " = a." + aviaoModel.COLUNA_ID + " " +
          "JOIN carro c ON v." + viajemModel.COLUNA_ID_CARRO + " = c." + carroModel.COLUNA_ID + " " +
          "JOIN hospedagem h ON v." + viajemModel.COLUNA_ID_HOSPEDAGEM + " = h." + hospedagemModel.COLUNA_ID + " " +
          "JOIN entretenimento e ON v." + viajemModel.COLUNA_ID_VIAJEM_ENTRETENIMENTO + " = e." + entretenimentoModel.COLUNA_ID + " " +
          "WHERE v." + viajemModel.COLUNA_ID + " = ?";

  String[] selectionArgs = {String.valueOf(id)};

  return db.rawQuery(query, selectionArgs);
 }
}
