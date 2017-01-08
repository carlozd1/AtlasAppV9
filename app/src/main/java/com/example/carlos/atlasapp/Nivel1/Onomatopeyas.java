package com.example.carlos.atlasapp.Nivel1;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F10Animal_Vaca;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F11Animal_Borrego;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F12Animal_Elefante;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F13Animal_Caballo;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F14Animal_Pato;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F15Animal_Rana;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F1Animal_Pollo;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F2Animal_Cerdo;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F3Animal_Tigre;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F4Animal_Abeja;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F5Animal_Gallina;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F6Animal_Gallo;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F7Animal_Perro;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F8Animal_Gato;
import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments.F9Animal_Lobo;
import com.example.carlos.atlasapp.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

// import com.example.carlos.atlasapp.R;


public class Onomatopeyas extends AppCompatActivity implements View.OnClickListener,
        F1Animal_Pollo.OnFragmentInteractionListener,
        F2Animal_Cerdo.OnFragmentInteractionListener,
        F3Animal_Tigre.OnFragmentInteractionListener,
        F4Animal_Abeja.OnFragmentInteractionListener,
        F5Animal_Gallina.OnFragmentInteractionListener,
        F6Animal_Gallo.OnFragmentInteractionListener,
        F7Animal_Perro.OnFragmentInteractionListener,
        F8Animal_Gato.OnFragmentInteractionListener,
        F9Animal_Lobo.OnFragmentInteractionListener,
        F10Animal_Vaca.OnFragmentInteractionListener,
        F11Animal_Borrego.OnFragmentInteractionListener,
        F12Animal_Elefante.OnFragmentInteractionListener,
        F13Animal_Caballo.OnFragmentInteractionListener,
        F14Animal_Pato.OnFragmentInteractionListener,
        F15Animal_Rana.OnFragmentInteractionListener{

    int NumeroBoton=0;
    int NumeroPaciente=0;

    //Botones de control
    ImageButton bAtras, bAdelante;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onomatopeyas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recogerExtras();


        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String n5;
                n5 = Integer.toString(NumeroBoton);
                Log.d("boton",n5);
                usarMetodoPalabra(1,NumeroBoton, NumeroPaciente);

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            usarMetodoReiniciar(1,NumeroBoton,NumeroPaciente);

            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bAdelante = (ImageButton) findViewById(R.id.obtn_Adelante); //view.findViewById(R.id.obtn_Adelante);
        bAdelante.setOnClickListener(this);

        bAtras = (ImageButton) findViewById(R.id.obtn_Atras);
        bAtras.setOnClickListener(this);

        int numero = getIntent().getIntExtra("num", 0); //Obtiene valor que pasa NI1_Animales
        NumeroBoton = numero;
        CargarFragment(numero);
        
    }

    @Override
    public void onClick(View v) {
        if(v == bAdelante) {
            if(NumeroBoton == 15) {
                Toast aviso = Toast.makeText(this, "Ultima onomatopeya", Toast.LENGTH_SHORT);
                aviso.show();
                NumeroBoton = 15;
                CargarFragment(NumeroBoton);
            } else {
                NumeroBoton++;
                CargarFragment(NumeroBoton);
            }
        }else if(v == bAtras){
            if(NumeroBoton == 0){
                Toast aviso = Toast.makeText(this, "Primera onomatopeya", Toast.LENGTH_SHORT);
                aviso.show();
                NumeroBoton = 1;
                CargarFragment(NumeroBoton);
            } else {
                NumeroBoton--;
                CargarFragment(NumeroBoton);
            }

        }
    }


    public void CargarFragment(int NumeroBoton){
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch(NumeroBoton){
            case 1:
                fragment = new F1Animal_Pollo();
                fragmentTransaction = true;
                break;
            case 2:
                fragment = new F2Animal_Cerdo();
                fragmentTransaction = true;
                break;
            case 3:
                fragment = new F3Animal_Tigre();
                fragmentTransaction = true;
                break;
            case 4:
                fragment = new F4Animal_Abeja();
                fragmentTransaction = true;
                break;
            case 5:
                fragment = new F5Animal_Gallina();
                fragmentTransaction = true;
                break;
            case 6:
                fragment = new F6Animal_Gallo();
                fragmentTransaction = true;
                break;
            case 7:
                fragment = new F7Animal_Perro();
                fragmentTransaction = true;
                break;
            case 8:
                fragment = new F8Animal_Gato();
                fragmentTransaction = true;
                break;
            case 9:
                fragment = new F9Animal_Lobo();
                        fragmentTransaction = true;
                break;
            case 10:
                fragment = new F10Animal_Vaca();
                        fragmentTransaction = true;
                break;
            case 11:
                fragment = new F11Animal_Borrego();
                        fragmentTransaction = true;
                break;
            case 12:
                fragment = new F12Animal_Elefante();
                        fragmentTransaction = true;
                break;
            case 13:
                fragment = new F13Animal_Caballo();
                        fragmentTransaction = true;
                break;
            case 14:
                fragment = new F14Animal_Pato();
                        fragmentTransaction = true;
                break;
            case 15:
                fragment = new F15Animal_Rana();
                        fragmentTransaction = true;
                break;
        }
        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_onomatopeyas, fragment).commit();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void usarMetodoPalabra(int nivel,int numero, int paciente)
    {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getReadableDatabase();
        helper.VerificarPalabra(nivel, numero, paciente);
        Toast.makeText(this, "Bien Hecho! Continua con la siguiente Onomatopeya!", Toast.LENGTH_SHORT).show();
    }

    public void usarMetodoReiniciar(int nivel,int numero, int paciente)
    {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getReadableDatabase();
        helper.RestaurarA0(nivel,numero, paciente);
        Toast.makeText(this, "Presiona la imagen y repite la Onomatopeya", Toast.LENGTH_SHORT).show();
    }

    public void recogerExtras() {
        // Bundle extras = this.getArguments();
        Bundle extras = getIntent().getExtras();

        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        NumeroPaciente = idPaciente;
        Log.d("Id de paciente",String.valueOf(NumeroPaciente));
    }
}