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

import com.uniftec.petmatchprojeto.Interfaces.Usuario;
import com.uniftec.petmatchprojeto.Models.Animal;
import com.uniftec.petmatchprojeto.Models.AnimalFavorito;
import com.uniftec.petmatchprojeto.Models.UsuarioONG;
import com.uniftec.petmatchprojeto.Uteis.DataBaseUtil;

public class AnimalRepository {
    private SQLiteDatabase db;

    public AnimalRepository(Context context) {
        DataBaseUtil dbHelper = new DataBaseUtil(context);
        db = dbHelper.getWritableDatabase();
    }

    public long favorite(Integer userId, Integer animalId) {
        ContentValues values = new ContentValues();
        values.put("idAnimal", animalId);
        values.put("idUsuario", userId);
        return db.insert("favoritos", null, values);
    }

    public long insert(Animal animal) {
        ContentValues values = new ContentValues();
        values.put("raca", animal.getRaca());
        values.put("cor", animal.getCor());
        values.put("porte", animal.getPorte());
        values.put("idade", animal.getIdade());
        return db.insert("animals", null, values);
    }

    public List<AnimalFavorito> getFavoritos(Integer userId) {
        List<AnimalFavorito> animais = new ArrayList<>();
        String[] columns = { "idAnimal"};
        String selection = "idUsuario = ?";
        String[] selectionArgs = {String.valueOf(userId)};
        Cursor cursor = db.query("favoritos", columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int idAnimal = 0;
                String cor = "";
                String raca = "";
                int idade = 0;
                int imagemResourceId = 0;

                int columnIndex = cursor.getColumnIndex("cor");
                if (columnIndex >= 0){
                    idAnimal = cursor.getInt(columnIndex);
                }

                String[] columnsAnimals = { "cor", "raca", "idade"};
                String selectionAnimals = "id = ?";
                String[] selectionArgsAnimals = {String.valueOf(idAnimal)};
                Cursor cursorAnimal = db.query("animals", columnsAnimals, selectionAnimals, selectionArgsAnimals, null, null, null);


                // Consulta para obter os detalhes do animal usando o idAnimal
              //  Cursor cursorAnimal = db.query("animals",
               //         new String[]{"cor", "raca", "idade", "imagemResourceId"},
               //         "id = ?",
                //        new String[]{String.valueOf(idAnimal)},
                 //       null, null, null);

                // Verificar se encontrou o animal
                if (cursorAnimal.moveToFirst()) {
                    columnIndex = cursorAnimal.getColumnIndex("cor");
                    if (columnIndex >= 0) {
                         cor = cursorAnimal.getString(columnIndex);
                    }
                    columnIndex = cursorAnimal.getColumnIndex("raca");
                    if (columnIndex >= 0) {
                         raca = cursorAnimal.getString(columnIndex);
                    }
                    columnIndex = cursorAnimal.getColumnIndex("idade");
                    if (columnIndex >= 0) {
                         idade = cursorAnimal.getInt(columnIndex);
                    }
                    columnIndex = cursorAnimal.getColumnIndex("imagemResourceId");
                    if (columnIndex >= 0) {
                         imagemResourceId = cursorAnimal.getInt(columnIndex);
                    }

                    // Criar um objeto AnimalFavorito com os dados obtidos
                    AnimalFavorito animalFavorito = new AnimalFavorito(cor, raca, idade, imagemResourceId);
                    animais.add(animalFavorito);
                }

                cursorAnimal.close(); // Fechar o cursor do animal após o uso

            } while (cursor.moveToNext());
        }

        cursor.close(); // Fechar o cursor de favoritos após o uso
        db.close(); // Fechar o banco de dados após o uso

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
                    cursor.getInt(cursor.getColumnIndexOrThrow("idade")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("imagemResourceId"))
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