package com.example.ex01_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStartService, btnStopService, btnStartIntentService, btnStartForegroundIntentService;
    Intent service_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.startService);
        btnStopService = findViewById(R.id.btnStopService);
        btnStartIntentService = findViewById(R.id.btnStartIntentService);
        btnStartForegroundIntentService = findViewById(R.id.btnStartForegroundIntentService);
        btnStopService.setOnClickListener(this);
        btnStartService.setOnClickListener(this);
        btnStartIntentService.setOnClickListener(this);
        btnStartForegroundIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startService:
                service_intent = new Intent(this, MyService.class);
                startService(service_intent);
                break;
            case R.id.btnStopService:
                stopService(service_intent);
                break;
            case R.id.btnStartIntentService :
                service_intent = new Intent(this, MyIntentService.class);
                startService(service_intent);
                break;
            case R.id.btnStartForegroundIntentService :
                service_intent = new Intent(this, MyForegroundIntentService.class);
                startForegroundService(service_intent);
                break;
        }
    }
}
