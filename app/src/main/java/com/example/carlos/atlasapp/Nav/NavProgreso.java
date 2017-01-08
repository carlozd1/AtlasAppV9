package com.example.carlos.atlasapp.Nav;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.carlos.atlasapp.Progreso.G_FluidezFragment;
import com.example.carlos.atlasapp.Progreso.G_FonemasFragment;
import com.example.carlos.atlasapp.Progreso.FragmentProgreso;
import com.example.carlos.atlasapp.Progreso.G_ConversacionFragment;
import com.example.carlos.atlasapp.Progreso.G_OnomatopeyasFragment;
import com.example.carlos.atlasapp.Progreso.G_FrasesFragment;
import com.example.carlos.atlasapp.Progreso.G_SilabasFragment;
import com.example.carlos.atlasapp.R;

public class NavProgreso extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        FragmentProgreso.OnFragmentInteractionListener,
        G_OnomatopeyasFragment.OnFragmentInteractionListener,
        G_FonemasFragment.OnFragmentInteractionListener,
        G_SilabasFragment.OnFragmentInteractionListener,
        G_FrasesFragment.OnFragmentInteractionListener,
        G_ConversacionFragment.OnFragmentInteractionListener,
        G_FluidezFragment.OnFragmentInteractionListener{

    int IdPaciente = 0;
    private boolean isStartup = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_progreso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras= getIntent().getExtras();
        int num = extras.getInt("numero");
        IdPaciente = extras.getInt("id");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Fragment fragment = new FragmentProgreso();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_nav_progreso,fragment).commit();
        getSupportActionBar().setTitle("Progreso");
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
        getMenuInflater().inflate(R.menu.nav_progreso, menu);
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
        int numero = 0;
        boolean FragmentTransaction = false;
        Fragment fragment = null;


        if (id == R.id.n_progreso_general) {
            // Handle the camera action
            fragment = new FragmentProgreso();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            FragmentTransaction = true;
        } else if (id == R.id.n_progreso_ono) {

            fragment = new G_OnomatopeyasFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            numero =1;
            setTheme(R.style.AppThemeOno);
            FragmentTransaction = true;

        } else if (id == R.id.n_progreso_fon) {

            fragment = new G_FonemasFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            numero =2;
            FragmentTransaction = true;

        } else if (id == R.id.n_progreso_sil) {

            fragment = new G_SilabasFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            numero =3;
            FragmentTransaction = true;

        } else if (id == R.id.n_progreso_pal) {

            fragment = new G_FrasesFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            numero =4;
            FragmentTransaction = true;

        } else if (id == R.id.n_progreso_fra) {

            fragment = new G_ConversacionFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            numero =5;
            FragmentTransaction = true;

        } else if (id == R.id.n_progreso_con) {

            fragment = new G_FluidezFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",IdPaciente);
            numero =6;
            FragmentTransaction = true;

        }


        if(FragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_nav_progreso,fragment).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
            switch (numero){
                case 1:
                    setTheme(R.style.AppThemeOno);
                    break;
                case 2:
                    setTheme(R.style.AppThemeFon);
                    break;
                case 3:
                    setTheme(R.style.AppThemeSil);
                    break;
                case 4:
                    setTheme(R.style.AppThemePal);
                    break;
                case 5:
                    setTheme(R.style.AppThemeFra);
                    break;
                case 6:
                    setTheme(R.style.AppThemeCon);
                    break;
                default:
                    break;
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
