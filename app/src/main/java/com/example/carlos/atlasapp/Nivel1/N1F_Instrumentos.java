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

import com.example.carlos.atlasapp.Nivel3.S_instrumentos;
import com.example.carlos.atlasapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link N1F_Instrumentos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link N1F_Instrumentos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class N1F_Instrumentos extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int IdPaciente = 0;
    int Nivel = 0;
    Button mbtn_Tambor, mbtn_Trompeta;

    private OnFragmentInteractionListener mListener;

    public N1F_Instrumentos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment N1F_Instrumentos.
     */
    // TODO: Rename and change types and number of parameters
    public static N1F_Instrumentos newInstance(String param1, String param2) {
        N1F_Instrumentos fragment = new N1F_Instrumentos();
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
        View view = inflater.inflate(R.layout.fragment_n1_f__instrumentos, container, false);

        mbtn_Tambor = (Button) view.findViewById(R.id.btnTambor);
        mbtn_Tambor.setOnClickListener(this);

        mbtn_Trompeta = (Button) view.findViewById(R.id.btnTrompeta);
        mbtn_Trompeta.setOnClickListener(this);
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

                if(v == mbtn_Tambor){
                    Intent i = new Intent(getActivity(), O_instrumentos.class);
                    i.putExtra("num",34);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Trompeta){
                    Intent i = new Intent(getActivity(), O_instrumentos.class);
                    i.putExtra("num",35);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }

                break;
            case 3:

                if(v == mbtn_Tambor){
                    Intent i = new Intent(getActivity(), S_instrumentos.class);
                    i.putExtra("num",34);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                } else if(v == mbtn_Trompeta){
                    Intent i = new Intent(getActivity(), S_instrumentos.class);
                    i.putExtra("num",35);
                    i.putExtra("id",IdPaciente);
                    startActivity(i);
                }

                break;
        }

    }

    public void recogerExtras() {
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
