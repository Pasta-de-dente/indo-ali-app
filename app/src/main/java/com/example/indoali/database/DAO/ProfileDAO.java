package com.example.indoali.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.indoali.LoginActivity;
import com.example.indoali.database.DBOpenHelper;
import com.example.indoali.database.model.carroModel;
import com.example.indoali.database.model.profileModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileDAO extends AbstrataDAO{

    private final String[] colunas={

            profileModel.COLUNA_ID,
            profileModel.COLUNA_NOME,
            profileModel.COLUNA_SENHA
    };
    public ProfileDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void AbreBanco() {
        Open();
    }

    public long Insert(profileModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

        Open();
    
        ContentValues values = new ContentValues();
        values.put(profileModel.COLUNA_NOME, model.getNome());
        values.put(profileModel.COLUNA_EMAIL, model.getEmail());
        values.put(profileModel.COLUNA_SENHA, model.getSenha());
        rowAffect = db.insert(profileModel.TABELA_NOME, null, values);

//              Close();

        return rowAffect;
    }
    public profileModel login(String email, String senha) {
        Open();

        String[] colunas = { profileModel.COLUNA_ID, profileModel.COLUNA_NOME,  profileModel.COLUNA_EMAIL,profileModel.COLUNA_SENHA };

        String selection = profileModel.COLUNA_EMAIL + " = ? AND " + profileModel.COLUNA_SENHA + " = ?";
        String[] selectionArgs = { email, senha };

        Cursor cursor = db.query(
                profileModel.TABELA_NOME, // Nome da tabela
                colunas,                 // Colunas para recuperar
                selection,               // Cláusula WHERE
                selectionArgs,           // Argumentos da cláusula WHERE
                null,                    // GROUP BY
                null,                    // HAVING
                null                     // ORDER BY
        );

        profileModel model = null;

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(profileModel.COLUNA_ID);
                int nameIndex = cursor.getColumnIndex(profileModel.COLUNA_NOME);
                int emailIndex = cursor.getColumnIndex(profileModel.COLUNA_EMAIL);
                int passwordIndex = cursor.getColumnIndex(profileModel.COLUNA_SENHA);

                model = new profileModel();

                if (idIndex >= 0) {
                    model.set_id(cursor.getInt(idIndex));
                }
                if (emailIndex >= 0) {
                    model.setEmail(cursor.getString(emailIndex));
                }

                if (nameIndex >= 0) {
                    model.setNome(cursor.getString(nameIndex));
                }

                if (passwordIndex >= 0) {
                    model.setSenha(cursor.getString(passwordIndex));
                }
            }
            cursor.close();
        }

        Close();

        return model;
    }


}
