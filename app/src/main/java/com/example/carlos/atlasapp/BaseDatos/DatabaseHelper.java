package com.example.carlos.atlasapp.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.Contact;
import com.example.carlos.atlasapp.Modelo.DetalleUsuario;

import static android.content.ContentValues.TAG;


/**
 * Created by Carlos on 06/11/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "prueba6.db";

    public static final String TABLE_NAME = "usuarios";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_USER = "usuario";
    public static final String COLUMN_PASS = "pass";

    public static final String TABLE_PACIENTE = "paciente";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_AP = "apellido";
    public static final String COLUMN_EDAD = "edad";
    public static final String COLUMN_DIAG = "diagnostico";
    public static final String COLUMN_PID= "_id";
    public static final String COLUMN_TERA = "terapeuta";

    public static final String TABLE_NIVEL = "nivel";
    public static final String NIVEL_ID = "idnivel";
    public static final String NIVEL_VALOR = "valortotal";

    public static final String TABLE_AVANCE = "avance";
    public static final String AVANCE_PACIENTE = "paciente";
    public static final String AVANCE_PORCENTAJE = "porcentaje";
    public static final String AVANCE_NIVEL = "nivel";
    public static final String AVANCE_TOTAL = "portotal";

    public static final String TABLE_PALABRA= "palabra";
    public static final String PALABRA_ID= "idpalabra";
    public static final String PALABRA_IDPACIENTE= "idpacinte";
    public static final String PALABRA_IDNIVEL= "idnivel";
    public static final String PALABRA_NUMERO= "numero";
    public static final String PALABRA_BIENMAL= "bienmal";

    public String[] columnas = new String[]{  COLUMN_PID , COLUMN_NOMBRE, COLUMN_AP, COLUMN_EDAD, COLUMN_DIAG, COLUMN_TERA} ;

    SQLiteDatabase db;

    private final String TABLE_CREATE = "CREATE TABLE usuarios (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , " +
            "name text not null, usuario text not null, pass text not null);";

    private final String PACIENTE_CREATE = "CREATE TABLE paciente ( _id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT,apellido TEXT, edad INTEGER, diagnostico TEXT, " +
            "terapeuta INTEGER REFERENCES usuarios (id));";

    private final String NIVEL_CREATE = "CREATE TABLE nivel (idnivel INTEGER PRIMARY KEY NOT NULL, valortotal INTEGER);";

    private final String AVANCE_CREATE = "CREATE TABLE avance (paciente INTEGER REFERENCES paciente (idpaciente)," +
            " porcentaje DOUBLE, nivel INTEGER REFERENCES nivel (idnivel), portotal INTEGER);";

    private final String PALABRA_CREATE = "CREATE TABLE palabra (" +
            "idpaciente INTEGER REFERENCES paciente (_id),idnivel INTEGER REFERENCES nivel(idnivel), numero INTEGER, bienmal INTEGER);";
    //    "SELECT idpaciente,bienmal FROM palabra WHERE idpaciente ="+valorPaciente+" AND idnivel = 1AND numero ="+valor,null


    private final String NIVELES = "INSERT INTO nivel VALUES " +
            "(1, 10)," +"(2, 10)," +"(3, 20)," +
            "(4, 20)," +"(5, 20)," +"(6, 20);";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(PACIENTE_CREATE);
        db.execSQL(AVANCE_CREATE);
        db.execSQL(NIVEL_CREATE);
        db.execSQL(PALABRA_CREATE);
        db.execSQL(NIVELES);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query1 = "DROP TABLE IF EXISTS"+ TABLE_NAME;
        String query2 = "DROP TABLE IF EXISTS"+ TABLE_PACIENTE;
        String query3 = "DROP TABLE IF EXISTS"+ TABLE_AVANCE;
        String query4 = "DROP TABLE IF EXISTS"+ TABLE_NIVEL;
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        this.onCreate(db);
    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
/*
        String query = "Select _id from usuarios order by id";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        if (cursor.moveToFirst()) {

            do {
                count = cursor.getInt(0)+1;
            } while(cursor.moveToNext());
        }
*/
        //values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_USER, c.getUsuario());
        values.put(COLUMN_PASS, c.getPass());
        db.insert(TABLE_NAME, null , values);

        db.close();
    }

    public void insertarPaciente(Contact paciente, int usuario) {

        db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

      /*  String query = "Select * from usuarios";
        Cursor cursor = db.rawQuery(query, null);

        String query2 = "Select _id from paciente order by _id";
        Cursor cursor2 = db.rawQuery(query2, null);

        int count = cursor.getCount();
        int count2 = 1;
        if (cursor2.moveToFirst()) {

            do {
                count2 = cursor2.getInt(0);
                count2 = cursor2.getInt(0)+1;
            } while(cursor2.moveToNext());
        } */

        valores.put(COLUMN_NOMBRE, paciente.getNombre());
        valores.put(COLUMN_AP, paciente.getApellido());
        valores.put(COLUMN_EDAD, paciente.getEdad());
        valores.put(COLUMN_DIAG, paciente.getDiagnostico());
        valores.put(COLUMN_TERA, usuario);
        //   valores.put(COLUMN_PID,count2);
        db.insert(TABLE_PACIENTE, null, valores);
        //     Log.d("Final",String.valueOf(count2));

    //     String id = String.valueOf(count2);
        String query = "Select _id from paciente";
        int id=0;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {

            do {
                id = cursor.getInt(0);
            } while(cursor.moveToNext());
        }


        String VALORES_PALABRA = "INSERT INTO palabra VALUES " +
                "("+id+",1,1,0), " + "("+id+",1,2,0)," +"("+id+",1,3,0)," + "("+id+",1,4,0)," + "("+id+",1,5,0)," +
                "("+id+",1,6,0), " + "("+id+",1,7,0)," +"("+id+",1,8,0)," + "("+id+",1,9,0)," + "("+id+",1,10,0)," +
                "("+id+",1,11,0), " + "("+id+",1,12,0)," +"("+id+",1,13,0)," + "("+id+",1,14,0)," + "("+id+",1,15,0)," +
                "("+id+",1,16,0), " + "("+id+",1,17,0)," +"("+id+",1,18,0)," + "("+id+",1,19,0)," + "("+id+",1,20,0)," +
                "("+id+",1,21,0), " + "("+id+",1,22,0)," +"("+id+",1,23,0)," + "("+id+",1,24,0)," + "("+id+",1,25,0)," +
                "("+id+",1,26,0), " + "("+id+",1,27,0)," +"("+id+",1,28,0)," + "("+id+",1,29,0)," + "("+id+",1,30,0)," +
                "("+id+",1,31,0), " + "("+id+",1,32,0)," +"("+id+",1,33,0)," + "("+id+",1,34,0)," + "("+id+",1,35,0)" +
                ";";
        String VALORES_PALABRA2 = "INSERT INTO palabra VALUES " +
                "("+id+",2,1,0), " + "("+id+",2,2,0)," +"("+id+",2,3,0)," + "("+id+",2,4,0)," + "("+id+",2,5,0)," +
                "("+id+",2,6,0), " + "("+id+",2,7,0)," +"("+id+",2,8,0)," + "("+id+",2,9,0)," + "("+id+",2,10,0)," +
                "("+id+",2,11,0), " + "("+id+",2,12,0)," +"("+id+",2,13,0);";
        //Cursor c3 = db.rawQuery(VALORES_PALABRA,null);

        String VALORES_PALABRA3 = "INSERT INTO palabra VALUES " +
                "("+id+",3,1,0), " + "("+id+",3,2,0)," +"("+id+",3,3,0)," + "("+id+",3,4,0)," + "("+id+",3,5,0)," +
                "("+id+",3,6,0), " + "("+id+",3,7,0)," +"("+id+",3,8,0)," + "("+id+",3,9,0)," + "("+id+",3,10,0)," +
                "("+id+",3,11,0), " + "("+id+",3,12,0)," +"("+id+",3,13,0)," + "("+id+",3,14,0)," + "("+id+",3,15,0)," +
                "("+id+",3,16,0), " + "("+id+",3,17,0)," +"("+id+",3,18,0)," + "("+id+",3,19,0)," + "("+id+",3,20,0)," +
                "("+id+",3,21,0), " + "("+id+",3,22,0)," +"("+id+",3,23,0)," + "("+id+",3,24,0)," + "("+id+",3,25,0)," +
                "("+id+",3,26,0), " + "("+id+",3,27,0)," +"("+id+",3,28,0)," + "("+id+",3,29,0)," + "("+id+",3,30,0)," +
                "("+id+",3,31,0), " + "("+id+",3,32,0)," +"("+id+",3,33,0)," + "("+id+",3,34,0)," + "("+id+",3,35,0)" +
                ";";

        db.execSQL(VALORES_PALABRA);
        db.execSQL(VALORES_PALABRA2);
        db.execSQL(VALORES_PALABRA3);
        Cursor c4 = db.rawQuery("SELECT numero FROM palabra WHERE idpaciente="+id,null);
        if (c4.moveToFirst()) {

            do {
                Log.e("R",c4.getString(0));
            } while(c4.moveToNext());
        }
        db.close();

    }

    public boolean actualizarUsuario(Contact paciente) {
        db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMN_ID, paciente.getId());
        valores.put(COLUMN_NAME, paciente.getName());
        valores.put(COLUMN_USER, paciente.getUsuario());
        valores.put(COLUMN_PASS, paciente.getPass());

        String whereClause = String.format("%s=?", COLUMN_ID);
        String[] whereArgs = {paciente.getId()};

        int resultado = db.update(TABLE_NAME, valores, whereClause, whereArgs);

        return resultado > 0;
    }

    public boolean actualizarPaciente(Contact paciente) {
        db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMN_NOMBRE, paciente.getNombre());
        valores.put(COLUMN_AP, paciente.getApellido());
        valores.put(COLUMN_EDAD, paciente.getEdad());
        valores.put(COLUMN_DIAG, paciente.getDiagnostico());
        valores.put(COLUMN_TERA, paciente.getTerapeuta());

        String whereClause = String.format("%s=?", COLUMN_PID);
        String[] whereArgs = {paciente.getId()};

        int resultado = db.update(TABLE_PACIENTE, valores, whereClause, whereArgs);

        db.close();
        return resultado > 0;
    }

    public Cursor obtenerPacientes() {
        db = this.getReadableDatabase();

        String sql = "SELECT * FROM paciente";

        return db.rawQuery(sql, null);
    }

    public int buscarPacienteEspecifico(String name, String ap, String diag) {
        db = this.getReadableDatabase();

        String sql = "SELECT * FROM paciente where nombre = "+name + "&& apellido = "+ap+" || diagnostico = "+diag;

        Cursor cursor=  db.rawQuery(sql, null);
        String strName, strAp, strDiag;
        if (cursor.moveToFirst())
        {
            do{
                strName = cursor.getString(0);
                String r= cursor.getColumnName(0);
                Log.e("Columna 0",r);



                if (strName.equals(name))
                {
                    strAp = cursor.getString(1);
                    if(strAp.equals(ap)){
                        if(diag.equals(cursor.getString(2))){
                            strDiag = cursor.getString(2);
                            return 1;
                        }
                    }
                    break;
                }
            }while(cursor.moveToNext());
        }
        return 0;
    }

    public String searchPass(String usuario)
    {
        db = this.getReadableDatabase();

        String query = "Select usuario, pass from usuarios";
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";
        if (cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                //String r= cursor.getColumnName(0);
                //Log.e("Columna 0",a);
                if (a.equals(usuario))
                {

                    b = cursor.getString(1);
                    String x = cursor.getColumnName(1);
                    //Log.e("Columna 1: ", x);
                    break;
                }
            }while(cursor.moveToNext());
        }
        db.close();
        return b;
    }

    public Cursor getCursor() throws SQLException
    {
        db = this.getReadableDatabase();
        Cursor c = db.query( true, TABLE_PACIENTE, columnas, null, null, null, null, null, null);
    //Cursor c = db.rawQuery("select * from paciente",null);
        return c;

    }

    public Cursor getCursorPaciente() throws SQLException
    {
        db = this.getReadableDatabase();
        Cursor c = db.query( true, TABLE_PACIENTE, columnas, null, null, null, null, null, null);
        //Cursor c = db.rawQuery("select * from paciente",null);
        return c;

    }

    public void VerificarPalabra(int nivel,int numero, int paciente){
        Log.d("Paciente",String.valueOf(paciente));
        Log.d("Nivel",String.valueOf(nivel));
        Log.d("Numero",String.valueOf(numero));
        String resultado = null;
        String valor = String.valueOf(numero);
        String valorPaciente = String.valueOf(paciente);
        String valorNivel = String.valueOf(nivel);
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT idpaciente,bienmal FROM palabra WHERE idpaciente ="+valorPaciente+" AND idnivel = "+valorNivel+" AND numero ="+valor,null,null);
        if (c.moveToFirst()) {

            do {
                valorPaciente = c.getString(0);
                resultado= c.getString(1);
                Log.e("La palabra esta en ",c.getString(1));
            } while(c.moveToNext());
        }

        int resul = Integer.parseInt(resultado);
        if (resul == 0)
        {
            ContentValues valores = new ContentValues();
            String[] args = new String[]{valorPaciente,valorNivel,valor};
            valores.put(PALABRA_IDNIVEL,valorNivel);
            valores.put(PALABRA_NUMERO,valor);
            valores.put(PALABRA_BIENMAL,"1");
            db.update(TABLE_PALABRA,valores,"idpaciente=? AND idnivel=? AND numero=? ",args);
            Log.e("prueba","la palabra esta en 0, Bien Hecho!");

        }else if (resul == 1){

            Log.e("prueba","la palabra ya estaba bien hecha");
        }
        db.close();

    }

    public void RestaurarA0(int nivel,int numero, int paciente){
        Log.d("Paciente",String.valueOf(paciente));
        Log.d("Numero",String.valueOf(numero));
        String valor = String.valueOf(numero);
        String valorPaciente = String.valueOf(paciente);
        String valorNivel = String.valueOf(nivel);

        db = this.getReadableDatabase();
        ContentValues valores = new ContentValues();

        String[] args = new String[]{valorPaciente,valorNivel,valor};

        valores.put(PALABRA_IDNIVEL,valorNivel);
        valores.put(PALABRA_NUMERO,valor);
        valores.put(PALABRA_BIENMAL,"0");
        db.update(TABLE_PALABRA,valores,"idpaciente=? AND idnivel=? AND numero=?",args);
        Log.e("prueba","Se reinicio la palabra");
        db.close();
    }

    public int GraficaN1(int nivel, int paciente){
        db = this.getReadableDatabase();
        String cuenta = "";
        String valorNivel = String.valueOf(nivel);
        String valorPaciente = String.valueOf(paciente);
        Cursor c = db.rawQuery("SELECT COUNT(bienmal) FROM palabra WHERE idpaciente="+valorPaciente+" AND idnivel="+valorNivel+" AND bienmal=1",null);
        if (c.moveToFirst()) {

            do {
                cuenta = c.getString(0);

            } while(c.moveToNext());
        }
        int resultado = Integer.parseInt(cuenta);

        int porcentaje = (resultado*100)/35;
        db.close();
        return porcentaje;

    }

    public int GraficaN2(int paciente){
        db = this.getReadableDatabase();
        String cuenta = "";
        String valorPaciente = String.valueOf(paciente);
        Cursor c = db.rawQuery("SELECT COUNT(bienmal) FROM palabra WHERE idpaciente="+valorPaciente+" AND idnivel=2 AND bienmal=1",null);
        if (c.moveToFirst()) {

            do {
                cuenta = c.getString(0);

            } while(c.moveToNext());
        }
        int resultado = Integer.parseInt(cuenta);

        int porcentaje = (resultado*100)/13;
        db.close();
        return porcentaje;

    }

    public String NIAprobado(int nivel, int paciente){
        db = this.getReadableDatabase();
        String cuenta = "";
        String valorNivel = String.valueOf(nivel);
        String valorPaciente = String.valueOf(paciente);
        Cursor c = db.rawQuery("SELECT COUNT(bienmal) FROM palabra WHERE idpaciente="+valorPaciente+" AND idnivel="+valorNivel+" AND bienmal=1",null);
        if (c.moveToFirst()) {

            do {
                cuenta = c.getString(0);

            } while(c.moveToNext());
        }
        db.close();
        return cuenta;

    }
    public String NAprobado( int paciente){
        db = this.getReadableDatabase();
        String cuenta = "";
        String valorPaciente = String.valueOf(paciente);
        Cursor c = db.rawQuery("SELECT COUNT(bienmal) FROM palabra WHERE idpaciente="+valorPaciente+" AND bienmal=1",null);
        if (c.moveToFirst()) {

            do {
                cuenta = c.getString(0);

            } while(c.moveToNext());
        }
        db.close();
        return cuenta;

    }

    public String NIFaltante(int nivel, int paciente){
        db = this.getReadableDatabase();
        String cuenta = "";
        String valorNivel = String.valueOf(nivel);
        String valorPaciente = String.valueOf(paciente);
        Cursor c = db.rawQuery("SELECT COUNT(bienmal) FROM palabra WHERE idpaciente="+valorPaciente+" AND idnivel="+valorNivel+" AND bienmal=0",null);
        if (c.moveToFirst()) {

            do {
                cuenta = c.getString(0);

            } while(c.moveToNext());
        }

        db.close();
        return cuenta;

    }




    public boolean eliminarPaciente(String idPaciente) {

        db = this.getWritableDatabase();
        String whereClause = COLUMN_PID + "=?";
        String[] whereArgs = {idPaciente};

        int resultado = db.delete(TABLE_PACIENTE, whereClause, whereArgs);

        return resultado > 0;
    }

}
