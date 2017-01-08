package com.example.carlos.atlasapp.Nivel2;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.carlos.atlasapp.Nivel2.*;

import com.example.carlos.atlasapp.R;

public class nivel2_principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        nivel2_terapia.OnFragmentInteractionListener,
        nivel2_botones1_fonemas.OnFragmentInteractionListener,
        nivel2_botones2_fonemas.OnFragmentInteractionListener,
        nivel2_diagnostico.OnFragmentInteractionListener,
        nivel2_todo.OnFragmentInteractionListener{

    private boolean isStartup = true;
    int IdPaciente = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nivel2_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras= getIntent().getExtras();
        IdPaciente = extras.getInt("id");
        Log.e("Paciente",String.valueOf(IdPaciente));

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.nivel2_principal, menu);
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

        boolean FragmentTransaction = false;
        Fragment fragment = null;

        if(isStartup) {
            ((RelativeLayout) findViewById(R.id.content_nivel2_principal)).removeAllViews();
            isStartup = false;
        }

        if (id == R.id.fon_diagnostico) {

            fragment = new nivel2_diagnostico();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            FragmentTransaction = true;

        } else if (id == R.id.fon_terapia) {

            fragment = new nivel2_todo();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            FragmentTransaction = true;

        }

        if(FragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_nivel2_principal,fragment).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
