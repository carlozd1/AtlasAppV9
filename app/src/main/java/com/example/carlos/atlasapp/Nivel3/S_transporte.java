package com.example.carlos.atlasapp.Nivel3;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.Nivel3.Silabas_transporte.*;
import com.example.carlos.atlasapp.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class S_transporte extends AppCompatActivity implements View.OnClickListener,
        F1Transporte_Tren.OnFragmentInteractionListener,
        F2Transporte_Bicicleta.OnFragmentInteractionListener,
        F3Transporte_Motocicleta.OnFragmentInteractionListener,
        F4Transporte_Carro.OnFragmentInteractionListener,
        F5Transporte_Barco.OnFragmentInteractionListener{

    int NumeroBoton=0;
    int NumeroPaciente=0;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2;

    //Botones de control
    ImageButton bAtrasTransporte, bAdelanteTransporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silabas_transporte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recogerExtras();

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menutransporte);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1transporte);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2transporte);

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

        bAdelanteTransporte = (ImageButton) findViewById(R.id.obtn_AdelanteTransporte); //view.findViewById(R.id.obtn_Adelante);
        bAdelanteTransporte.setOnClickListener(this);

        bAtrasTransporte = (ImageButton) findViewById(R.id.obtn_AtrasTransporte);
        bAtrasTransporte.setOnClickListener(this);

        int numero = getIntent().getIntExtra("num", 0); //Obtiene valor que pasa NI1_Animales
        NumeroBoton = numero;
        CargarFragment(numero);
    }


    public void CargarFragment(int NumeroBoton){
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch(NumeroBoton){
            case 29:
                fragment = new F1Transporte_Tren();
                fragmentTransaction = true;
                break;
            case 30:
                fragment = new F2Transporte_Bicicleta();
                fragmentTransaction = true;
                break;
            case 31:
                fragment = new F3Transporte_Motocicleta();
                fragmentTransaction = true;
                break;
            case 32:
                fragment = new F4Transporte_Carro();
                fragmentTransaction = true;
                break;
            case 33:
                fragment = new F5Transporte_Barco();
                fragmentTransaction = true;
                break;

        }
        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.otransporte, fragment).commit();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == bAdelanteTransporte) {
            if (NumeroBoton == 33) {
                Toast aviso = Toast.makeText(this, "Ultima palabra de transporte", Toast.LENGTH_SHORT);
                aviso.show();
                NumeroBoton = 33;
                CargarFragment(NumeroBoton);
            } else {
                NumeroBoton++;
                CargarFragment(NumeroBoton);
            }
        } else if (v == bAtrasTransporte) {
            if (NumeroBoton == 29) {
                Toast aviso = Toast.makeText(this, "Primera palabra de transporte", Toast.LENGTH_SHORT);
                aviso.show();
                NumeroBoton = 29;
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
        helper.VerificarPalabra(3,numero, paciente);
        Toast.makeText(this, "Palabra calificada, continua con la siguiente", Toast.LENGTH_SHORT).show();
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
        helper.RestaurarA0(3,numero, paciente);
        Toast.makeText(this, "Se reinicio la palabra", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
