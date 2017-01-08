package com.example.carlos.atlasapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlos.atlasapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBuscarP.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentBuscarP extends Fragment {

    private OnFragmentInteractionListener mListener;

    public FragmentBuscarP() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscarp, container, false);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

 /*   public void buscarPaciente() {
        DatabaseHelper helper = new DatabaseHelper(getActivity());
        helper.getWritableDatabase();
        String nombre = nombrePaciente.getText().toString();
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor fila = db.rawQuery("select edad, diagnostico, terapeuta  from paciente where nombre='"+ nombre+"'", null);
        if (fila.moveToFirst()) {
            edadPaciente.setText(fila.getString(0));
            diagPaciente.setText(fila.getString(1));
            otrosPaciente.setText(fila.getString(2));
        } else
            Toast.makeText(getActivity(), "No existe una paciente con dicho nombre",Toast.LENGTH_SHORT).show();
        db.close();

    } */

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
