package com.example.carlos.atlasapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.Contact;
import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentModificarP.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentModificarP extends Fragment {

    private OnFragmentInteractionListener mListener;
    EditText nombrePaciente, apePaciente,  edadPaciente, diagPaciente, otrosPaciente, fechaPaciente, nombreUsuario;
    String correo;
    int nombreP;
    Button guardar;

    public FragmentModificarP() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modificarp, container, false);
        nombrePaciente = (EditText)view.findViewById(R.id.input_nombrepaciente);
        apePaciente = (EditText)view.findViewById(R.id.input_apepaciente);
        edadPaciente = (EditText)view.findViewById(R.id.input_edad);
        diagPaciente = (EditText)view.findViewById(R.id.input_diagnostico);
        otrosPaciente = (EditText)view.findViewById(R.id.input_terapeuta);
        guardar = (Button)view.findViewById(R.id.btn_modificarP);
        recogerExtras();

        guardar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                actualizar(v);
                nombrePaciente.setText("");
                apePaciente.setText("");
                edadPaciente.setText("");
                diagPaciente.setText("");
                otrosPaciente.setText("");
            }
        });

        return view;
    }

    public void actualizar(View v) {
        DatabaseHelper helper = new DatabaseHelper(getActivity());

        String nombre = nombrePaciente.getText().toString();
        String ape = apePaciente.getText().toString();
        String diagnostico = diagPaciente.getText().toString();
        String edad = edadPaciente.getText().toString();
        String terapeuta = otrosPaciente.getText().toString();
        String prueba;
        prueba = String.valueOf(nombreP);

        Contact c = new Contact();
        c.setId(prueba);
        c.setNombre(nombre);
        c.setApellido(ape);
        c.setEdad(edad);
        c.setDiagnostico(diagnostico);
        c.setTerapeuta(terapeuta);

        helper.actualizarPaciente(c);
        Fragment fragment = new InicioFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_nav_inicio,fragment).commit();

        Toast aviso = Toast.makeText(getContext(), "Paciente actualizado" , Toast.LENGTH_SHORT);
        aviso.show();
    }

    public void recogerExtras() {
        Bundle extras = this.getArguments();
        Integer s= extras.getInt("paciente");
        String s2 = extras.getString("correo");
        correo = s2;
        nombreP = s;
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
}
