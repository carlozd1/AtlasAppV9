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
 * {@link F9Animal_Lobo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class F9Animal_Lobo extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;

    ImageButton oPollo, oCerdo, oTigre, oAbeja, oGallina, oGallo, oPerro;
    ImageButton oGato, oLobo, oVaca, oBorrego, oElefante, oCaballo, oPato, oRana;

    public F9Animal_Lobo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_f9_animal__lobo, container, false);

        oLobo  = (ImageButton) view.findViewById(R.id.obtn_Lobo);
        oLobo.setOnClickListener(this);

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
        if(v == oLobo){
            Toast tLobo = Toast.makeText(getActivity(), "Auuu!", Toast.LENGTH_SHORT);
            tLobo.show();
            //Sonido
            MediaPlayer mp;
            mp = MediaPlayer.create(getActivity(), R.raw.lobo);
            mp.start();
        }
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
