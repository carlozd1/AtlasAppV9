package com.example.carlos.atlasapp.Nivel1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.example.carlos.atlasapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FO_Parte1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FO_Parte1 extends Fragment implements View.OnClickListener{

    ImageButton oPollo, oCerdo, oTigre, oAbeja, oGallina, oGallo, oPerro;
    ImageButton oGato, oLobo, oVaca, oBorrego, oElefante, oCaballo, oPato, oRana;
    /*

    //Botones de onomatopeyas
    ImageButton oPollo, oCerdo, oTigre, oAbeja, oGallina, oGallo, oPerro,
    oGato, oLobo, oVaca, oBorrego, oElefante, oCaballo, oPato, oRana;
     */
    //Botones de control
    ImageButton bAtras, bAdelante;
    int NumBtn = 0;

    private OnFragmentInteractionListener mListener;

    public FO_Parte1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fo__parte1, container, false);
        View view = inflater.inflate(R.layout.fragment_fo__parte1, container, false);

        oPollo = (ImageButton) view.findViewById(R.id.obtn_Pollo);
        oPollo.setOnClickListener(this);

        oCerdo  = (ImageButton) view.findViewById(R.id.obtn_Cerdo);
        oCerdo.setOnClickListener(this);

        oTigre = (ImageButton) view.findViewById(R.id.obtn_Tigre);
        oTigre.setOnClickListener(this);

        oAbeja = (ImageButton) view.findViewById(R.id.obtn_Abeja);
        oAbeja.setOnClickListener(this);

        oGallina = (ImageButton) view.findViewById(R.id.obtn_Gallina);
        oGallina.setOnClickListener(this);

        oGallo = (ImageButton) view.findViewById(R.id.obtn_Gallo);
        oGallo.setOnClickListener(this);

        oPerro = (ImageButton) view.findViewById(R.id.obtn_Perro);
        oPerro.setOnClickListener(this);

        oGato = (ImageButton) view.findViewById(R.id.obtn_Gato);
        oGato.setOnClickListener(this);

        oLobo  = (ImageButton) view.findViewById(R.id.obtn_Lobo);
        oLobo.setOnClickListener(this);

        oVaca = (ImageButton) view.findViewById(R.id.obtn_Vaca);
        oVaca.setOnClickListener(this);


        oBorrego = (ImageButton) view.findViewById(R.id.obtn_Borrego);
        oBorrego.setOnClickListener(this);


        oElefante = (ImageButton) view.findViewById(R.id.obtn_Elefante);
        oElefante.setOnClickListener(this);

        oCaballo = (ImageButton) view.findViewById(R.id.obtn_Caballo);
        oCaballo.setOnClickListener(this);

        oPato = (ImageButton) view.findViewById(R.id.obtn_Pato);
        oPato.setOnClickListener(this);

        oRana = (ImageButton) view.findViewById(R.id.obtn_Rana);
        oRana.setOnClickListener(this);


        Invisible();

        Bundle extras = this.getArguments();
        int valor = extras.getInt("num",0);
        //casosBotones(valor);

        return view;
    }


    private void Invisible(){
        oPollo.setVisibility(View.GONE);
        oCerdo.setVisibility(View.GONE);
        oTigre.setVisibility(View.GONE);
        oAbeja.setVisibility(View.GONE);
        oGallina.setVisibility(View.GONE);
        oGallo.setVisibility(View.GONE);
        oPerro.setVisibility(View.GONE);
        oGato.setVisibility(View.GONE);
        oLobo.setVisibility(View.GONE);
        oVaca.setVisibility(View.GONE);
        oBorrego.setVisibility(View.GONE);

        oElefante.setVisibility(View.GONE);
        oCaballo.setVisibility(View.GONE);
        oPato.setVisibility(View.GONE);
        oRana.setVisibility(View.GONE);

    }

    /*

    public void casosBotones(int caso){
        switch (caso){
            case 1:
                Invisible();
                oPollo.setVisibility(View.VISIBLE);
                break;
            case 2:
                Invisible();
                oCerdo.setVisibility(View.VISIBLE);
                break;
            case 3:
                Invisible();
                oTigre.setVisibility(View.VISIBLE);
                break;
            case 4:
                Invisible();
                oAbeja.setVisibility(View.VISIBLE);
                break;
            case 5:
                Invisible();
                oGallina.setVisibility(View.VISIBLE);
                break;
            case 6:
                Invisible();
                oGallo.setVisibility(View.VISIBLE);
                break;
            case 7:
                Invisible();
                oPerro.setVisibility(View.VISIBLE);
                break;
            case 8:
                Invisible();
                oGato.setVisibility(View.VISIBLE);
                break;
            case 9:
                Invisible();
                oLobo.setVisibility(View.VISIBLE);
                break;
            case 10:
                Invisible();
                oVaca.setVisibility(View.VISIBLE);
                break;

            case 11:
                Invisible();
                oBorrego.setVisibility(View.VISIBLE);
                break;

            case 12:
                Invisible();
                oElefante.setVisibility(View.VISIBLE);
                break;
            case 13:
                Invisible();
                oCaballo.setVisibility(View.VISIBLE);
                break;
            case 14:
                Invisible();
                oPato.setVisibility(View.VISIBLE);
                break;
            case 15:
                Invisible();
                oRana.setVisibility(View.VISIBLE);
                break;

        }
    }

    */

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
        /*
        if (v == oPollo) {
            Toast tPollo = Toast.makeText(getActivity(), "Pio pio!", Toast.LENGTH_SHORT);
            tPollo.show();
        } else if (v == oCerdo) {
            Toast tCerdo = Toast.makeText(getActivity(), "Oink!", Toast.LENGTH_SHORT);
            tCerdo.show();
        } else if (v == oTigre) {
            Toast tTigre = Toast.makeText(getActivity(), "Grrr!", Toast.LENGTH_SHORT);
            tTigre.show();
        } else if (v == oAbeja) {
            Toast tAbeja = Toast.makeText(getActivity(), "Bzzz!", Toast.LENGTH_SHORT);
            tAbeja.show();
        } else if (v == oGallina) {
            Toast tGallina = Toast.makeText(getActivity(), "Coc coc!", Toast.LENGTH_SHORT);
            tGallina.show();
        } else if (v == oGallo) {
            Toast tGallo = Toast.makeText(getActivity(), "Quiriki quiki!", Toast.LENGTH_SHORT);
            tGallo.show();
        } else if (v == oPerro) {
            Toast tPerro = Toast.makeText(getActivity(), "Guau guau!", Toast.LENGTH_SHORT);
            tPerro.show();
        } else if(v == oGato){
            Toast tGato = Toast.makeText(getActivity(), "miau miau!", Toast.LENGTH_SHORT);
            tGato.show();
        }else if(v == oLobo){
            Toast tLobo = Toast.makeText(getActivity(), "Auuu!", Toast.LENGTH_SHORT);
            tLobo.show();
        }else if(v == oVaca){
            Toast tVaca = Toast.makeText(getActivity(), "Muu muuu!", Toast.LENGTH_SHORT);
            tVaca.show();
        }
        else if(v == oBorrego){
            Toast tBorrego = Toast.makeText(getActivity(), "Beee!", Toast.LENGTH_SHORT);
            tBorrego.show();
        }else if(v == oElefante){
            Toast tElefante = Toast.makeText(getActivity(), "Bruuu!", Toast.LENGTH_SHORT);
            tElefante.show();
        }else if(v == oCaballo){
            Toast tCaballo = Toast.makeText(getActivity(), "Hiii!", Toast.LENGTH_SHORT);
            tCaballo.show();
        }else if(v == oPato){
            Toast tPato = Toast.makeText(getActivity(), "Cuac cuac!", Toast.LENGTH_SHORT);
            tPato.show();
        }else if(v == oRana){
            Toast tRana = Toast.makeText(getActivity(), "Croac!", Toast.LENGTH_SHORT);
            tRana.show();
        }
        */
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
