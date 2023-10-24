package com.example.indoali.database.DAO;

import com.example.indoali.database.DBOpenHelper;

import android.database.sqlite.SQLiteDatabase;

public class AbstrataDAO {
    protected SQLiteDatabase db;
    protected DBOpenHelper db_helper;

    protected void Open() {
        db = db_helper.getWritableDatabase();
    }

    protected void Close() {
        db_helper.close();
    }
}
