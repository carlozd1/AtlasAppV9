package com.example.carlos.atlasapp.Perfil;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.Nav.NavProgreso;
import com.example.carlos.atlasapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Tab2 extends Fragment {

    private OnFragmentInteractionListener mListener;
    TextView  edadPaciente, diagPaciente, otrosPaciente, palabraTotal, fechaTerapia;
    String correo,apePaciente,s;
    ImageButton btnO, btnFon,btnSil,btnPal,btnFrase,btnCon;
    int num = 0;
    int IdPaciente = 0;
    ImageButton progreso;
    Date fecha;
    String nombrePaciente;

    public Tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        palabraTotal = (TextView)view.findViewById(R.id.palabraTotal);
        fechaTerapia = (TextView)view.findViewById(R.id.fechaUltima);

        fecha = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        fechaTerapia.setText("           "+df.format(fecha));

        recogerExtras();
        ObtenerAvance();

        progreso = (ImageButton)view.findViewById(R.id.buttonProgreso);
        progreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crear = new Intent(getActivity(), NavProgreso.class);
                crear.putExtra("paciente",nombrePaciente);
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
        s= extras.getString("paciente");
        String s2 = extras.getString("correo");
        String s3 = extras.getString("apellido");
        nombrePaciente = s;
        IdPaciente = idPaciente;
        //  apellido(IdPaciente);
        //  String NombreCompleto = s+" "+apePaciente;
        //  nombrePaciente.setText(NombreCompleto);
        correo = s2;
    }


    public void ObtenerAvance(){
        DatabaseHelper helper = new DatabaseHelper(getActivity());

        palabraTotal.setText(helper.NAprobado(IdPaciente).toString());
    }
}
