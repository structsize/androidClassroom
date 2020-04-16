package com.example.example6_1_textclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView text;
    TextClock tc1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        text = findViewById(R.id.text);
        tc1 = findViewById(R.id.tc1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                text.setText("Time : " + tc1.getText());
            }
        });
    }
}
