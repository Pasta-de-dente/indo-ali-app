package com.example.indoali.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.indoali.database.model.*;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String
            DATABASE_NOME = "mano.db";

    private static final int
            DATABASE_VERSAO = 1;

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(aviaoModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(carroModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(refeicaoModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(hospedagemModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(viajemModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(viajemToEntretenimentoModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(entretenimentoModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(profileModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // i = oldVersion
        // i1 = newVersion

        sqLiteDatabase.execSQL(aviaoModel.DROP_TABLE);
        sqLiteDatabase.execSQL(aviaoModel.CREATE_TABLE);

        sqLiteDatabase.execSQL(carroModel.DROP_TABLE);
        sqLiteDatabase.execSQL(carroModel.CREATE_TABLE);

        sqLiteDatabase.execSQL(refeicaoModel.DROP_TABLE);
        sqLiteDatabase.execSQL(refeicaoModel.CREATE_TABLE);

        sqLiteDatabase.execSQL(hospedagemModel.DROP_TABLE);
        sqLiteDatabase.execSQL(hospedagemModel.CREATE_TABLE);

        sqLiteDatabase.execSQL(viajemModel.DROP_TABLE);
        sqLiteDatabase.execSQL(viajemModel.CREATE_TABLE);

        sqLiteDatabase.execSQL(viajemToEntretenimentoModel.DROP_TABLE);
        sqLiteDatabase.execSQL(viajemToEntretenimentoModel.CREATE_TABLE);

        sqLiteDatabase.execSQL(entretenimentoModel.DROP_TABLE);
        sqLiteDatabase.execSQL(entretenimentoModel.CREATE_TABLE);

        sqLiteDatabase.execSQL(profileModel.DROP_TABLE);
        sqLiteDatabase.execSQL(profileModel.CREATE_TABLE);
    }

}
