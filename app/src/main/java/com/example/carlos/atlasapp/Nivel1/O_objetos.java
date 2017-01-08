package com.example.carlos.atlasapp.Nivel1;

import android.net.Uri;
import android.os.Bundle;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.carlos.atlasapp.Nivel1.Onomatopeyas_objetos.*;
import com.example.carlos.atlasapp.R;

public class O_objetos extends AppCompatActivity implements View.OnClickListener,
        F1Objetos_Reloj.OnFragmentInteractionListener,
        F2Objetos_Campana.OnFragmentInteractionListener,
        F3Objetos_Telefono.OnFragmentInteractionListener{

    int NumeroBoton=0;
    int NumeroPaciente=0;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2;

        //Botones de control
        ImageButton bAtrasObjetos, bAdelanteObjetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onomatopeyas_objetos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recogerExtras();

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menuobjeto);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1objeto);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2objeto);

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

                usarMetodoReiniciar(NumeroBoton,NumeroPaciente);

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bAdelanteObjetos = (ImageButton) findViewById(R.id.obtn_AdelanteObjetos); //view.findViewById(R.id.obtn_Adelante);
        bAdelanteObjetos.setOnClickListener(this);

        bAtrasObjetos = (ImageButton) findViewById(R.id.obtn_AtrasObjetos);
        bAtrasObjetos.setOnClickListener(this);

        int numero = getIntent().getIntExtra("num", 0); //Obtiene valor que pasa NI1_Animales
        NumeroBoton = numero;
        CargarFragment(numero);

    }


    public void CargarFragment(int NumeroBoton){
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch(NumeroBoton){
            case 26:
                fragment = new F1Objetos_Reloj();
                fragmentTransaction = true;
                break;
            case 27:
                fragment = new F2Objetos_Campana();
                fragmentTransaction = true;
                break;
            case 28:
                fragment = new F3Objetos_Telefono();
                fragmentTransaction = true;
                break;
        }
        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.oobjetos, fragment).commit();
        }
    }

    @Override
    public void onClick(View v) {
        if(v == bAdelanteObjetos) {
            if(NumeroBoton == 28) {
                Toast aviso = Toast.makeText(this, "Ultima onomatopeya", Toast.LENGTH_SHORT);
                aviso.show();
                NumeroBoton = 28;
                CargarFragment(NumeroBoton);
            } else {
                NumeroBoton++;
                CargarFragment(NumeroBoton);
            }
        }else if(v == bAtrasObjetos){
            if(NumeroBoton == 26){
                Toast aviso = Toast.makeText(this, "Primera onomatopeya de objetos", Toast.LENGTH_SHORT);
                aviso.show();
                NumeroBoton = 26;
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

    public void usarMetodoReiniciar(int numero, int paciente)
    {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getReadableDatabase();
        helper.RestaurarA0(1,numero, paciente);
        Toast.makeText(this, "Presiona la imagen y repite la Onomatopeya", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
