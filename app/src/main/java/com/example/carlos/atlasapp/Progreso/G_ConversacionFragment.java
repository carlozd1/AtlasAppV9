package com.example.carlos.atlasapp.Progreso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.example.carlos.atlasapp.R;
import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.EdgeDetail;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link G_ConversacionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class G_ConversacionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public G_ConversacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frases, container, false);
        //Graficas
        final DecoView arcView = (DecoView)view.findViewById(R.id.dynamicArcViewFra);
        final TextView tvPorciento = (TextView) view.findViewById(R.id.tv_porcientoFra);


        int series1Index = 0;

        final SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(200, 156, 204, 101))
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

        arcView.addEvent(new DecoEvent.Builder(25).setIndex(series1Index).setDelay(4000).build());


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
