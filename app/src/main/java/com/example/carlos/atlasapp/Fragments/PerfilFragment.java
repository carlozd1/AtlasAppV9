package com.example.carlos.atlasapp.Fragments;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.Nav.NavProgreso;
import com.example.carlos.atlasapp.Nivel1.*;
import com.example.carlos.atlasapp.Nivel2.nivel2_principal;
import com.example.carlos.atlasapp.Progreso.FragmentProgreso;

import com.example.carlos.atlasapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PerfilFragment extends Fragment implements FragmentProgreso.OnFragmentInteractionListener  {

    private OnFragmentInteractionListener mListener;
    TextView nombrePaciente, edadPaciente, diagPaciente, otrosPaciente, palabraTotal, fechaTerapia;
    String correo,apePaciente,s;
    ImageButton btnO, btnFon,btnSil,btnPal,btnFrase,btnCon;
    int num = 0;
    int IdPaciente = 0;
    ImageButton progreso;
    Date fecha;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        Resources res = getResources();

        btnO = (ImageButton)view.findViewById(R.id.onomatopeya);
        btnFon = (ImageButton)view.findViewById(R.id.fonema);
        btnSil = (ImageButton)view.findViewById(R.id.silaba);
        btnPal = (ImageButton)view.findViewById(R.id.palabra);
        btnFrase = (ImageButton)view.findViewById(R.id.frase);
        btnCon = (ImageButton)view.findViewById(R.id.conversacion);


        //tabs
        TabHost tabs=(TabHost)view.findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("PERFIL",
                res.getDrawable(android.R.drawable.ic_btn_speak_now));
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
        //Graficas


        nombrePaciente = (TextView)view.findViewById(R.id.nombrePaciente);
        edadPaciente = (TextView)view.findViewById(R.id.txt1);
        diagPaciente = (TextView)view.findViewById(R.id.txt2);
     //   fechaPaciente = (TextView)view.findViewById(R.id.txt3);
        otrosPaciente = (TextView)view.findViewById(R.id.txt4);
        palabraTotal = (TextView)view.findViewById(R.id.palabraTotal);
        fechaTerapia = (TextView)view.findViewById(R.id.fechaUltima);

        fecha = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        fechaTerapia.setText("           "+df.format(fecha));

        correo = "";

        recogerExtras();
        buscarPaciente();
        ObtenerAvance();



        progreso = (ImageButton)view.findViewById(R.id.buttonProgreso);
        progreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), NavProgreso.class);
                crear.putExtra("paciente",nombrePaciente.getText().toString());
                crear.putExtra("id",IdPaciente);
                startActivity(crear, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
            }
        });



        btnFon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel2_principal.class);
                num = 2;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
            }
        });
/*
        btnCon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 6;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);
            }
        });

        btnFrase.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 5;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);
            }
        });

        btnPal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 4;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);
            }
        });
*/
        btnSil.setOnClickListener(new View.OnClickListener(){

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 3;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());

            }
        });

        btnO.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 1;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
            }
        });




        return view;
    }

    public void recogerExtras() {
        Bundle extras = this.getArguments();
        int idPaciente = extras.getInt("id");
        s= extras.getString("paciente");
        String s2 = extras.getString("correo");
        String s3 = extras.getString("apellido");
        nombrePaciente.setText(s);
        IdPaciente = idPaciente;
      //  apellido(IdPaciente);
      //  String NombreCompleto = s+" "+apePaciente;
      //  nombrePaciente.setText(NombreCompleto);
        correo = s2;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void buscarPaciente() {
        DatabaseHelper helper = new DatabaseHelper(getActivity());
        helper.getWritableDatabase();
        String nombre = String.valueOf(IdPaciente);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor fila = db.rawQuery("select nombre,apellido,edad, diagnostico, terapeuta  from paciente where _id='"+ nombre+"'", null);
        if (fila.moveToFirst()) {
          //  apePaciente = fila.getString(0);
            nombrePaciente.setText(fila.getString(0)+" "+fila.getString(1));
            edadPaciente.setText(fila.getString(2));
            diagPaciente.setText(fila.getString(3));
            otrosPaciente.setText(fila.getString(4));
        } else{
            Toast.makeText(getActivity(), "No existe una paciente con dicho nombre",Toast.LENGTH_SHORT).show();
        }
        String no = otrosPaciente.getText().toString();
        db.close();
        db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("select name from usuarios where _id='"+no+"'",null);
        if (c.moveToFirst()) {

            do {
                otrosPaciente.setText(c.getString(0));
            } while(c.moveToNext());
        }
        db.close();

    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void ObtenerAvance(){
        DatabaseHelper helper = new DatabaseHelper(getActivity());

        palabraTotal.setText(helper.NAprobado(IdPaciente).toString());
    }


   /* @Override
    public void onClick(View v) {
        if(v.getId()== btnO.getId()){
           Intent i = new Intent(getActivity(),nivel3_principal.class);
        }
    }  */


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
