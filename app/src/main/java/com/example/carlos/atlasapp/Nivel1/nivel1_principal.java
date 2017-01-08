package com.example.carlos.atlasapp.Nivel1;

//import android.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;

import com.example.carlos.atlasapp.R;

public class nivel1_principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        N1F_Todo.OnFragmentInteractionListener,
        N1F_Animales.OnFragmentInteractionListener,
        N1F_Acciones.OnFragmentInteractionListener,
        N1F_Objetoos.OnFragmentInteractionListener,
        N1F_Transporte.OnFragmentInteractionListener,
        N1F_Instrumentos.OnFragmentInteractionListener{

    int IdPaciente = 0;
    int Num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras= getIntent().getExtras();
        Num = extras.getInt("numero");
        IdPaciente = extras.getInt("id");
        ponerTema(Num);
        setContentView(R.layout.activity_nivel1_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ponerTitulo(Num);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        boolean fragmentTransaction = false;
        Fragment fragment = null;

        //inicio: muestra todo
        fragment = new N1F_Todo();
        Bundle bundle = new Bundle();
        bundle.putInt("id",IdPaciente);
        fragmentTransaction = true;
        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_nivel1_principal,fragment).commit();
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nivel1_principal, menu);
        TextView label = (TextView) findViewById(R.id.txtnivel);
        switch (Num){
            case 1:
                label.setText("Onomatopeyas");
                break;
            case 3:
                label.setText("Silabas & Palabras");
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        boolean fragmentTransaction = false;
        Fragment fragment = null;

        if(id == R.id.inicio){
            fragment = new N1F_Todo();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            fragmentTransaction = true;
        } else if(id == R.id.animales){
            fragment = new N1F_Animales();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            fragmentTransaction = true;
        } else if(id == R.id.acciones){
            fragment = new N1F_Acciones();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            fragmentTransaction = true;
        } else if(id == R.id.objetos){
            fragment = new N1F_Objetoos();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            fragmentTransaction = true;
        } else if(id == R.id.transporte){
            fragment = new N1F_Transporte();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            fragmentTransaction = true;
        } else if(id == R.id.pruebanivel1){
            //LLAMAR OTRO ACTIVITY
        } else if(id == R.id.regresa){
            //REGRESAR ACTIVITY NIÑOS
        } else if(id == R.id.comenzarnivel1){
            Intent i = new Intent(getApplicationContext(), Onomatopeyas.class);
            i.putExtra("num",1);
            i.putExtra("id",IdPaciente);
            startActivity(i);
        }

        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_nivel1_principal,fragment).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void ponerTema(int num){

        switch (num) {
            case 1:
                setTheme(R.style.AppThemeOno);
                setTitle("Onomatopeyas");

                break;
            case 2:
                setTheme(R.style.AppThemeFon);
                setTitle("Fonemas");

                break;
            case 3:
                setTheme(R.style.AppThemeSil);
                setTitle("Silabas - Palabras");
                break;
            case 4:
                setTheme(R.style.AppThemePal);
                setTitle("Palabras");
                break;
            case 5:
                setTheme(R.style.AppThemeFra);
                setTitle("Frases");
                break;
            case 6:
                setTheme(R.style.AppThemeCon);
                setTitle("Conversación");
                break;
            default:
                break;
        }
    }

    public void ponerTitulo(int num){

        switch (num) {
            case 1:
                getSupportActionBar().setTitle("Onomatopeyas");

                break;
            case 2:
                getSupportActionBar().setTitle("Fonemas");

                break;
            case 3:
                getSupportActionBar().setTitle("Silabas & Palabras");
                break;
            case 4:
                getSupportActionBar().setTitle("Palabras");
                break;
            case 5:
                getSupportActionBar().setTitle("Frases");
                break;
            case 6:
                getSupportActionBar().setTitle("Conversación");
                break;
            default:
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
