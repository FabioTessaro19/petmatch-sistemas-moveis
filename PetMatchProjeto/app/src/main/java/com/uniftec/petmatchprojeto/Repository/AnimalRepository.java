package com.uniftec.petmatchprojeto.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.uniftec.petmatchprojeto.Models.Animal;
import com.uniftec.petmatchprojeto.Uteis.DataBaseUtil;

public class AnimalRepository {
    private SQLiteDatabase db;

    public AnimalRepository(Context context) {
        DataBaseUtil dbHelper = new DataBaseUtil(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(Animal animal) {
        ContentValues values = new ContentValues();
        values.put("raca", animal.getRaca());
        values.put("cor", animal.getCor());
        values.put("porte", animal.getPorte());
        values.put("idade", animal.getIdade());
        return db.insert("animals", null, values);
    }

    public List<Animal> getAll() {
        List<Animal> animais = new ArrayList<>();
        String[] columns = {"id", "raca", "cor", "porte", "idade"};
        Cursor cursor = db.query("animals", columns, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Animal animal = new Animal(
                        cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                        cursor.getString(cursor.getColumnIndexOrThrow("raca")),
                        cursor.getString(cursor.getColumnIndexOrThrow("cor")),
                        cursor.getString(cursor.getColumnIndexOrThrow("porte")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("idade"))
                );
                animais.add(animal);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return animais;
    }

    public Animal getById(int id) {
        Animal animal = null;
        String[] columns = {"id", "raca", "cor", "porte", "idade"};
        String selection = "id = ?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = db.query("animals", columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            animal = new Animal(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("raca")),
                    cursor.getString(cursor.getColumnIndexOrThrow("cor")),
                    cursor.getString(cursor.getColumnIndexOrThrow("porte")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idade"))
            );
        }
        cursor.close();
        return animal;
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