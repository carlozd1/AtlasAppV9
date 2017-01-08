package com.example.carlos.atlasapp.Progreso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.example.carlos.atlasapp.R;
import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.EdgeDetail;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link G_OnomatopeyasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class G_OnomatopeyasFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    int porcentaje =0;
    String NombrePaciente = "";
    int IdPaciente = 0;
    TextView faltante,aprobado;

    public G_OnomatopeyasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppThemeOno);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View view = localInflater.inflate(R.layout.fragment_onomatopeyas, container, false);
        faltante = (TextView)view.findViewById(R.id.numeroFaltante);
        aprobado = (TextView)view.findViewById(R.id.numeroAprobado);

        //Graficas
        final DecoView arcView = (DecoView)view.findViewById(R.id.dynamicArcViewOno);
        final TextView tvPorciento = (TextView) view.findViewById(R.id.tv_porcientoOno);
        recogerExtras();

        int series1Index = 0;

        final SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(200, 255, 83, 80))
                .setRange(0, 100, 0)
                .setInitialVisibility(false)
                .setLineWidth(50f)
                .addEdgeDetail(new EdgeDetail(EdgeDetail.EdgeType.EDGE_OUTER, Color.parseColor("#22000000"), 0.4f))
                .setSeriesLabel(new SeriesLabel.Builder("Avance %.0f%%").build())
                .setInterpolator(new DecelerateInterpolator())
                .setShowPointWhenEmpty(true)
                .setCapRounded(true)
                .setInset(new PointF(20f, 20f))
                .setDrawAsPoint(false)
                .setSpinClockwise(true)
                .setSpinDuration(6000)
                .setChartStyle(SeriesItem.ChartStyle.STYLE_DONUT)
                .build();

        series1Index = arcView.addSeries(seriesItem1);
        arcView.addEvent(
                new DecoEvent.Builder(DecoEvent.EventType.EVENT_SHOW, true)
                        .setDelay(1000)
                        .setDuration(2000)
                        .build()
        );


        ObtenerPorcentaje();
        arcView.addEvent(new DecoEvent.Builder(porcentaje).setIndex(series1Index).setDelay(4000).build());


        seriesItem1.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                //obtenemos el porcentaje a mostrar
                float percentFilled = ((currentPosition - seriesItem1.getMinValue()) / (seriesItem1.getMaxValue() - seriesItem1.getMinValue()));
                //se lo pasamos al TextView
                tvPorciento.setText(String.format("%.0f%%", percentFilled * 100f));
            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

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


    public void ObtenerPorcentaje(){
        DatabaseHelper helper = new DatabaseHelper(getActivity());
        porcentaje = helper.GraficaN1(1,IdPaciente);
        faltante.setText(helper.NIFaltante(1,IdPaciente).toString());
        aprobado.setText(helper.NIAprobado(1,IdPaciente).toString());
    }

    public void recogerExtras() {
        Bundle extras = getActivity().getIntent().getExtras();
        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        NombrePaciente = s;
        IdPaciente = idPaciente;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
