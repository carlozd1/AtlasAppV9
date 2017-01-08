package com.example.carlos.atlasapp.sqlite;

import android.net.Uri;

import java.util.UUID;

/**
 * Created by Carlos on 14/11/2016.
 */

public class EstructuraBD {

    public static final String BASE_CONTENIDOS = "atlas.";

    public static final String TIPO_CONTENIDO = "vnd.android.cursor.dir/vnd."
            + BASE_CONTENIDOS;

    public static final String TIPO_CONTENIDO_ITEM = "vnd.android.cursor.item/vnd."
            + BASE_CONTENIDOS;

    public static String generarMime(String id) {
        if (id != null) {
            return TIPO_CONTENIDO + id;
        } else {
            return null;
        }
    }

    public static String generarMimeItem(String id) {
        if (id != null) {
            return TIPO_CONTENIDO_ITEM + id;
        } else {
            return null;
        }
    }

    interface ColumnasUsuario{
        String ID = "idusuario";
        String NOMBRE = "nombre";
        String EDAD = "edad";
        String TELEFONO = "telefono";
    }

    interface ColumnasPaciente{
        String NOMBRE = "nombre";
        String EDAD = "edad";
        String DIAGNOSTICO = "diagnostico";
        String TERAPEUTA = "terapeuta";
        String IDPACIENTE = "idpaciente";
    }

    interface ColumnasAvance{
        String PACIENTE = "paciente";
        String PORCENTAJE = "porcentaje";
        String NIVEL = "nivel";
        String PORTOTAL = "portotal";
    }

    interface ColumnasNivel{
        String IDNIVEL = "idnivel";
        String NOMBRE = "nombre";
        String VALOR = "valor";
    }

    public static class Usuarios implements ColumnasUsuario{
        public static String generarIdUsuario() {
            return "U-" + UUID.randomUUID().toString();
        }
        public static final Uri URI_CONTENIDO =
                    URI_BASE.buildUpon().appendPath(RUTA_USUARIOS).build();

        public static final String PARAMETRO_FILTRO = "filtro";

        public static String obtenerIdCabeceraPedido(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static Uri crearUriCabeceraPedido(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static Uri crearUriParaDetalles(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).appendPath("detalles").build();
        }

        public static boolean tieneFiltro(Uri uri) {
            return uri != null && uri.getQueryParameter(PARAMETRO_FILTRO) != null;
        }

    }

    public static class Pacientes implements ColumnasPaciente{
        public static String generarIdPaciente() {
            return "P-" + UUID.randomUUID().toString();
        }
        public static final Uri URI_CONTENIDO =
                URI_BASE.buildUpon().appendPath(RUTA_PACIENTES).build();

        public static Uri crearUriDetallePaciente(String id, String secuencia) {
            // Uri de la forma 'detalles_pcaiente/:id#:secuencia'
            return URI_CONTENIDO.buildUpon()
                    .appendPath(String.format("%s#%s", id, secuencia))
                    .build();
        }

        public static String[] obtenerIdDetalle(Uri uri) {
            return uri.getLastPathSegment().split("#");
        }
    }
    public static class DetallesPacientes implements ColumnasPaciente{
        //Metodos extra
    }

    public static class Nivel implements ColumnasNivel{
        public static String generarIdNivel() {
            return "N-" + UUID.randomUUID().toString();
        }
    }

    public static class Avance implements ColumnasAvance{

    }

    private EstructuraBD(){

    }

    public static final String AUTORIDAD_CONTENIDO = "com.example.carlos.atlasapp";

    public static final Uri URI_BASE = Uri.parse("content://" + AUTORIDAD_CONTENIDO);

    private static final String RUTA_USUARIOS = "usuario";
    private static final String RUTA_PACIENTES = "paciente";
    private static final String RUTA_NIVEL = "nivel";
    private static final String RUTA_AVANCE = "avance";


}
