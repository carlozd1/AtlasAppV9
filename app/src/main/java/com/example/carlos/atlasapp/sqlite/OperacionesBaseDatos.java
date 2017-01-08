package com.example.carlos.atlasapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.carlos.atlasapp.Modelo.DetalleUsuario;
import com.example.carlos.atlasapp.Modelo.DetallePaciente;
import com.example.carlos.atlasapp.sqlite.BaseDatosAtlas.Tablas;


public class OperacionesBaseDatos {

    private static BaseDatosAtlas baseDatos;

    private static OperacionesBaseDatos instancia = new OperacionesBaseDatos();

    private OperacionesBaseDatos() {
    }

    public static OperacionesBaseDatos obtenerInstancia(Context contexto) {
        if (baseDatos == null) {
            baseDatos = new BaseDatosAtlas(contexto);
        }
        return instancia;
    }

    public Cursor obtenerUsuarios() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();

     //   builder.setTables(CABECERA_PEDIDO_JOIN_CLIENTE_Y_FORMA_PAGO);

        builder.setTables(Usuarios);

        return builder.query(db, proyUsuarios, null, null, null, null, null);
    }

    private static final String Usuarios = "SELECT * FROM usuario";

   /* private static final String CABECERA_PEDIDO_JOIN_CLIENTE_Y_FORMA_PAGO = "cabecera_pedido " +
            "INNER JOIN cliente " +
            "ON cabecera_pedido.id_cliente = cliente.id " +
            "INNER JOIN forma_pago " +
            "ON cabecera_pedido.id_forma_pago = forma_pago.id"; */


    private final String[] proyUsuarios = new String[]{
            Tablas.Usuario + "." + EstructuraBD.Usuarios.ID,
            EstructuraBD.Usuarios.NOMBRE,
            EstructuraBD.Usuarios.EDAD,
            EstructuraBD.Usuarios.TELEFONO};

    public String insertarUsuario(DetalleUsuario usuarios) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        // Generar Pk
        String idUsuario = EstructuraBD.Usuarios.generarIdUsuario();

        ContentValues valores = new ContentValues();
        valores.put(EstructuraBD.Usuarios.ID, idUsuario);
        valores.put(EstructuraBD.Usuarios.NOMBRE, usuarios.Nombre);
        valores.put(EstructuraBD.Usuarios.EDAD, usuarios.Edad);
        valores.put(EstructuraBD.Usuarios.TELEFONO, usuarios.Telefono);

        // Insertar cabecera
        db.insertOrThrow(Tablas.Usuario, null, valores);

        return idUsuario;
    }



    public boolean actualizarUsuario(DetalleUsuario usuarioNuevo) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(EstructuraBD.Usuarios.NOMBRE, usuarioNuevo.Nombre);
        valores.put(EstructuraBD.Usuarios.EDAD, usuarioNuevo.Edad);
        valores.put(EstructuraBD.Usuarios.TELEFONO, usuarioNuevo.Telefono);

        String whereClause = String.format("%s=?", EstructuraBD.Usuarios.ID);
        String[] whereArgs = {usuarioNuevo.idUsuario};

        int resultado = db.update(Tablas.Usuario, valores, whereClause, whereArgs);

        return resultado > 0;
    }

    public boolean eliminarUsuario(String idUsuario) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String whereClause = EstructuraBD.Usuarios.ID + "=?";
        String[] whereArgs = {idUsuario};

        int resultado = db.delete(Tablas.Usuario, whereClause, whereArgs);

        return resultado > 0;
    }
 // Operaciones Pacientes
    public Cursor obtenerPacientes() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = String.format("SELECT * FROM %s", Tablas.Paciente);

        return db.rawQuery(sql, null);
    }

    public String insertarPaciente(DetallePaciente paciente) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        // Generar Pk
        String idPaciente = EstructuraBD.Pacientes.generarIdPaciente();

        ContentValues valores = new ContentValues();
        valores.put(EstructuraBD.Pacientes.NOMBRE, paciente.Nombre);
        valores.put(EstructuraBD.Pacientes.EDAD, paciente.Edad);
        valores.put(EstructuraBD.Pacientes.DIAGNOSTICO, paciente.Diagnostico);
        valores.put(EstructuraBD.Pacientes.TERAPEUTA, paciente.Terapeuta);
        valores.put(EstructuraBD.Pacientes.IDPACIENTE,idPaciente);

        return db.insertOrThrow(Tablas.Paciente, null, valores) > 0 ? idPaciente : null;
    }

    public boolean actualizarPaciente(DetallePaciente paciente) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(EstructuraBD.Pacientes.NOMBRE, paciente.Nombre);
        valores.put(EstructuraBD.Pacientes.EDAD, paciente.Edad);
        valores.put(EstructuraBD.Pacientes.DIAGNOSTICO, paciente.Diagnostico);
        valores.put(EstructuraBD.Pacientes.TERAPEUTA, paciente.Terapeuta);

        String whereClause = String.format("%s=?", EstructuraBD.Pacientes.IDPACIENTE);
        final String[] whereArgs = {paciente.idPaciente};

        int resultado = db.update(Tablas.Paciente, valores, whereClause, whereArgs);

        return resultado > 0;
    }

    public boolean eliminarPaciente(String idPaciente) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String whereClause = String.format("%s=?", EstructuraBD.Pacientes.IDPACIENTE);
        final String[] whereArgs = {idPaciente};

        int resultado = db.delete(Tablas.Paciente, whereClause, whereArgs);

        return resultado > 0;
    }


    public SQLiteDatabase getDb() {
        return baseDatos.getWritableDatabase();
    }
}
