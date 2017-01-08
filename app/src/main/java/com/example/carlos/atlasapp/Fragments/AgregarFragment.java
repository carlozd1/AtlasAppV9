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
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.Contact;
import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.BaseDatos.PacienteCursorAdapter;
import com.example.carlos.atlasapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AgregarFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    PacienteCursorAdapter pacienteAdapter;
    Button agregarPaciente;
    EditText txtnombre,txtedad,txtdiagnostico, txtape;
    Context context;
    Date fechaRegistro;
    Calendar c;


    public AgregarFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar, container, false);

        agregarPaciente = (Button)view.findViewById(R.id.btn_guardar);
        txtnombre = (EditText)view.findViewById(R.id.txtName);
        txtape = (EditText)view.findViewById(R.id.textAp);
        txtedad = (EditText)view.findViewById(R.id.txtEdad);
        txtdiagnostico = (EditText)view.findViewById(R.id.txtDiag);



        agregarPaciente.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                alta(v);
                txtnombre.setText("");
                txtedad.setText("");
                txtape.setText("");
                txtdiagnostico.setText("");
                //c = Calendar.getInstance();
                //DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                //String reportDate = df.format(c);
            }
        });
        return view;
            }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Add this here:
        context = getActivity(); //use the instance variable

    }



    public void alta(View v) {
        DatabaseHelper helper = new DatabaseHelper(getActivity());

        String nombre = txtnombre.getText().toString();
        String apellido = txtape.getText().toString();
        String diagnostico = txtdiagnostico.getText().toString();
        String edad = txtedad.getText().toString();

        Contact c = new Contact();
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setEdad(edad);
        c.setDiagnostico(diagnostico);

        helper.insertarPaciente(c,1);

        Toast aviso = Toast.makeText(context, "Paciente registrado" , Toast.LENGTH_SHORT);
        aviso.show();
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
