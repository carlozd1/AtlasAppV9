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

import com.example.carlos.atlasapp.Nivel3.S_animales;
import com.example.carlos.atlasapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link N1F_Animales.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class N1F_Animales extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;

    //
    Button mbtn_Pollo, mbtn_Cerdo, mbtn_Tigre, mbtn_Abeja, mbtn_Gallina, mbtn_Gallo, mbtn_Perro, mbtn_Gato, mbtn_Lobo,
            mbtn_Vaca, mbtn_Borrego, mbtn_Elefante, mbtn_Caballo, mbtn_Pato, mbtn_Rana;
    int IdPaciente = 0;
    int Nivel = 0;
    private Context applicationContext;

    public N1F_Animales() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_n1_f__animales, container, false);

        View view = inflater.inflate(R.layout.fragment_n1_f__animales, container, false);


        mbtn_Pollo = (Button) view.findViewById(R.id.btnPollo);
        mbtn_Pollo.setOnClickListener(this);

        mbtn_Cerdo = (Button) view.findViewById(R.id.btnCerdo);
        mbtn_Cerdo.setOnClickListener(this);

        mbtn_Tigre = (Button) view.findViewById(R.id.btnTigre);
        mbtn_Tigre.setOnClickListener(this);

        mbtn_Abeja = (Button) view.findViewById(R.id.btnAbeja);
        mbtn_Abeja.setOnClickListener(this);

        mbtn_Gallina = (Button) view.findViewById(R.id.btnGallina);
        mbtn_Gallina.setOnClickListener(this);

        mbtn_Gallo = (Button) view.findViewById(R.id.btnGallo);
        mbtn_Gallo.setOnClickListener(this);

        mbtn_Perro = (Button) view.findViewById(R.id.btnPerro);
        mbtn_Perro.setOnClickListener(this);

        mbtn_Gato = (Button) view.findViewById(R.id.btnGato);
        mbtn_Gato.setOnClickListener(this);

        mbtn_Lobo = (Button) view.findViewById(R.id.btnLobo);
        mbtn_Lobo.setOnClickListener(this);

        mbtn_Vaca = (Button) view.findViewById(R.id.btnVaca);
        mbtn_Vaca.setOnClickListener(this);

        mbtn_Borrego = (Button) view.findViewById(R.id.btnBorrego);
        mbtn_Borrego.setOnClickListener(this);

        mbtn_Elefante = (Button) view.findViewById(R.id.btnElefante);
        mbtn_Elefante.setOnClickListener(this);

        mbtn_Caballo = (Button) view.findViewById(R.id.btnCaballo);
        mbtn_Caballo.setOnClickListener(this);

        mbtn_Pato = (Button) view.findViewById(R.id.btnPato);
        mbtn_Pato.setOnClickListener(this);

        mbtn_Rana = (Button) view.findViewById(R.id.btnRana);
        mbtn_Rana.setOnClickListener(this);
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

        switch(Nivel){
            case 1:

                if(v == mbtn_Pollo){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",1);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Cerdo){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",2);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Tigre){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",3);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Abeja){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",4);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Gallina){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",5);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Gallo){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",6);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Perro){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",7);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Gato){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",8);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Lobo){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",9);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Vaca){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",10);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Borrego){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",11);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Elefante){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",12);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Caballo){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",13);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Pato){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",14);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Rana){
                    Intent i = new Intent(getActivity(), Onomatopeyas.class);
                    i.putExtra("num",15);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }

                break;
            case 3:
                if(v == mbtn_Pollo){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",1);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Cerdo){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",2);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Tigre){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",3);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Abeja){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",4);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Gallina){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",5);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Gallo){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",6);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Perro){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",7);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Gato){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",8);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Lobo){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",9);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Vaca){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",10);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Borrego){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",11);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Elefante){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",12);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Caballo){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",13);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Pato){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",14);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Rana){
                    Intent i = new Intent(getActivity(), S_animales.class);
                    i.putExtra("num",15);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }


                break;
            default:
                break;
        }


    }


    public void recogerExtras() {
       // Bundle extras = this.getArguments();
        Bundle extras = getActivity().getIntent().getExtras();

        int idPaciente = extras.getInt("id");
        int numeroNivel = extras.getInt("numero");
        String s= extras.getString("paciente");
        IdPaciente = idPaciente;
        Nivel = numeroNivel;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
