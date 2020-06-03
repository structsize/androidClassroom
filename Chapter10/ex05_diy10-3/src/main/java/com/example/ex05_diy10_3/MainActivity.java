package com.example.ex05_diy10_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btn;
    int n1, n2;
    RadioButton hap, cha, gob, mok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.edtNum1);
        num2 = findViewById(R.id.edtNum2);
        btn = findViewById(R.id.btn);

        hap = findViewById(R.id.hap);
        cha = findViewById(R.id.cha);
        gob = findViewById(R.id.gob);
        mok = findViewById(R.id.mok);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("n1",n1);
                intent.putExtra("n2", n2);
                if(hap.isChecked()){
                    intent.putExtra("flag",1);
                }
                if(cha.isChecked()){
                    intent.putExtra("flag",2);
                }
                if(gob.isChecked()){
                    intent.putExtra("flag",3);
                }
                if(mok.isChecked()){
                    intent.putExtra("flag",4);
                }
                startActivityForResult(intent,0);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            double value = data.getDoubleExtra("value",0);

            Toast.makeText(getApplicationContext(),"정답 : "+value, Toast.LENGTH_SHORT).show();
        }
    }
}

