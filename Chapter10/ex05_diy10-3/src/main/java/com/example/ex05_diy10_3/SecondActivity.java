package com.example.ex05_diy10_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    int num1, num2;
    Button btn;
    int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent inIntent = getIntent();
        num1 = inIntent.getIntExtra("n1",0);
        num2 = inIntent.getIntExtra("n2", 0);
        flag = inIntent.getIntExtra("flag",0);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = 0;
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                if(flag == 1){
                    value = num1 + num2;
                } else if( flag == 2 ){
                    value = num1-num2;
                } else if(flag == 3){
                    value = num1*num2;
                } else if (flag == 4){
                    value = (double)num1/num2;
                }
                outIntent.putExtra("value",value);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }


}
