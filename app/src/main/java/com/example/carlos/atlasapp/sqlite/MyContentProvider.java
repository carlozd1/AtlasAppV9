package com.example.carlos.atlasapp.sqlite;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    private BaseDatosAtlas bd;

    private ContentResolver resolver;

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        switch (uriMatcher.match(uri)) {
            case USUARIOS:
                return EstructuraBD.generarMime("usuarios");
            case USUARIOS_ID:
                return EstructuraBD.generarMimeItem("usuariosid");
            case PACIENTES:
                return EstructuraBD.generarMime("pacientes");
            case PACIENTES_ID:
                return EstructuraBD.generarMimeItem("pacientesid");
            case NIVEL:
                return EstructuraBD.generarMime("nivel");
            case NIVEL_ID:
                return EstructuraBD.generarMimeItem("nivelid");
            case AVANCE:
                return EstructuraBD.generarMime("avance");
            default:
                throw new UnsupportedOperationException("Uri desconocida =>" + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static final UriMatcher uriMatcher;

    // Casos
    public static final int USUARIOS = 100;
    public static final int USUARIOS_ID = 101;
    public static final int CABECERAS_ID_DETALLES = 102;

    public static final int PACIENTES = 200;
    public static final int PACIENTES_ID = 201;

    public static final int NIVEL = 300;
    public static final int NIVEL_ID = 301;

    public static final int AVANCE = 400;

    public static final String AUTORIDAD = "com.example.carlos.atlasapp";

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(AUTORIDAD, "usuarios", USUARIOS);
        uriMatcher.addURI(AUTORIDAD, "usuariosid/*", USUARIOS_ID);

        uriMatcher.addURI(AUTORIDAD, "pacientes", PACIENTES);
        uriMatcher.addURI(AUTORIDAD, "pacientesid/*", PACIENTES_ID);

        uriMatcher.addURI(AUTORIDAD, "nivel", NIVEL);
        uriMatcher.addURI(AUTORIDAD, "nivelid/*", NIVEL_ID);

        uriMatcher.addURI(AUTORIDAD, "avance", AVANCE);
    }

}
