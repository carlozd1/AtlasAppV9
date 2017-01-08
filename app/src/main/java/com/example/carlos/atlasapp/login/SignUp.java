package com.example.carlos.atlasapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.Contact;
import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.R;

public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    Button crearUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        crearUsuario = (Button)findViewById(R.id.btn_signup);

        crearUsuario.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onbtn_signupClick(v);
                Intent crear = new Intent(SignUp.this, LoginActivity.class);
                startActivity(crear);
            }
        });
    }

    public void onbtn_signupClick(View v)
    {
        if (v.getId() == R.id.btn_signup)
        {
            EditText name = (EditText)findViewById(R.id.input_name);

            EditText usuario = (EditText)findViewById(R.id.input_usuario);

            EditText pass = (EditText)findViewById(R.id.input_password);
            EditText repetir_contraseña = (EditText)findViewById(R.id.input_reEnterPassword);

            String nombrestr = name.getText().toString();

            String usuarioString = usuario.getText().toString();

            String contrastr = pass.getText().toString();
            String recontrastr = repetir_contraseña.getText().toString();

            if (!contrastr.equals(recontrastr))
            {
                Toast pass1 = Toast.makeText(SignUp.this, "No coincide la Contraseña!" , Toast.LENGTH_SHORT);
                pass1.show();
            }
            else
            {
                //insertar en bd
                Contact c = new Contact();
                c.setName(nombrestr);
                c.setUsuario(usuarioString);
                c.setPass(contrastr);


                helper.insertContact(c);
                Toast aviso = Toast.makeText(SignUp.this, "Usuario registrado" , Toast.LENGTH_SHORT);
                aviso.show();
            }

        }
    }
}
