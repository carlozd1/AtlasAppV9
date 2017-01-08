package com.example.carlos.atlasapp.Perfil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Tab1 extends Fragment {

    TextView  edadPaciente, diagPaciente, otrosPaciente, palabraTotal, fechaTerapia;
    String correo,apePaciente,s;
    Date fecha;
    int num = 0;
    int IdPaciente = 0;
    String nombrePaciente;
    private OnFragmentInteractionListener mListener;

    public Tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

       // nombrePaciente = (TextView) view.findViewById(R.id.nombrePaciente);
        edadPaciente = (TextView)view.findViewById(R.id.txt1);
        diagPaciente = (TextView)view.findViewById(R.id.txt2);
        //   fechaPaciente = (TextView)view.findViewById(R.id.txt3);
        otrosPaciente = (TextView)view.findViewById(R.id.txt4);
        palabraTotal = (TextView)view.findViewById(R.id.palabraTotal);
        correo = "";
        recogerExtras();
        buscarPaciente();







        return view;
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


    public void recogerExtras() {
        Bundle extras = getActivity().getIntent().getExtras();
        int idPaciente = extras.getInt("id");
        s= extras.getString("paciente");
        String s2 = extras.getString("correo");
        String s3 = extras.getString("apellido");
        nombrePaciente = s;
        IdPaciente = idPaciente;
        //  apellido(IdPaciente);
        //  String NombreCompleto = s+" "+apePaciente;
        //  nombrePaciente.setText(NombreCompleto);
        correo = s2;
    }

    public void buscarPaciente() {
        DatabaseHelper helper = new DatabaseHelper(getActivity());
        helper.getWritableDatabase();
        String nombre = String.valueOf(IdPaciente);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor fila = db.rawQuery("select nombre,apellido,edad, diagnostico, terapeuta  from paciente where _id='"+ nombre+"'", null);
        if (fila.moveToFirst()) {
            //  apePaciente = fila.getString(0);
            nombrePaciente = fila.getString(0)+" "+fila.getString(1);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
