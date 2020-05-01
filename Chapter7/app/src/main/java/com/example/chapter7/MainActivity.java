package com.example.chapter7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnLayoutInFlater;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLayoutInFlater = findViewById(R.id.btnLayoutInFlatter);
        linearLayout = findViewById(R.id.mainLinearLayout);

        btnLayoutInFlater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View sampleLayoutView = inflater.inflate(R.layout.sample_layout, null);
                linearLayout.addView(sampleLayoutView);
            }
        });
    }
}
