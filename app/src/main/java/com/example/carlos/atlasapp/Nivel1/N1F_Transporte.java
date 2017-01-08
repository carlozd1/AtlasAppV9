package com.example.carlos.atlasapp.Nivel1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.carlos.atlasapp.Nivel3.S_transporte;
import com.example.carlos.atlasapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link N1F_Transporte.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link N1F_Transporte#newInstance} factory method to
 * create an instance of this fragment.
 */
public class N1F_Transporte extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    int IdPaciente = 0;
    int Nivel = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    Button mbtn_Tren, mbtn_Bicicleta,mbtn_Motocicleta, mbtn_Carro, mbtn_Barco;
    public N1F_Transporte() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment N1F_Transporte.
     */
    // TODO: Rename and change types and number of parameters
    public static N1F_Transporte newInstance(String param1, String param2) {
        N1F_Transporte fragment = new N1F_Transporte();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_n1_f__transporte, container, false);

        mbtn_Tren = (Button) view.findViewById(R.id.btnTren);
        mbtn_Tren.setOnClickListener(this);

        mbtn_Bicicleta = (Button) view.findViewById(R.id.btnBicicleta);
        mbtn_Bicicleta.setOnClickListener(this);

        mbtn_Motocicleta = (Button) view.findViewById(R.id.btnMotocicleta);
        mbtn_Motocicleta.setOnClickListener(this);

        mbtn_Carro = (Button) view.findViewById(R.id.btnCarro);
        mbtn_Carro.setOnClickListener(this);

        mbtn_Barco = (Button) view.findViewById(R.id.btnBarco);
        mbtn_Barco.setOnClickListener(this);

        recogerExtras();

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

        switch (Nivel){
            case 1:

                if(v == mbtn_Tren){
                    Intent i = new Intent(getActivity(), O_transporte.class);
                    i.putExtra("num",29);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Bicicleta){
                    Intent i = new Intent(getActivity(), O_transporte.class);
                    i.putExtra("num",30);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Motocicleta){
                    Intent i = new Intent(getActivity(), O_transporte.class);
                    i.putExtra("num",31);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Carro){
                    Intent i = new Intent(getActivity(), O_transporte.class);
                    i.putExtra("num",32);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Barco){
                    Intent i = new Intent(getActivity(), O_transporte.class);
                    i.putExtra("num",33);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }

                break;
            case 3:

                if(v == mbtn_Tren){
                    Intent i = new Intent(getActivity(), S_transporte.class);
                    i.putExtra("num",29);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Bicicleta){
                    Intent i = new Intent(getActivity(), S_transporte.class);
                    i.putExtra("num",30);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Motocicleta){
                    Intent i = new Intent(getActivity(), S_transporte.class);
                    i.putExtra("num",31);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Carro){
                    Intent i = new Intent(getActivity(), S_transporte.class);
                    i.putExtra("num",32);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Barco){
                    Intent i = new Intent(getActivity(), S_transporte.class);
                    i.putExtra("num",33);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }

                break;
        }

    }

    public void recogerExtras() {
        // Bundle extras = this.getArguments();
        Bundle extras = getActivity().getIntent().getExtras();

        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        Nivel = extras.getInt("numero");
        IdPaciente = idPaciente;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
