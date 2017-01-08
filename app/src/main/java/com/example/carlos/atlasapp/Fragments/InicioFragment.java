package com.example.carlos.atlasapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.BaseDatos.PacienteCursorAdapter;
import com.example.carlos.atlasapp.Perfil.PerfilActivity;
import com.example.carlos.atlasapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InicioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class InicioFragment extends Fragment implements FragmentModificarP.OnFragmentInteractionListener {

    private OnFragmentInteractionListener mListener;
    private PacienteCursorAdapter pacienteadapter ;
    public ListView lista;
    DatabaseHelper helper;
    Cursor cursor2;
    String e;
    TextView texto;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        helper = new DatabaseHelper(getActivity());
        lista = (ListView)view.findViewById(R.id.lista);

        consultar();
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cursor c = (Cursor) lista.getItemAtPosition(position);
                long identificacion = parent.getItemIdAtPosition(position);
                String nombre = String.valueOf(identificacion);
                int current = Integer.parseInt(nombre);
                String CurrentPacienteNombre = c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE));
                showDetailScreen(current, CurrentPacienteNombre);

                Fade explode = new Fade();
                explode.setDuration(100); // Duración en milisegundos
        //        getActivity().getWindow().setExitTransition(explode);


            }
        });
        registerForContextMenu(lista);


        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.lista) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle("Selecciona una opción");
            menu.add(0, v.getId(), 0, "Eliminar");//groupId, itemId, order, title
            menu.add(0, v.getId(), 1, "Editar");
        }
    }

    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Eliminar"){

            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            String nombre;
            nombre = info.toString();
            long index = info.id;
            nombre = String.valueOf(index);
            helper.eliminarPaciente(nombre);
            pacienteadapter.notifyDataSetChanged();
            Toast.makeText(getContext(),"Paciente Eliminado",Toast.LENGTH_SHORT).show();
        }
        if(item.getTitle()=="Editar"){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            String sapo;
            long index = info.id;
            sapo = String.valueOf(index);
            int id = Integer.parseInt(sapo);
            showModificarP(id);
            Toast.makeText(getContext(),"Ok",Toast.LENGTH_SHORT).show();
        }else{
            return false;
        }
        return true;
    }




    private void showDetailScreen(int paciente, String Nombrepaciente) {
       //  Parametro metodo String paciente

      /*  Fragment fragment = new PerfilFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",paciente);
        bundle.putString("paciente", Nombrepaciente);
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_nav_inicio,fragment).commit();
*/
        Intent i = new Intent(getActivity(), PerfilActivity.class);
        i.putExtra("id",paciente);
        i.putExtra("paciente", Nombrepaciente);
        startActivity(i);


        //item.setChecked(true);
    }
    private void showModificarP(int paciente){
        Fragment fragment = new FragmentModificarP();
        Bundle bundle = new Bundle();
        bundle.putInt("paciente",paciente);
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_nav_inicio,fragment).commit();
    }

    public void consultar(){
        helper = new DatabaseHelper(getActivity());
        cursor2 = helper.getCursor();
        getActivity().startManagingCursor(cursor2);
        pacienteadapter = new PacienteCursorAdapter(getActivity(), cursor2);
        lista.setAdapter(pacienteadapter);
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
    public void onFragmentInteraction(Uri uri) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
