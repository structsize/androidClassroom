package com.example.practice10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btnResult = findViewById(R.id.btnResult);
        Intent intent = getIntent();
        String[] imageNames = intent.getStringArrayExtra("imageNames");
        int[] voteResult = intent.getIntArrayExtra("voteResult");
    }
}
