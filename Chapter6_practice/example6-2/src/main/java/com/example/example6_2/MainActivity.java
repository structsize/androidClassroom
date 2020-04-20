package com.example.example6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button startBtn;
    Button resetBtn;
    Button stopBtn;
    Long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = SystemClock.elapsedRealtime();
        chronometer = findViewById(R.id.chronometer);
        startBtn = findViewById(R.id.startBtn);
        resetBtn = findViewById(R.id.resetBtn);
        stopBtn = findViewById(R.id.stopBtn);


        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                Log.d("realTime",String.valueOf(SystemClock.elapsedRealtime()));
            }
        });


    }
}
