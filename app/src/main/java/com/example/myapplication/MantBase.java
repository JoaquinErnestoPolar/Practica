package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MantBase extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="mantbase.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_CURSO="CREATE TABLE CURSO(CODIGO TEXT PRIMARY KEY, CURSO TEXT, CARRERA TEXT)";

    public MantBase(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CURSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_CURSO);
        sqLiteDatabase.execSQL(TABLA_CURSO);
    }

    public void agregarCursos(String codigo,String curso,String carrera){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO CURSOS VALUES('"+codigo+"','"+curso+"','"+carrera+"')");
            bd.close();
        }
    }
}
