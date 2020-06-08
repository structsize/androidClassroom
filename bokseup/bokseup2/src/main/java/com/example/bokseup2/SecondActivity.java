package com.example.bokseup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    Button btnReturn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView);
        btnReturn = findViewById(R.id.btnReturn);
        editText = findViewById(R.id.editReturn);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("message"));
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("returnMessage",editText.getText().toString());
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }
}
