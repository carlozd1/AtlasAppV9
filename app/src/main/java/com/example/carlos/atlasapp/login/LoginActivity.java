package com.example.carlos.atlasapp.login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.Nav.NavInicio;
import com.example.carlos.atlasapp.R;

public class LoginActivity extends AppCompatActivity {
// implements LoaderCallbacks<Cursor>

    DatabaseHelper helper = new DatabaseHelper(this);
    Button crear;
    Button entrar;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        crear = (Button)findViewById(R.id.crearUsuario);
        entrar = (Button)findViewById(R.id.btn_login);

        crear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(LoginActivity.this, SignUp.class);
                startActivity(crear);
            }
        });

        entrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onButtonClick(v);

            }
        });
    }

    public void onButtonClick(View v)
    {
        if (v.getId() == R.id.btn_login)
        {
            EditText a = (EditText) findViewById(R.id.txtUsu);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.tfpass);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if (pass.equals(password))
            {
               // Intent i = new Intent(LoginActivity.this, NavInicio.class);
               // i.putExtra("Correo", str);
              //  startActivity(i);
                lanzarActivity(str);
            }
            else
            {
                Toast pass1 = Toast.makeText(LoginActivity.this, "Correo - Contraseña incorrectos!" , Toast.LENGTH_SHORT);
                pass1.show();
            }
        }

    }
    public void lanzarActivity(String texto) {
        Intent i = new Intent(this, NavInicio.class);
        if (texto.equals("") || texto.equals(null))
            i.putExtra("correo", "TEXTO VACÍO");
        else
            i.putExtra("correo", texto);
            startActivity(i);
    }

}

