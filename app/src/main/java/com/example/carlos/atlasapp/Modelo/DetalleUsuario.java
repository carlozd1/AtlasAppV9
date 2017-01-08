package com.example.carlos.atlasapp.Modelo;

/**
 * Created by Carlos on 15/11/2016.
 */

public class DetalleUsuario {

    public String idUsuario;

    public String Nombre;

    public String Edad;

    public String Telefono;

    public DetalleUsuario(String idUsuario, String Nombre,
                         String Edad, String Telefono) {
        this.idUsuario = idUsuario;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Telefono = Telefono;
    }
}
