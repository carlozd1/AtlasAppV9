package com.example.carlos.atlasapp.BaseDatos;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.carlos.atlasapp.R;

/**
 * Created by Carlos on 17/11/2016.
 */

public class PacienteCursorAdapter extends CursorAdapter {

    DatabaseHelper helper = null;
    ImageView imageView;
    TextView friendName;
    String nombre, apellido;
    private LayoutInflater mInflater;


    public PacienteCursorAdapter(Context context, Cursor c) {
        super(context, c,3);
        helper = new DatabaseHelper(context);
        helper.getReadableDatabase();
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.list_item_paciente, parent, false);
     //   android.R.layout.simple_dropdown_item_1line

        return view;
    }



    @Override
    public void bindView(View view, Context context, Cursor cursor) {
       // TextView tv = (TextView) view ;
       // tv.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE)));
       // tv.getText().toString();

        imageView = (ImageView) view.findViewById(R.id.image_view);
        friendName = (TextView) view.findViewById(R.id.text);

        String firstLetter = String.valueOf(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE)).charAt(0));

        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getColor(cursor.getPosition());

        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstLetter, color); // radius in px

/*
        if (cursor.moveToFirst()) {

            do {
                //friendName.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE))+ " "+
                //        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_AP)));
                nombre =  cursor.getString(1);
                apellido =  cursor.getString(2);

            } while(cursor.moveToNext());
        }
        */
        nombre =  cursor.getString(1);
        apellido =  cursor.getString(2);
        friendName.setText(nombre +" "+ apellido);
     //   friendName.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NOMBRE)));
        imageView.setImageDrawable(drawable);

    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }



}
