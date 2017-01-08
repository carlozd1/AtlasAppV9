package com.example.carlos.atlasapp.Perfil;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.carlos.atlasapp.Nivel1.nivel1_principal;
import com.example.carlos.atlasapp.Nivel2.nivel2_principal;
import com.example.carlos.atlasapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Tab3 extends Fragment {

    private OnFragmentInteractionListener mListener;
    ImageButton btnO, btnFon,btnSil,btnPal,btnFrase,btnCon;
    int num = 0;
    int IdPaciente = 0;
    String nombrePaciente ;

    public Tab3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);

        btnO = (ImageButton)view.findViewById(R.id.onomatopeya);
        btnFon = (ImageButton)view.findViewById(R.id.fonema);
        btnSil = (ImageButton)view.findViewById(R.id.silaba);
        btnPal = (ImageButton)view.findViewById(R.id.palabra);
        btnFrase = (ImageButton)view.findViewById(R.id.frase);
        btnCon = (ImageButton)view.findViewById(R.id.conversacion);
        recogerExtras();

        btnFon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel2_principal.class);
                num = 2;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);
            }
        });
/*
        btnCon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 6;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);
            }
        });

        btnFrase.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 5;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);
            }
        });

        btnPal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 4;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);
            }
        });
*/
        btnSil.setOnClickListener(new View.OnClickListener(){

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 3;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);

            }
        });

        btnO.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), nivel1_principal.class);
                num = 1;
                crear.putExtra("numero",num);
                crear.putExtra("id",IdPaciente);
                startActivity(crear);
            }
        });


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

    public void recogerExtras() {
        Bundle extras = getActivity().getIntent().getExtras();
        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        String s2 = extras.getString("correo");
        String s3 = extras.getString("apellido");
        nombrePaciente = s;
        IdPaciente = idPaciente;
        //  apellido(IdPaciente);
        //  String NombreCompleto = s+" "+apePaciente;
        //  nombrePaciente.setText(NombreCompleto);
    }
}
