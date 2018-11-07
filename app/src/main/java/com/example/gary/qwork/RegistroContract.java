package com.example.gary.qwork;

import android.provider.BaseColumns;

/**
 * Created by osori on 02/07/2017.
 */

public final class RegistroContract {

    private RegistroContract(){}

    public static class RegistroEntry implements BaseColumns
    {
        public static final String TABLE_NAME="Registro";
        public static final String nombre= "nombre";
        public static final String matricula="matricula";
        public static final String email="email";
        public static final String password="password";
        public static final String rol = "rol";
    }
}
