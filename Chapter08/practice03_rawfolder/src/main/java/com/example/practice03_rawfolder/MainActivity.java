package com.example.practice03_rawfolder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    long startTime, endTime;
    Button btnInputStreamReader, btnBufferStreamReader;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInputStreamReader = findViewById(R.id.btnISR);
        btnBufferStreamReader = findViewById(R.id.btnBR);
        textView = findViewById(R.id.textView);
        btnInputStreamReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (InputStreamReader isr = new InputStreamReader(getResources().openRawResource(R.raw.android))){
                    startTime = System.currentTimeMillis();
                    int i;
                    String str = "";
                    StringBuilder sb = new StringBuilder();
                    while((i = isr.read()) != -1){
                       sb.append((char)i);
                    }
                    endTime = System.currentTimeMillis();
                    Toast.makeText(MainActivity.this, String.format("%d ms",endTime-startTime),Toast.LENGTH_SHORT).show();
                    textView.setText(sb.toString());
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        btnBufferStreamReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.android)))){
                    startTime = System.currentTimeMillis();
                    int i;
                    String str = "";
                    StringBuilder sb = new StringBuilder();
                    while((i = br.read()) != -1){
                        sb.append((char)i);
                    }
                    endTime = System.currentTimeMillis();
                    Toast.makeText(MainActivity.this, String.format("%d ms",endTime-startTime),Toast.LENGTH_SHORT).show();
                    textView.setText(sb.toString());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
