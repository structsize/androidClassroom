package com.example.ex04_example10_16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btn;
    int n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.edtNum1);
        num2 = findViewById(R.id.edtNum2);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                   n1 = Integer.parseInt(num1.getText().toString());
                   n2 = Integer.parseInt(num2.getText().toString());
                   Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                   intent.putExtra("n1",n1);
                   intent.putExtra("n2", n2);
                   startActivityForResult(intent,0);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("hap",0);
            Toast.makeText(getApplicationContext(),"합 : "+hap, Toast.LENGTH_SHORT).show();
        }
    }
}
