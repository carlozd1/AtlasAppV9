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
 * {@link FO_Parte2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FO_Parte2 extends Fragment implements View.OnClickListener,
        FO_Parte1.OnFragmentInteractionListener{

    private OnFragmentInteractionListener mListener;
    ImageButton oGato, oLobo, oVaca, oBorrego, oElefante, oCaballo, oPato, oRana;
    ImageButton bAtras2, bAdelante2;
    int NumBtn = 8;

    public FO_Parte2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fo__parte2, container, false);
        View view = inflater.inflate(R.layout.content_onomatopeyas, container, false);


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

    }

    private void Invisible(){
        oGato.setVisibility(View.GONE);
        oLobo.setVisibility(View.GONE);
        oVaca.setVisibility(View.GONE);
        oBorrego.setVisibility(View.GONE);
        oElefante.setVisibility(View.GONE);
        oCaballo.setVisibility(View.GONE);
        oPato.setVisibility(View.GONE);
        oRana.setVisibility(View.GONE);
    }


    public void casosBotones(int caso){
        switch (caso){
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

    @Override
    public void onFragmentInteraction(Uri uri) {

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
