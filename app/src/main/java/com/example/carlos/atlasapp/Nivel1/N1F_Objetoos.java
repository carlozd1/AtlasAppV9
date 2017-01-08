package com.example.carlos.atlasapp.Nivel1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.carlos.atlasapp.Nivel3.S_objetos;
import com.example.carlos.atlasapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link N1F_Objetoos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class N1F_Objetoos extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    Button mbtn_Reloj, mbtn_Campana, mbtn_Telefono;
    int IdPaciente = 0;
    int Nivel = 0;
    public N1F_Objetoos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_n1_f__objetoos, container, false);

        mbtn_Campana = (Button) view.findViewById(R.id.btnCampana);
        mbtn_Campana.setOnClickListener(this);

        mbtn_Reloj = (Button) view.findViewById(R.id.btnReloj);
        mbtn_Reloj.setOnClickListener(this);

        mbtn_Telefono = (Button) view.findViewById(R.id.btnTelefono);
        mbtn_Telefono.setOnClickListener(this);
        recogerExtras();

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

    @Override
    public void onClick(View v) {

        switch (Nivel){
            case 1:

                if(v == mbtn_Reloj){
                    Intent i = new Intent(getActivity(), O_objetos.class);
                    i.putExtra("num",26);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Campana){
                    Intent i = new Intent(getActivity(), O_objetos.class);
                    i.putExtra("num",27);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Telefono){
                    Intent i = new Intent(getActivity(), O_objetos.class);
                    i.putExtra("num",28);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }

                break;
            case 3:

                if(v == mbtn_Reloj){
                    Intent i = new Intent(getActivity(), S_objetos.class);
                    i.putExtra("num",26);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Campana){
                    Intent i = new Intent(getActivity(), S_objetos.class);
                    i.putExtra("num",27);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Telefono){
                    Intent i = new Intent(getActivity(), S_objetos.class);
                    i.putExtra("num",28);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }

                break;
        }

    }

    public void recogerExtras() {
        // Bundle extras = this.getArguments();
        Bundle extras = getActivity().getIntent().getExtras();

        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        Nivel = extras.getInt("numero");
        IdPaciente = idPaciente;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
