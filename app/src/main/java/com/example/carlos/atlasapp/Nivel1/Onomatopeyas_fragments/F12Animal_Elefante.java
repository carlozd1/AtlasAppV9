package com.example.carlos.atlasapp.Nivel1.Onomatopeyas_fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.carlos.atlasapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link F12Animal_Elefante.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class F12Animal_Elefante extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;

    ImageButton oPollo, oCerdo, oTigre, oAbeja, oGallina, oGallo, oPerro;
    ImageButton oGato, oLobo, oVaca, oBorrego, oElefante, oCaballo, oPato, oRana;

    public F12Animal_Elefante() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_f12_animal__elefante, container, false);

        oElefante = (ImageButton) view.findViewById(R.id.obtn_Elefante);
        oElefante.setOnClickListener(this);

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
        if(v == oElefante){
            Toast tElefante = Toast.makeText(getActivity(), "Bruuu!", Toast.LENGTH_SHORT);
            tElefante.show();

            //Sonido
            MediaPlayer mp;
            mp = MediaPlayer.create(getActivity(), R.raw.elefante);
            mp.start();
        }
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
