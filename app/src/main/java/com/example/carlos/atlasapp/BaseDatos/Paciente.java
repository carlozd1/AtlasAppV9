package com.example.carlos.atlasapp.BaseDatos;

/**
 * Created by Carlos on 15/11/2016.
 */

public class Paciente {
    private String id;
    private String nombre;
    private String edad;
    private String diagnostico;
    private String terapeuta;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTerapeuta() {
        return terapeuta;
    }

    public void setTerapeuta(String terapeuta) {
        this.terapeuta = terapeuta;
    }



}
