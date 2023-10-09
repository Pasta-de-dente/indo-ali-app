package com.example.indoali.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NOME = "banco.db";
    private static final int DATABASE_VERSAO = 1;

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aqui você deve lidar com atualizações de esquema, se necessário.
        // Por exemplo, você pode adicionar código para alterar a estrutura da tabela
        // se a versão do banco de dados for atualizada.
    }
}
