package com.example.carlos.atlasapp.Nivel2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.hardware.Camera;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.carlos.atlasapp.BaseDatos.DatabaseHelper;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;


import com.example.carlos.atlasapp.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Fonemas extends Activity implements SurfaceHolder.Callback{


    FloatingActionMenu materialDesignFAM, materialDesignFAM2;
    FloatingActionButton floatingActionButton1, floatingActionButton2,floatingActionButton3, floatingActionButton4;

    private ImageSurfaceView mImageSurfaceView;
    private Camera camera;
    private FrameLayout cameraPreviewLayout;
    int NumeroBoton=0;
    int NumeroPaciente=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fonemas);
        recogerExtras();
        cameraPreviewLayout = (FrameLayout)findViewById(R.id.flcamara);


        materialDesignFAM2 = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_fcamara);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_fcamara1);
        floatingActionButton4 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_fcamara2);

        camera = checkDeviceCamera();
        mImageSurfaceView = new ImageSurfaceView(Fonemas.this, camera);
        cameraPreviewLayout.addView(mImageSurfaceView);

        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String n5;
                n5 = Integer.toString(NumeroBoton);
                Log.d("boton",n5);
                usarMetodoPalabra(NumeroBoton, NumeroPaciente);
            }
        });
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                usarMetodoReiniciar(NumeroBoton,NumeroPaciente);
            }
        });

        MediaController mc = new MediaController(this);
        VideoView videoView = (VideoView) findViewById(R.id.videoView2);

        Uri path = Uri.parse("android.resource://"+this.getPackageName()+"/raw/lenguarevoltosa/");

        mc.setMediaPlayer(videoView);
        mc.setAnchorView(findViewById(R.id.linea));

        videoView.setMediaController(mc);
        videoView.setVideoURI(path);
        videoView.start();

        getWindow().setFormat(PixelFormat.UNKNOWN);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private Camera checkDeviceCamera(){
        Camera mCamera = null;
        try {
            mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mCamera;
    }
    public void recogerExtras() {
        // Bundle extras = this.getArguments();
        Bundle extras = getIntent().getExtras();
        int numero = getIntent().getIntExtra("num", 0); //Obtiene valor que pasa NI1_Animales
        NumeroBoton = numero;
        int idPaciente = extras.getInt("id");
        String s= extras.getString("paciente");
        NumeroPaciente = idPaciente;
        Log.d("Id de paciente",String.valueOf(NumeroPaciente));
    }

    public void usarMetodoPalabra(int numero, int paciente)
    {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getReadableDatabase();
        helper.VerificarPalabra(2, numero, paciente);
        Toast.makeText(this, "Bien Hecho! Continua con el siguiente Fonema!", Toast.LENGTH_SHORT).show();
        Log.d("Resultado", "Se guardo");
    }

    public void usarMetodoReiniciar(int numero, int paciente)
    {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getReadableDatabase();
        helper.RestaurarA0(2,numero, paciente);
        Toast.makeText(this, "Se Reinicio el Fonema", Toast.LENGTH_SHORT).show();
        Log.d("Resultado", "Se reinicio");
    }
}