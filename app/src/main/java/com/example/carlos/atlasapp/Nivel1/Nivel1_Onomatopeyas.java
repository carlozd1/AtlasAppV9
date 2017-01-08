package com.example.carlos.atlasapp.Nivel1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.carlos.atlasapp.R;

public class Nivel1_Onomatopeyas extends AppCompatActivity implements View.OnClickListener{

    int NumeroBoton=0;
    //Botones del menu principal
    Button bPollo, bCerdo;

    //Botones de onomatopeyas
    ImageButton oPollo, oCerdo, oTigre, oAbeja, oGallina, oGallo, oPerro, oGato, oLobo, oVaca, oBorrego, oElefante, oCaballo, oPato;
    ImageButton oTocarPuerta, oTomarAgua, oSilencio,oComer,oCantar,oBeso,oBostezo,oHablar,oDormir,oAplaudir;
    ImageButton oReloj,oCampana,oTeléfono;
    ImageButton oTren, oBicicleta, oMotocicleta, oCarro, oBarco, oTambor, oTrompeta;

    //Botones de control
    ImageButton bAtras, bAdelante;

    public void Nivel1_Onomatopeyas(){
        //No recibe nada
    }
    public void Nivel1_Onomatopeyas(int NumBtn){
        NumeroBoton = NumBtn;
    }
    public void setNumeroBoton(int NumBtn){
        NumeroBoton = NumBtn;
    }
    public int getNumeroBoton(){
        return NumeroBoton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1__onomatopeyas);

        //setContentView(R.layout.activity_nivel1_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bAdelante = (ImageButton) findViewById(R.id.obtn_Adelante);
        bAtras = (ImageButton) findViewById(R.id.obtn_Atras);

        bAdelante.setOnClickListener(this);
        bAtras.setOnClickListener(this);

        cargarBotones();
        Invisibilidad();

        //FONDO
        View someView = findViewById(R.id.content_nivel1_principal);
        View root = someView.getRootView();
        root.setBackgroundDrawable(getResources().getDrawable(R.drawable.granja));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    void cargarBotones(){
        oPollo = (ImageButton) findViewById(R.id.obtn_Pollo);
        oCerdo = (ImageButton) findViewById(R.id.obtn_Cerdo);
        oTigre = (ImageButton) findViewById(R.id.obtn_Tigre);
        oAbeja = (ImageButton) findViewById(R.id.obtn_Abeja);
        oGallina = (ImageButton) findViewById(R.id.obtn_Gallina);
        oGallo = (ImageButton) findViewById(R.id.obtn_Gallo);
        oPerro = (ImageButton) findViewById(R.id.obtn_Perro);
        oGato = (ImageButton) findViewById(R.id.obtn_Gato);
        oLobo = (ImageButton) findViewById(R.id.obtn_Lobo);
        oVaca = (ImageButton) findViewById(R.id.obtn_Vaca);
        oBorrego = (ImageButton) findViewById(R.id.obtn_Oveja);
        oElefante = (ImageButton) findViewById(R.id.obtn_Elefante);
        oCaballo = (ImageButton) findViewById(R.id.obtn_Caballo);
        oPato = (ImageButton) findViewById(R.id.obtn_Pato);

        oTocarPuerta = (ImageButton) findViewById(R.id.obtn_TocarPuerta);
        //oTomarAgua = (ImageButton) findViewById(R.id.obtn_);
        oSilencio = (ImageButton) findViewById(R.id.obtn_Silencio);
        oComer = (ImageButton) findViewById(R.id.obtn_Comer);
        oCantar = (ImageButton) findViewById(R.id.obtn_Cantar);
        oBeso = (ImageButton) findViewById(R.id.obtn_Besar);
        oBostezo = (ImageButton) findViewById(R.id.obtn_Bostezar);
        oHablar = (ImageButton) findViewById(R.id.obtn_HablarAlguien);
        oDormir = (ImageButton) findViewById(R.id.obtn_Dormir);
        oAplaudir = (ImageButton) findViewById(R.id.obtn_Aplaudir);

        oReloj = (ImageButton) findViewById(R.id.obtn_Reloj);
        oCampana = (ImageButton) findViewById(R.id.obtn_Campana);
        oTeléfono = (ImageButton) findViewById(R.id.obtn_Telefono);

        oTren = (ImageButton) findViewById(R.id.obtn_Tren);
        oBicicleta = (ImageButton) findViewById(R.id.obtn_Bicicleta);
        oMotocicleta = (ImageButton) findViewById(R.id.obtn_Motocicleta);
        oCarro = (ImageButton) findViewById(R.id.obtn_Carro);
        oBarco = (ImageButton) findViewById(R.id.obtn_Barco);
        oTambor = (ImageButton) findViewById(R.id.obtn_Tambor);
        oTrompeta = (ImageButton) findViewById(R.id.obtn_Trompeta);

        //
        oPollo.setOnClickListener(this);
        oCerdo.setOnClickListener(this);
        oTigre.setOnClickListener(this);
        oAbeja.setOnClickListener(this);
        oGallina.setOnClickListener(this);
        oGallo.setOnClickListener(this);
        oPerro.setOnClickListener(this);
        oGato.setOnClickListener(this);
        oLobo.setOnClickListener(this);
        oVaca.setOnClickListener(this);
        oBorrego.setOnClickListener(this);
        oElefante.setOnClickListener(this);
        oCaballo.setOnClickListener(this);
        oPato.setOnClickListener(this);

        oTocarPuerta.setOnClickListener(this);
        //oTomarAgua.setOnClickListener(this);
        oSilencio.setOnClickListener(this);
        oComer.setOnClickListener(this);
        oCantar.setOnClickListener(this);
        oBeso.setOnClickListener(this);
        oBostezo.setOnClickListener(this);
        oHablar.setOnClickListener(this);
        oDormir.setOnClickListener(this);
        oAplaudir.setOnClickListener(this);

        oReloj.setOnClickListener(this);
        oCampana.setOnClickListener(this);
        oTeléfono.setOnClickListener(this);

        oTren.setOnClickListener(this);
        oBicicleta.setOnClickListener(this);
        oMotocicleta.setOnClickListener(this);
        oCarro.setOnClickListener(this);
        oBarco.setOnClickListener(this);
        oTambor.setOnClickListener(this);
        oTrompeta.setOnClickListener(this);
    }

    void Invisibilidad(){
        oPollo.setVisibility(View.GONE); //1
        oCerdo.setVisibility(View.GONE); //2
        oTigre.setVisibility(View.GONE); //3
        oAbeja.setVisibility(View.GONE); //4
        oGallina.setVisibility(View.GONE); //5
        oGallo.setVisibility(View.GONE); //6
        oPerro.setVisibility(View.GONE); //7
        oGato.setVisibility(View.GONE); //8
        oLobo.setVisibility(View.GONE); //9
        oVaca.setVisibility(View.GONE); //10

        oBorrego.setVisibility(View.GONE); //11
        oElefante.setVisibility(View.GONE); //12
        oCaballo.setVisibility(View.GONE); //13
        oPato.setVisibility(View.GONE); //14
        oTocarPuerta.setVisibility(View.GONE); //15
        //oTomarAgua.setVisibility(View.GONE); //16
        oSilencio.setVisibility(View.GONE); //17
        oComer.setVisibility(View.GONE); //18
        oCantar.setVisibility(View.GONE); //19
        oBeso.setVisibility(View.GONE); //20

        oBostezo.setVisibility(View.GONE); //21
        oHablar.setVisibility(View.GONE); //22
        oDormir.setVisibility(View.GONE); //23
        oAplaudir.setVisibility(View.GONE); //24
        oReloj.setVisibility(View.GONE); //25
        oCampana.setVisibility(View.GONE); //26
        oTeléfono.setVisibility(View.GONE); //27
        oTren.setVisibility(View.GONE); //28
        oBicicleta.setVisibility(View.GONE); //29
        oMotocicleta.setVisibility(View.GONE); //30

        oCarro.setVisibility(View.GONE); //31
        oBarco.setVisibility(View.GONE); //32
        oTambor.setVisibility(View.GONE); //33
        oTrompeta.setVisibility(View.GONE); //34
    }

    void casosBotones(int caso){
        switch (caso){
            case 1:
                Invisibilidad();
                oPollo.setVisibility(View.VISIBLE);
                break;
            case 2:
                Invisibilidad();
                oCerdo.setVisibility(View.VISIBLE);
                break;
            case 3:
                Invisibilidad();
                oTigre.setVisibility(View.VISIBLE);
                break;
            case 4:
                Invisibilidad();
                oAbeja.setVisibility(View.VISIBLE);
                break;
            case 5:
                Invisibilidad();
                oGallina.setVisibility(View.VISIBLE);
                break;
            case 6:
                Invisibilidad();
                oGallo.setVisibility(View.VISIBLE);
                break;
            case 7:
                Invisibilidad();
                oPerro.setVisibility(View.VISIBLE);
                break;
            case 8:
                Invisibilidad();
                oGato.setVisibility(View.VISIBLE);
                break;
            case 9:
                Invisibilidad();
                oLobo.setVisibility(View.VISIBLE);
                break;
            case 10:
                Invisibilidad();
                oVaca.setVisibility(View.VISIBLE);
                break;
            case 11:
                Invisibilidad();
                oBorrego.setVisibility(View.VISIBLE);
                break;
            case 12:
                Invisibilidad();
                oElefante.setVisibility(View.VISIBLE);
                break;
            case 13:
                Invisibilidad();
                oCaballo.setVisibility(View.VISIBLE);
                break;
            case 14:
                Invisibilidad();
                oPato.setVisibility(View.VISIBLE);
                break;
            case 15:
                Invisibilidad();
                oTocarPuerta.setVisibility(View.VISIBLE);
                break;
            case 16:
                Invisibilidad();
                //oTomarAgua.setVisibility(View.VISIBLE);
                break;
            case 17:
                Invisibilidad();
                oSilencio.setVisibility(View.VISIBLE);
                break;
            case 18:
                Invisibilidad();
                oComer.setVisibility(View.VISIBLE);
                break;
            case 19:
                Invisibilidad();
                oCantar.setVisibility(View.VISIBLE);
                break;
            case 20:
                Invisibilidad();
                oBeso.setVisibility(View.VISIBLE);
                break;
            case 21:
                Invisibilidad();
                oBostezo.setVisibility(View.VISIBLE);
                break;
            case 22:
                Invisibilidad();
                oHablar.setVisibility(View.VISIBLE);
                break;
            case 23:
                Invisibilidad();
                oDormir.setVisibility(View.VISIBLE);
                break;
            case 24:
                Invisibilidad();
                oAplaudir.setVisibility(View.VISIBLE);
                break;
            case 25:
                Invisibilidad();
                oReloj.setVisibility(View.VISIBLE);
                break;
            case 26:
                Invisibilidad();
                oCampana.setVisibility(View.VISIBLE);
                break;
            case 27:
                Invisibilidad();
                oTeléfono.setVisibility(View.VISIBLE);
                break;
            case 28:
                Invisibilidad();
                oTren.setVisibility(View.VISIBLE);
                break;
            case 29:
                Invisibilidad();
                oBicicleta.setVisibility(View.VISIBLE);
                break;
            case 30:
                Invisibilidad();
                oMotocicleta.setVisibility(View.VISIBLE);
                break;
            case 31:
                Invisibilidad();
                oCarro.setVisibility(View.VISIBLE);
                break;
            case 32:
                Invisibilidad();
                oBarco.setVisibility(View.VISIBLE);
                break;
            case 33:
                Invisibilidad();
                oTambor.setVisibility(View.VISIBLE);
                break;
            case 34:
                Invisibilidad();
                oTrompeta.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(v == bAdelante){
            if(NumeroBoton == 33){
                NumeroBoton = 33;
                Toast toast = Toast.makeText(this, "Usted está en la primera onomatopeya", Toast.LENGTH_SHORT);
            } else {
                NumeroBoton++;
                casosBotones(NumeroBoton);
            }

        } else if(v == bAtras){
            if(NumeroBoton <= 0){
                NumeroBoton = 0;
                Toast toast = Toast.makeText(this, "Usted está en la primera onomatopeya", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                NumeroBoton--;
                casosBotones(NumeroBoton);
            }
        }
        if(v==oPollo){
            //Insertar sonido
        }
        if(v==oCerdo){
            //Insertar sonido
        }
        if(v==oTigre){
            //Insertar sonido
        }
        if(v==oAbeja){
            //Insertar sonido
        }
        if(v==oGallina){
            //Insertar sonido
        }
        if(v==oGallo){

        }
        if(v==oPerro){

        }
        if(v==oGato){

        }
        if(v==oLobo){

        }
        if(v==oVaca){

        }
        if(v==oBorrego){

        }
        if(v==oElefante){

        }
        if(v==oCaballo){

        }
        if(v==oCaballo){

        }
        if(v==oPato){

        }
        if(v==oTocarPuerta){

        }
        /*
        if(v==oTomarAgua){

        }
        */
        if(v==oSilencio){

        }
        if(v==oComer){

        }
        if(v==oCantar){

        }
        if(v==oBeso){

        }
        if(v==oBostezo){

        }
        if(v==oHablar){

        }
        if(v==oDormir){

        }
        if(v==oAplaudir){

        }
        if(v==oReloj){

        }
        if(v==oCampana){

        }
        if(v==oTeléfono){

        }
        if(v==oTren){

        }
        if(v==oBicicleta){

        }
        if(v==oMotocicleta){

        }
        if(v==oCarro){

        }
        if(v==oBarco){

        }
        if(v==oTambor){

        }
        if(v==oTrompeta){

        }

        // ESPACIO PARA GUARDAR AVANCE
        // MANEJO DE BASE DE DATOS

    }
}
