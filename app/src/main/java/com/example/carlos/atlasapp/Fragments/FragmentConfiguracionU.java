package com.example.carlos.atlasapp.Fragments;

import android.content.Context;
import android.content.Intent;
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
import com.example.carlos.atlasapp.R;
import com.example.carlos.atlasapp.login.LoginActivity;
import com.example.carlos.atlasapp.login.SignUp;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentConfiguracionU.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentConfiguracionU extends Fragment {

    DatabaseHelper helper = new DatabaseHelper(getActivity());
    Button crearUsuario;
    EditText name, pass, usuario, repetir_contraseña;

    private OnFragmentInteractionListener mListener;

    public FragmentConfiguracionU() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_configuracionu, container, false);

         name = (EditText)view.findViewById(R.id.modificaru_name);
         usuario = (EditText)view.findViewById(R.id.modificaru_usuario);
         pass = (EditText)view.findViewById(R.id.modificaru_password);
         repetir_contraseña = (EditText)view.findViewById(R.id.modificaru_reEnterPassword);
        crearUsuario = (Button)view.findViewById(R.id.btn_modu);
       // recogerExtras();

        crearUsuario.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                actualizar(v);
                name.setText("");
                usuario.setText("");
                pass.setText("");
                repetir_contraseña.setText("");

            }
        });

        return view;
    }

    public void actualizar(View v) {
        DatabaseHelper helper = new DatabaseHelper(getActivity());
        boolean c1 =false,c2=false,c3=false,c4=false;
        String nombre = name.getText().toString();
        String user = usuario.getText().toString();
        String pas = pass.getText().toString();
        String rep = repetir_contraseña.getText().toString();
        String prueba;
        prueba = String.valueOf(nombre);
        if (nombre.matches("")){
            Toast.makeText(getContext(), "Ingresa el nombre!", Toast.LENGTH_SHORT).show();
            c1 = false;
        }
        if (user.matches("")){
            Toast.makeText(getContext(), "Ingresa el usuario!", Toast.LENGTH_SHORT).show();
            c2 = false;
        }
        if (pas.matches("")){
            Toast.makeText(getContext(), "Ingresa la contraseña!", Toast.LENGTH_SHORT).show();
            c3 = false;
        }
        if (rep.matches("")){
            Toast.makeText(getContext(), "Ingresa la contraseña!", Toast.LENGTH_SHORT).show();
            c4 = false;
        }

        if (name.getText().length() !=0 && usuario.getText().length() !=0
                && pass.getText().length() !=0 && repetir_contraseña.getText().length() !=0){
            c1 = true;
            c2 = true;
            c3 = true;
            c4 = true;
        }

        Contact c = new Contact();
        c.setId(prueba);
        c.setNombre(nombre);
        c.setApellido(user);
        c.setEdad(pas);
        c.setDiagnostico(rep);

        if (c1 && c2 && c3 && c4){

        helper.actualizarUsuario(c);
        Fragment fragment = new InicioFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_nav_inicio,fragment).commit();

        Toast aviso = Toast.makeText(getContext(), "Usuario actualizado" , Toast.LENGTH_SHORT);
        aviso.show();
        }else{

            Toast aviso = Toast.makeText(getContext(), "Existen campos vacios!" , Toast.LENGTH_SHORT);
        }
    }


    public void recogerExtras() {
        //Aquí recogemos y tratamos los parámetros
        Bundle extras = this.getArguments();
        String s2 = extras.getString("correo");
        name.setText(s2);
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
