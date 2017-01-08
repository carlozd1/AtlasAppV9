package com.example.carlos.atlasapp.Perfil;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.R;

public class PerfilActivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,
Tab2.OnFragmentInteractionListener, Tab3.OnFragmentInteractionListener{

    int IdPaciente = 0;
    String NombrePaciente;
    String s;
    Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPerfil);
        setSupportActionBar(toolbar);
        recogerExtras();
        buscarPaciente();
        toolbar.setTitle(NombrePaciente);
        getSupportActionBar().setTitle(NombrePaciente);

      /*  TabLayout tab = (TabLayout) findViewById(R.id.tabs);
        tab.addTab(tab.newTab().setText("PERFIL").setIcon(R.drawable.ic_action_perfil));
        tab.addTab(tab.newTab().setText("PROGRESO").setIcon(R.drawable.ic_action_avance));
        tab.addTab(tab.newTab().setText("TERAPIA").setIcon(R.drawable.ic_action_terapia));

        tab.setOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        // ...
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        // ...
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        // ...
                    }
                }
        );¨*/

        Resources res = getResources();
        TabHost tabs=(TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();


        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("PERFIL", getResources().getDrawable(R.drawable.ic_action_perfil));

        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("PROGRESO",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("TERAPIA",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
        //tabs



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void recogerExtras() {
        Bundle extras = this.getIntent().getExtras();
        int idPaciente = extras.getInt("id");
        s= extras.getString("paciente");
        String s2 = extras.getString("correo");
        String s3 = extras.getString("apellido");
        NombrePaciente = s;
        IdPaciente = idPaciente;
        //  apellido(IdPaciente);
        //  String NombreCompleto = s+" "+apePaciente;
        //  nombrePaciente.setText(NombreCompleto);
    }

    public void buscarPaciente() {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getWritableDatabase();
        String nombre = String.valueOf(IdPaciente);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor fila = db.rawQuery("select nombre,apellido from paciente where _id='"+ nombre+"'", null);
        if (fila.moveToFirst()) {
            //  apePaciente = fila.getString(0);
            NombrePaciente = fila.getString(0)+" "+fila.getString(1);

        } else{
            Toast.makeText(this, "No existe una paciente con dicho nombre",Toast.LENGTH_SHORT).show();
        }

    }


}
