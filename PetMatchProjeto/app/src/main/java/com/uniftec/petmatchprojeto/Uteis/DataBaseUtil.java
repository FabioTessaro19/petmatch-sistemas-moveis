package com.uniftec.petmatchprojeto.Uteis;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.uniftec.petmatchprojeto.HomeFragment;
import com.uniftec.petmatchprojeto.Models.Animal;
import com.uniftec.petmatchprojeto.Models.UsuarioNormal;
import com.uniftec.petmatchprojeto.Models.UsuarioONG;
import com.uniftec.petmatchprojeto.R;



public class DataBaseUtil extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "animals_list.db";
    private static final int DATABASE_VERSION = 1;


    public DataBaseUtil(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DataBaseUtil", "onCreate: Creating database");

        String createTableAnimals = "CREATE TABLE animals (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "raca TEXT," +
                "cor TEXT," +
                "porte TEXT," +
                "idade INTEGER," +
                "imagemResourceId INTEGER)";
        db.execSQL(createTableAnimals);

        String createTableFavoritos = "CREATE TABLE favoritos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idAnimal INTEGER," +
                "idUsuario INTEGER," +
                "FOREIGN KEY (id_usuario) REFERENCES usuarios (id)," +
                "FOREIGN KEY (id_animal) REFERENCES animais (id))";
        db.execSQL(createTableFavoritos);


        String createTableUsuarios = "CREATE TABLE usuariosNormal (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeCompleto TEXT," +
                "email TEXT," +
                "senha TEXT," +
                "cep TEXT)";
        db.execSQL(createTableUsuarios);


        String createTableUsuariosOng = "CREATE TABLE usuariosOng (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeCompleto TEXT," +
                "email TEXT," +
                "senha TEXT," +
                "cep TEXT," +
                "cpfCnpj TEXT)";
        db.execSQL(createTableUsuariosOng);

        // Inserir produtos padrão
        insertDefaultAnimals(db);
        insertDefaultUsers(db);
        insertDefaultFavoritos(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS animals");
        db.execSQL("DROP TABLE IF EXISTS favoritos");
        db.execSQL("DROP TABLE IF EXISTS usuariosNormal");
        db.execSQL("DROP TABLE IF EXISTS usuariosOng");
        onCreate(db);
    }

    private void insertDefaultAnimals(SQLiteDatabase db) {

        insertAnimal(
                db,
                new Animal(
                1,
                "gato",
                "preto",
                "pequeno",
                1,
                R.drawable.gato_tcc));

        insertAnimal(
                db,
                new Animal(
                        2,
                        "gato",
                        "branco",
                        "pequeno",
                        2,
                R.drawable.gato_tres));

        insertAnimal(
                db,
                new Animal(
                        3,
                        "cachorro",
                        "branco",
                        "pequeno",
                        1,
                R.drawable.cachorro_tres_app));

        insertAnimal(
                db,
                new Animal(
                        4,
                        "cachorro",
                        "preto",
                        "pequeno",
                        2,
                R.drawable.cachrro_app));


        insertAnimal(
                db,
                new Animal(
                        5,
                        "cachorro",
                        "mesclado",
                        "pequeno",
                        1,
                R.drawable.cachorro_dois_app));


        insertAnimal(
                db,
                new Animal(
                        6,
                        "gato",
                        "cinza",
                        "pequeno",
                        1,
                R.drawable.gato_doisi));

        insertAnimal(
                db,
                new Animal(
                        7,
                        "gato",
                        "laranja",
                        "pequeno",
                        1,
                R.drawable.gato_quatro));

        Log.d("DataBaseUtil", "valores padrão inseridos");
    }

    private void insertAnimal(SQLiteDatabase db, Animal animal) {
        Log.d("DataBaseUtil", "insertAnimal: Inserting animal - " + animal.getRaca() + " - " + animal.getCor() + ")");
        ContentValues values = new ContentValues();
        values.put("raca", animal.getRaca());
        values.put("cor", animal.getCor());
        values.put("porte", animal.getPorte());
        values.put("idade", animal.getIdade());
        values.put("imagemResourceId", animal.getImagemResourceId());
        db.insert("animals", null, values);
    }

    private void insertDefaultUsers(SQLiteDatabase db) {

        insertUser(
                db,
                new UsuarioNormal(
                        1,
                        "Joao",
                        "joao@email.com",
                        "joao",
                        "10")
        ,       new UsuarioONG(
                        1,
                        "Instituicao",
                        "instituicao@email.com",
                        "abc",
                        "20",
                        "999")
        );


        Log.d("DataBaseUtil", "valores padrão inseridos");
    }

    private void insertUser(SQLiteDatabase db, UsuarioNormal usuarioNormal, UsuarioONG usuarioOng) {
        ContentValues values = new ContentValues();
        Log.d("DataBaseUtil", "insertUser: Inserting users - ");

        values.put("nomeCompleto", usuarioNormal.getNome());
        values.put("email", usuarioNormal.getEmail());
        values.put("senha", usuarioNormal.getSenha());
        values.put("cep", usuarioNormal.getCep());
        db.insert("usuariosNormal", null, values);

        values.put("nomeCompleto", usuarioOng.getNome());
        values.put("email", usuarioOng.getEmail());
        values.put("senha", usuarioOng.getSenha());
        values.put("cep", usuarioOng.getCep());
        values.put("cpfCnpj", usuarioOng.getCpfCnpj());
        db.insert("usuariosOng", null, values);
    }

    private void insertDefaultFavoritos(SQLiteDatabase db) {

        insertFavoritos(
                db,
               1,
                1
        );


        insertFavoritos(
                db,
                1,
                2
        );


        Log.d("DataBaseUtil", "valores padrão inseridos");
    }

    private void insertFavoritos(SQLiteDatabase db, Integer userId, Integer animalId)
    {
        ContentValues values = new ContentValues();
        Log.d("DataBaseUtil", "insertFavorito: Inserting favoritos - ");
        values.put("idUsuario", userId);
        values.put("idAnimal", animalId);
        db.insert("favoritos", null, values);
    }

}