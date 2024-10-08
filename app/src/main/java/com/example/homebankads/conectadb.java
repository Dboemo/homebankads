package com.example.homebankads;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class conectadb extends SQLiteOpenHelper {

    String tab_usr = "CREATE TABLE IF NOT EXISTS usuario (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "login TEXT," +
            "senha TEXT, " +
            "saldo NUMERIC)";
    String tab_mov ="CREATE TABLE IF NOT EXISTS movimento (" +
            "idmov INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "idusr INTEGER ," +
            "tipo_opera TEXT ," +
            "valor NUMERIC ," +
            "destino TEXT  ," +
            "dataopera DATE )";

    conectadb(Context contexto) {

        super(contexto, "homebankdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(tab_usr);
        sqLiteDatabase.execSQL(tab_mov);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String RECRIA = "DROP TABLE IF EXISTS usuario";
        String RECRIA2 = "DROP TABLE IF EXISTS movimento";
        sqLiteDatabase.execSQL(RECRIA);
        sqLiteDatabase.execSQL(RECRIA2);
        onCreate(sqLiteDatabase);
    }
}
