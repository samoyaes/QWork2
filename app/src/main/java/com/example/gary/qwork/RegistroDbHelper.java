package com.example.gary.qwork;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gary.qwork.RegistroContract.RegistroEntry;


/**
 * Created by osori on 02/07/2017.
 */

public class RegistroDbHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProyectoIng.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + RegistroEntry.TABLE_NAME + " ("
                    + RegistroEntry.matricula + " INTEGER PRIMARY KEY, "
                    + RegistroEntry.nombre + " TEXT, "
                    + RegistroEntry.email + " TEXT, "
                    + RegistroEntry.password + " TEXT, "
                    + RegistroEntry.rol + " TEXT )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + RegistroEntry.TABLE_NAME;

    public RegistroDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","DATABASE CONSTRUCTOR");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.e("DATABASE OPERATIONS","TABLA CREADA");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);

        db.execSQL(SQL_CREATE_ENTRIES);
    }

}
