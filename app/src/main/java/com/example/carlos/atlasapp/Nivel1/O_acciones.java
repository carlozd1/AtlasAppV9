package com.example.carlos.atlasapp.Nivel1;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_acciones.*;
import com.example.carlos.atlasapp.R;

public class O_acciones extends AppCompatActivity implements View.OnClickListener,
        F1Acciones_TocarPuerta.OnFragmentInteractionListener,
        F2Acciones_TomarAgua.OnFragmentInteractionListener,
        F3Acciones_Silencio.OnFragmentInteractionListener,
        F4Acciones_Comer.OnFragmentInteractionListener,
        F5Acciones_Cantar.OnFragmentInteractionListener,
        F6Acciones_Beso.OnFragmentInteractionListener,
        F7Acciones_Bostezar.OnFragmentInteractionListener,
        F8Acciones_Hablar.OnFragmentInteractionListener,
        F9Acciones_Dormir.OnFragmentInteractionListener,
        F10Acciones_Aplaudir.OnFragmentInteractionListener{


    int NumeroBoton=0;
    int NumeroPaciente=0;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2;

    //Botones de control
    ImageButton bAtrasAcciones, bAdelanteAcciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onomatopeyas_acciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recogerExtras();

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menuacciones);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1acciones);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2acciones);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String n5;
                n5 = Integer.toString(NumeroBoton);
                Log.d("boton",n5);
                usarMetodoPalabra(NumeroBoton, NumeroPaciente);

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                usarMetodoReiniciar(1,NumeroBoton,NumeroPaciente);

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bAdelanteAcciones = (ImageButton) findViewById(R.id.obtn_AdelanteAcciones); //view.findViewById(R.id.obtn_Adelante);
        bAdelanteAcciones.setOnClickListener(this);

        bAtrasAcciones = (ImageButton) findViewById(R.id.obtn_AtrasAcciones);
        bAtrasAcciones.setOnClickListener(this);

        int numero = getIntent().getIntExtra("num", 0); //Obtiene valor que pasa NI1_Animales
        NumeroBoton = numero;
        CargarFragment(numero);

    }

    public void CargarFragment(int NumeroBoton){
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch(NumeroBoton){
            case 16:
                fragment = new F1Acciones_TocarPuerta();
                fragmentTransaction = true;
                break;
            case 17:
                fragment = new F2Acciones_TomarAgua();
                fragmentTransaction = true;
                break;
            case 18:
                fragment = new F3Acciones_Silencio();
                fragmentTransaction = true;
                break;
            case 19:
                fragment = new F4Acciones_Comer();
                fragmentTransaction = true;
                break;
            case 20:
                fragment = new F5Acciones_Cantar();
                fragmentTransaction = true;
                break;
            case 21:
                fragment = new F6Acciones_Beso();
                fragmentTransaction = true;
                break;
            case 22:
                fragment = new F7Acciones_Bostezar();
                fragmentTransaction = true;
                break;
            case 23:
                fragment = new F8Acciones_Hablar();
                fragmentTransaction = true;
                break;
            case 24:
                fragment = new F9Acciones_Dormir();
                fragmentTransaction = true;
                break;
            case 25:
                fragment = new F10Acciones_Aplaudir();
                fragmentTransaction = true;
                break;
        }
        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.oacciones, fragment).commit();
        }
    }

    @Override
    public void onClick(View v) {
        if(v == bAdelanteAcciones) {
            if(NumeroBoton == 25) {
                Toast aviso = Toast.makeText(this, "Ultima onomatopeya de acciones", Toast.LENGTH_SHORT);
                aviso.show();
                NumeroBoton = 25;
                CargarFragment(NumeroBoton);
            } else {
                NumeroBoton++;
                CargarFragment(NumeroBoton);
            }
        }else if(v == bAtrasAcciones) {
            if (NumeroBoton == 16) {
                Toast aviso = Toast.makeText(this, "Primera onomatopeya de acciones", Toast.LENGTH_SHORT);
                aviso.show();
                NumeroBoton = 16;
                CargarFragment(NumeroBoton);
            } else {
                NumeroBoton--;
                CargarFragment(NumeroBoton);
            }
        }
    }


    public void usarMetodoPalabra(int numero, int paciente)
    {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getReadableDatabase();
        helper.VerificarPalabra(1,numero, paciente);
        Toast.makeText(this, "Bien Hecho! Continua con la siguiente Onomatopeya!", Toast.LENGTH_SHORT).show();

    }

    public void recogerExtras() {
        // Bundle extras = this.getArguments();
        Bundle extras = getIntent().getExtras();

        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        NumeroPaciente = idPaciente;
        Log.d("Id de paciente",String.valueOf(NumeroPaciente));
    }
    public void usarMetodoReiniciar(int nivel,int numero, int paciente)
    {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getReadableDatabase();
        helper.RestaurarA0(nivel,numero, paciente);
        Toast.makeText(this, "Presiona la imagen y repite la Onomatopeya", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
