package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_visible, btn_invisible;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_visible = findViewById(R.id.btn_visible);
        btn_invisible = findViewById(R.id.btn_invisible);
        img = findViewById(R.id.imageView3);

        /*btn_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.VISIBLE);
            }
        });
        btn_invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.INVISIBLE);
            }
        });

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_invisible:
                        img.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.btn_visible:
                        img.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };*/

        btn_visible.setOnClickListener(this);
        btn_invisible.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        if(btn_visible.equals(v)){
            img.setVisibility(View.VISIBLE);
        } else if(btn_invisible.equals(v)){
            img.setVisibility(View.INVISIBLE);
        }
    }
}
