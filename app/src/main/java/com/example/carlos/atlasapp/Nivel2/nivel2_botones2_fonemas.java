package com.example.carlos.atlasapp.Nivel2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.carlos.atlasapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link nivel2_botones2_fonemas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class nivel2_botones2_fonemas extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    int IdPaciente = 0;
    Button btnMesa, btnRadio, btnSombrero,btnTenedor, btnVaca, btnPala;

    public nivel2_botones2_fonemas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.nivel2_botones2_fonemas, container, false);
        recogerExtras();

        btnMesa = (Button)view.findViewById(R.id.btnMesa);
        btnRadio = (Button)view.findViewById(R.id.btnRadio);
        btnPala = (Button)view.findViewById(R.id.btnPala);
        btnSombrero = (Button)view.findViewById(R.id.btnSombrero);
        btnTenedor = (Button)view.findViewById(R.id.btnTenedor);
        btnVaca = (Button)view.findViewById(R.id.btnVaca);

        btnMesa = (Button) view.findViewById(R.id.btnMesa);
        btnMesa.setOnClickListener(this);

        btnPala = (Button) view.findViewById(R.id.btnPala);
        btnPala.setOnClickListener(this);

        btnRadio = (Button) view.findViewById(R.id.btnRadio);
        btnRadio.setOnClickListener(this);

        btnSombrero = (Button) view.findViewById(R.id.btnSombrero);
        btnSombrero.setOnClickListener(this);

        btnTenedor = (Button) view.findViewById(R.id.btnTenedor);
        btnTenedor.setOnClickListener(this);

        btnVaca = (Button) view.findViewById(R.id.btnVaca);
        btnVaca.setOnClickListener(this);

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
        // Bundle extras = this.getArguments();
        Bundle extras = getActivity().getIntent().getExtras();

        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        IdPaciente = idPaciente;
    }

    @Override
    public void onClick(View v) {
        if (v == btnMesa){
            Intent i = new Intent(getActivity(),Fonemas.class);
            i.putExtra("num",8);
            i.putExtra("id",IdPaciente);
            startActivity(i);
        } else if(v == btnRadio){
            Intent i = new Intent(getActivity(), Fonemas.class);
            i.putExtra("num",10);
            i.putExtra("id",IdPaciente);
            startActivity(i);
        } else if(v == btnPala){
            Intent i = new Intent(getActivity(), Fonemas.class);
            i.putExtra("num",9);
            i.putExtra("id",IdPaciente);
            startActivity(i);
        } else if(v == btnSombrero){
            Intent i = new Intent(getActivity(), Fonemas.class);
            i.putExtra("num",11);
            i.putExtra("id",IdPaciente);
            startActivity(i);
        } else if(v == btnTenedor){
            Intent i = new Intent(getActivity(), Fonemas.class);
            i.putExtra("num",12);
            i.putExtra("id",IdPaciente);
            startActivity(i);
        } else if(v == btnVaca) {
            Intent i = new Intent(getActivity(), Fonemas.class);
            i.putExtra("num", 13);
            i.putExtra("id", IdPaciente);
            startActivity(i);
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
