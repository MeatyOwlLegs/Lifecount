package com.example.android.lifecount;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final Button plusHoldRedButton = (Button) findViewById(R.id.plusRHold);
    boolean plusRedHold = false;
    int lifeRed;

{
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:

                    if(plusRedHold == false){
                        plusRedHold = true;
                        new plusRedHoldTask().execute();
                    }
                    break;
                case MotionEvent.ACTION_UP:

                    plusRedHold = false;

            }
            return true;
        }
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    plusHoldRedButton.setOnTouchListener(new View.OnTouchListener()
    @Override
    protected void onResume() {
        super.onResume();

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    });

    public void displayLifeRed(int lifeRed) {
        TextView scoreView = (TextView) findViewById(R.id.lifeCounterRed);
        scoreView.setText(String.valueOf(lifeRed));
    }

    public void plusLifeRed(View v) {
        lifeRed = lifeRed + 1;
        displayLifeRed(lifeRed);
    }

    public void minusLifeRed(View v) {
        lifeRed = lifeRed - 1;
        displayLifeRed(lifeRed);
    }

    }

    class plusRedHoldTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {
            while (plusRedHold) {
                lifeRed = lifeRed +1;
                displayLifeRed(lifeRed);
                wait(100);
            }
            return null;
        }
    }

}
