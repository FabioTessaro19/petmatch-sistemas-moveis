package com.uniftec.petmatchprojeto.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.uniftec.petmatchprojeto.Interfaces.Usuario;
import com.uniftec.petmatchprojeto.Models.Animal;
import com.uniftec.petmatchprojeto.Models.UsuarioNormal;
import com.uniftec.petmatchprojeto.Models.UsuarioONG;
import com.uniftec.petmatchprojeto.Uteis.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private SQLiteDatabase db;

    public UsuarioRepository(Context context ) {
        DataBaseUtil dbHelper = new DataBaseUtil(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insertNormal(UsuarioNormal usuarioNormal) {
        ContentValues values = new ContentValues();
        values.put("nomeCompleto", usuarioNormal.getNome());
        values.put("email", usuarioNormal.getEmail());
        values.put("senha", usuarioNormal.getSenha());
        values.put("cep", usuarioNormal.getCep());
        return db.insert("usuariosNormal", null, values);
    }

    public long insertOng(UsuarioONG usuarioONG) {
        ContentValues values = new ContentValues();
        values.put("nomeCompleto", usuarioONG.getNome());
        values.put("email", usuarioONG.getEmail());
        values.put("senha", usuarioONG.getSenha());
        values.put("cep", usuarioONG.getCep());
        values.put("cpfCnpj", usuarioONG.getCpfCnpj());
        return db.insert("usuariosOng", null, values);
    }

    public Boolean getByLogin (String email, String password) {
        Usuario usuarioNormal = null;
        UsuarioONG usuarioOng = null;
        String[] columns = {"id", "nomeCompleto", "email", "senha", "cep"};
        String selection = "email = ? and senha = ?";
        String[] selectionArgs = {String.valueOf(email), (password)};
        Cursor cursor = db.query("usuariosNormal", columns, selection, selectionArgs,  null, null, null);
        Cursor cursorOng = db.query("usuariosONG", columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            usuarioNormal = new UsuarioNormal(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("nomeCompleto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("email")),
                    cursor.getString(cursor.getColumnIndexOrThrow("senha")),
                    cursor.getString(cursor.getColumnIndexOrThrow("cep"))
            );
            return true;
        }
        else if (cursorOng.moveToFirst()){
            usuarioOng = new UsuarioONG(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("nomeCompleto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("email")),
                    cursor.getString(cursor.getColumnIndexOrThrow("senha")),
                    cursor.getString(cursor.getColumnIndexOrThrow("cep")),
                    cursor.getString(cursor.getColumnIndexOrThrow("cpfCnpj"))
            );
            return true;
        }
        return false;
    }

    public int update(Animal animal) {
        ContentValues values = new ContentValues();
        values.put("raca", animal.getRaca());
        values.put("cor", animal.getCor());
        values.put("porte", animal.getPorte());
        values.put("idade", animal.getIdade());
        String where = "id = ?";
        String[] whereArgs = {String.valueOf(animal.getId())};
        return db.update("animals", values, where, whereArgs);
    }

    public int delete(int id) {
        String where = "id = ?";
        String[] whereArgs = {String.valueOf(id)};
        return db.delete("animals", where, whereArgs);
    }

}