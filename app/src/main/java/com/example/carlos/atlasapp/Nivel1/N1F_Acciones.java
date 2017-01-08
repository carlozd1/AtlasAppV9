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

import com.example.carlos.atlasapp.Nivel3.S_acciones;
import com.example.carlos.atlasapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link N1F_Acciones.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class N1F_Acciones extends Fragment implements View.OnClickListener{

    Button mbtn_TocarPuerta, mbtn_TomarAgua, mbtn_Silencio, mbtn_Comer,
            mbtn_Cantar, mbtn_Beso, mbtn_Bostezar, mbtn_Hablar, mbtn_Dormir, mbtn_Aplaudir;
    int IdPaciente = 0;
    int Nivel = 0;

    private OnFragmentInteractionListener mListener;

    public N1F_Acciones() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_n1_f__acciones, container, false);

        mbtn_TocarPuerta = (Button) view.findViewById(R.id.btnTocarPuerta);
        mbtn_TocarPuerta.setOnClickListener(this);

        mbtn_TomarAgua = (Button) view.findViewById(R.id.btnTomarAgua);
        mbtn_TomarAgua.setOnClickListener(this);

        mbtn_Silencio = (Button) view.findViewById(R.id.btnGuardarSilencio);
        mbtn_Silencio.setOnClickListener(this);

        mbtn_Comer = (Button) view.findViewById(R.id.btnComer);
        mbtn_Comer.setOnClickListener(this);

        mbtn_Cantar = (Button) view.findViewById(R.id.btnCantar);
        mbtn_Cantar.setOnClickListener(this);

        mbtn_Beso = (Button) view.findViewById(R.id.btnBeso);
        mbtn_Beso.setOnClickListener(this);

        mbtn_Bostezar = (Button) view.findViewById(R.id.btnBostezo);
        mbtn_Bostezar.setOnClickListener(this);

        mbtn_Hablar= (Button) view.findViewById(R.id.btnHablarAlguien);
        mbtn_Hablar.setOnClickListener(this);

        mbtn_Dormir= (Button) view.findViewById(R.id.btnDormir);
        mbtn_Dormir.setOnClickListener(this);

        mbtn_Aplaudir= (Button) view.findViewById(R.id.btnAplaudir);
        mbtn_Aplaudir.setOnClickListener(this);
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

        switch(Nivel) {
            case 1:

                if(v == mbtn_TocarPuerta){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",16);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_TomarAgua){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",17);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Silencio){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",18);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Comer){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",19);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Cantar){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",20);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Beso){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",21);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Bostezar){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",22);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Hablar){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",23);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Dormir){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",24);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Aplaudir){
                    Intent i = new Intent(getActivity(), O_acciones.class);
                    i.putExtra("num",25);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }

                break;
            case 3:

                if(v == mbtn_TocarPuerta){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",16);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_TomarAgua){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",17);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Silencio){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",18);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Comer){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",19);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Cantar){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",20);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Beso){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",21);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Bostezar){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",22);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Hablar){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",23);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Dormir){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",24);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Aplaudir){
                    Intent i = new Intent(getActivity(), S_acciones.class);
                    i.putExtra("num",25);
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
        Nivel = extras.getInt("numero");
        String s= extras.getString("paciente");
        IdPaciente = idPaciente;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
