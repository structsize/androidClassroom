package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView answer;

    Button plus;
    Button minus;
    Button mult;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mult = findViewById(R.id.mult);
        sub = findViewById(R.id.sub);
        answer = findViewById(R.id.answer);

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        mult.setOnClickListener(listener);
        sub.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"숫자를 입력해주세요",Toast.LENGTH_SHORT).show();
            }

            else{
                double a;
                double b;
                double an = 0;
                try{
                    a = Double.parseDouble(num1.getText().toString());
                    b = Double.parseDouble(num2.getText().toString());
                    switch (v.getId()){
                        case R.id.plus :
                            an = a+b;
                            break;
                        case R.id.minus:
                            an = a-b;
                            break;
                        case R.id.mult:
                            an = a * b;
                            break;
                        case R.id.sub:
                            an = a / b;
                            break;
                    }

                    answer.setText("계산결과 : " + an);
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"계산중 오류 발생",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

}
