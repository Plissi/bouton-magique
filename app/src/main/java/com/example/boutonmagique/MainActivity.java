package com.example.boutonmagique;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View.OnTouchListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bouton = null;

    float coordonnee_x = 0;
    float coordonnee_y = 0;
    float largeur_bouton = 0;
    float hauteur_bouton = 0;
    float width = 0;
    float height = 0;

    MotionEvent toucher = null;

    private  OnTouchListener touchListenerBouton = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            coordonnee_x = motionEvent.getX();
            coordonnee_y = motionEvent.getY();
            new Thread() {
                @Override
                public void run() {

                    while (width == 0 || height == 0) {
                        width = bouton.getWidth();
                        height = bouton.getHeight();
                    }

                }
            }.start();

            bouton.setTextSize(Math.abs(coordonnee_x-width/2) - Math.abs(coordonnee_y-height/2));

            Log.i("Test", "Width : " + width);
            Log.i("Test", "Height : " + height);
            Log.i("Test", "X : " + coordonnee_x);
            Log.i("Test", "Y : " + coordonnee_y);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bouton = (Button)findViewById(R.id.bouton);

        bouton.setOnTouchListener(touchListenerBouton);
    }
}
