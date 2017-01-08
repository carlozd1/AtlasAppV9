package com.example.carlos.atlasapp.Nav;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.Fragments.AgregarFragment;
import com.example.carlos.atlasapp.BaseDatos.PacienteCursorAdapter;
import com.example.carlos.atlasapp.Fragments.FragmentConfiguracionU;
import com.example.carlos.atlasapp.Fragments.FragmentModificarP;
import com.example.carlos.atlasapp.Progreso.FragmentProgreso;
import com.example.carlos.atlasapp.Fragments.InicioFragment;
import com.example.carlos.atlasapp.Fragments.PerfilFragment;
import com.example.carlos.atlasapp.R;
import com.example.carlos.atlasapp.login.LoginActivity;


public class NavInicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AgregarFragment.OnFragmentInteractionListener,
        FragmentConfiguracionU.OnFragmentInteractionListener,
        PerfilFragment.OnFragmentInteractionListener,
        InicioFragment.OnFragmentInteractionListener,
        FragmentModificarP.OnFragmentInteractionListener,
        FragmentProgreso.OnFragmentInteractionListener{

    private boolean isStartup = true;
    TextView texto;
    private PacienteCursorAdapter pacienteadapter ;
    InicioFragment lista;
    DatabaseHelper helper ;
    Cursor cursor2;
    SearchView searchView = null;
    Context c;


    public NavInicio(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        helper =  new DatabaseHelper(this);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new InicioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_nav_inicio,fragment).commit();
        getSupportActionBar().setTitle("Inicio");

    }


    private void MandarUsuario(String user){
        Bundle bundle = new Bundle();
        bundle.putString("correo",user);
    }

    public void recogerExtras() {
        //Aquí recogemos y tratamos los parámetros
        Bundle extras= getIntent().getExtras();
         String s= extras.getString("correo");
         texto.setText(s);
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

        getMenuInflater().inflate(R.menu.nav_inicio, menu);
        texto = (TextView) findViewById(R.id.txtusuario);
        recogerExtras();

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //permite modificar el hint que el EditText muestra por defecto
        searchView.setQueryHint("Buscar Paciente");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
             //   showResults(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
             //   showResults(newText + "*");
                return true;
            }

        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        boolean FragmentTransaction = false;
        Fragment fragment = null;

/*        if(isStartup) {
            ((RelativeLayout) findViewById(R.id.content_nav_inicio)).removeAllViews();
            isStartup = false;
        } */

        if (id == R.id.ini_inicio) {
            fragment = new InicioFragment();
            FragmentTransaction = true;

        } else if (id == R.id.ini_agregar) {
            fragment = new AgregarFragment();
            FragmentTransaction = true;

        } else if (id == R.id.ini_config) {

            fragment = new FragmentConfiguracionU();
            FragmentTransaction = true;
        } else if (id == R.id.ini_cerrar) {
            finish();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }

        if(FragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_nav_inicio,fragment).commit();
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
/*
    private void showResults(String query) {

        //Cursor cursor = helper.searchCustomer((query != null ? query.toString() : "@@@@"));
        helper.getReadableDatabase();
        Cursor cursor = helper.getCursorPaciente(query);
        startManagingCursor(cursor);
        pacienteadapter = new PacienteCursorAdapter(this, cursor);
        pacienteadapter.notifyDataSetChanged();
        Fragment fragment = new InicioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_nav_inicio,fragment).commit();
        //lista.setAdapter(pacienteadapter);

    }
*/

}
