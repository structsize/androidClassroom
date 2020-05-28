package com.example.ex03_doityourself10_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView[] imageViews = new ImageView[9];
    Button btn;
    int[] imageIds = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9};
    String[] imageNames = {"이미지1","이미지2","이미지3","이미지4","이미지5","이미지6","이미지7","이미지8","이미지9"};
    int[] voteCount = new int[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        for(int i = 0; i < imageViews.length; i++){
            final int index = i;
            imageViews[i] = findViewById(imageIds[i]);
            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(MainActivity.this, imageNames[index] + ": 총 " + voteCount[index]+"표",Toast.LENGTH_SHORT).show();
                }
            });
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("nameData",imageNames);
                intent.putExtra("voteData", voteCount);

                startActivity(intent);
            }
        });

    }
}
