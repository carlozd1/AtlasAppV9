package com.example.carlos.atlasapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;
import android.telecom.PhoneAccount;

import com.example.carlos.atlasapp.sqlite.EstructuraBD.*;

public class BaseDatosAtlas extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "atlas.db";
    private static final int VERSION_ACTUAL = 1;
    private final Context contexto;

    interface Tablas {
        String Usuario = "usuario";
        String Paciente = "paciente";
        String Nivel = "nivel";
        String Avance = "avance";
    }
    interface Referencias {
        String ID_USUARIO = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
               Tablas.Usuario, Usuarios.ID);
        String ID_PACIENTE = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.Paciente, Pacientes.IDPACIENTE);
        String ID_NIVEL = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.Nivel, Nivel.IDNIVEL);
    }

    public BaseDatosAtlas(Context contexto) {
        super(contexto, NOMBRE_BD,null, VERSION_ACTUAL);
        this.contexto = contexto;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT UNIQUE NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL )",
                Tablas.Usuario, BaseColumns._ID,
                Usuarios.ID, Usuarios.NOMBRE,
                Usuarios.EDAD, Usuarios.TELEFONO));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT UNIQUE NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL %s )",
                Tablas.Paciente, BaseColumns._ID,
                Pacientes.IDPACIENTE, Pacientes.NOMBRE,
                Pacientes.EDAD, Pacientes.DIAGNOSTICO,
                Pacientes.IDPACIENTE, Pacientes.TERAPEUTA, Referencias.ID_USUARIO));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT UNIQUE NOT NULL,%s TEXT NOT NULL,%s INTEGER NOT NULL)",
                Tablas.Nivel, BaseColumns._ID,
                Nivel.IDNIVEL, Nivel.NOMBRE,
                Nivel.VALOR));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL %s," +
                        "%s TEXT  NOT NULL,%s TEXT NOT NULL %s , %s TEXT NOT NULL)",
                Tablas.Avance, Avance.PACIENTE, Referencias.ID_PACIENTE, Avance.PORCENTAJE,
                Avance.NIVEL, Referencias.ID_NIVEL , Avance.PORTOTAL));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.Usuario);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.Paciente);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.Nivel);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.Avance);
        onCreate(db);

    }
}
