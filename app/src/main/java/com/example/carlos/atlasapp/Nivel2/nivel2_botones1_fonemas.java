package com.example.carlos.atlasapp.Nivel2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.carlos.atlasapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link nivel2_botones1_fonemas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class nivel2_botones1_fonemas extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    int IdPaciente=0;

    Button btnAbrigo,btnAguja,btnAraña, btnBarco,btnBici,btnBota, btnCama,btnComida,btnCasa, btnEscoba,btnEspejo,btnEspuma,
            btnGallina,btnGancho,btnGoma, btnJabon,btnJarra,btnJoven, btnLibro,btnLentes,btnLapiz;
    public nivel2_botones1_fonemas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.nivel2_botones1_fonemas, container, false);
        recogerExtras();

        btnAbrigo = (Button) view.findViewById(R.id.btnAbrigo);
        btnAbrigo.setOnClickListener(this);

        btnAguja = (Button) view.findViewById(R.id.btnAguja);
        btnAguja.setOnClickListener(this);

        btnAraña = (Button) view.findViewById(R.id.btnAraña);
        btnAraña.setOnClickListener(this);

        btnBarco = (Button) view.findViewById(R.id.btnBarco);
        btnBarco.setOnClickListener(this);

        btnBici = (Button) view.findViewById(R.id.btnBici);
        btnBici.setOnClickListener(this);

        btnBota = (Button) view.findViewById(R.id.btnBota);
        btnBota.setOnClickListener(this);

        btnCama = (Button) view.findViewById(R.id.btnCama);
        btnCama.setOnClickListener(this);

        btnCasa = (Button) view.findViewById(R.id.btnCasa);
        btnCasa.setOnClickListener(this);

        btnComida = (Button) view.findViewById(R.id.btnComida);
        btnComida.setOnClickListener(this);

        btnEscoba = (Button) view.findViewById(R.id.btnEscoba);
        btnEscoba.setOnClickListener(this);

        btnEspejo = (Button) view.findViewById(R.id.btnEspejo);
        btnEspejo.setOnClickListener(this);

        btnEspuma = (Button) view.findViewById(R.id.btnEspuma);
        btnEspuma.setOnClickListener(this);

        btnGallina = (Button) view.findViewById(R.id.btnGallina);
        btnGallina.setOnClickListener(this);

        btnGancho = (Button) view.findViewById(R.id.btnGancho);
        btnGancho.setOnClickListener(this);

        btnGoma = (Button) view.findViewById(R.id.btnGoma);
        btnGoma.setOnClickListener(this);

        btnJabon = (Button) view.findViewById(R.id.btnJabon);
        btnJabon.setOnClickListener(this);

        btnJarra = (Button) view.findViewById(R.id.btnJarra);
        btnJarra.setOnClickListener(this);

        btnJoven = (Button) view.findViewById(R.id.btnJoven);
        btnJoven.setOnClickListener(this);

        btnLapiz = (Button) view.findViewById(R.id.btnLapiz);
        btnLapiz.setOnClickListener(this);

        btnLentes = (Button) view.findViewById(R.id.btnLentes);
        btnLentes.setOnClickListener(this);

        btnLibro = (Button) view.findViewById(R.id.btnLibro);
        btnLibro.setOnClickListener(this);

        Log.e("numeroP",String.valueOf(IdPaciente));
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
        if (v == btnAbrigo){
            Intent i = new Intent(getActivity(),Fonemas.class);
            i.putExtra("num",1);
            i.putExtra("id",IdPaciente);
            startActivity(i);
        } else if(v == btnBarco){
        Intent i = new Intent(getActivity(), Fonemas.class);
        i.putExtra("num",2);
        i.putExtra("id",IdPaciente);
        startActivity(i);
    } else if(v == btnCama){
        Intent i = new Intent(getActivity(), Fonemas.class);
        i.putExtra("num",3);
        i.putExtra("id",IdPaciente);
        startActivity(i);
    } else if(v == btnEscoba){
        Intent i = new Intent(getActivity(), Fonemas.class);
        i.putExtra("num",4);
        i.putExtra("id",IdPaciente);
        startActivity(i);
    } else if(v == btnGallina){
        Intent i = new Intent(getActivity(), Fonemas.class);
        i.putExtra("num",5);
        i.putExtra("id",IdPaciente);
        startActivity(i);
    } else if(v == btnJabon){
        Intent i = new Intent(getActivity(), Fonemas.class);
        i.putExtra("num",6);
        i.putExtra("id",IdPaciente);
        startActivity(i);
    } else if(v == btnLibro){
        Intent i = new Intent(getActivity(), Fonemas.class);
        i.putExtra("num",7);
        i.putExtra("id",IdPaciente);
        startActivity(i);
        }
    }

    public void recogerExtras() {
        // Bundle extras = this.getArguments();
        Bundle extras = getActivity().getIntent().getExtras();

        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        IdPaciente = idPaciente;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
