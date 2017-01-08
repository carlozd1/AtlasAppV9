package com.example.carlos.atlasapp.Modelo;

/**
 * Created by Carlos on 15/11/2016.
 */

public class DetallePaciente {

    public String idPaciente;

    public String Nombre;

    public String Edad;

    public String Diagnostico;

    public String Terapeuta;


    public DetallePaciente(String idPaciente, String Nombre,
                          String Edad, String Diagnostico, String Terapeuta) {
        this.idPaciente = idPaciente;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Diagnostico = Diagnostico;
        this.Terapeuta = Terapeuta;
    }

}
